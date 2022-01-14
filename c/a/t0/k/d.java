package c.a.t0.k;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.q.x0;
import c.a.t0.k.b;
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
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener A;
    public Runnable B;
    public View.OnClickListener C;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f18601b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f18602c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f18603d;

    /* renamed from: e  reason: collision with root package name */
    public x0 f18604e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f18605f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1156b> f18606g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.k.b f18607h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18608i;

    /* renamed from: j  reason: collision with root package name */
    public int f18609j;
    public int k;
    public int l;
    public TextView m;
    public TBSpecificationBtn n;
    public c.a.s0.s.j0.n.b o;
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

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18610e;

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
            this.f18610e = dVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f18610e.u != null) {
                    this.f18610e.u.onCheckedChanged(this.f18610e.f18604e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1156b) {
                    b.C1156b c1156b = (b.C1156b) compoundButton.getTag();
                    if (z) {
                        if (!this.f18610e.f18606g.contains(c1156b)) {
                            this.f18610e.f18606g.add(c1156b);
                        }
                    } else {
                        this.f18610e.f18606g.remove(c1156b);
                    }
                }
                if (ListUtils.isEmpty(this.f18610e.f18606g)) {
                    return;
                }
                c.a.d.f.m.e.a().removeCallbacks(this.f18610e.B);
                c.a.d.f.m.e.a().postDelayed(this.f18610e.B, 500L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18611e;

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
            this.f18611e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18611e.h();
            }
        }
    }

    /* renamed from: c.a.t0.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1158d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18612e;

        public RunnableC1158d(d dVar) {
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
            this.f18612e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18612e.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f18613e;

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
            this.f18613e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18613e.m();
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
        this.f18602c = null;
        this.f18604e = null;
        this.f18605f = null;
        this.f18606g = new ArrayList();
        this.f18609j = 3;
        this.u = null;
        this.v = true;
        this.w = true;
        this.x = false;
        this.y = new a(this, 2001304);
        this.z = new b(this);
        this.A = new c(this);
        this.B = new RunnableC1158d(this);
        this.C = new e(this);
        this.a = tbPageContext.getPageActivity();
        this.f18601b = tbPageContext;
        l();
    }

    public final void g() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f18609j) {
            return;
        }
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f18603d);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
        this.f18609j = skinType;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PopupDialog popupDialog = this.f18602c;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.f18602c = null;
            }
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f18606g)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (b.C1156b c1156b : this.f18606g) {
                if (c1156b != null) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(c1156b.f18586c);
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
            if (this.f18604e == null || arrayList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (!ListUtils.isEmpty(this.f18606g)) {
                for (b.C1156b c1156b : this.f18606g) {
                    if (c1156b != null) {
                        arrayList.add(Integer.valueOf(c1156b.f18585b));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(c1156b.f18585b));
                        if (sb2.length() != 0) {
                            sb2.append(",");
                        }
                        sb2.append(c1156b.f18587d);
                    }
                }
            }
            try {
                jSONObject.put("tid", this.f18604e.f());
                if (sb.length() != 0) {
                    jSONObject.put("dislike_ids", sb.toString());
                }
                jSONObject.put("fid", this.f18604e.c());
                jSONObject.put("click_time", System.currentTimeMillis());
                if (!StringUtils.isNull(this.f18604e.getType())) {
                    jSONObject.put("type", this.f18604e.getType());
                }
                if (this.f18604e.h() != 0) {
                    jSONObject.put("topic_id", this.f18604e.h());
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
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.f18603d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f18603d = viewGroup;
                this.m = (TextView) viewGroup.findViewById(R.id.head_text);
                this.n = (TBSpecificationBtn) this.f18603d.findViewById(R.id.uninterested_btn);
                c.a.s0.s.j0.n.b bVar = new c.a.s0.s.j0.n.b();
                this.o = bVar;
                bVar.r(R.color.CAM_X0304);
                this.n.setConfig(this.o);
                this.n.setOnClickListener(this.C);
                this.n.setText(this.a.getResources().getString(R.string.not_interested));
                this.n.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.f18603d;
                int i2 = this.k;
                viewGroup2.setPadding(i2, 0, i2, this.w ? 0 : this.l);
            }
            View h2 = this.f18607h.h();
            if (h2 != null && h2.getParent() == null) {
                this.f18603d.addView(h2);
            }
            if (this.p == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.p = linearLayout;
                this.s = linearLayout.findViewById(R.id.top_line);
                this.r = (TextView) this.p.findViewById(R.id.dialog_bottom_cancel_button);
                this.q = (TextView) this.p.findViewById(R.id.dialog_bottom_certain_button);
                View findViewById = this.p.findViewById(R.id.middle_line);
                this.t = findViewById;
                findViewById.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setOnClickListener(this.A);
                this.f18603d.addView(this.p);
            }
            return this.f18603d;
        }
        return (View) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = n.f(this.a, R.dimen.M_W_X005);
            this.l = n.f(this.a, R.dimen.M_H_X007);
            c.a.t0.k.b bVar = new c.a.t0.k.b(this.f18601b);
            this.f18607h = bVar;
            bVar.o(this.z);
            this.f18607h.n(true);
            this.f18607h.m(true);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f18604e == null || this.f18602c == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        JSONObject j2 = j(arrayList);
        if (this.v) {
            if (!StringUtils.isNull(this.f18604e.getType())) {
                CustomMessage customMessage = new CustomMessage(2921324, this.f18601b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, j2);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } else {
                CustomMessage customMessage2 = new CustomMessage(2016488, this.f18601b.getUniqueId());
                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, j2);
                customResponsedMessage2.setOrginalMessage(customMessage2);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
            }
        }
        h();
        String string = this.a.getResources().getString(R.string.reduce_related_thread_recommend);
        if (j2 != null && "7".equals(j2.optString("dislike_ids"))) {
            string = this.a.getResources().getString(R.string.forbidden_forum_success1);
        }
        n.N(this.a, string);
        NEGFeedBackView.b bVar = this.u;
        if (bVar != null) {
            bVar.onNEGFeedbackConfirm(arrayList, i(), this.f18604e);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f18608i && this.f18606g.size() != 0) {
            this.f18606g.clear();
        }
    }

    public void o(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x0Var) == null) || x0Var == null) {
            return;
        }
        this.f18604e = x0Var;
        SparseArray<String> b2 = x0Var.b();
        this.f18605f = b2;
        if (b2 != null && b2.size() > 9) {
            for (int size = this.f18605f.size() - 1; size >= 9; size--) {
                this.f18605f.removeAt(size);
            }
        }
        this.f18607h.j(x0Var);
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
            this.f18607h.m(z);
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
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.a == null) {
            return;
        }
        View k = k();
        if (k != null && k.getParent() != null) {
            ((ViewGroup) k.getParent()).removeView(k);
        }
        g();
        this.f18602c = new PopupDialog(this.f18601b);
        n();
        this.f18602c.setContentView(k);
        this.f18602c.show();
        TbPageContext tbPageContext = this.f18601b;
        if (tbPageContext != null) {
            tbPageContext.registerListener(this.y);
        }
        NEGFeedBackView.b bVar = this.u;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f18604e);
        }
        this.f18608i = true;
    }
}
