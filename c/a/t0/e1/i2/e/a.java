package c.a.t0.e1.i2.e;

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
import c.a.d.n.e.n;
import c.a.s0.d1.o0;
import c.a.s0.s.s.a;
import c.a.t0.e1.i2.a;
import c.a.t0.t2.s.c;
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
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGameSubPbActivity a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f16505b;

    /* renamed from: c  reason: collision with root package name */
    public View f16506c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.e1.i2.d.e f16507d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f16508e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f16509f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f16510g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16511h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f16512i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f16513j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public View n;
    public c.a.t0.e1.i2.c o;
    public c.a.t0.e1.i2.b p;
    public View.OnClickListener q;
    public ViewTreeObserver.OnGlobalLayoutListener r;
    public c.a.t0.e1.i2.d.b s;
    public List<n> t;
    public String u;
    public String v;
    public long w;
    public boolean x;
    public boolean y;
    public c.a.t0.t2.s.c z;

    /* renamed from: c.a.t0.e1.i2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1052a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16514e;

        public RunnableC1052a(a aVar) {
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
            this.f16514e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16514e.f16512i.requestFocus();
                c.a.d.f.p.n.w(this.f16514e.a.getPageContext().getPageActivity(), this.f16514e.f16512i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16515e;

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
            this.f16515e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16515e.f16512i.requestFocus();
                c.a.d.f.p.n.L(this.f16515e.a.getPageContext().getPageActivity(), this.f16515e.f16512i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a {
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

        @Override // c.a.t0.t2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.t2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.t2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                this.a.s(false);
                this.a.N(view);
                this.a.s(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16516e;

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
            this.f16516e = aVar;
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
            c.a.d.f.p.n.w(this.f16516e.a.getPageContext().getPageActivity(), this.f16516e.f16512i);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16517e;

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
            this.f16517e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f16517e;
                aVar.p(aVar.f16512i.getText().toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.InterfaceC1049a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.t0.e1.i2.a.InterfaceC1049a
        public void a(c.a.t0.e1.i2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null) {
                return;
            }
            this.a.M(dVar);
        }

        @Override // c.a.t0.e1.i2.a.InterfaceC1049a
        public void b(c.a.t0.e1.i2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.a.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.f16501g).longValue(), String.valueOf(this.a.w).equals(dVar.f16501g), false)));
            }
        }

        @Override // c.a.t0.e1.i2.a.InterfaceC1049a
        public void c(c.a.t0.e1.i2.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                if (this.a.o != null) {
                    this.a.o.i();
                }
                if (dVar == null) {
                    this.a.t(null);
                    this.a.J();
                    return;
                }
                this.a.t(dVar.f16502h);
                this.a.v = dVar.f16501g;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16518e;

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
            this.f16518e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f16518e.a.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = c.a.d.f.p.n.r(this.f16518e.a.getPageContext().getPageActivity());
                int[] p = c.a.d.f.p.n.p(this.f16518e.a.getPageContext().getPageActivity());
                if (p[1] - rect.bottom > p[1] / 4 && !this.f16518e.x) {
                    this.f16518e.x = true;
                    this.f16518e.F(true);
                } else if (p[1] - rect.height() == r && this.f16518e.x) {
                    this.f16518e.x = false;
                    this.f16518e.F(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f16519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.e1.i2.d.d f16520f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f16521g;

        public h(a aVar, c.a.s0.s.s.a aVar2, c.a.t0.e1.i2.d.d dVar) {
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
            this.f16521g = aVar;
            this.f16519e = aVar2;
            this.f16520f = dVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16519e.dismiss();
                this.f16521g.r(this.f16520f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f16522e;

        public i(a aVar, c.a.s0.s.s.a aVar2) {
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
            this.f16522e = aVar2;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16522e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16524f;

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
            this.f16524f = aVar;
            this.f16523e = i2;
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
                    this.f16524f.f16513j.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (StringUtils.isNull(charSequence2)) {
                        return;
                    }
                    int b2 = o0.b(charSequence2);
                    int i5 = this.f16523e;
                    if (b2 > i5) {
                        String k = o0.k(charSequence2, 0, i5 - 1);
                        this.f16524f.f16512i.setText(k);
                        this.f16524f.f16512i.setSelection(this.f16524f.f16512i.getText().length());
                        UtilHelper.showToast(this.f16524f.a.getPageContext().getPageActivity().getApplication(), this.f16524f.a.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                this.f16524f.J();
                this.f16524f.f16513j.setEnabled(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f16525e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16526f;

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
            this.f16526f = aVar;
            this.f16525e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16526f.f16508e.setEnabled(this.f16525e);
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
        this.z = new c.a.t0.t2.s.c(new c(this));
        this.a = frsGameSubPbActivity;
        this.q = onClickListener;
        this.u = str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.f16505b = relativeLayout;
        BdTypeListView bdTypeListView = (BdTypeListView) relativeLayout.findViewById(R.id.new_sub_pb_list);
        this.f16508e = bdTypeListView;
        bdTypeListView.setOnTouchListener(this.z);
        this.f16508e.setOnScrollListener(new d(this));
        this.f16507d = new c.a.t0.e1.i2.d.e(this.a.getPageContext());
        this.f16506c = BdListViewHelper.d(this.a.getActivity(), this.f16508e, BdListViewHelper.HeadType.DEFAULT);
        TextView textView = (TextView) this.f16505b.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.k = textView;
        textView.setOnClickListener(this.q);
        this.l = (TextView) this.f16505b.findViewById(R.id.no_reply_list_view);
        this.f16510g = (FrameLayout) this.f16505b.findViewById(R.id.bottom_view);
        this.f16511h = (LinearLayout) this.f16505b.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.f16512i = (EditText) this.f16505b.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        TextView textView2 = (TextView) this.f16505b.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.f16513j = textView2;
        textView2.setOnClickListener(new e(this));
        this.m = (ProgressBar) this.f16505b.findViewById(R.id.progressBar);
        C();
        c.a.t0.e1.i2.b bVar = new c.a.t0.e1.i2.b(this.a.getPageContext(), this.f16508e);
        this.p = bVar;
        bVar.b(new f(this));
        K(PbFullScreenEditorActivity.REPLY_MAX_SIZE);
        B();
        D(TbadkCoreApplication.getInst().getSkinType());
        this.t = new ArrayList();
        this.w = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public void A(boolean z, String str, c.a.t0.e1.i2.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            if (z) {
                BdToast.d(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).q();
                this.t.remove(dVar);
                this.p.c(this.t);
                G(this.y);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.a.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
            }
            BdToast.d(this.a.getPageContext().getPageActivity(), str, 1).q();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.r = new g(this);
            this.a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.r);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.f16505b.findViewById(R.id.view_navigation_bar);
            this.f16509f = navigationBar;
            this.n = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ImageView backImageView = this.f16509f.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                int f2 = c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds30);
                layoutParams.height = f2;
                layoutParams.width = f2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.n;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                this.n.setPadding(c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds32), this.n.getPaddingTop(), this.n.getPaddingRight(), this.n.getPaddingBottom());
                this.n.setLayoutParams(layoutParams2);
            }
            if (this.f16509f.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16509f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f16505b);
            SkinManager.setBackgroundColor(this.f16505b, R.color.CAM_X0201);
            this.f16509f.onChangeSkinType(this.a.getPageContext(), i2);
            this.f16507d.d(i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0110);
            this.k.setAlpha(0.95f);
            SkinManager.setBackgroundResource(this.k, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.f16511h, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.f16512i, R.color.CAM_X0106);
            this.f16512i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f16513j, R.color.game_sub_pb_send_txt_color);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r == null) {
            return;
        }
        this.a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                Rect rect = new Rect();
                this.f16511h.getWindowVisibleDisplayFrame(rect);
                int d2 = (c.a.d.f.p.n.p(this.a.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? c.a.d.f.p.n.d(this.a.getPageContext().getPageActivity(), 48.0f) : 0);
                FrameLayout frameLayout = this.f16510g;
                frameLayout.scrollTo(frameLayout.getScrollX(), d2);
                return;
            }
            this.f16510g.setScrollY(0);
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (ListUtils.isEmpty(this.t)) {
                this.f16508e.setNextPage(null);
                this.l.setVisibility(0);
            } else {
                this.f16508e.setNextPage(this.f16507d);
                this.l.setVisibility(8);
                if (z) {
                    this.f16507d.R();
                } else {
                    this.f16507d.f();
                }
            }
            L();
        }
    }

    public void H(c.a.t0.e1.i2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.o = cVar;
        }
    }

    public void I(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.f16508e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.t0.e1.i2.d.b bVar = this.s;
            this.v = bVar != null ? bVar.f16495e : null;
        }
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f16512i.addTextChangedListener(new j(this, i2));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!ListUtils.isEmpty(this.t)) {
                this.f16509f.setCenterTextTitle(String.format(this.a.getResources().getString(R.string.subpb_floor_reply_count), StringHelper.numFormatOver10000(this.t.size())));
            } else {
                this.f16509f.setCenterTextTitle(this.a.getResources().getString(R.string.reply));
            }
        }
    }

    public final void M(c.a.t0.e1.i2.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getPageContext().getPageActivity());
            aVar.setTitle((String) null);
            aVar.setMessageId(R.string.del_all_post_confirm);
            aVar.setCanceledOnTouchOutside(true);
            aVar.setPositiveButton(R.string.dialog_ok, new h(this, aVar, dVar));
            aVar.setNegativeButton(R.string.dialog_cancel, new i(this, aVar));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public void N(View view) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || this.f16506c == null || (navigationBar = this.f16509f) == null) {
            return;
        }
        if (navigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.f16509f.showNavigationBarExcludeStatusbar(false);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f16506c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
            } else {
                BdTypeListView bdTypeListView = this.f16508e;
                if (bdTypeListView != null) {
                    bdTypeListView.removeHeaderView(this.f16506c);
                }
            }
            this.f16509f.setVisibility(8);
            return;
        }
        this.f16509f.showNavigationBarExcludeStatusbar(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f16506c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + c.a.d.f.p.n.f(this.a.getActivity(), R.dimen.ds98)));
        } else {
            BdTypeListView bdTypeListView2 = this.f16508e;
            if (bdTypeListView2 != null) {
                bdTypeListView2.addHeaderView(this.f16506c, 0);
            }
        }
        this.f16509f.setVisibility(0);
    }

    public void O(boolean z, c.a.t0.e1.i2.d.b bVar, List<n> list) {
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
            this.f16508e.setNextPage(this.f16507d);
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
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (view = this.f16506c) == null || view.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f16506c.getLayoutParams();
        if (z) {
            q();
            layoutParams.height = c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds98);
        } else {
            layoutParams.height = c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
        }
        this.f16506c.setLayoutParams(layoutParams);
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
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f16509f.getBackImageView() == null) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16509f.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final void r(c.a.t0.e1.i2.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
            httpMessage.addParam("user_id", this.w);
            httpMessage.addParam("main_tower_id", dVar.f16500f);
            httpMessage.addParam("id", dVar.f16499e);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void s(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (bdTypeListView = this.f16508e) == null) {
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
            this.f16511h.setVisibility(0);
            this.f16512i.post(new b(this));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String format = String.format(this.a.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.f16512i.setText(format);
            this.f16512i.setSelection(format.length());
        }
    }

    public ListView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f16508e : (ListView) invokeV.objValue;
    }

    public NavigationBar v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f16509f : (NavigationBar) invokeV.objValue;
    }

    public TextView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f16505b : (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f16506c : (View) invokeV.objValue;
    }

    public void z(boolean z, String str, c.a.t0.e1.i2.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            Q(8);
            if (z && dVar != null) {
                BdToast.d(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).q();
                this.f16512i.setText((CharSequence) null);
                this.t.add(dVar);
                this.p.c(this.t);
                G(this.y);
                this.f16512i.post(new RunnableC1052a(this));
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.a.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
            }
            BdToast.d(this.a.getPageContext().getPageActivity(), str, 1).q();
        }
    }
}
