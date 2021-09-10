package c.a.r0.j2.k.e;

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
public class b implements c.a.q0.i0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19858a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ForumManageModel f19859b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final c.a.e.a.e f19860c;

    /* renamed from: d  reason: collision with root package name */
    public List<CustomBlueCheckRadioButton> f19861d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f19862e;

    /* renamed from: f  reason: collision with root package name */
    public View f19863f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f19864g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f19865h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19866i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f19867j;
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
        public final /* synthetic */ b f19868a;

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
            this.f19868a = bVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.f19868a.f19858a.getPageActivity().isDestroyed()) {
                return;
            }
            int loadDataMode = this.f19868a.f19859b.getLoadDataMode();
            if (loadDataMode != 2 && loadDataMode != 3 && loadDataMode != 4 && loadDataMode != 5) {
                if (loadDataMode != 6) {
                    return;
                }
                this.f19868a.m(((ForumManageModel.g) obj).f57149c);
                return;
            }
            ForumManageModel.g gVar = (ForumManageModel.g) obj;
            if (TextUtils.isEmpty(gVar.f57148b)) {
                gVar.f57148b = this.f19868a.f19858a.getString(gVar.f57147a ? R.string.operation_success : R.string.operation_failed);
            }
            BarManageResultListener.sendMessage(this.f19868a.f19859b.N(this.f19868a.f19859b.getLoadDataMode(), gVar));
        }
    }

    /* renamed from: c.a.r0.j2.k.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0950b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19869e;

        public C0950b(b bVar) {
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
            this.f19869e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f19869e.k = (String) compoundButton.getTag();
                if (this.f19869e.f19861d != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f19869e.f19861d) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f19869e.k != null && !str.equals(this.f19869e.k)) {
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
        public final /* synthetic */ b f19870e;

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
            this.f19870e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f19870e.f19862e instanceof Dialog)) {
                c.a.e.e.m.g.b(this.f19870e.f19862e, this.f19870e.f19858a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19871e;

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
            this.f19871e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19871e.f19859b.T(this.f19871e.m, this.f19871e.n, this.f19871e.o, 2, this.f19871e.k);
                if (this.f19871e.f19862e instanceof Dialog) {
                    c.a.e.e.m.g.b(this.f19871e.f19862e, this.f19871e.f19858a);
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
        this.f19860c = new a(this);
        this.f19862e = null;
        this.f19863f = null;
        this.f19864g = null;
        this.f19865h = null;
        this.f19866i = null;
        this.f19867j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.f19858a = tbPageContext;
        ForumManageModel forumManageModel = new ForumManageModel(tbPageContext);
        this.f19859b = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.f19860c);
    }

    @Override // c.a.q0.i0.c.a
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f19859b.P()) {
            return;
        }
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.f19859b.T(str, str2, str3, z ? 3 : 6, null);
    }

    @Override // c.a.q0.i0.c.a
    public void b(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f19859b.P()) {
            return;
        }
        this.f19859b.T(str, str2, str3, z ? 5 : 4, null);
    }

    public final CustomBlueCheckRadioButton l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Activity pageActivity = this.f19858a.getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.e.e.p.l.g(pageActivity, R.dimen.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.f19865h);
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
            if (this.f19863f == null) {
                this.f19863f = LayoutInflater.from(this.f19858a.getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            if (this.f19862e == null) {
                Dialog dialog = new Dialog(this.f19858a.getPageActivity());
                this.f19862e = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f19862e.setCancelable(true);
                this.l = (ScrollView) this.f19863f.findViewById(R.id.good_scroll);
                this.f19862e.setContentView(this.f19863f);
                WindowManager.LayoutParams attributes = this.f19862e.getWindow().getAttributes();
                attributes.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.f19862e.getWindow().setAttributes(attributes);
                this.f19865h = new C0950b(this);
                this.f19864g = (LinearLayout) this.f19863f.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.f19863f.findViewById(R.id.dialog_button_cancel);
                this.f19867j = textView;
                textView.setOnClickListener(new c(this));
                TextView textView2 = (TextView) this.f19863f.findViewById(R.id.dialog_button_ok);
                this.f19866i = textView2;
                textView2.setOnClickListener(new d(this));
            }
            this.f19864g.removeAllViews();
            this.f19861d = new ArrayList();
            CustomBlueCheckRadioButton l = l("0", this.f19858a.getString(R.string.thread_good_class));
            this.f19861d.add(l);
            l.setChecked(true);
            this.f19864g.addView(l);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.q0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton l2 = l(String.valueOf(m0Var.a()), m0Var.b());
                        this.f19861d.add(l2);
                        View view = new View(this.f19858a.getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f19864g.addView(view);
                        this.f19864g.addView(l2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19858a.getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19858a.getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f19858a.getPageActivity(), 186.0f);
                }
                this.l.setLayoutParams(layoutParams2);
                this.l.removeAllViews();
                LinearLayout linearLayout = this.f19864g;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l.addView(this.f19864g);
                }
            }
            c.a.e.e.m.g.j(this.f19862e, this.f19858a);
        }
    }
}
