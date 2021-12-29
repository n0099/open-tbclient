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
    public ForumManageModel f23278b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final c.a.d.a.e f23279c;

    /* renamed from: d  reason: collision with root package name */
    public List<CustomBlueCheckRadioButton> f23280d;

    /* renamed from: e  reason: collision with root package name */
    public Dialog f23281e;

    /* renamed from: f  reason: collision with root package name */
    public View f23282f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f23283g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f23284h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f23285i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f23286j;

    /* renamed from: k  reason: collision with root package name */
    public String f23287k;
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
            int loadDataMode = this.a.f23278b.getLoadDataMode();
            if (loadDataMode != 2 && loadDataMode != 3 && loadDataMode != 4 && loadDataMode != 5) {
                if (loadDataMode != 6) {
                    return;
                }
                this.a.m(((ForumManageModel.g) obj).f50085c);
                return;
            }
            ForumManageModel.g gVar = (ForumManageModel.g) obj;
            if (TextUtils.isEmpty(gVar.f50084b)) {
                gVar.f50084b = this.a.a.getString(gVar.a ? c.a.t0.s2.l.operation_success : c.a.t0.s2.l.operation_failed);
            }
            BarManageResultListener.sendMessage(this.a.f23278b.N(this.a.f23278b.getLoadDataMode(), gVar));
        }
    }

    /* renamed from: c.a.t0.s2.u.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1383b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23288e;

        public C1383b(b bVar) {
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
            this.f23288e = bVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f23288e.f23287k = (String) compoundButton.getTag();
                if (this.f23288e.f23280d != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f23288e.f23280d) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f23288e.f23287k != null && !str.equals(this.f23288e.f23287k)) {
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
        public final /* synthetic */ b f23289e;

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
            this.f23289e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f23289e.f23281e instanceof Dialog)) {
                c.a.d.f.m.g.b(this.f23289e.f23281e, this.f23289e.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23290e;

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
            this.f23290e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23290e.f23278b.T(this.f23290e.m, this.f23290e.n, this.f23290e.o, 2, this.f23290e.f23287k);
                if (this.f23290e.f23281e instanceof Dialog) {
                    c.a.d.f.m.g.b(this.f23290e.f23281e, this.f23290e.a);
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
        this.f23279c = new a(this);
        this.f23281e = null;
        this.f23282f = null;
        this.f23283g = null;
        this.f23284h = null;
        this.f23285i = null;
        this.f23286j = null;
        this.f23287k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = tbPageContext;
        ForumManageModel forumManageModel = new ForumManageModel(tbPageContext);
        this.f23278b = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.f23279c);
    }

    @Override // c.a.s0.j0.e.a
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f23278b.P()) {
            return;
        }
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.f23278b.T(str, str2, str3, z ? 3 : 6, null);
    }

    @Override // c.a.s0.j0.e.a
    public void b(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.f23278b.P()) {
            return;
        }
        this.f23278b.T(str, str2, str3, z ? 5 : 4, null);
    }

    public final CustomBlueCheckRadioButton l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.d.f.p.n.f(pageActivity, c.a.t0.s2.g.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.f23284h);
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
            if (this.f23282f == null) {
                this.f23282f = LayoutInflater.from(this.a.getPageActivity()).inflate(c.a.t0.s2.j.commit_good, (ViewGroup) null);
            }
            if (this.f23281e == null) {
                Dialog dialog = new Dialog(this.a.getPageActivity());
                this.f23281e = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f23281e.setCancelable(true);
                this.l = (ScrollView) this.f23282f.findViewById(c.a.t0.s2.i.good_scroll);
                this.f23281e.setContentView(this.f23282f);
                WindowManager.LayoutParams attributes = this.f23281e.getWindow().getAttributes();
                attributes.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.ds540);
                this.f23281e.getWindow().setAttributes(attributes);
                this.f23284h = new C1383b(this);
                this.f23283g = (LinearLayout) this.f23282f.findViewById(c.a.t0.s2.i.good_class_group);
                TextView textView = (TextView) this.f23282f.findViewById(c.a.t0.s2.i.dialog_button_cancel);
                this.f23286j = textView;
                textView.setOnClickListener(new c(this));
                TextView textView2 = (TextView) this.f23282f.findViewById(c.a.t0.s2.i.dialog_button_ok);
                this.f23285i = textView2;
                textView2.setOnClickListener(new d(this));
            }
            this.f23283g.removeAllViews();
            this.f23280d = new ArrayList();
            CustomBlueCheckRadioButton l = l("0", this.a.getString(c.a.t0.s2.l.thread_good_class));
            this.f23280d.add(l);
            l.setChecked(true);
            this.f23283g.addView(l);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.s0.s.q.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton l2 = l(String.valueOf(m0Var.a()), m0Var.b());
                        this.f23280d.add(l2);
                        View view = new View(this.a.getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.ds1));
                        SkinManager.setBackgroundColor(view, c.a.t0.s2.f.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f23283g.addView(view);
                        this.f23283g.addView(l2);
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
                LinearLayout linearLayout = this.f23283g;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l.addView(this.f23283g);
                }
            }
            c.a.d.f.m.g.j(this.f23281e, this.a);
        }
    }
}
