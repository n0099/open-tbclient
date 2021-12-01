package c.a.r0.d1.b2.f;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.s.i;
import c.a.r0.d1.b2.f.b;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.e1;
import c.a.r0.d1.f1;
import c.a.r0.d1.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public NavigationBar C;
    public TextView D;
    public TextView E;
    public TextView F;
    public c.a.r0.k0.g G;
    public EditorScrollView H;
    public List<c.a.r0.d1.b2.f.b> I;
    public ForumRuleBaseData J;
    public BdTopToast K;
    public boolean L;
    public int M;
    public PopupDialog N;
    public c.a.q0.s.s.i O;
    public boolean P;
    public Runnable Q;
    public i.d R;
    public i.d S;

    /* renamed from: e  reason: collision with root package name */
    public final TbPageContext<?> f15253e;

    /* renamed from: f  reason: collision with root package name */
    public final String f15254f;

    /* renamed from: g  reason: collision with root package name */
    public final String f15255g;

    /* renamed from: h  reason: collision with root package name */
    public final String f15256h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.d1.b2.b.b f15257i;

    /* renamed from: j  reason: collision with root package name */
    public ForumRulesEditActivity f15258j;

    /* renamed from: k  reason: collision with root package name */
    public View f15259k;
    public View l;
    public View m;
    public RelativeLayout n;
    public RelativeLayout o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public EMTextView v;
    public EMTextView w;
    public EMTextView x;
    public EditText y;
    public EditText z;

    /* renamed from: c.a.r0.d1.b2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0927a implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0927a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
                if (this.a.f15258j != null) {
                    this.a.f15258j.finish();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f15260e;

        public b(a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15260e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15260e.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15261e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15261e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15261e.s(true, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
                l.w(this.a.f15253e.getPageActivity(), this.a.y);
                l.w(this.a.f15253e.getPageActivity(), this.a.z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15262e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15262e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.f15262e.b0(length);
                a.V(this.f15262e.u, length, 50);
                this.f15262e.M();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15263e;

        /* renamed from: c.a.r0.d1.b2.f.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnTouchListenerC0928a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public View$OnTouchListenerC0928a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (motionEvent.getAction() == 3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15263e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.f15263e.t(length);
                a.V(this.f15263e.w, length, 500);
                this.f15263e.M();
                if (this.f15263e.z.getLineCount() > 6) {
                    this.f15263e.z.setOnTouchListener(new View$OnTouchListenerC0928a(this));
                } else {
                    this.f15263e.z.setOnTouchListener(null);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.d1.b2.f.b f15264e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15265f;

        /* renamed from: c.a.r0.d1.b2.f.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0929a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f15266e;

            public View$OnClickListenerC0929a(g gVar) {
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
                this.f15266e = gVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    g gVar = this.f15266e;
                    gVar.f15265f.Q(gVar.f15264e);
                }
            }
        }

        public g(a aVar, c.a.r0.d1.b2.f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15265f = aVar;
            this.f15264e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f15264e.k().getText().toString().length() != 0 || this.f15264e.l().getText().toString().length() != 0) {
                    this.f15265f.Z(new View$OnClickListenerC0929a(this));
                } else {
                    this.f15265f.Q(this.f15264e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.r0.d1.b2.f.b.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15267e;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15267e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15267e.H.fullScroll(130);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public j(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, c.a.r0.d1.b2.b.b bVar, View view, String str, String str2, String str3, String str4, int i2, ForumRulesEditActivity forumRulesEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, view, str, str2, str3, str4, Integer.valueOf(i2), forumRulesEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I = new ArrayList();
        this.J = new ForumRuleBaseData();
        this.L = true;
        this.P = false;
        this.Q = new c(this);
        this.R = new k(this);
        this.S = new C0927a(this);
        this.f15253e = tbPageContext;
        this.f15254f = str;
        this.f15255g = str2;
        this.f15256h = str4;
        this.M = i2;
        this.f15258j = forumRulesEditActivity;
        this.f15257i = bVar;
        D(view, str3);
    }

    public static void V(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, textView, i2, i3) == null) {
            textView.setText(i2 + "/" + i3);
            if (i2 > i3) {
                c.a.q0.s.u.c.d(textView).v(c1.CAM_X0301);
            } else {
                c.a.q0.s.u.c.d(textView).v(c1.CAM_X0111);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.I.size() <= 0 || this.B == null) {
            return;
        }
        c.a.r0.d1.b2.f.b bVar = this.I.get(0);
        this.B.removeView(bVar.m());
        this.I.remove(bVar);
        L();
        O();
    }

    public void B() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (popupDialog = this.N) != null && popupDialog.isShowing()) {
            this.N.dismiss();
        }
    }

    public final void C() {
        c.a.r0.k0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.G) == null) {
            return;
        }
        gVar.I();
    }

    public final void D(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, str) == null) {
            this.f15259k = view;
            this.C = (NavigationBar) view.findViewById(f1.navi_forumrule_title);
            this.A = (LinearLayout) view.findViewById(f1.rule_main_content);
            this.H = (EditorScrollView) view.findViewById(f1.scrool_main);
            this.p = (ImageView) view.findViewById(f1.forum_copy_icon);
            this.n = (RelativeLayout) view.findViewById(f1.forum_to_copy_rl);
            this.q = (ImageView) view.findViewById(f1.forum_copy_arrow);
            this.s = (EMTextView) view.findViewById(f1.forum_copy_title);
            this.l = view.findViewById(f1.forum_to_copy_divider);
            this.y = (EditText) view.findViewById(f1.et_big_title);
            this.t = (EMTextView) view.findViewById(f1.tv_used_example);
            this.u = (EMTextView) view.findViewById(f1.title_number);
            this.m = view.findViewById(f1.forum_title_divider);
            this.v = (EMTextView) view.findViewById(f1.preface_title);
            this.z = (EditText) view.findViewById(f1.preface_content);
            this.w = (EMTextView) view.findViewById(f1.preface_number);
            this.B = (LinearLayout) view.findViewById(f1.ll_add_rule);
            this.o = (RelativeLayout) view.findViewById(f1.create_rule_btn);
            this.x = (EMTextView) view.findViewById(f1.create_rule);
            this.r = (ImageView) view.findViewById(f1.create_rule_icon);
            TextView addTextButton = this.C.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f15253e.getString(i1.dialog_cancel), null);
            this.F = addTextButton;
            addTextButton.setId(f1.negative_feedback_view);
            this.F.setOnClickListener(this);
            this.C.setCenterTextTitle(this.f15253e.getString(i1.forum_rule_defalt_title_setting));
            EMTextView eMTextView = new EMTextView(this.f15253e.getPageActivity());
            this.D = eMTextView;
            eMTextView.setText(this.f15253e.getString(i1.video_preview));
            this.D.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            this.D.setPadding(UtilHelper.getDimenPixelSize(d1.M_W_X004), 0, UtilHelper.getDimenPixelSize(d1.M_W_X004), 0);
            this.D.setLayoutParams(layoutParams);
            this.C.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.D, this);
            EMTextView eMTextView2 = new EMTextView(this.f15253e.getPageActivity());
            this.E = eMTextView2;
            eMTextView2.setText(this.f15253e.getString(i1.push_commit));
            this.E.setEnabled(false);
            this.E.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(d1.M_W_X007);
            this.E.setPadding(UtilHelper.getDimenPixelSize(d1.M_W_X004), 0, 0, 0);
            this.E.setLayoutParams(layoutParams2);
            this.C.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.E, this);
            E();
            Y();
            s(false, null, false);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.n.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.C.setOnClickListener(this);
            V(this.u, 0, 50);
            V(this.w, 0, 500);
            this.H.setListener(new d(this));
            this.y.addTextChangedListener(new e(this));
            this.z.addTextChangedListener(new f(this));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.K = null;
            this.J = null;
            this.f15257i = null;
            this.f15258j = null;
            B();
            this.N = null;
            this.O = null;
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.N == null) {
                c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f15253e.getPageActivity());
                this.O = iVar;
                iVar.p(this.f15253e.getString(i1.forum_rule_draft_title));
                this.N = new PopupDialog(this.f15253e, this.O);
                ArrayList arrayList = new ArrayList();
                c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.f15253e.getString(i1.save), this.O);
                fVar.o(c1.CAM_X0302);
                fVar.l(this.R);
                arrayList.add(fVar);
                c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(this.f15253e.getString(i1.not_save), this.O);
                fVar2.l(this.S);
                arrayList.add(fVar2);
                this.O.l(new j(this));
                this.O.j(arrayList);
            }
            X();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.J == null) {
                this.J = new ForumRuleBaseData();
            }
            ArrayList arrayList = new ArrayList();
            List<c.a.r0.d1.b2.f.b> list = this.I;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.I.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                    c.a.r0.d1.b2.f.b bVar = this.I.get(i2);
                    EditText l = bVar.l();
                    SpanGroupEditText k2 = bVar.k();
                    if (l != null) {
                        forumRuleItemData.setTitle(l.getText().toString());
                    }
                    if (k2 != null) {
                        forumRuleItemData.setContent(k2.getSpanGroupManager().C());
                    }
                    forumRuleItemData.setStatus(i2 + "");
                    arrayList.add(forumRuleItemData);
                }
            }
            this.J.setTitle(this.y.getText().toString());
            this.J.setPreface(this.z.getText().toString());
            this.J.setList(arrayList);
        }
    }

    public final void L() {
        List<c.a.r0.d1.b2.f.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.I) == null) {
            return;
        }
        if (list.size() >= 20) {
            this.x.setText(this.f15253e.getString(i1.forum_rule_item_number_max));
            this.o.setEnabled(false);
            this.x.setEnabled(false);
            this.L = false;
            this.r.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_edit_add12, c.a.r0.t3.c.a(SkinManager.getColor(c1.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_PRESS));
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.o);
            d2.k(c1.CAM_X0902);
            d2.l(d1.L_X02);
            d2.n(i1.J_X07);
            d2.e(i1.A_X09);
            d2.f(c1.CAM_X0201);
            return;
        }
        this.x.setText(String.format(this.f15253e.getString(i1.forum_rule_item_add_number), Integer.valueOf(20 - this.I.size())));
        this.o.setEnabled(true);
        this.x.setEnabled(true);
        this.L = true;
        this.r.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_edit_add12, SkinManager.getColor(c1.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.o);
        d3.k(c1.CAM_X0902);
        d3.l(d1.L_X02);
        d3.n(i1.J_X07);
        d3.e(i1.A_X01);
        d3.f(c1.CAM_X0201);
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.E == null) {
            return;
        }
        if (y()) {
            this.E.setEnabled(true);
        } else {
            this.E.setEnabled(false);
        }
    }

    public final void O() {
        List<c.a.r0.d1.b2.f.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (list = this.I) == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            c.a.r0.d1.b2.f.b bVar = this.I.get(i2);
            bVar.t(i2);
            bVar.s(i2);
        }
    }

    public final void Q(c.a.r0.d1.b2.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) || bVar == null) {
            return;
        }
        this.B.removeView(bVar.m());
        this.I.remove(bVar);
        W();
        L();
        O();
        M();
    }

    public final void S(c.a.r0.d1.b2.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.o(new g(this, bVar));
        bVar.p(new h(this));
    }

    public void T(ForumRuleBaseData forumRuleBaseData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, forumRuleBaseData, z) == null) || this.f15259k == null || forumRuleBaseData == null) {
            return;
        }
        this.y.setText(forumRuleBaseData.getTitle());
        this.y.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
        this.z.setText(forumRuleBaseData.getPreface());
        this.z.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
        if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
            c.a.r0.d1.b2.f.b bVar = this.I.get(0);
            this.B.removeView(bVar.m());
            this.I.remove(bVar);
            for (int i2 = 0; i2 < forumRuleBaseData.getPbDataList().size(); i2++) {
                s(false, forumRuleBaseData.getPbDataList().get(i2), !z);
            }
            return;
        }
        A();
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.I.get(0) == null) {
            return;
        }
        if (this.I.size() == 1) {
            this.I.get(0).q(false);
        } else {
            this.I.get(0).q(true);
        }
    }

    public void X() {
        ForumRulesEditActivity forumRulesEditActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.N == null || (forumRulesEditActivity = this.f15258j) == null || forumRulesEditActivity.isFinishing()) {
            return;
        }
        this.N.showDialog();
    }

    public final void Y() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.G == null && (relativeLayout = this.n) != null) {
            c.a.r0.k0.g gVar = new c.a.r0.k0.g(this.f15253e, relativeLayout);
            this.G = gVar;
            gVar.g0(e1.bg_tip_blue_up_left);
            this.G.O(16);
            this.G.U(true);
            this.G.h0(true);
            this.G.N(3000);
            this.G.j0(UtilHelper.getDimenPixelSize(d1.tbds20));
            this.G.m0(this.f15253e.getString(i1.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    public final void Z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f15253e.getPageActivity());
            lVar.q(i1.forum_rule_item_del_dialog_title);
            lVar.j(i1.forum_rule_item_del_dialog_abstract);
            lVar.p(new TBAlertConfig.a(i1.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a(i1.del_post, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, onClickListener)));
            lVar.f();
            lVar.g(false);
            lVar.t();
        }
    }

    public final void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            BdTopToast bdTopToast = this.K;
            if (bdTopToast == null || !bdTopToast.isShown()) {
                BdTopToast content = new BdTopToast(this.f15253e.getPageActivity(), 2000).setIcon(false).setContent(str);
                this.K = content;
                content.show((ViewGroup) this.f15259k.findViewById(f1.ll_forum_rule_all));
            }
        }
    }

    public final void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (i2 > 0) {
                this.t.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
                layoutParams.width = -1;
                this.y.setLayoutParams(layoutParams);
                return;
            }
            this.t.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
            layoutParams2.width = -2;
            this.y.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view == this.F) {
                G();
            } else if (view == this.E) {
                v();
            } else if (view == this.D) {
                K();
                this.f15253e.sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.f15253e.getPageActivity(), this.f15254f, this.f15255g, this.J, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.f15256h, this.M)));
            } else if (view == this.n) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsActivityConfig(this.f15253e.getPageActivity()).createNormalCfg(this.f15255g, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
            } else if (view == this.t) {
                z();
            } else if (view != this.A && view != this.C) {
                if (view == this.o) {
                    c.a.d.f.m.e.a().removeCallbacks(this.Q);
                    c.a.d.f.m.e.a().postDelayed(this.Q, 300L);
                }
            } else {
                l.w(this.f15253e.getPageActivity(), this.y);
                l.w(this.f15253e.getPageActivity(), this.z);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            A();
            q(i1.forum_rule_defalt_one_title, i1.forum_rule_defalt_one_content);
            q(i1.forum_rule_defalt_two_title, i1.forum_rule_defalt_two_content);
            q(i1.forum_rule_defalt_three_title, i1.forum_rule_defalt_three_content);
            q(i1.forum_rule_defalt_four_title, i1.forum_rule_defalt_four_content);
            s(false, null, false);
        }
    }

    public final void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) || this.B == null) {
            return;
        }
        c.a.r0.d1.b2.f.b bVar = new c.a.r0.d1.b2.f.b(this.f15253e.getPageActivity());
        S(bVar);
        r(bVar);
        String string = TbadkApplication.getInst().getResources().getString(i2);
        String string2 = TbadkApplication.getInst().getResources().getString(i3);
        bVar.l().setText(string);
        bVar.l().setSelection(string.length());
        bVar.k().insert(string2);
        bVar.k().setSelection(bVar.k().getText().toString().length());
    }

    public final void r(c.a.r0.d1.b2.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) || bVar == null) {
            return;
        }
        this.B.addView(bVar.m());
        this.I.add(bVar);
        W();
        if (this.I.indexOf(bVar) != -1) {
            bVar.t(this.I.indexOf(bVar));
            bVar.s(this.I.indexOf(bVar));
        }
        M();
        L();
    }

    public final void s(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), forumRuleItemPbData, Boolean.valueOf(z2)}) == null) || this.B == null) {
            return;
        }
        c.a.r0.d1.b2.f.b bVar = new c.a.r0.d1.b2.f.b(this.f15253e.getPageActivity());
        S(bVar);
        r(bVar);
        if (forumRuleItemPbData != null) {
            bVar.l().setText(forumRuleItemPbData.title);
            EditText l = bVar.l();
            String str = forumRuleItemPbData.title;
            l.setSelection(str != null ? str.length() : 0);
            if (forumRuleItemPbData.mContent != null) {
                for (int i2 = 0; i2 < forumRuleItemPbData.mContent.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i2);
                    if (forumRuleItemPbContentData != null) {
                        if ("a".equals(forumRuleItemPbContentData.tag)) {
                            TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                            SpanGroupEditText k2 = bVar.k();
                            tbLinkSpanGroup.a(k2.getText(), k2.getSelectionEnd(), k2.getSelectionEnd(), (int) k2.getTextSize());
                            tbLinkSpanGroup.C(forumRuleItemPbContentData.href);
                            tbLinkSpanGroup.z(forumRuleItemPbContentData.value);
                            tbLinkSpanGroup.r();
                            k2.getSpanGroupManager().F(tbLinkSpanGroup);
                        } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                            bVar.k().insert(forumRuleItemPbContentData.value);
                        } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                            bVar.k().insert("\r\n");
                        }
                    }
                }
            }
            bVar.k().setSelection(bVar.k().getText().toString().length());
            if (z2 && "1".equals(forumRuleItemPbData.status)) {
                bVar.l().setTextColor(SkinManager.getColor(c1.CAM_X0301));
                bVar.k().setTextColor(SkinManager.getColor(c1.CAM_X0301));
                bVar.r(true);
            }
        }
        if (z) {
            c.a.d.f.m.e.a().post(new i(this));
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (i2 == 0 && !this.P) {
                if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                    c.a.r0.d1.b2.e.a.c(UtilHelper.getDimenPixelSize(d1.tbds6), UtilHelper.getDimenPixelSize(d1.tbds20), this.z);
                    this.P = true;
                } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                    c.a.r0.d1.b2.e.a.c(0, UtilHelper.getDimenPixelSize(d1.tbds_20), this.z);
                    this.P = true;
                }
            } else if (this.P) {
                this.P = false;
                c.a.r0.d1.b2.e.a.c(0, 0, this.z);
            }
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.f15259k == null) {
            return;
        }
        c.a.q0.s.u.c.d(this.A).f(c1.CAM_X0201);
        c.a.q0.s.u.c.d(this.s).v(c1.CAM_X0105);
        c.a.q0.s.u.c.d(this.l).f(c1.CAM_X0210);
        c.a.q0.s.u.c.d(this.m).f(c1.CAM_X0210);
        c.a.q0.s.u.c.d(this.u).v(c1.CAM_X0111);
        c.a.q0.s.u.c.d(this.w).v(c1.CAM_X0111);
        c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.t);
        d2.v(c1.CAM_X0304);
        d2.A(i1.F_X02);
        c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.v);
        d3.v(c1.CAM_X0107);
        d3.A(i1.F_X02);
        c.a.q0.s.u.c.d(this.F).x(c1.CAM_X0105);
        c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(this.D);
        d4.x(c1.CAM_X0302);
        d4.z(d1.T_X05);
        c.a.q0.s.u.c.d(this.E).z(d1.T_X05);
        this.E.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(c1.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
        this.x.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(c1.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
        this.y.setHintTextColor(SkinManager.getColor(c1.CAM_X0111));
        this.y.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        this.z.setHintTextColor(SkinManager.getColor(c1.CAM_X0111));
        this.z.setTextColor(SkinManager.getColor(c1.CAM_X0105));
        this.p.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_frs_recommend_copy18, SkinManager.getColor(c1.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.q.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_list_arrow16_right, SkinManager.getColor(c1.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        if (this.L) {
            this.r.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_edit_add12, SkinManager.getColor(c1.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            this.r.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_edit_add12, c.a.r0.t3.c.a(SkinManager.getColor(c1.CAM_X0304), SkinManager.RESOURCE_ALPHA_PRESS), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        NavigationBar navigationBar = this.C;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f15253e, i2);
        }
        c.a.q0.s.s.i iVar = this.O;
        if (iVar != null) {
            iVar.i();
        }
        if (i2 == 0) {
            c.a.r0.l4.i.n(this.y, e1.edittext_cursor);
            c.a.r0.l4.i.n(this.z, e1.edittext_cursor);
        } else {
            c.a.r0.l4.i.n(this.y, e1.edittext_cursor_1);
            c.a.r0.l4.i.n(this.z, e1.edittext_cursor_1);
        }
        c.a.q0.s.u.c d5 = c.a.q0.s.u.c.d(this.o);
        d5.k(c1.CAM_X0902);
        d5.l(d1.L_X02);
        d5.n(i1.J_X07);
        d5.e(this.L ? i1.A_X01 : i1.A_X09);
        d5.f(c1.CAM_X0201);
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            EditText editText = this.y;
            if (editText != null && editText.getText().toString().length() > 50) {
                a0(String.format(this.f15253e.getString(i1.forum_rule_commit_error_toast), this.f15253e.getString(i1.forum_rule_defalt_main_title)));
                return;
            }
            List<c.a.r0.d1.b2.f.b> list = this.I;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.I.size(); i2++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    c.a.r0.d1.b2.f.b bVar = this.I.get(i2);
                    EditText l = bVar.l();
                    SpanGroupEditText k2 = bVar.k();
                    if (l != null && l.getText().toString().trim().length() > 30) {
                        a0(String.format(this.f15253e.getString(i1.forum_rule_commit_error_toast), String.format(this.f15253e.getString(i1.forum_rule_defalt_has_forum_rule), c.a.r0.d1.b2.e.a.d(i2 + 1), this.f15253e.getString(i1.forum_rule_title))));
                        return;
                    } else if (k2 != null && k2.getText().toString().length() > 1000) {
                        a0(String.format(this.f15253e.getString(i1.forum_rule_commit_error_toast), String.format(this.f15253e.getString(i1.forum_rule_defalt_has_forum_rule), c.a.r0.d1.b2.e.a.d(i2 + 1), this.f15253e.getString(i1.forum_rule_content))));
                        return;
                    }
                }
            }
            EditText editText2 = this.z;
            if (editText2 != null && editText2.getText().toString().length() > 500) {
                a0(String.format(this.f15253e.getString(i1.forum_rule_commit_error_toast), this.f15253e.getString(i1.forum_rule_defalt_preface_title)));
                return;
            }
            K();
            this.f15257i.commitData(this.J, false);
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ForumRuleBaseData forumRuleBaseData = this.J;
            if (forumRuleBaseData != null) {
                i2 = forumRuleBaseData.getTitle() != null ? this.J.getTitle().length() : 0;
                if (this.J.getList() == null || this.J.getList().size() <= 0) {
                    i4 = 0;
                    i5 = 0;
                } else {
                    i4 = 0;
                    i5 = 0;
                    for (int i6 = 0; i6 < this.J.getList().size(); i6++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.J.getList().get(i6);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle() != null) {
                                i4 += forumRuleItemData.getTitle().length();
                            }
                            if (forumRuleItemData.getContent() != null) {
                                i5 += forumRuleItemData.getContent().length();
                            }
                        }
                    }
                }
                i3 = this.J.getPreface() != null ? this.J.getPreface().length() : 0;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i2 + i4 + i5 + i3 > 5000) {
                B();
                a0(String.format(this.f15253e.getString(i1.forum_rule_draft_total_num_error_toast), 5000));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            K();
            if (w()) {
                return;
            }
            ForumRuleBaseData forumRuleBaseData = this.J;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle().length() > 50) {
                    B();
                    a0(String.format(this.f15253e.getString(i1.forum_rule_draft_error_toast), this.f15253e.getString(i1.forum_rule_defalt_main_title), 50));
                    return;
                }
                if (this.J.getList() != null) {
                    for (int i2 = 0; i2 < this.J.getList().size(); i2++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.J.getList().get(i2);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle().length() > 50) {
                                B();
                                a0(String.format(this.f15253e.getString(i1.forum_rule_draft_error_toast), this.f15253e.getString(i1.forum_rule_defalt_item_title), 50));
                                return;
                            } else if (forumRuleItemData.getContent().length() > 1000) {
                                B();
                                a0(String.format(this.f15253e.getString(i1.forum_rule_draft_error_toast), this.f15253e.getString(i1.forum_rule_defalt_item_content), 1000));
                                return;
                            }
                        }
                    }
                }
                if (this.J.getPreface().length() > 600) {
                    B();
                    a0(String.format(this.f15253e.getString(i1.forum_rule_draft_error_toast), this.f15253e.getString(i1.forum_rule_defalt_preface_title), 600));
                    return;
                }
            }
            this.f15257i.commitData(this.J, true);
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.E == null || (editText = this.y) == null || editText.getText().toString().trim().length() <= 0) {
                return false;
            }
            EditText editText2 = this.z;
            if (editText2 == null || editText2.getText().toString().trim().length() > 0) {
                List<c.a.r0.d1.b2.f.b> list = this.I;
                if (list == null || list.size() <= 0) {
                    return true;
                }
                for (int i2 = 0; i2 < this.I.size(); i2++) {
                    c.a.r0.d1.b2.f.b bVar = this.I.get(i2);
                    EditText l = bVar.l();
                    SpanGroupEditText k2 = bVar.k();
                    if (l == null || l.getText().toString().trim().length() <= 0 || k2 == null || k2.getText().toString().trim().length() <= 0) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            String format = String.format(this.f15253e.getString(i1.forum_rule_defalt_title_demo), this.f15255g, c.a.d.f.p.k.getDateStringMouth(new Date()));
            this.y.setText(format);
            this.y.setSelection(format.length());
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            layoutParams.width = -1;
            this.y.setLayoutParams(layoutParams);
        }
    }
}
