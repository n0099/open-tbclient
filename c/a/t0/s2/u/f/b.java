package c.a.t0.s2.u.f;

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
/* loaded from: classes8.dex */
public class b implements c.a.s0.j0.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ForumManageModel f22635b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final c.a.d.a.e f22636c;

    /* renamed from: d  reason: collision with root package name */
    public List<CustomBlueCheckRadioButton> f22637d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f22638e;

    /* renamed from: f  reason: collision with root package name */
    public View f22639f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f22640g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f22641h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f22642i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f22643j;
    public String k;
    public ScrollView l;
    public String m;
    public String n;
    public String o;

    /* loaded from: classes8.dex */
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
            int loadDataMode = this.a.f22635b.getLoadDataMode();
            if (loadDataMode != 2 && loadDataMode != 3 && loadDataMode != 4 && loadDataMode != 5) {
                if (loadDataMode != 6) {
                    return;
                }
                this.a.m(((ForumManageModel.g) obj).f48200c);
                return;
            }
            ForumManageModel.g gVar = (ForumManageModel.g) obj;
            if (TextUtils.isEmpty(gVar.f48199b)) {
                gVar.f48199b = this.a.a.getString(gVar.a ? c.a.t0.s2.l.operation_success : c.a.t0.s2.l.operation_failed);
            }
            BarManageResultListener.sendMessage(this.a.f22635b.N(this.a.f22635b.getLoadDataMode(), gVar));
        }
    }

    /* renamed from: c.a.t0.s2.u.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1398b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22644e;

        public C1398b(b bVar) {
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
            this.f22644e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f22644e.k = (String) compoundButton.getTag();
                if (this.f22644e.f22637d != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f22644e.f22637d) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f22644e.k != null && !str.equals(this.f22644e.k)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22645e;

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
            this.f22645e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f22645e.f22638e instanceof Dialog)) {
                c.a.d.f.m.g.b(this.f22645e.f22638e, this.f22645e.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22646e;

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
            this.f22646e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22646e.f22635b.T(this.f22646e.m, this.f22646e.n, this.f22646e.o, 2, this.f22646e.k);
                if (this.f22646e.f22638e instanceof Dialog) {
                    c.a.d.f.m.g.b(this.f22646e.f22638e, this.f22646e.a);
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
        this.f22636c = new a(this);
        this.f22638e = null;
        this.f22639f = null;
        this.f22640g = null;
        this.f22641h = null;
        this.f22642i = null;
        this.f22643j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = tbPageContext;
        ForumManageModel forumManageModel = new ForumManageModel(tbPageContext);
        this.f22635b = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.f22636c);
    }

    @Override // c.a.s0.j0.e.a
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f22635b.P()) {
            return;
        }
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.f22635b.T(str, str2, str3, z ? 3 : 6, null);
    }

    @Override // c.a.s0.j0.e.a
    public void b(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f22635b.P()) {
            return;
        }
        this.f22635b.T(str, str2, str3, z ? 5 : 4, null);
    }

    public final CustomBlueCheckRadioButton l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.d.f.p.n.f(pageActivity, c.a.t0.s2.g.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.f22641h);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void m(ArrayList<c.a.s0.s.q.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            if (this.f22639f == null) {
                this.f22639f = LayoutInflater.from(this.a.getPageActivity()).inflate(c.a.t0.s2.j.commit_good, (ViewGroup) null);
            }
            if (this.f22638e == null) {
                Dialog dialog = new Dialog(this.a.getPageActivity());
                this.f22638e = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f22638e.setCancelable(true);
                this.l = (ScrollView) this.f22639f.findViewById(c.a.t0.s2.i.good_scroll);
                this.f22638e.setContentView(this.f22639f);
                WindowManager.LayoutParams attributes = this.f22638e.getWindow().getAttributes();
                attributes.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.ds540);
                this.f22638e.getWindow().setAttributes(attributes);
                this.f22641h = new C1398b(this);
                this.f22640g = (LinearLayout) this.f22639f.findViewById(c.a.t0.s2.i.good_class_group);
                TextView textView = (TextView) this.f22639f.findViewById(c.a.t0.s2.i.dialog_button_cancel);
                this.f22643j = textView;
                textView.setOnClickListener(new c(this));
                TextView textView2 = (TextView) this.f22639f.findViewById(c.a.t0.s2.i.dialog_button_ok);
                this.f22642i = textView2;
                textView2.setOnClickListener(new d(this));
            }
            this.f22640g.removeAllViews();
            this.f22637d = new ArrayList();
            CustomBlueCheckRadioButton l = l("0", this.a.getString(c.a.t0.s2.l.thread_good_class));
            this.f22637d.add(l);
            l.setChecked(true);
            this.f22640g.addView(l);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.s0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton l2 = l(String.valueOf(m0Var.a()), m0Var.b());
                        this.f22637d.add(l2);
                        View view = new View(this.a.getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.ds1));
                        SkinManager.setBackgroundColor(view, c.a.t0.s2.f.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f22640g.addView(view);
                        this.f22640g.addView(l2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.d.f.p.n.d(this.a.getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.d.f.p.n.d(this.a.getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.d.f.p.n.d(this.a.getPageActivity(), 186.0f);
                }
                this.l.setLayoutParams(layoutParams2);
                this.l.removeAllViews();
                LinearLayout linearLayout = this.f22640g;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l.addView(this.f22640g);
                }
            }
            c.a.d.f.m.g.j(this.f22638e, this.a);
        }
    }
}
