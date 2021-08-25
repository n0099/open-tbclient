package c.a.q0.v0.v1.e;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.p0.b1.l0;
import c.a.p0.s.s.a;
import c.a.q0.i2.i.c;
import c.a.q0.v0.v1.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGameSubPbActivity f27281a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f27282b;

    /* renamed from: c  reason: collision with root package name */
    public View f27283c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.v0.v1.d.e f27284d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f27285e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f27286f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f27287g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f27288h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f27289i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f27290j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public View n;
    public c.a.q0.v0.v1.c o;
    public c.a.q0.v0.v1.b p;
    public View.OnClickListener q;
    public ViewTreeObserver.OnGlobalLayoutListener r;
    public c.a.q0.v0.v1.d.b s;
    public List<n> t;
    public String u;
    public String v;
    public long w;
    public boolean x;
    public boolean y;
    public c.a.q0.i2.i.c z;

    /* renamed from: c.a.q0.v0.v1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1278a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27291e;

        public RunnableC1278a(a aVar) {
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
            this.f27291e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27291e.f27289i.requestFocus();
                l.x(this.f27291e.f27281a.getPageContext().getPageActivity(), this.f27291e.f27289i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27292e;

        public b(a aVar) {
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
            this.f27292e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27292e.f27289i.requestFocus();
                l.K(this.f27292e.f27281a.getPageContext().getPageActivity(), this.f27292e.f27289i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27293a;

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
            this.f27293a = aVar;
        }

        @Override // c.a.q0.i2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.q0.i2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.q0.i2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                this.f27293a.s(false);
                this.f27293a.N(view);
                this.f27293a.s(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27294e;

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
            this.f27294e = aVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || i2 == 0) {
                return;
            }
            l.x(this.f27294e.f27281a.getPageContext().getPageActivity(), this.f27294e.f27289i);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27295e;

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
            this.f27295e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f27295e;
                aVar.p(aVar.f27289i.getText().toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.InterfaceC1275a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27296a;

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
            this.f27296a = aVar;
        }

        @Override // c.a.q0.v0.v1.a.InterfaceC1275a
        public void a(c.a.q0.v0.v1.d.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null) {
                return;
            }
            this.f27296a.M(dVar);
        }

        @Override // c.a.q0.v0.v1.a.InterfaceC1275a
        public void b(c.a.q0.v0.v1.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f27296a.f27281a.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.f27277g).longValue(), String.valueOf(this.f27296a.w).equals(dVar.f27277g), false)));
            }
        }

        @Override // c.a.q0.v0.v1.a.InterfaceC1275a
        public void c(c.a.q0.v0.v1.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                if (this.f27296a.o != null) {
                    this.f27296a.o.i();
                }
                if (dVar == null) {
                    this.f27296a.t(null);
                    this.f27296a.J();
                    return;
                }
                this.f27296a.t(dVar.f27278h);
                this.f27296a.v = dVar.f27277g;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27297e;

        public g(a aVar) {
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
            this.f27297e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f27297e.f27281a.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(this.f27297e.f27281a.getPageContext().getPageActivity());
                int[] p = l.p(this.f27297e.f27281a.getPageContext().getPageActivity());
                if (p[1] - rect.bottom > p[1] / 4 && !this.f27297e.x) {
                    this.f27297e.x = true;
                    this.f27297e.F(true);
                } else if (p[1] - rect.height() == r && this.f27297e.x) {
                    this.f27297e.x = false;
                    this.f27297e.F(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f27298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.v0.v1.d.d f27299f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f27300g;

        public h(a aVar, c.a.p0.s.s.a aVar2, c.a.q0.v0.v1.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27300g = aVar;
            this.f27298e = aVar2;
            this.f27299f = dVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f27298e.dismiss();
                this.f27300g.r(this.f27299f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f27301e;

        public i(a aVar, c.a.p0.s.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27301e = aVar2;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f27301e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f27302e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27303f;

        public j(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27303f = aVar;
            this.f27302e = i2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
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
                if (!TextUtils.isEmpty(charSequence)) {
                    this.f27303f.f27290j.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (StringUtils.isNull(charSequence2)) {
                        return;
                    }
                    int b2 = l0.b(charSequence2);
                    int i5 = this.f27302e;
                    if (b2 > i5) {
                        String k = l0.k(charSequence2, 0, i5 - 1);
                        this.f27303f.f27289i.setText(k);
                        this.f27303f.f27289i.setSelection(this.f27303f.f27289i.getText().length());
                        UtilHelper.showToast(this.f27303f.f27281a.getPageContext().getPageActivity().getApplication(), this.f27303f.f27281a.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                this.f27303f.J();
                this.f27303f.f27290j.setEnabled(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f27304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f27305f;

        public k(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27305f = aVar;
            this.f27304e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27305f.f27285e.setEnabled(this.f27304e);
            }
        }
    }

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGameSubPbActivity, onClickListener, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = new c.a.q0.i2.i.c(new c(this));
        this.f27281a = frsGameSubPbActivity;
        this.q = onClickListener;
        this.u = str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.f27282b = relativeLayout;
        BdTypeListView bdTypeListView = (BdTypeListView) relativeLayout.findViewById(R.id.new_sub_pb_list);
        this.f27285e = bdTypeListView;
        bdTypeListView.setOnTouchListener(this.z);
        this.f27285e.setOnScrollListener(new d(this));
        this.f27284d = new c.a.q0.v0.v1.d.e(this.f27281a.getPageContext());
        this.f27283c = BdListViewHelper.d(this.f27281a.getActivity(), this.f27285e, BdListViewHelper.HeadType.DEFAULT);
        TextView textView = (TextView) this.f27282b.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.k = textView;
        textView.setOnClickListener(this.q);
        this.l = (TextView) this.f27282b.findViewById(R.id.no_reply_list_view);
        this.f27287g = (FrameLayout) this.f27282b.findViewById(R.id.bottom_view);
        this.f27288h = (LinearLayout) this.f27282b.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.f27289i = (EditText) this.f27282b.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        TextView textView2 = (TextView) this.f27282b.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.f27290j = textView2;
        textView2.setOnClickListener(new e(this));
        this.m = (ProgressBar) this.f27282b.findViewById(R.id.progressBar);
        C();
        c.a.q0.v0.v1.b bVar = new c.a.q0.v0.v1.b(this.f27281a.getPageContext(), this.f27285e);
        this.p = bVar;
        bVar.b(new f(this));
        K(140);
        B();
        D(TbadkCoreApplication.getInst().getSkinType());
        this.t = new ArrayList();
        this.w = c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public void A(boolean z, String str, c.a.q0.v0.v1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            if (z) {
                BdToast.d(this.f27281a.getPageContext().getPageActivity(), this.f27281a.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).q();
                this.t.remove(dVar);
                this.p.c(this.t);
                G(this.y);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.f27281a.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
            }
            BdToast.d(this.f27281a.getPageContext().getPageActivity(), str, 1).q();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.r = new g(this);
            this.f27281a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.r);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f27282b.findViewById(R.id.view_navigation_bar);
            this.f27286f = navigationBar;
            this.n = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ImageView backImageView = this.f27286f.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                int g2 = l.g(this.f27281a.getPageContext().getPageActivity(), R.dimen.ds30);
                layoutParams.height = g2;
                layoutParams.width = g2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.n;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                this.n.setPadding(l.g(this.f27281a.getPageContext().getPageActivity(), R.dimen.ds32), this.n.getPaddingTop(), this.n.getPaddingRight(), this.n.getPaddingBottom());
                this.n.setLayoutParams(layoutParams2);
            }
            if (this.f27286f.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f27286f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f27281a.getLayoutMode().k(i2 == 1);
            this.f27281a.getLayoutMode().j(this.f27282b);
            SkinManager.setBackgroundColor(this.f27282b, R.color.CAM_X0201);
            this.f27286f.onChangeSkinType(this.f27281a.getPageContext(), i2);
            this.f27284d.d(i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0110);
            this.k.setAlpha(0.95f);
            SkinManager.setBackgroundResource(this.k, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f27288h, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.f27289i, R.color.CAM_X0106);
            this.f27289i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f27290j, R.color.game_sub_pb_send_txt_color);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r == null) {
            return;
        }
        this.f27281a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                Rect rect = new Rect();
                this.f27288h.getWindowVisibleDisplayFrame(rect);
                int e2 = (l.p(this.f27281a.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.e(this.f27281a.getPageContext().getPageActivity(), 48.0f) : 0);
                FrameLayout frameLayout = this.f27287g;
                frameLayout.scrollTo(frameLayout.getScrollX(), e2);
                return;
            }
            this.f27287g.setScrollY(0);
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (ListUtils.isEmpty(this.t)) {
                this.f27285e.setNextPage(null);
                this.l.setVisibility(0);
            } else {
                this.f27285e.setNextPage(this.f27284d);
                this.l.setVisibility(8);
                if (z) {
                    this.f27284d.O();
                } else {
                    this.f27284d.f();
                }
            }
            L();
        }
    }

    public void H(c.a.q0.v0.v1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void I(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f27285e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.q0.v0.v1.d.b bVar = this.s;
            this.v = bVar != null ? bVar.f27270e : null;
        }
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f27289i.addTextChangedListener(new j(this, i2));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!ListUtils.isEmpty(this.t)) {
                this.f27286f.setCenterTextTitle(String.format(this.f27281a.getResources().getString(R.string.subpb_floor_reply_count), StringHelper.numFormatOver10000(this.t.size())));
            } else {
                this.f27286f.setCenterTextTitle(this.f27281a.getResources().getString(R.string.reply));
            }
        }
    }

    public final void M(c.a.q0.v0.v1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f27281a.getPageContext().getPageActivity());
            aVar.setTitle((String) null);
            aVar.setMessageId(R.string.del_all_post_confirm);
            aVar.setCanceledOnTouchOutside(true);
            aVar.setPositiveButton(R.string.dialog_ok, new h(this, aVar, dVar));
            aVar.setNegativeButton(R.string.dialog_cancel, new i(this, aVar));
            aVar.create(this.f27281a.getPageContext()).show();
        }
    }

    public void N(View view) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.f27283c == null || (navigationBar = this.f27286f) == null) {
            return;
        }
        if (navigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.f27286f.showNavigationBarExcludeStatusbar(false);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f27283c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
            } else {
                BdTypeListView bdTypeListView = this.f27285e;
                if (bdTypeListView != null) {
                    bdTypeListView.removeHeaderView(this.f27283c);
                }
            }
            this.f27286f.setVisibility(8);
            return;
        }
        this.f27286f.showNavigationBarExcludeStatusbar(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f27283c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f27281a.getActivity(), R.dimen.ds98)));
        } else {
            BdTypeListView bdTypeListView2 = this.f27285e;
            if (bdTypeListView2 != null) {
                bdTypeListView2.addHeaderView(this.f27283c, 0);
            }
        }
        this.f27286f.setVisibility(0);
    }

    public void O(boolean z, c.a.q0.v0.v1.d.b bVar, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, list}) == null) {
            this.y = z;
            this.s = bVar;
            J();
            if (ListUtils.isEmpty(list)) {
                G(z);
                return;
            }
            this.t.clear();
            this.t.addAll(list);
            this.l.setVisibility(8);
            this.f27285e.setNextPage(this.f27284d);
            this.p.c(list);
            q();
            this.k.setVisibility(0);
            this.k.setText(R.string.say_your_point);
            G(z);
        }
    }

    public void P(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (view = this.f27283c) == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f27283c.getLayoutParams();
        if (z) {
            q();
            layoutParams.height = l.g(this.f27281a.getPageContext().getPageActivity(), R.dimen.ds98);
        } else {
            layoutParams.height = l.g(this.f27281a.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
        }
        this.f27283c.setLayoutParams(layoutParams);
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.m.setVisibility(i2);
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Q(0);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
            httpMessage.addParam("user_id", this.w);
            httpMessage.addParam("reply_user_id", this.v);
            httpMessage.addParam("content", str);
            httpMessage.addParam("main_tower_id", this.u);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f27286f.getBackImageView() == null) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f27286f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final void r(c.a.q0.v0.v1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
            httpMessage.addParam("user_id", this.w);
            httpMessage.addParam("main_tower_id", dVar.f27276f);
            httpMessage.addParam("id", dVar.f27275e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void s(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (bdTypeListView = this.f27285e) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new k(this, z), 10L);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.k.setVisibility(8);
            this.f27288h.setVisibility(0);
            this.f27289i.post(new b(this));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String format = String.format(this.f27281a.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.f27289i.setText(format);
            this.f27289i.setSelection(format.length());
        }
    }

    public ListView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f27285e : (ListView) invokeV.objValue;
    }

    public NavigationBar v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f27286f : (NavigationBar) invokeV.objValue;
    }

    public TextView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f27282b : (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f27283c : (View) invokeV.objValue;
    }

    public void z(boolean z, String str, c.a.q0.v0.v1.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            Q(8);
            if (z && dVar != null) {
                BdToast.d(this.f27281a.getPageContext().getPageActivity(), this.f27281a.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).q();
                this.f27289i.setText((CharSequence) null);
                this.t.add(dVar);
                this.p.c(this.t);
                G(this.y);
                this.f27289i.post(new RunnableC1278a(this));
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.f27281a.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
            }
            BdToast.d(this.f27281a.getPageContext().getPageActivity(), str, 1).q();
        }
    }
}
