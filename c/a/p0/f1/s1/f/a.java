package c.a.p0.f1.s1.f;

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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.t.l;
import c.a.o0.r.t.o;
import c.a.p0.f1.s1.f.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public c.a.p0.l0.g C;
    public EditorScrollView D;
    public List<c.a.p0.f1.s1.f.b> E;
    public ForumRuleBaseData F;
    public BdTopToast G;
    public boolean H;
    public int I;
    public c.a.o0.r.t.j J;
    public l K;
    public boolean L;
    public Runnable M;
    public l.d N;
    public l.d O;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14538b;

    /* renamed from: c  reason: collision with root package name */
    public final String f14539c;

    /* renamed from: d  reason: collision with root package name */
    public final String f14540d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.f1.s1.b.b f14541e;

    /* renamed from: f  reason: collision with root package name */
    public ForumRulesEditActivity f14542f;

    /* renamed from: g  reason: collision with root package name */
    public View f14543g;

    /* renamed from: h  reason: collision with root package name */
    public View f14544h;
    public View i;
    public RelativeLayout j;
    public RelativeLayout k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EditText u;
    public EditText v;
    public LinearLayout w;
    public LinearLayout x;
    public NavigationBar y;
    public TextView z;

    /* renamed from: c.a.p0.f1.s1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1098a implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1098a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
                if (this.a.f14542f != null) {
                    this.a.f14542f.finish();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        public b(a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.onClick(view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.s(true, null, false);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                n.w(this.a.a.getPageActivity(), this.a.u);
                n.w(this.a.a.getPageActivity(), this.a.v);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.U(length);
                a.O(this.a.q, length, 50);
                this.a.J();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.f1.s1.f.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnTouchListenerC1099a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public View$OnTouchListenerC1099a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.t(length);
                a.O(this.a.s, length, 500);
                this.a.J();
                if (this.a.v.getLineCount() > 6) {
                    this.a.v.setOnTouchListener(new View$OnTouchListenerC1099a(this));
                } else {
                    this.a.v.setOnTouchListener(null);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.s1.f.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14545b;

        /* renamed from: c.a.p0.f1.s1.f.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1100a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public View$OnClickListenerC1100a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    g gVar = this.a;
                    gVar.f14545b.L(gVar.a);
                }
            }
        }

        public g(a aVar, c.a.p0.f1.s1.f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14545b = aVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.k().getText().toString().length() != 0 || this.a.l().getText().toString().length() != 0) {
                    this.f14545b.S(new View$OnClickListenerC1100a(this));
                } else {
                    this.f14545b.L(this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.f1.s1.f.b.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D.fullScroll(130);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements l.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements l.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, c.a.p0.f1.s1.b.b bVar, View view, String str, String str2, String str3, String str4, int i2, ForumRulesEditActivity forumRulesEditActivity) {
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
        this.E = new ArrayList();
        this.F = new ForumRuleBaseData();
        this.H = true;
        this.L = false;
        this.M = new c(this);
        this.N = new k(this);
        this.O = new C1098a(this);
        this.a = tbPageContext;
        this.f14538b = str;
        this.f14539c = str2;
        this.f14540d = str4;
        this.I = i2;
        this.f14542f = forumRulesEditActivity;
        this.f14541e = bVar;
        D(view, str3);
    }

    public static void O(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, textView, i2, i3) == null) {
            textView.setText(i2 + "/" + i3);
            if (i2 > i3) {
                c.a.o0.r.v.c.d(textView).v(R.color.CAM_X0301);
            } else {
                c.a.o0.r.v.c.d(textView).v(R.color.CAM_X0111);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.E.size() <= 0 || this.x == null) {
            return;
        }
        c.a.p0.f1.s1.f.b bVar = this.E.get(0);
        this.x.removeView(bVar.m());
        this.E.remove(bVar);
        I();
        K();
    }

    public void B() {
        c.a.o0.r.t.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jVar = this.J) != null && jVar.isShowing()) {
            this.J.dismiss();
        }
    }

    public final void C() {
        c.a.p0.l0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.C) == null) {
            return;
        }
        gVar.I();
    }

    public final void D(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, str) == null) {
            this.f14543g = view;
            this.y = (NavigationBar) view.findViewById(R.id.obfuscated_res_0x7f0914fe);
            this.w = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091b00);
            this.D = (EditorScrollView) view.findViewById(R.id.obfuscated_res_0x7f091c15);
            this.l = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090a27);
            this.j = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f090a97);
            this.m = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090a26);
            this.o = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a28);
            this.f14544h = view.findViewById(R.id.obfuscated_res_0x7f090a96);
            this.u = (EditText) view.findViewById(R.id.obfuscated_res_0x7f09090f);
            this.p = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f092228);
            this.q = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f09204d);
            this.i = view.findViewById(R.id.obfuscated_res_0x7f090a94);
            this.r = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f0918d9);
            this.v = (EditText) view.findViewById(R.id.obfuscated_res_0x7f0918d7);
            this.s = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f0918d8);
            this.x = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0912e4);
            this.k = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f09071f);
            this.t = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f09071e);
            this.n = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090720);
            TextView addTextButton = this.y.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.a.getString(R.string.obfuscated_res_0x7f0f04d1), null);
            this.B = addTextButton;
            addTextButton.setId(R.id.obfuscated_res_0x7f091537);
            this.B.setOnClickListener(this);
            this.y.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0683));
            EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
            this.z = eMTextView;
            eMTextView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f14e8));
            this.z.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            this.z.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
            this.z.setLayoutParams(layoutParams);
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.z, this);
            EMTextView eMTextView2 = new EMTextView(this.a.getPageActivity());
            this.A = eMTextView2;
            eMTextView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0f05));
            this.A.setEnabled(false);
            this.A.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            this.A.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
            this.A.setLayoutParams(layoutParams2);
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.A, this);
            E();
            R();
            s(false, null, false);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.y.setOnClickListener(this);
            O(this.q, 0, 50);
            O(this.s, 0, 500);
            this.D.setListener(new d(this));
            this.u.addTextChangedListener(new e(this));
            this.v.addTextChangedListener(new f(this));
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.G = null;
            this.F = null;
            this.f14541e = null;
            this.f14542f = null;
            B();
            this.J = null;
            this.K = null;
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.J == null) {
                l lVar = new l(this.a.getPageActivity());
                this.K = lVar;
                lVar.q(this.a.getString(R.string.obfuscated_res_0x7f0f0689));
                this.J = new c.a.o0.r.t.j(this.a, this.K);
                ArrayList arrayList = new ArrayList();
                c.a.o0.r.t.h hVar = new c.a.o0.r.t.h(this.a.getString(R.string.obfuscated_res_0x7f0f105d), this.K);
                hVar.q(R.color.CAM_X0302);
                hVar.m(this.N);
                arrayList.add(hVar);
                c.a.o0.r.t.h hVar2 = new c.a.o0.r.t.h(this.a.getString(R.string.obfuscated_res_0x7f0f0c7a), this.K);
                hVar2.m(this.O);
                arrayList.add(hVar2);
                this.K.m(new j(this));
                this.K.j(arrayList);
            }
            Q();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.F == null) {
                this.F = new ForumRuleBaseData();
            }
            ArrayList arrayList = new ArrayList();
            List<c.a.p0.f1.s1.f.b> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                    c.a.p0.f1.s1.f.b bVar = this.E.get(i2);
                    EditText l = bVar.l();
                    SpanGroupEditText k2 = bVar.k();
                    if (l != null) {
                        forumRuleItemData.setTitle(l.getText().toString());
                    }
                    if (k2 != null) {
                        forumRuleItemData.setContent(k2.getSpanGroupManager().E());
                    }
                    forumRuleItemData.setStatus(i2 + "");
                    arrayList.add(forumRuleItemData);
                }
            }
            this.F.setTitle(this.u.getText().toString());
            this.F.setPreface(this.v.getText().toString());
            this.F.setList(arrayList);
        }
    }

    public final void I() {
        List<c.a.p0.f1.s1.f.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.E) == null) {
            return;
        }
        if (list.size() >= 20) {
            this.t.setText(this.a.getString(R.string.obfuscated_res_0x7f0f068f));
            this.k.setEnabled(false);
            this.t.setEnabled(false);
            this.H = false;
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808f9, c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_PRESS));
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.k);
            d2.k(R.color.CAM_X0902);
            d2.l(R.dimen.L_X02);
            d2.n(R.string.J_X07);
            d2.e(R.string.A_X09);
            d2.f(R.color.CAM_X0201);
            return;
        }
        this.t.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f068b), Integer.valueOf(20 - this.E.size())));
        this.k.setEnabled(true);
        this.t.setEnabled(true);
        this.H = true;
        this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808f9, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.k);
        d3.k(R.color.CAM_X0902);
        d3.l(R.dimen.L_X02);
        d3.n(R.string.J_X07);
        d3.e(R.string.A_X01);
        d3.f(R.color.CAM_X0201);
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.A == null) {
            return;
        }
        if (y()) {
            this.A.setEnabled(true);
        } else {
            this.A.setEnabled(false);
        }
    }

    public final void K() {
        List<c.a.p0.f1.s1.f.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (list = this.E) == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            c.a.p0.f1.s1.f.b bVar = this.E.get(i2);
            bVar.t(i2);
            bVar.s(i2);
        }
    }

    public final void L(c.a.p0.f1.s1.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) || bVar == null) {
            return;
        }
        this.x.removeView(bVar.m());
        this.E.remove(bVar);
        P();
        I();
        K();
        J();
    }

    public final void M(c.a.p0.f1.s1.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.o(new g(this, bVar));
        bVar.p(new h(this));
    }

    public void N(ForumRuleBaseData forumRuleBaseData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, forumRuleBaseData, z) == null) || this.f14543g == null || forumRuleBaseData == null) {
            return;
        }
        this.u.setText(forumRuleBaseData.getTitle());
        this.u.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
        this.v.setText(forumRuleBaseData.getPreface());
        this.v.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
        if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
            c.a.p0.f1.s1.f.b bVar = this.E.get(0);
            this.x.removeView(bVar.m());
            this.E.remove(bVar);
            for (int i2 = 0; i2 < forumRuleBaseData.getPbDataList().size(); i2++) {
                s(false, forumRuleBaseData.getPbDataList().get(i2), !z);
            }
            return;
        }
        A();
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.E.get(0) == null) {
            return;
        }
        if (this.E.size() == 1) {
            this.E.get(0).q(false);
        } else {
            this.E.get(0).q(true);
        }
    }

    public void Q() {
        ForumRulesEditActivity forumRulesEditActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.J == null || (forumRulesEditActivity = this.f14542f) == null || forumRulesEditActivity.isFinishing()) {
            return;
        }
        this.J.m();
    }

    public final void R() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.C == null && (relativeLayout = this.j) != null) {
            c.a.p0.l0.g gVar = new c.a.p0.l0.g(this.a, relativeLayout);
            this.C = gVar;
            gVar.g0(R.drawable.obfuscated_res_0x7f0802f4);
            this.C.O(16);
            this.C.U(true);
            this.C.h0(true);
            this.C.N(3000);
            this.C.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.C.m0(this.a.getString(R.string.obfuscated_res_0x7f0f0685), "key_forum_rule_first_edit");
        }
    }

    public final void S(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            o oVar = new o(this.a.getPageActivity());
            oVar.v(R.string.obfuscated_res_0x7f0f068e);
            oVar.l(R.string.obfuscated_res_0x7f0f068d);
            oVar.r(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0c21, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0489, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, onClickListener)));
            oVar.g();
            oVar.i(false);
            oVar.y();
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            BdTopToast bdTopToast = this.G;
            if (bdTopToast == null || !bdTopToast.isShown()) {
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getPageActivity(), 2000);
                bdTopToast2.i(false);
                bdTopToast2.h(str);
                this.G = bdTopToast2;
                bdTopToast2.j((ViewGroup) this.f14543g.findViewById(R.id.obfuscated_res_0x7f0912f2));
            }
        }
    }

    public final void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (i2 > 0) {
                this.p.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
                layoutParams.width = -1;
                this.u.setLayoutParams(layoutParams);
                return;
            }
            this.p.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.u.getLayoutParams();
            layoutParams2.width = -2;
            this.u.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view == this.B) {
                G();
            } else if (view == this.A) {
                v();
            } else if (view == this.z) {
                H();
                this.a.sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.a.getPageActivity(), this.f14538b, this.f14539c, this.F, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.f14540d, this.I)));
            } else if (view == this.j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(this.f14539c, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
            } else if (view == this.p) {
                z();
            } else if (view != this.w && view != this.y) {
                if (view == this.k) {
                    c.a.d.f.m.e.a().removeCallbacks(this.M);
                    c.a.d.f.m.e.a().postDelayed(this.M, 300L);
                }
            } else {
                n.w(this.a.getPageActivity(), this.u);
                n.w(this.a.getPageActivity(), this.v);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            A();
            q(R.string.obfuscated_res_0x7f0f067b, R.string.obfuscated_res_0x7f0f067a);
            q(R.string.obfuscated_res_0x7f0f0687, R.string.obfuscated_res_0x7f0f0686);
            q(R.string.obfuscated_res_0x7f0f067f, R.string.obfuscated_res_0x7f0f067e);
            q(R.string.obfuscated_res_0x7f0f0674, R.string.obfuscated_res_0x7f0f0673);
            s(false, null, false);
        }
    }

    public final void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) || this.x == null) {
            return;
        }
        c.a.p0.f1.s1.f.b bVar = new c.a.p0.f1.s1.f.b(this.a.getPageActivity());
        M(bVar);
        r(bVar);
        String string = TbadkApplication.getInst().getResources().getString(i2);
        String string2 = TbadkApplication.getInst().getResources().getString(i3);
        bVar.l().setText(string);
        bVar.l().setSelection(string.length());
        bVar.k().insert(string2);
        bVar.k().setSelection(bVar.k().getText().toString().length());
    }

    public final void r(c.a.p0.f1.s1.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) || bVar == null) {
            return;
        }
        this.x.addView(bVar.m());
        this.E.add(bVar);
        P();
        if (this.E.indexOf(bVar) != -1) {
            bVar.t(this.E.indexOf(bVar));
            bVar.s(this.E.indexOf(bVar));
        }
        J();
        I();
    }

    public final void s(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), forumRuleItemPbData, Boolean.valueOf(z2)}) == null) || this.x == null) {
            return;
        }
        c.a.p0.f1.s1.f.b bVar = new c.a.p0.f1.s1.f.b(this.a.getPageActivity());
        M(bVar);
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
                            k2.getSpanGroupManager().H(tbLinkSpanGroup);
                        } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                            bVar.k().insert(forumRuleItemPbContentData.value);
                        } else if (TtmlNode.TAG_BR.equals(forumRuleItemPbContentData.tag)) {
                            bVar.k().insert("\r\n");
                        }
                    }
                }
            }
            bVar.k().setSelection(bVar.k().getText().toString().length());
            if (z2 && "1".equals(forumRuleItemPbData.status)) {
                bVar.l().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                bVar.k().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
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
            if (i2 == 0 && !this.L) {
                if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                    c.a.p0.f1.s1.e.a.c(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.v);
                    this.L = true;
                } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                    c.a.p0.f1.s1.e.a.c(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.v);
                    this.L = true;
                }
            } else if (this.L) {
                this.L = false;
                c.a.p0.f1.s1.e.a.c(0, 0, this.v);
            }
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.f14543g == null) {
            return;
        }
        c.a.o0.r.v.c.d(this.w).f(R.color.CAM_X0201);
        c.a.o0.r.v.c.d(this.o).v(R.color.CAM_X0105);
        c.a.o0.r.v.c.d(this.f14544h).f(R.color.CAM_X0210);
        c.a.o0.r.v.c.d(this.i).f(R.color.CAM_X0210);
        c.a.o0.r.v.c.d(this.q).v(R.color.CAM_X0111);
        c.a.o0.r.v.c.d(this.s).v(R.color.CAM_X0111);
        c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.p);
        d2.v(R.color.CAM_X0304);
        d2.A(R.string.F_X02);
        c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.r);
        d3.v(R.color.CAM_X0107);
        d3.A(R.string.F_X02);
        c.a.o0.r.v.c.d(this.B).x(R.color.CAM_X0105);
        c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.z);
        d4.x(R.color.CAM_X0302);
        d4.z(R.dimen.T_X05);
        c.a.o0.r.v.c.d(this.A).z(R.dimen.T_X05);
        this.A.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
        this.t.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
        this.u.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
        this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
        this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.l.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080904, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        if (this.H) {
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808f9, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0808f9, c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0304), SkinManager.RESOURCE_ALPHA_PRESS), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        NavigationBar navigationBar = this.y;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.a, i2);
        }
        l lVar = this.K;
        if (lVar != null) {
            lVar.i();
        }
        if (i2 == 0) {
            c.a.p0.s4.i.l(this.u, R.drawable.obfuscated_res_0x7f0804b8);
            c.a.p0.s4.i.l(this.v, R.drawable.obfuscated_res_0x7f0804b8);
        } else {
            c.a.p0.s4.i.l(this.u, R.drawable.obfuscated_res_0x7f0804b9);
            c.a.p0.s4.i.l(this.v, R.drawable.obfuscated_res_0x7f0804b9);
        }
        c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(this.k);
        d5.k(R.color.CAM_X0902);
        d5.l(R.dimen.L_X02);
        d5.n(R.string.J_X07);
        d5.e(this.H ? R.string.A_X01 : R.string.A_X09);
        d5.f(R.color.CAM_X0201);
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            EditText editText = this.u;
            if (editText != null && editText.getText().toString().length() > 50) {
                T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0670), this.a.getString(R.string.obfuscated_res_0x7f0f0679)));
                return;
            }
            List<c.a.p0.f1.s1.f.b> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    c.a.p0.f1.s1.f.b bVar = this.E.get(i2);
                    EditText l = bVar.l();
                    SpanGroupEditText k2 = bVar.k();
                    if (l != null && l.getText().toString().trim().length() > 30) {
                        T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0670), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0676), c.a.p0.f1.s1.e.a.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f0691))));
                        return;
                    } else if (k2 != null && k2.getText().toString().length() > 1000) {
                        T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0670), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0676), c.a.p0.f1.s1.e.a.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f0671))));
                        return;
                    }
                }
            }
            EditText editText2 = this.v;
            if (editText2 != null && editText2.getText().toString().length() > 500) {
                T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0670), this.a.getString(R.string.obfuscated_res_0x7f0f067d)));
                return;
            }
            H();
            this.f14541e.commitData(this.F, false);
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
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                i2 = forumRuleBaseData.getTitle() != null ? this.F.getTitle().length() : 0;
                if (this.F.getList() == null || this.F.getList().size() <= 0) {
                    i4 = 0;
                    i5 = 0;
                } else {
                    i4 = 0;
                    i5 = 0;
                    for (int i6 = 0; i6 < this.F.getList().size(); i6++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i6);
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
                i3 = this.F.getPreface() != null ? this.F.getPreface().length() : 0;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i2 + i4 + i5 + i3 > 5000) {
                B();
                T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f068a), 5000));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            H();
            if (w()) {
                return;
            }
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle().length() > 50) {
                    B();
                    T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0688), this.a.getString(R.string.obfuscated_res_0x7f0f0679), 50));
                    return;
                }
                if (this.F.getList() != null) {
                    for (int i2 = 0; i2 < this.F.getList().size(); i2++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i2);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle().length() > 50) {
                                B();
                                T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0688), this.a.getString(R.string.obfuscated_res_0x7f0f0678), 50));
                                return;
                            } else if (forumRuleItemData.getContent().length() > 1000) {
                                B();
                                T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0688), this.a.getString(R.string.obfuscated_res_0x7f0f0677), 1000));
                                return;
                            }
                        }
                    }
                }
                if (this.F.getPreface().length() > 600) {
                    B();
                    T(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0688), this.a.getString(R.string.obfuscated_res_0x7f0f067d), 600));
                    return;
                }
            }
            this.f14541e.commitData(this.F, true);
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.A == null || (editText = this.u) == null || editText.getText().toString().trim().length() <= 0) {
                return false;
            }
            EditText editText2 = this.v;
            if (editText2 == null || editText2.getText().toString().trim().length() > 0) {
                List<c.a.p0.f1.s1.f.b> list = this.E;
                if (list == null || list.size() <= 0) {
                    return true;
                }
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    c.a.p0.f1.s1.f.b bVar = this.E.get(i2);
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
            String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0680), this.f14539c, m.getDateStringMouth(new Date()));
            this.u.setText(format);
            this.u.setSelection(format.length());
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            layoutParams.width = -1;
            this.u.setLayoutParams(layoutParams);
        }
    }
}
