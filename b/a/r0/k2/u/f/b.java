package b.a.r0.k2.u.f;

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
/* loaded from: classes5.dex */
public class b implements b.a.q0.i0.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19059a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ForumManageModel f19060b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final b.a.e.a.e f19061c;

    /* renamed from: d  reason: collision with root package name */
    public List<CustomBlueCheckRadioButton> f19062d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f19063e;

    /* renamed from: f  reason: collision with root package name */
    public View f19064f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f19065g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f19066h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19067i;
    public TextView j;
    public String k;
    public ScrollView l;
    public String m;
    public String n;
    public String o;

    /* loaded from: classes5.dex */
    public class a extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19068a;

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
            this.f19068a = bVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.f19068a.f19059a.getPageActivity().isDestroyed()) {
                return;
            }
            int loadDataMode = this.f19068a.f19060b.getLoadDataMode();
            if (loadDataMode != 2 && loadDataMode != 3 && loadDataMode != 4 && loadDataMode != 5) {
                if (loadDataMode != 6) {
                    return;
                }
                this.f19068a.m(((ForumManageModel.g) obj).f54272c);
                return;
            }
            ForumManageModel.g gVar = (ForumManageModel.g) obj;
            if (TextUtils.isEmpty(gVar.f54271b)) {
                gVar.f54271b = this.f19068a.f19059a.getString(gVar.f54270a ? b.a.r0.k2.l.operation_success : b.a.r0.k2.l.operation_failed);
            }
            BarManageResultListener.sendMessage(this.f19068a.f19060b.N(this.f19068a.f19060b.getLoadDataMode(), gVar));
        }
    }

    /* renamed from: b.a.r0.k2.u.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0956b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19069e;

        public C0956b(b bVar) {
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
            this.f19069e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f19069e.k = (String) compoundButton.getTag();
                if (this.f19069e.f19062d != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f19069e.f19062d) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f19069e.k != null && !str.equals(this.f19069e.k)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19070e;

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
            this.f19070e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f19070e.f19063e instanceof Dialog)) {
                b.a.e.e.m.g.b(this.f19070e.f19063e, this.f19070e.f19059a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19071e;

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
            this.f19071e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19071e.f19060b.T(this.f19071e.m, this.f19071e.n, this.f19071e.o, 2, this.f19071e.k);
                if (this.f19071e.f19063e instanceof Dialog) {
                    b.a.e.e.m.g.b(this.f19071e.f19063e, this.f19071e.f19059a);
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
        this.f19061c = new a(this);
        this.f19063e = null;
        this.f19064f = null;
        this.f19065g = null;
        this.f19066h = null;
        this.f19067i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f19059a = tbPageContext;
        ForumManageModel forumManageModel = new ForumManageModel(tbPageContext);
        this.f19060b = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.f19061c);
    }

    @Override // b.a.q0.i0.d.a
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f19060b.P()) {
            return;
        }
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.f19060b.T(str, str2, str3, z ? 3 : 6, null);
    }

    @Override // b.a.q0.i0.d.a
    public void b(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f19060b.P()) {
            return;
        }
        this.f19060b.T(str, str2, str3, z ? 5 : 4, null);
    }

    public final CustomBlueCheckRadioButton l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Activity pageActivity = this.f19059a.getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, b.a.e.e.p.l.g(pageActivity, b.a.r0.k2.g.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.f19066h);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void m(ArrayList<b.a.q0.s.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            if (this.f19064f == null) {
                this.f19064f = LayoutInflater.from(this.f19059a.getPageActivity()).inflate(b.a.r0.k2.j.commit_good, (ViewGroup) null);
            }
            if (this.f19063e == null) {
                Dialog dialog = new Dialog(this.f19059a.getPageActivity());
                this.f19063e = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f19063e.setCancelable(true);
                this.l = (ScrollView) this.f19064f.findViewById(b.a.r0.k2.i.good_scroll);
                this.f19063e.setContentView(this.f19064f);
                WindowManager.LayoutParams attributes = this.f19063e.getWindow().getAttributes();
                attributes.width = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds540);
                this.f19063e.getWindow().setAttributes(attributes);
                this.f19066h = new C0956b(this);
                this.f19065g = (LinearLayout) this.f19064f.findViewById(b.a.r0.k2.i.good_class_group);
                TextView textView = (TextView) this.f19064f.findViewById(b.a.r0.k2.i.dialog_button_cancel);
                this.j = textView;
                textView.setOnClickListener(new c(this));
                TextView textView2 = (TextView) this.f19064f.findViewById(b.a.r0.k2.i.dialog_button_ok);
                this.f19067i = textView2;
                textView2.setOnClickListener(new d(this));
            }
            this.f19065g.removeAllViews();
            this.f19062d = new ArrayList();
            CustomBlueCheckRadioButton l = l("0", this.f19059a.getString(b.a.r0.k2.l.thread_good_class));
            this.f19062d.add(l);
            l.setChecked(true);
            this.f19065g.addView(l);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    b.a.q0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton l2 = l(String.valueOf(m0Var.a()), m0Var.b());
                        this.f19062d.add(l2);
                        View view = new View(this.f19059a.getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds1));
                        SkinManager.setBackgroundColor(view, b.a.r0.k2.f.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f19065g.addView(view);
                        this.f19065g.addView(l2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = b.a.e.e.p.l.e(this.f19059a.getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = b.a.e.e.p.l.e(this.f19059a.getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = b.a.e.e.p.l.e(this.f19059a.getPageActivity(), 186.0f);
                }
                this.l.setLayoutParams(layoutParams2);
                this.l.removeAllViews();
                LinearLayout linearLayout = this.f19065g;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l.addView(this.f19065g);
                }
            }
            b.a.e.e.m.g.j(this.f19063e, this.f19059a);
        }
    }
}
