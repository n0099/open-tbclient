package c.a.r0.q2.u.f;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.module.pb.BarManageResultListener;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements c.a.q0.j0.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ForumManageModel f21760b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final c.a.d.a.e f21761c;

    /* renamed from: d  reason: collision with root package name */
    public List<CustomBlueCheckRadioButton> f21762d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f21763e;

    /* renamed from: f  reason: collision with root package name */
    public View f21764f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f21765g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f21766h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21767i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f21768j;

    /* renamed from: k  reason: collision with root package name */
    public String f21769k;
    public ScrollView l;
    public String m;
    public String n;
    public String o;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.a.a.getPageActivity().isDestroyed()) {
                return;
            }
            int loadDataMode = this.a.f21760b.getLoadDataMode();
            if (loadDataMode != 2 && loadDataMode != 3 && loadDataMode != 4 && loadDataMode != 5) {
                if (loadDataMode != 6) {
                    return;
                }
                this.a.m(((ForumManageModel.g) obj).f49331c);
                return;
            }
            ForumManageModel.g gVar = (ForumManageModel.g) obj;
            if (TextUtils.isEmpty(gVar.f49330b)) {
                gVar.f49330b = this.a.a.getString(gVar.a ? c.a.r0.q2.l.operation_success : c.a.r0.q2.l.operation_failed);
            }
            BarManageResultListener.sendMessage(this.a.f21760b.N(this.a.f21760b.getLoadDataMode(), gVar));
        }
    }

    /* renamed from: c.a.r0.q2.u.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1274b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21770e;

        public C1274b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21770e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f21770e.f21769k = (String) compoundButton.getTag();
                if (this.f21770e.f21762d != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f21770e.f21762d) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f21770e.f21769k != null && !str.equals(this.f21770e.f21769k)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21771e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21771e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f21771e.f21763e instanceof Dialog)) {
                c.a.d.f.m.g.b(this.f21771e.f21763e, this.f21771e.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21772e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21772e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21772e.f21760b.T(this.f21772e.m, this.f21772e.n, this.f21772e.o, 2, this.f21772e.f21769k);
                if (this.f21772e.f21763e instanceof Dialog) {
                    c.a.d.f.m.g.b(this.f21772e.f21763e, this.f21772e.a);
                }
            }
        }
    }

    public b(@NonNull TbPageContext tbPageContext) {
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
        this.f21761c = new a(this);
        this.f21763e = null;
        this.f21764f = null;
        this.f21765g = null;
        this.f21766h = null;
        this.f21767i = null;
        this.f21768j = null;
        this.f21769k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = tbPageContext;
        ForumManageModel forumManageModel = new ForumManageModel(tbPageContext);
        this.f21760b = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.f21761c);
    }

    @Override // c.a.q0.j0.e.a
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f21760b.P()) {
            return;
        }
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.f21760b.T(str, str2, str3, z ? 3 : 6, null);
    }

    @Override // c.a.q0.j0.e.a
    public void b(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f21760b.P()) {
            return;
        }
        this.f21760b.T(str, str2, str3, z ? 5 : 4, null);
    }

    public final CustomBlueCheckRadioButton l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.d.f.p.l.f(pageActivity, c.a.r0.q2.g.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.f21766h);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void m(ArrayList<c.a.q0.s.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            if (this.f21764f == null) {
                this.f21764f = LayoutInflater.from(this.a.getPageActivity()).inflate(c.a.r0.q2.j.commit_good, (ViewGroup) null);
            }
            if (this.f21763e == null) {
                Dialog dialog = new Dialog(this.a.getPageActivity());
                this.f21763e = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f21763e.setCancelable(true);
                this.l = (ScrollView) this.f21764f.findViewById(c.a.r0.q2.i.good_scroll);
                this.f21763e.setContentView(this.f21764f);
                WindowManager.LayoutParams attributes = this.f21763e.getWindow().getAttributes();
                attributes.width = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), c.a.r0.q2.g.ds540);
                this.f21763e.getWindow().setAttributes(attributes);
                this.f21766h = new C1274b(this);
                this.f21765g = (LinearLayout) this.f21764f.findViewById(c.a.r0.q2.i.good_class_group);
                TextView textView = (TextView) this.f21764f.findViewById(c.a.r0.q2.i.dialog_button_cancel);
                this.f21768j = textView;
                textView.setOnClickListener(new c(this));
                TextView textView2 = (TextView) this.f21764f.findViewById(c.a.r0.q2.i.dialog_button_ok);
                this.f21767i = textView2;
                textView2.setOnClickListener(new d(this));
            }
            this.f21765g.removeAllViews();
            this.f21762d = new ArrayList();
            CustomBlueCheckRadioButton l = l("0", this.a.getString(c.a.r0.q2.l.thread_good_class));
            this.f21762d.add(l);
            l.setChecked(true);
            this.f21765g.addView(l);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.q0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton l2 = l(String.valueOf(m0Var.a()), m0Var.b());
                        this.f21762d.add(l2);
                        View view = new View(this.a.getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), c.a.r0.q2.g.ds1));
                        SkinManager.setBackgroundColor(view, c.a.r0.q2.f.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f21765g.addView(view);
                        this.f21765g.addView(l2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.d.f.p.l.d(this.a.getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.d.f.p.l.d(this.a.getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.d.f.p.l.d(this.a.getPageActivity(), 186.0f);
                }
                this.l.setLayoutParams(layoutParams2);
                this.l.removeAllViews();
                LinearLayout linearLayout = this.f21765g;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l.addView(this.f21765g);
                }
            }
            c.a.d.f.m.g.j(this.f21763e, this.a);
        }
    }
}
