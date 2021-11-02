package b.a.r0.k2.u.d;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.t0;
import b.a.q0.s.q.x0;
import b.a.q0.s.s.a;
import b.a.q0.s.s.i;
import b.a.q0.t.c.w;
import b.a.r0.j.g;
import b.a.r0.j.j;
import b.a.r0.k2.u.f.q0;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Z = 0;
    public static int a0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public View B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public TbRichTextView.z E;
    public b.a.r0.k2.s.c F;
    public View.OnLongClickListener G;
    public PopupDialog H;
    public b.a.q0.s.s.a I;
    public PbFragment.b3 J;
    public b.a.q0.s.g0.a K;
    public b.a.r0.j.g L;
    public b.a.r0.j.j M;
    public String N;
    public PermissionJudgePolicy O;
    public boolean P;
    public TextView Q;
    public PbEmotionBar R;
    public EditorTools S;
    public b.a.r0.k2.u.f.t T;
    public List<String> U;
    public b.a.r0.k2.u.f.b1.c V;
    public PbFakeFloorModel W;
    public BdListView.p X;
    public CustomMessageListener Y;

    /* renamed from: a  reason: collision with root package name */
    public FoldCommentActivity f18912a;

    /* renamed from: b  reason: collision with root package name */
    public PbModel f18913b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f18914c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f18915d;

    /* renamed from: e  reason: collision with root package name */
    public SubPbView f18916e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18917f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f18918g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f18919h;

    /* renamed from: i  reason: collision with root package name */
    public View f18920i;
    public View j;
    public ImageView k;
    public AlertDialog l;
    public BlankView m;
    public RelativeLayout n;
    public BdTypeListView o;
    public b.a.r0.k2.u.h.d p;
    public ProgressBar q;
    public b.a.r0.k2.u.d.a r;
    public b.a.r0.k2.r.f s;
    public boolean t;
    public MaskView u;
    public TextView v;
    public ImageView w;
    public ImageView x;
    public RelativeLayout y;
    public LinearLayout z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18921e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18921e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(b.a.r0.k2.i.tag_from, 1);
                    this.f18921e.f18912a.checkMuteState(sparseArray);
                    return;
                }
                this.f18921e.P(view);
            } else if (booleanValue2) {
                sparseArray.put(b.a.r0.k2.i.tag_from, 0);
                sparseArray.put(b.a.r0.k2.i.tag_check_mute_from, 1);
                this.f18921e.f18912a.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f18921e.L(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18922e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18922e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18922e.f18913b == null) {
                return;
            }
            this.f18922e.f18913b.H1();
        }
    }

    /* renamed from: b.a.r0.k2.u.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0952c implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f18923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f18924f;

        public C0952c(c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18924f = cVar;
            this.f18923e = z;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f18924f.H.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f18924f.L(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f18924f.J != null) {
                            this.f18924f.J.a(new Object[]{sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f18924f.f18912a.handleMuteClick(this.f18923e, (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f18925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f18926f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f18927g;

        public e(c cVar, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18927g = cVar;
            this.f18925e = alertDialog;
            this.f18926f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f18925e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!b.a.e.e.p.j.A()) {
                    b.a.e.e.p.l.L(this.f18927g.f18912a, b.a.r0.k2.l.neterror);
                } else {
                    this.f18927g.f18912a.deleteThread(this.f18926f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f18928e;

        public f(c cVar, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18928e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f18928e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f18929a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f18930b;

        public g(c cVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18930b = cVar;
            this.f18929a = sparseArray;
        }

        @Override // b.a.r0.j.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f18930b.f18912a.deleteThread(this.f18929a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements g.InterfaceC0930g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f18931a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f18932b;

        public h(c cVar, b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18932b = cVar;
            this.f18931a = aVar;
        }

        @Override // b.a.r0.j.g.InterfaceC0930g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f18932b.f18912a.deleteThread(this.f18931a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18933e;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18933e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18933e.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements b.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18934e;

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18934e = cVar;
        }

        @Override // b.a.q0.x.b
        public void onAction(b.a.q0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14197c;
                if (obj instanceof w) {
                    if (((w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((w) aVar.f14197c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f18934e.O == null) {
                            this.f18934e.O = new PermissionJudgePolicy();
                        }
                        this.f18934e.O.clearRequestPermissionList();
                        this.f18934e.O.appendRequestPermission(this.f18934e.f18912a, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f18934e.O.startRequestPermission(this.f18934e.f18912a)) {
                            return;
                        }
                        this.f18934e.f18912a.getPbEditor().h((w) aVar.f14197c);
                        this.f18934e.f18912a.getPbEditor().A(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18935e;

        public k(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18935e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18935e.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18936e;

        public l(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18936e = cVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f18936e.f18912a.mContentProcessController == null || this.f18936e.f18912a.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f18936e.f18912a.mContentProcessController.e().e()) {
                this.f18936e.f18912a.mContentProcessController.a(false);
            }
            this.f18936e.f18912a.mContentProcessController.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int i5;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f18936e.S == null || this.f18936e.S.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f18936e.V == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f18936e.S.getId());
                c cVar = this.f18936e;
                cVar.V = new b.a.r0.k2.u.f.b1.c(cVar.f18912a.getPageContext(), this.f18936e.f18916e, layoutParams);
                if (!ListUtils.isEmpty(this.f18936e.U)) {
                    this.f18936e.V.m(this.f18936e.U);
                }
                this.f18936e.V.n(this.f18936e.S);
            }
            this.f18936e.V.l(substring);
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18937a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18937a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.k2.r.t)) {
                b.a.r0.k2.r.t tVar = (b.a.r0.k2.r.t) customResponsedMessage.getData();
                if (this.f18937a.f18916e != null) {
                    this.f18937a.f18916e.setSubPbViewData(tVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18938e;

        public n(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18938e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18938e.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18939e;

        public o(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18939e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new t0(this.f18939e.f18912a.getActivity(), "pb_huitie"))) {
                this.f18939e.f18912a.processProfessionPermission();
                if (this.f18939e.f18912a == null || this.f18939e.f18912a.getModel() == null || this.f18939e.f18912a.getModel().P0() == null || this.f18939e.f18912a.getModel().P0().O() == null || this.f18939e.f18912a.getModel().P0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f18939e.f18912a.getModel().g1()).param("fid", this.f18939e.f18912a.getModel().P0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f18939e.f18912a.getModel().f1()).param("fid", this.f18939e.f18912a.getModel().P0().m()).param("obj_locate", 1).param("uid", this.f18939e.f18912a.getModel().P0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18940e;

        public p(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18940e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18940e.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18941a;

        public q(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18941a = cVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f18941a.W.N(postData);
                this.f18941a.r.b();
                this.f18941a.T.c();
                this.f18941a.S.hideTools();
                this.f18941a.a0(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18942e;

        public r(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18942e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18942e.f18916e == null) {
                return;
            }
            this.f18942e.f18916e.onFinish();
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18943e;

        public s(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18943e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18943e.f18912a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18944e;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f18945e;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18945e = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18945e.f18944e.l == null) {
                    return;
                }
                this.f18945e.f18944e.l.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f18946e;

            public b(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18946e = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    UrlManager.getInstance().dealOneLink(this.f18946e.f18944e.f18912a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                    if (this.f18946e.f18944e.s != null) {
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.f18946e.f18944e.s.Q()).param("fname", this.f18946e.f18944e.s.n()).param("fid", this.f18946e.f18944e.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                }
            }
        }

        public t(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18944e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.comment_folded_explain));
                if (this.f18944e.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.f18944e.s.Q()).param("fname", this.f18944e.s.n()).param("fid", this.f18944e.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a(b.a.r0.k2.l.know, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.a(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.f18944e.f18912a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(b.a.r0.k2.g.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.f18944e.f18912a);
                textView.setText(b.a.r0.k2.l.view_tieba_policy);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(b.a.r0.k2.g.T_X07));
                textView.setTextColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.f18944e.f18912a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(b.a.r0.k2.h.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(b.a.e.e.p.l.g(this.f18944e.f18912a, b.a.r0.k2.g.tbds36), b.a.e.e.p.l.g(this.f18944e.f18912a, b.a.r0.k2.g.tbds36)));
                c cVar = this.f18944e;
                b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(cVar.f18912a);
                lVar.q(b.a.r0.k2.l.comment_folded);
                lVar.n(spannableString);
                lVar.k(3);
                lVar.h(linearLayout);
                lVar.l(true);
                lVar.m(LinkMovementMethod.getInstance());
                lVar.p(aVar);
                lVar.g(true);
                cVar.l = lVar.t();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(526609083, "Lb/a/r0/k2/u/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(526609083, "Lb/a/r0/k2/u/d/c;");
        }
    }

    public c(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.z zVar, b.a.r0.k2.s.c cVar, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, onClickListener, zVar, cVar, onLongClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18918g = null;
        this.q = null;
        this.H = null;
        this.I = null;
        this.K = null;
        this.P = false;
        this.X = new k(this);
        this.Y = new m(this, 2921597);
        this.f18912a = foldCommentActivity;
        this.f18913b = foldCommentActivity.getModel();
        this.C = onClickListener;
        this.E = zVar;
        this.F = cVar;
        this.G = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.layout_fold_comment_activity, (ViewGroup) null);
        this.f18916e = subPbView;
        this.f18917f = (LinearLayout) subPbView.findViewById(b.a.r0.k2.i.navigation_bar_group);
        RelativeLayout relativeLayout = (RelativeLayout) this.f18916e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_comment);
        this.y = relativeLayout;
        relativeLayout.setVisibility(8);
        this.v = (TextView) this.f18916e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_comment_reply_text);
        this.w = (ImageView) this.f18916e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_more_img);
        this.x = (ImageView) this.f18916e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_emotion_img);
        this.f18914c = (NoNetworkView) this.f18916e.findViewById(b.a.r0.k2.i.view_no_network);
        G();
        this.n = (RelativeLayout) this.f18916e.findViewById(b.a.r0.k2.i.fold_comment_body_layout);
        this.o = (BdTypeListView) this.f18916e.findViewById(b.a.r0.k2.i.fold_comment_list);
        View view = new View(foldCommentActivity.getActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.addHeaderView(view, 0);
        this.o.setOnSrollToBottomListener(this.X);
        this.f18916e.setTopView(view);
        this.f18916e.setNavigationView(this.f18917f);
        this.f18916e.setListView(this.o);
        this.f18916e.setContentView(this.n);
        b.a.r0.k2.u.h.d dVar = new b.a.r0.k2.u.h.d(foldCommentActivity.getPageContext());
        this.p = dVar;
        dVar.x();
        this.p.B(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.f18916e.findViewById(b.a.r0.k2.i.progress);
        this.u = (MaskView) this.f18916e.findViewById(b.a.r0.k2.i.mask_view);
        this.B = this.f18916e.findViewById(b.a.r0.k2.i.view_comment_top_line);
        LinearLayout linearLayout = (LinearLayout) this.f18916e.findViewById(b.a.r0.k2.i.fold_comment_editer_tool_comment_layout);
        this.z = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.f18916e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_comment_user_image);
        this.A = headImageView;
        headImageView.setVisibility(0);
        this.A.setIsRound(true);
        this.A.setBorderWidth(b.a.e.e.p.l.g(this.f18912a, b.a.r0.k2.g.L_X01));
        this.A.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
        this.A.setDefaultBgResource(0);
        this.A.setDefaultResource(b.a.r0.k2.f.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.A.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        K(TbadkCoreApplication.getInst().getSkinType());
        F();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.f18912a.getPageContext());
        this.W = pbFakeFloorModel;
        pbFakeFloorModel.P(this.f18913b.F(), this.f18913b.B(), this.f18913b.C(), this.f18913b.A(), this.f18913b.G());
        b.a.r0.k2.u.f.t tVar = new b.a.r0.k2.u.f.t(this.f18912a.getPageContext(), this.W, this.n);
        this.T = tVar;
        tVar.k(new p(this));
        this.T.m(this.f18912a.mOnFloorPostWriteNewCallback);
        this.W.R(new q(this));
        this.f18912a.registerListener(this.Y);
    }

    public SubPbView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18916e : (SubPbView) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.y == null) {
            return;
        }
        this.B.setVisibility(8);
        this.y.setVisibility(8);
        PbEmotionBar pbEmotionBar = this.R;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.y == null || this.Q == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        PbModel pbModel = this.f18913b;
        boolean z2 = true;
        this.Q.setText(tbSingleton.getAdVertiComment((pbModel == null || pbModel.P0() == null || !this.f18913b.P0().k0()) ? false : true, (this.f18913b.P0() == null || !this.f18913b.P0().l0()) ? false : false, z()));
        if (z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.y.startAnimation(alphaAnimation);
        }
    }

    public void D() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.hide();
        b.a.r0.k2.u.f.b1.c cVar = this.V;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void E() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (noDataView = this.f18915d) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.o.setVisibility(0);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.k2.u.d.a aVar = new b.a.r0.k2.u.d.a(this.f18912a, this.o);
            this.r = aVar;
            aVar.i(this.f18912a.getEventController());
            this.r.j(this.f18912a.getPbPostShareController());
            this.r.f(this.E);
            this.r.c(this.C);
            this.r.k(this.F);
            this.r.f(this.E);
            this.r.g(this.G);
            a aVar2 = new a(this);
            this.D = aVar2;
            this.r.e(aVar2);
            this.r.a();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int g2 = b.a.e.e.p.l.g(this.f18912a.getPageContext().getPageActivity(), b.a.r0.k2.g.ds88);
            int g3 = b.a.e.e.p.l.g(this.f18912a.getPageContext().getPageActivity(), b.a.r0.k2.g.ds2);
            NavigationBar navigationBar = (NavigationBar) this.f18916e.findViewById(b.a.r0.k2.i.view_navigation_bar);
            this.f18918g = navigationBar;
            navigationBar.setCenterTextTitle(this.f18912a.getResources().getString(b.a.r0.k2.l.folded_comment));
            this.f18920i = this.f18918g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f18912a).inflate(b.a.r0.k2.j.layout_fold_explain_icon, (ViewGroup) null);
            this.j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(b.a.r0.k2.i.navigation_fold_explain_icon);
            this.k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(b.a.r0.k2.h.icon_pure_explain44, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f18918g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, new t(this));
            ImageView backImageView = this.f18918g.getBackImageView();
            this.f18919h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f18920i.getLayoutParams();
                layoutParams.height = g2;
                layoutParams.width = g2;
                layoutParams.leftMargin = g3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.f18920i;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f18920i.getLayoutParams();
                layoutParams2.width = g2;
                layoutParams2.height = g2;
                this.f18920i.setLayoutParams(layoutParams2);
            }
            this.f18918g.setIsClose(true);
            this.f18918g.setIsCorner(true);
            this.f18918g.isShowBottomLine(true);
            this.f18918g.setBottomLineHeight(3);
            this.f18918g.setStatusBarVisibility(8);
        }
    }

    public final void H(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f18912a.getPageContext().getString(b.a.r0.k2.l.refresh_view_button_text), new b(this)));
            if (this.f18915d == null) {
                Activity pageActivity = this.f18912a.getPageContext().getPageActivity();
                this.f18915d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, b.a.e.e.p.l.g(pageActivity, b.a.r0.k2.g.ds250)), eVar, a2);
            }
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            SkinManager.setBackgroundColor(this.f18915d, b.a.r0.k2.f.CAM_X0201);
            this.f18915d.setClickable(true);
            this.f18915d.setTextOption(eVar);
            this.f18915d.onChangeSkinType(this.f18912a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f18915d.setVisibility(0);
        }
    }

    public void I() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f18912a == null || (editorTools = this.S) == null) {
            return;
        }
        editorTools.display();
        if (this.f18912a.getPbEditor() != null) {
            this.f18912a.getPbEditor().Q();
        }
        B();
    }

    public final void J() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (pbModel = this.f18913b) == null || pbModel.P0() == null || this.f18913b.P0().y() == null || !b.a.e.e.p.l.D()) {
            return;
        }
        if (this.f18913b.P0().y().b() == 0) {
            U();
            return;
        }
        b.a.r0.k2.u.h.d dVar = this.p;
        if (dVar != null) {
            dVar.Q();
        }
        if (this.f18913b.B1(false)) {
            X();
        } else {
            U();
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f18912a.getLayoutMode().k(i2 == 1);
            this.f18912a.getLayoutMode().j(this.f18916e);
            SkinManager.setBackgroundColor(this.f18916e, b.a.r0.k2.f.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, b.a.r0.k2.f.CAM_X0201);
            this.f18918g.onChangeSkinType(this.f18912a.getPageContext(), i2);
            WebPManager.setPureDrawable(this.f18919h, b.a.r0.k2.h.icon_pure_topbar_close44, b.a.r0.k2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f18914c.onChangeSkinType(this.f18912a.getPageContext(), i2);
            this.f18912a.getLayoutMode().j(this.p.b());
            this.p.d(i2);
            SkinManager.setViewTextColor(this.v, b.a.r0.k2.f.CAM_X0110);
            this.v.setAlpha(0.95f);
            b.a.r0.k2.u.d.a aVar = this.r;
            if (aVar != null) {
                aVar.b();
            }
            SkinManager.setBackgroundColor(this.B, b.a.r0.k2.f.CAM_X0203);
            this.A.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
            this.z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.e.p.l.g(this.f18912a, b.a.r0.k2.g.tbds47), SkinManager.getColor(b.a.r0.k2.f.CAM_X0209)));
            b.a.q0.s.u.c.d(this.y).f(b.a.r0.k2.f.CAM_X0208);
        }
    }

    public void L(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            M(i2, str, i3, z, null);
        }
    }

    public void M(int i2, String str, int i3, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2}) == null) {
            N(i2, str, i3, z, str2, false);
        }
    }

    public void N(int i2, String str, int i3, boolean z, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(Z, Integer.valueOf(a0));
            int i4 = b.a.r0.k2.l.del_all_post_confirm;
            if (i3 == 1002 && !z) {
                i4 = b.a.r0.k2.l.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = b.a.r0.k2.l.report_thread_confirm;
                } else {
                    i4 = b.a.r0.k2.l.del_thread_confirm;
                }
            }
            this.I = new b.a.q0.s.s.a(this.f18912a);
            if (StringUtils.isNull(str2)) {
                this.I.setMessageId(i4);
            } else {
                this.I.setOnlyMessageShowCenter(false);
                this.I.setMessage(str2);
            }
            this.I.setYesButtonTag(sparseArray);
            this.I.setPositiveButton(b.a.r0.k2.l.dialog_ok, this.f18912a);
            this.I.setNegativeButton(b.a.r0.k2.l.dialog_cancel, new d(this));
            this.I.setCancelable(true);
            this.I.create(this.f18912a.getPageContext());
            if (z2) {
                b0(sparseArray);
            } else if (z) {
                b0(sparseArray);
            } else if (Z()) {
                b.a.r0.j.i iVar = new b.a.r0.j.i(this.f18913b.P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f18913b.P0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f18913b.P0().o().has_forum_rule.intValue());
                iVar.i(this.f18913b.P0().l().getId(), this.f18913b.P0().l().getName());
                iVar.h(this.f18913b.P0().l().getImage_url());
                iVar.j(this.f18913b.P0().l().getUser_level());
                e0(sparseArray, i2, iVar, this.f18913b.P0().U(), false);
            } else {
                h0(this.I, i2);
            }
        }
    }

    public void O(SparseArray<Object> sparseArray, boolean z) {
        b.a.q0.s.s.f fVar;
        b.a.q0.s.s.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, sparseArray, z) == null) {
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f18912a);
            iVar.p(this.f18912a.getString(b.a.r0.k2.l.bar_manager));
            iVar.m(new C0952c(this, z));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(b.a.r0.k2.i.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(b.a.r0.k2.i.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new b.a.q0.s.s.f(10, this.f18912a.getString(b.a.r0.k2.l.delete_post), iVar);
                } else {
                    fVar2 = new b.a.q0.s.s.f(10, this.f18912a.getString(b.a.r0.k2.l.delete), iVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = b.a.r0.k2.i.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = b.a.r0.k2.i.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = b.a.r0.k2.i.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = b.a.r0.k2.i.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                fVar2.f13556d.setTag(sparseArray2);
                arrayList.add(fVar2);
            }
            if (!"".equals(sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name)) || !"".equals(sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show))) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = b.a.r0.k2.i.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = b.a.r0.k2.i.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = b.a.r0.k2.i.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = b.a.r0.k2.i.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = b.a.r0.k2.i.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(11, this.f18912a.getString(b.a.r0.k2.l.forbidden_person), iVar);
                fVar3.f13556d.setTag(sparseArray3);
                arrayList.add(fVar3);
            }
            if ((sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = b.a.r0.k2.i.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = b.a.r0.k2.i.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = b.a.r0.k2.i.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = b.a.r0.k2.i.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = b.a.r0.k2.i.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z) {
                    fVar = new b.a.q0.s.s.f(12, this.f18912a.getString(b.a.r0.k2.l.un_mute), iVar);
                } else {
                    fVar = new b.a.q0.s.s.f(12, this.f18912a.getString(b.a.r0.k2.l.mute), iVar);
                }
                fVar.f13556d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            b.a.r0.k2.u.f.f1.a.e(arrayList);
            if (b.a.q0.b.d.F()) {
                iVar.k(arrayList, false);
            } else {
                iVar.k(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f18912a.getPageContext(), iVar);
            this.H = popupDialog;
            popupDialog.showDialog();
        }
    }

    public void P(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        O(sparseArray, false);
    }

    public final void Q() {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (foldCommentActivity = this.f18912a) == null || foldCommentActivity.getPbEditor() == null || this.S == null) {
            return;
        }
        b.a.q0.x.x.a.a().c(0);
        b.a.q0.x.x.e pbEditor = this.f18912a.getPbEditor();
        pbEditor.U();
        pbEditor.S();
        if (pbEditor.z() != null) {
            pbEditor.z().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.m0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        b.a.q0.x.h findLauncherById = this.S.findLauncherById(23);
        b.a.q0.x.h findLauncherById2 = this.S.findLauncherById(2);
        b.a.q0.x.h findLauncherById3 = this.S.findLauncherById(5);
        if (findLauncherById2 != null) {
            findLauncherById2.display();
        }
        if (findLauncherById3 != null) {
            findLauncherById3.display();
        }
        if (findLauncherById != null) {
            findLauncherById.hide();
        }
        this.S.invalidate();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Q();
            D();
            this.T.c();
            a0(false);
        }
    }

    public void S(b.a.r0.k2.r.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048594, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.s = fVar;
        this.t = z;
        if (fVar.a0()) {
            this.p.Q();
        } else {
            this.p.f();
        }
        this.r.d(this.t);
        this.r.h(fVar);
        this.f18916e.setEnableDragExit(true);
        String adVertiComment = TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), z());
        TextView textView = this.Q;
        if (textView != null) {
            textView.setText(adVertiComment);
        }
    }

    public void T(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.S = editorTools;
            editorTools.setOnCancelClickListener(new i(this));
            this.S.setId(b.a.r0.k2.i.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.S.getParent() == null) {
                this.n.addView(this.S, layoutParams);
            }
            this.S.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.S.setActionListener(24, new j(this));
            D();
            this.f18912a.getPbEditor().i(new l(this));
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.f();
        }
    }

    public void V(PbFragment.b3 b3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, b3Var) == null) {
            this.J = b3Var;
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.P = z;
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.R();
        }
    }

    public void Y(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, pbModel) == null) {
            this.f18913b = pbModel;
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.f18912a == null || this.f18913b.P0().l().getDeletedReasonInfo() == null || 1 != this.f18913b.P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true : invokeV.booleanValue;
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || this.y == null) {
            return;
        }
        W(this.f18912a.getPbEditor().D());
        if (this.P) {
            c0(z);
        } else {
            C(z);
        }
    }

    public final void b0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, sparseArray) == null) || this.f18912a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(b.a.r0.k2.l.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(b.a.r0.k2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f18912a);
        lVar.q(b.a.r0.k2.l.del_my_thread_confirm);
        lVar.j(b.a.r0.k2.l.del_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.p(aVar2, aVar);
        lVar.g(false);
        AlertDialog t2 = lVar.t();
        aVar.a(new e(this, t2, sparseArray));
        aVar2.a(new f(this, t2));
    }

    public void c0(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || this.y == null || (textView = this.Q) == null) {
            return;
        }
        textView.setText(b.a.r0.k2.l.draft_to_send);
        if (z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.y.startAnimation(alphaAnimation);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.K == null) {
                this.K = new b.a.q0.s.g0.a(this.f18912a.getPageContext());
            }
            this.K.h(true);
        }
    }

    public final void e0(SparseArray<Object> sparseArray, int i2, b.a.r0.j.i iVar, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z)}) == null) || (foldCommentActivity = this.f18912a) == null) {
            return;
        }
        if (this.M == null) {
            this.M = new b.a.r0.j.j(foldCommentActivity.getPageContext(), null, iVar, userData);
        }
        this.M.C(z);
        AntiData antiData = this.f18912a.getAntiData();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.j(sparseArray2);
        this.M.E(new String[]{this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.M.D(x0Var);
        this.M.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.M.F(new g(this, sparseArray));
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            H(NoDataViewFactory.e.d(null, this.f18912a.getResources().getString(b.a.r0.k2.l.refresh_view_title_text)));
            this.y.setVisibility(8);
        }
    }

    public void g0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, str, z) == null) {
            if (z) {
                H(NoDataViewFactory.e.d("", str));
            } else {
                H(NoDataViewFactory.e.d(str, this.f18912a.getPageContext().getString(b.a.r0.k2.l.refresh_view_title_text)));
            }
            this.y.setVisibility(8);
        }
    }

    public final void h0(b.a.q0.s.s.a aVar, int i2) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048609, this, aVar, i2) == null) || (foldCommentActivity = this.f18912a) == null || aVar == null) {
            return;
        }
        if (this.L == null) {
            this.L = new b.a.r0.j.g(foldCommentActivity.getPageContext(), null);
        }
        AntiData antiData = this.f18912a.getAntiData();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (antiData != null && antiData.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.j(sparseArray);
        this.L.y(new String[]{this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f18912a.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.L.x(x0Var);
        this.L.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.L.z(new h(this, aVar));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.m = new BlankView(this.f18912a.getPageContext().getPageActivity());
            this.f18917f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds160)));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.f18916e.setBlankView(this.m);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.f18912a.checkUpIsLogin() && this.f18912a.checkPrivacyBeforeInput()) {
            b.a.q0.x.x.e pbEditor = this.f18912a.getPbEditor();
            if (pbEditor != null && (pbEditor.C() || pbEditor.E())) {
                this.f18912a.getPbEditor().A(false, null);
                return;
            }
            if (this.S != null) {
                I();
            }
            B();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            D();
        }
    }

    public void v(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.f18912a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.f18912a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(b.a.r0.k2.l.success));
            } else if (z2) {
                if (b.a.e.e.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.neterror);
                }
                this.f18912a.showToast(str);
            }
        }
    }

    public BdTypeListView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.o : (BdTypeListView) invokeV.objValue;
    }

    public PbFakeFloorModel x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.W : (PbFakeFloorModel) invokeV.objValue;
    }

    public b.a.r0.k2.u.f.t y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.T : (b.a.r0.k2.u.f.t) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!b.a.e.e.p.k.isEmpty(this.N)) {
                return this.N;
            }
            if (this.f18912a != null) {
                this.N = TbadkCoreApplication.getInst().getResources().getString(q0.b());
            }
            return this.N;
        }
        return (String) invokeV.objValue;
    }
}
