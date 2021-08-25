package c.a.q0.i;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.q.x0;
import c.a.q0.i.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener A;
    public Runnable B;
    public View.OnClickListener C;

    /* renamed from: a  reason: collision with root package name */
    public Context f18837a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f18838b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f18839c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f18840d;

    /* renamed from: e  reason: collision with root package name */
    public x0 f18841e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f18842f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C0901b> f18843g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.i.b f18844h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18845i;

    /* renamed from: j  reason: collision with root package name */
    public int f18846j;
    public int k;
    public int l;
    public TextView m;
    public TBSpecificationBtn n;
    public c.a.p0.s.f0.n.b o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public View s;
    public View t;
    public NEGFeedBackView.b u;
    public boolean v;
    public boolean w;
    public boolean x;
    public CustomMessageListener y;
    public CompoundButton.OnCheckedChangeListener z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f18847a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f18847a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f18847a.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18848e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18848e = dVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f18848e.u != null) {
                    this.f18848e.u.onCheckedChanged(this.f18848e.f18841e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C0901b) {
                    b.C0901b c0901b = (b.C0901b) compoundButton.getTag();
                    if (z) {
                        if (!this.f18848e.f18843g.contains(c0901b)) {
                            this.f18848e.f18843g.add(c0901b);
                        }
                    } else {
                        this.f18848e.f18843g.remove(c0901b);
                    }
                }
                if (ListUtils.isEmpty(this.f18848e.f18843g)) {
                    return;
                }
                c.a.e.e.m.e.a().removeCallbacks(this.f18848e.B);
                c.a.e.e.m.e.a().postDelayed(this.f18848e.B, 500L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18849e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18849e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18849e.h();
            }
        }
    }

    /* renamed from: c.a.q0.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0903d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18850e;

        public RunnableC0903d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18850e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18850e.m();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18851e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18851e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18851e.m();
            }
        }
    }

    public d(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18839c = null;
        this.f18841e = null;
        this.f18842f = null;
        this.f18843g = new ArrayList();
        this.f18846j = 3;
        this.u = null;
        this.v = true;
        this.w = true;
        this.x = false;
        this.y = new a(this, 2001304);
        this.z = new b(this);
        this.A = new c(this);
        this.B = new RunnableC0903d(this);
        this.C = new e(this);
        this.f18837a = tbPageContext.getPageActivity();
        this.f18838b = tbPageContext;
        l();
    }

    public final void g() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f18846j) {
            return;
        }
        c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.f18840d);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
        this.f18846j = skinType;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PopupDialog popupDialog = this.f18839c;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.f18839c = null;
            }
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f18843g)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (b.C0901b c0901b : this.f18843g) {
                if (c0901b != null) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(c0901b.f18820c);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject j(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f18841e == null || arrayList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (!ListUtils.isEmpty(this.f18843g)) {
                for (b.C0901b c0901b : this.f18843g) {
                    if (c0901b != null) {
                        arrayList.add(Integer.valueOf(c0901b.f18819b));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(c0901b.f18819b));
                        if (sb2.length() != 0) {
                            sb2.append(",");
                        }
                        sb2.append(c0901b.f18821d);
                    }
                }
            }
            try {
                jSONObject.put("tid", this.f18841e.f());
                if (sb.length() != 0) {
                    jSONObject.put("dislike_ids", sb.toString());
                }
                jSONObject.put("fid", this.f18841e.c());
                jSONObject.put("click_time", System.currentTimeMillis());
                if (!StringUtils.isNull(this.f18841e.i())) {
                    jSONObject.put("type", this.f18841e.i());
                }
                if (this.f18841e.h() != 0) {
                    jSONObject.put("topic_id", this.f18841e.h());
                }
                jSONObject.put("extra", sb2.toString());
                jSONObject.put("dislike_from", this.x ? "client_videomiddle" : "client_videotab");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = this.f18837a;
            if (context == null) {
                return null;
            }
            if (this.f18840d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f18840d = viewGroup;
                this.m = (TextView) viewGroup.findViewById(R.id.head_text);
                this.n = (TBSpecificationBtn) this.f18840d.findViewById(R.id.uninterested_btn);
                c.a.p0.s.f0.n.b bVar = new c.a.p0.s.f0.n.b();
                this.o = bVar;
                bVar.q(R.color.CAM_X0304);
                this.n.setConfig(this.o);
                this.n.setOnClickListener(this.C);
                this.n.setText(this.f18837a.getResources().getString(R.string.not_interested));
                this.n.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.f18840d;
                int i2 = this.k;
                viewGroup2.setPadding(i2, 0, i2, this.w ? 0 : this.l);
            }
            View h2 = this.f18844h.h();
            if (h2 != null && h2.getParent() == null) {
                this.f18840d.addView(h2);
            }
            if (this.p == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f18837a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.p = linearLayout;
                this.s = linearLayout.findViewById(R.id.top_line);
                this.r = (TextView) this.p.findViewById(R.id.dialog_bottom_cancel_button);
                this.q = (TextView) this.p.findViewById(R.id.dialog_bottom_certain_button);
                View findViewById = this.p.findViewById(R.id.middle_line);
                this.t = findViewById;
                findViewById.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setOnClickListener(this.A);
                this.f18840d.addView(this.p);
            }
            return this.f18840d;
        }
        return (View) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = l.g(this.f18837a, R.dimen.M_W_X005);
            this.l = l.g(this.f18837a, R.dimen.M_H_X007);
            c.a.q0.i.b bVar = new c.a.q0.i.b(this.f18838b);
            this.f18844h = bVar;
            bVar.o(this.z);
            this.f18844h.n(true);
            this.f18844h.m(true);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f18841e == null || this.f18839c == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        JSONObject j2 = j(arrayList);
        if (this.v) {
            if (!StringUtils.isNull(this.f18841e.i())) {
                CustomMessage customMessage = new CustomMessage(2921324, this.f18838b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, j2);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } else {
                CustomMessage customMessage2 = new CustomMessage(2016488, this.f18838b.getUniqueId());
                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, j2);
                customResponsedMessage2.setOrginalMessage(customMessage2);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
            }
        }
        h();
        String string = this.f18837a.getResources().getString(R.string.reduce_related_thread_recommend);
        if (j2 != null && "7".equals(j2.optString("dislike_ids"))) {
            string = this.f18837a.getResources().getString(R.string.forbidden_forum_success1);
        }
        l.M(this.f18837a, string);
        NEGFeedBackView.b bVar = this.u;
        if (bVar != null) {
            bVar.onNEGFeedbackConfirm(arrayList, i(), this.f18841e);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f18845i && this.f18843g.size() != 0) {
            this.f18843g.clear();
        }
    }

    public void o(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x0Var) == null) || x0Var == null) {
            return;
        }
        this.f18841e = x0Var;
        SparseArray<String> b2 = x0Var.b();
        this.f18842f = b2;
        if (b2 != null && b2.size() > 9) {
            for (int size = this.f18842f.size() - 1; size >= 9; size--) {
                this.f18842f.removeAt(size);
            }
        }
        this.f18844h.j(x0Var);
    }

    public void p(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.u = bVar;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f18844h.m(z);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f18837a == null) {
            return;
        }
        View k = k();
        if (k != null && k.getParent() != null) {
            ((ViewGroup) k.getParent()).removeView(k);
        }
        g();
        this.f18839c = new PopupDialog(this.f18838b);
        n();
        this.f18839c.setContentView(k);
        this.f18839c.show();
        TbPageContext tbPageContext = this.f18838b;
        if (tbPageContext != null) {
            tbPageContext.registerListener(this.y);
        }
        NEGFeedBackView.b bVar = this.u;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f18841e);
        }
        this.f18845i = true;
    }
}
