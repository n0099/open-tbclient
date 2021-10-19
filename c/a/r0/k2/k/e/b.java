package c.a.r0.k2.k.e;

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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements c.a.q0.i0.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f20050a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ForumManageModel f20051b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final c.a.e.a.e f20052c;

    /* renamed from: d  reason: collision with root package name */
    public List<CustomBlueCheckRadioButton> f20053d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f20054e;

    /* renamed from: f  reason: collision with root package name */
    public View f20055f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f20056g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f20057h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f20058i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f20059j;
    public String k;
    public ScrollView l;
    public String m;
    public String n;
    public String o;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20060a;

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
            this.f20060a = bVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.f20060a.f20050a.getPageActivity().isDestroyed()) {
                return;
            }
            int loadDataMode = this.f20060a.f20051b.getLoadDataMode();
            if (loadDataMode != 2 && loadDataMode != 3 && loadDataMode != 4 && loadDataMode != 5) {
                if (loadDataMode != 6) {
                    return;
                }
                this.f20060a.m(((ForumManageModel.g) obj).f57200c);
                return;
            }
            ForumManageModel.g gVar = (ForumManageModel.g) obj;
            if (TextUtils.isEmpty(gVar.f57199b)) {
                gVar.f57199b = this.f20060a.f20050a.getString(gVar.f57198a ? R.string.operation_success : R.string.operation_failed);
            }
            BarManageResultListener.sendMessage(this.f20060a.f20051b.N(this.f20060a.f20051b.getLoadDataMode(), gVar));
        }
    }

    /* renamed from: c.a.r0.k2.k.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0957b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20061e;

        public C0957b(b bVar) {
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
            this.f20061e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f20061e.k = (String) compoundButton.getTag();
                if (this.f20061e.f20053d != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f20061e.f20053d) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f20061e.k != null && !str.equals(this.f20061e.k)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20062e;

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
            this.f20062e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f20062e.f20054e instanceof Dialog)) {
                c.a.e.e.m.g.b(this.f20062e.f20054e, this.f20062e.f20050a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20063e;

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
            this.f20063e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20063e.f20051b.T(this.f20063e.m, this.f20063e.n, this.f20063e.o, 2, this.f20063e.k);
                if (this.f20063e.f20054e instanceof Dialog) {
                    c.a.e.e.m.g.b(this.f20063e.f20054e, this.f20063e.f20050a);
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
        this.f20052c = new a(this);
        this.f20054e = null;
        this.f20055f = null;
        this.f20056g = null;
        this.f20057h = null;
        this.f20058i = null;
        this.f20059j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f20050a = tbPageContext;
        ForumManageModel forumManageModel = new ForumManageModel(tbPageContext);
        this.f20051b = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.f20052c);
    }

    @Override // c.a.q0.i0.d.a
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f20051b.P()) {
            return;
        }
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.f20051b.T(str, str2, str3, z ? 3 : 6, null);
    }

    @Override // c.a.q0.i0.d.a
    public void b(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f20051b.P()) {
            return;
        }
        this.f20051b.T(str, str2, str3, z ? 5 : 4, null);
    }

    public final CustomBlueCheckRadioButton l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Activity pageActivity = this.f20050a.getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.e.e.p.l.g(pageActivity, R.dimen.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.f20057h);
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
            if (this.f20055f == null) {
                this.f20055f = LayoutInflater.from(this.f20050a.getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            if (this.f20054e == null) {
                Dialog dialog = new Dialog(this.f20050a.getPageActivity());
                this.f20054e = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f20054e.setCancelable(true);
                this.l = (ScrollView) this.f20055f.findViewById(R.id.good_scroll);
                this.f20054e.setContentView(this.f20055f);
                WindowManager.LayoutParams attributes = this.f20054e.getWindow().getAttributes();
                attributes.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.f20054e.getWindow().setAttributes(attributes);
                this.f20057h = new C0957b(this);
                this.f20056g = (LinearLayout) this.f20055f.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.f20055f.findViewById(R.id.dialog_button_cancel);
                this.f20059j = textView;
                textView.setOnClickListener(new c(this));
                TextView textView2 = (TextView) this.f20055f.findViewById(R.id.dialog_button_ok);
                this.f20058i = textView2;
                textView2.setOnClickListener(new d(this));
            }
            this.f20056g.removeAllViews();
            this.f20053d = new ArrayList();
            CustomBlueCheckRadioButton l = l("0", this.f20050a.getString(R.string.thread_good_class));
            this.f20053d.add(l);
            l.setChecked(true);
            this.f20056g.addView(l);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.q0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton l2 = l(String.valueOf(m0Var.a()), m0Var.b());
                        this.f20053d.add(l2);
                        View view = new View(this.f20050a.getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f20056g.addView(view);
                        this.f20056g.addView(l2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20050a.getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20050a.getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20050a.getPageActivity(), 186.0f);
                }
                this.l.setLayoutParams(layoutParams2);
                this.l.removeAllViews();
                LinearLayout linearLayout = this.f20056g;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l.addView(this.f20056g);
                }
            }
            c.a.e.e.m.g.j(this.f20054e, this.f20050a);
        }
    }
}
