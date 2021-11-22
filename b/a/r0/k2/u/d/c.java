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
import b.a.r0.k2.r.u;
import b.a.r0.k2.u.f.r0;
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
    public static int a0 = 0;
    public static int b0 = 3;
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
    public int J;
    public PbFragment.b3 K;
    public b.a.q0.s.g0.a L;
    public b.a.r0.j.g M;
    public b.a.r0.j.j N;
    public String O;
    public PermissionJudgePolicy P;
    public boolean Q;
    public TextView R;
    public PbEmotionBar S;
    public EditorTools T;
    public b.a.r0.k2.u.f.t U;
    public List<String> V;
    public b.a.r0.k2.u.f.c1.c W;
    public PbFakeFloorModel X;
    public BdListView.p Y;
    public CustomMessageListener Z;

    /* renamed from: a  reason: collision with root package name */
    public FoldCommentActivity f20449a;

    /* renamed from: b  reason: collision with root package name */
    public PbModel f20450b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f20451c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f20452d;

    /* renamed from: e  reason: collision with root package name */
    public SubPbView f20453e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20454f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f20455g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f20456h;

    /* renamed from: i  reason: collision with root package name */
    public View f20457i;
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
        public final /* synthetic */ c f20458e;

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
            this.f20458e = cVar;
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
                    this.f20458e.f20449a.checkMuteState(sparseArray);
                    return;
                }
                this.f20458e.P(view);
            } else if (booleanValue2) {
                sparseArray.put(b.a.r0.k2.i.tag_from, 0);
                sparseArray.put(b.a.r0.k2.i.tag_check_mute_from, 1);
                this.f20458e.f20449a.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f20458e.L(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20459e;

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
            this.f20459e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20459e.f20450b == null) {
                return;
            }
            this.f20459e.f20450b.J1();
        }
    }

    /* renamed from: b.a.r0.k2.u.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1021c implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f20461f;

        public C1021c(c cVar, boolean z) {
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
            this.f20461f = cVar;
            this.f20460e = z;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f20461f.H.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f20461f.L(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f20461f.K != null) {
                            this.f20461f.K.a(new Object[]{sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f20461f.f20449a.handleMuteClick(this.f20460e, (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid), sparseArray);
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
        public final /* synthetic */ AlertDialog f20462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20463f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f20464g;

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
            this.f20464g = cVar;
            this.f20462e = alertDialog;
            this.f20463f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f20462e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!b.a.e.f.p.j.A()) {
                    b.a.e.f.p.l.L(this.f20464g.f20449a, b.a.r0.k2.l.neterror);
                } else {
                    this.f20464g.f20449a.deleteThread(this.f20463f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f20465e;

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
            this.f20465e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f20465e) == null) {
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
        public final /* synthetic */ SparseArray f20466a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f20467b;

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
            this.f20467b = cVar;
            this.f20466a = sparseArray;
        }

        @Override // b.a.r0.j.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20467b.f20449a.deleteThread(this.f20466a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements g.InterfaceC0991g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f20468a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f20469b;

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
            this.f20469b = cVar;
            this.f20468a = aVar;
        }

        @Override // b.a.r0.j.g.InterfaceC0991g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20469b.f20449a.deleteThread(this.f20468a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20470e;

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
            this.f20470e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20470e.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements b.a.q0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20471e;

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
            this.f20471e = cVar;
        }

        @Override // b.a.q0.x.b
        public void onAction(b.a.q0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14964c;
                if (obj instanceof w) {
                    if (((w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((w) aVar.f14964c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f20471e.P == null) {
                            this.f20471e.P = new PermissionJudgePolicy();
                        }
                        this.f20471e.P.clearRequestPermissionList();
                        this.f20471e.P.appendRequestPermission(this.f20471e.f20449a, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f20471e.P.startRequestPermission(this.f20471e.f20449a)) {
                            return;
                        }
                        this.f20471e.f20449a.getPbEditor().h((w) aVar.f14964c);
                        this.f20471e.f20449a.getPbEditor().A(false, null);
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
        public final /* synthetic */ c f20472e;

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
            this.f20472e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20472e.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20473e;

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
            this.f20473e = cVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f20473e.f20449a.mContentProcessController == null || this.f20473e.f20449a.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f20473e.f20449a.mContentProcessController.e().e()) {
                this.f20473e.f20449a.mContentProcessController.a(false);
            }
            this.f20473e.f20449a.mContentProcessController.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f20473e.T == null || this.f20473e.T.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f20473e.W == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f20473e.T.getId());
                c cVar = this.f20473e;
                cVar.W = new b.a.r0.k2.u.f.c1.c(cVar.f20449a.getPageContext(), this.f20473e.f20453e, layoutParams);
                if (!ListUtils.isEmpty(this.f20473e.V)) {
                    this.f20473e.W.m(this.f20473e.V);
                }
                this.f20473e.W.n(this.f20473e.T);
            }
            this.f20473e.W.l(substring);
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20474a;

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
            this.f20474a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                u uVar = (u) customResponsedMessage.getData();
                if (this.f20474a.f20453e != null) {
                    this.f20474a.f20453e.setSubPbViewData(uVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20475e;

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
            this.f20475e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20475e.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20476e;

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
            this.f20476e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new t0(this.f20476e.f20449a.getActivity(), "pb_huitie"))) {
                this.f20476e.f20449a.processProfessionPermission();
                if (this.f20476e.f20449a == null || this.f20476e.f20449a.getModel() == null || this.f20476e.f20449a.getModel().P0() == null || this.f20476e.f20449a.getModel().P0().O() == null || this.f20476e.f20449a.getModel().P0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f20476e.f20449a.getModel().g1()).param("fid", this.f20476e.f20449a.getModel().P0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f20476e.f20449a.getModel().f1()).param("fid", this.f20476e.f20449a.getModel().P0().m()).param("obj_locate", 1).param("uid", this.f20476e.f20449a.getModel().P0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20477e;

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
            this.f20477e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20477e.R();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20478a;

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
            this.f20478a = cVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f20478a.X.N(postData);
                this.f20478a.r.b();
                this.f20478a.U.c();
                this.f20478a.T.hideTools();
                this.f20478a.a0(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20479e;

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
            this.f20479e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20479e.f20453e == null) {
                return;
            }
            this.f20479e.f20453e.onFinish();
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20480e;

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
            this.f20480e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20480e.f20449a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20481e;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f20482e;

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
                this.f20482e = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20482e.f20481e.l == null) {
                    return;
                }
                this.f20482e.f20481e.l.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f20483e;

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
                this.f20483e = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    UrlManager.getInstance().dealOneLink(this.f20483e.f20481e.f20449a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                    if (this.f20483e.f20481e.s != null) {
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.f20483e.f20481e.s.Q()).param("fname", this.f20483e.f20481e.s.n()).param("fid", this.f20483e.f20481e.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
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
            this.f20481e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.comment_folded_explain));
                if (this.f20481e.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.f20481e.s.Q()).param("fname", this.f20481e.s.n()).param("fid", this.f20481e.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a(b.a.r0.k2.l.know, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.a(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.f20481e.f20449a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(b.a.r0.k2.g.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.f20481e.f20449a);
                textView.setText(b.a.r0.k2.l.view_tieba_policy);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(b.a.r0.k2.g.T_X07));
                textView.setTextColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.f20481e.f20449a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(b.a.r0.k2.h.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(b.a.e.f.p.l.g(this.f20481e.f20449a, b.a.r0.k2.g.tbds36), b.a.e.f.p.l.g(this.f20481e.f20449a, b.a.r0.k2.g.tbds36)));
                c cVar = this.f20481e;
                b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(cVar.f20449a);
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
        this.f20455g = null;
        this.q = null;
        this.H = null;
        this.I = null;
        this.J = 0;
        this.L = null;
        this.Q = false;
        this.Y = new k(this);
        this.Z = new m(this, 2921597);
        this.f20449a = foldCommentActivity;
        this.f20450b = foldCommentActivity.getModel();
        this.C = onClickListener;
        this.E = zVar;
        this.F = cVar;
        this.G = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.layout_fold_comment_activity, (ViewGroup) null);
        this.f20453e = subPbView;
        this.f20454f = (LinearLayout) subPbView.findViewById(b.a.r0.k2.i.navigation_bar_group);
        RelativeLayout relativeLayout = (RelativeLayout) this.f20453e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_comment);
        this.y = relativeLayout;
        relativeLayout.setVisibility(8);
        this.v = (TextView) this.f20453e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_comment_reply_text);
        this.w = (ImageView) this.f20453e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_more_img);
        this.x = (ImageView) this.f20453e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_emotion_img);
        this.f20451c = (NoNetworkView) this.f20453e.findViewById(b.a.r0.k2.i.view_no_network);
        G();
        this.n = (RelativeLayout) this.f20453e.findViewById(b.a.r0.k2.i.fold_comment_body_layout);
        this.o = (BdTypeListView) this.f20453e.findViewById(b.a.r0.k2.i.fold_comment_list);
        View view = new View(foldCommentActivity.getActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.addHeaderView(view, 0);
        this.o.setOnSrollToBottomListener(this.Y);
        this.f20453e.setTopView(view);
        this.f20453e.setNavigationView(this.f20454f);
        this.f20453e.setListView(this.o);
        this.f20453e.setContentView(this.n);
        b.a.r0.k2.u.h.d dVar = new b.a.r0.k2.u.h.d(foldCommentActivity.getPageContext());
        this.p = dVar;
        dVar.x();
        this.p.B(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.f20453e.findViewById(b.a.r0.k2.i.progress);
        this.u = (MaskView) this.f20453e.findViewById(b.a.r0.k2.i.mask_view);
        this.B = this.f20453e.findViewById(b.a.r0.k2.i.view_comment_top_line);
        LinearLayout linearLayout = (LinearLayout) this.f20453e.findViewById(b.a.r0.k2.i.fold_comment_editer_tool_comment_layout);
        this.z = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.f20453e.findViewById(b.a.r0.k2.i.fold_comment_editor_tool_comment_user_image);
        this.A = headImageView;
        headImageView.setVisibility(0);
        this.A.setIsRound(true);
        this.A.setBorderWidth(b.a.e.f.p.l.g(this.f20449a, b.a.r0.k2.g.L_X01));
        this.A.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
        this.A.setDefaultBgResource(0);
        this.A.setDefaultResource(b.a.r0.k2.f.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.A.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        K(TbadkCoreApplication.getInst().getSkinType());
        F();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.f20449a.getPageContext());
        this.X = pbFakeFloorModel;
        pbFakeFloorModel.P(this.f20450b.F(), this.f20450b.B(), this.f20450b.C(), this.f20450b.A(), this.f20450b.G());
        b.a.r0.k2.u.f.t tVar = new b.a.r0.k2.u.f.t(this.f20449a.getPageContext(), this.X, this.n);
        this.U = tVar;
        tVar.k(new p(this));
        this.U.m(this.f20449a.mOnFloorPostWriteNewCallback);
        this.X.R(new q(this));
        this.f20449a.registerListener(this.Z);
    }

    public SubPbView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20453e : (SubPbView) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.y == null) {
            return;
        }
        this.B.setVisibility(8);
        this.y.setVisibility(8);
        PbEmotionBar pbEmotionBar = this.S;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.y == null || this.R == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        PbModel pbModel = this.f20450b;
        boolean z2 = true;
        this.R.setText(tbSingleton.getAdVertiComment((pbModel == null || pbModel.P0() == null || !this.f20450b.P0().k0()) ? false : true, (this.f20450b.P0() == null || !this.f20450b.P0().l0()) ? false : false, z()));
        if (z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.y.startAnimation(alphaAnimation);
        }
    }

    public void D() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (editorTools = this.T) == null) {
            return;
        }
        editorTools.hide();
        b.a.r0.k2.u.f.c1.c cVar = this.W;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void E() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (noDataView = this.f20452d) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.o.setVisibility(0);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.r0.k2.u.d.a aVar = new b.a.r0.k2.u.d.a(this.f20449a, this.o);
            this.r = aVar;
            aVar.i(this.f20449a.getEventController());
            this.r.j(this.f20449a.getPbPostShareController());
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
            int g2 = b.a.e.f.p.l.g(this.f20449a.getPageContext().getPageActivity(), b.a.r0.k2.g.ds88);
            int g3 = b.a.e.f.p.l.g(this.f20449a.getPageContext().getPageActivity(), b.a.r0.k2.g.ds2);
            NavigationBar navigationBar = (NavigationBar) this.f20453e.findViewById(b.a.r0.k2.i.view_navigation_bar);
            this.f20455g = navigationBar;
            navigationBar.setCenterTextTitle(this.f20449a.getResources().getString(b.a.r0.k2.l.folded_comment));
            this.f20457i = this.f20455g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f20449a).inflate(b.a.r0.k2.j.layout_fold_explain_icon, (ViewGroup) null);
            this.j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(b.a.r0.k2.i.navigation_fold_explain_icon);
            this.k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(b.a.r0.k2.h.icon_pure_explain44, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f20455g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, new t(this));
            ImageView backImageView = this.f20455g.getBackImageView();
            this.f20456h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20457i.getLayoutParams();
                layoutParams.height = g2;
                layoutParams.width = g2;
                layoutParams.leftMargin = g3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.f20457i;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f20457i.getLayoutParams();
                layoutParams2.width = g2;
                layoutParams2.height = g2;
                this.f20457i.setLayoutParams(layoutParams2);
            }
            this.f20455g.setIsClose(true);
            this.f20455g.setIsCorner(true);
            this.f20455g.isShowBottomLine(true);
            this.f20455g.setBottomLineHeight(3);
            this.f20455g.setStatusBarVisibility(8);
        }
    }

    public final void H(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f20449a.getPageContext().getString(b.a.r0.k2.l.refresh_view_button_text), new b(this)));
            if (this.f20452d == null) {
                Activity pageActivity = this.f20449a.getPageContext().getPageActivity();
                this.f20452d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, b.a.e.f.p.l.g(pageActivity, b.a.r0.k2.g.ds250)), eVar, a2);
            }
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            SkinManager.setBackgroundColor(this.f20452d, b.a.r0.k2.f.CAM_X0201);
            this.f20452d.setClickable(true);
            this.f20452d.setTextOption(eVar);
            this.f20452d.onChangeSkinType(this.f20449a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f20452d.setVisibility(0);
        }
    }

    public void I() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f20449a == null || (editorTools = this.T) == null) {
            return;
        }
        editorTools.display();
        if (this.f20449a.getPbEditor() != null) {
            this.f20449a.getPbEditor().Q();
        }
        B();
    }

    public final void J() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (pbModel = this.f20450b) == null || pbModel.P0() == null || this.f20450b.P0().y() == null || !b.a.e.f.p.l.D()) {
            return;
        }
        if (this.f20450b.P0().y().b() == 0) {
            U();
            return;
        }
        b.a.r0.k2.u.h.d dVar = this.p;
        if (dVar != null) {
            dVar.Q();
        }
        if (this.f20450b.D1(false)) {
            X();
        } else {
            U();
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f20449a.getLayoutMode().k(i2 == 1);
            this.f20449a.getLayoutMode().j(this.f20453e);
            SkinManager.setBackgroundColor(this.f20453e, b.a.r0.k2.f.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, b.a.r0.k2.f.CAM_X0201);
            this.f20455g.onChangeSkinType(this.f20449a.getPageContext(), i2);
            PbModel pbModel = this.f20450b;
            if (pbModel != null && (pbModel.t1() || this.f20450b.s1())) {
                WebPManager.setPureDrawable(this.f20456h, b.a.r0.k2.h.icon_topbar_return, b.a.r0.k2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.f20456h, b.a.r0.k2.h.icon_pure_topbar_close44, b.a.r0.k2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.f20451c.onChangeSkinType(this.f20449a.getPageContext(), i2);
            this.f20449a.getLayoutMode().j(this.p.b());
            this.p.d(i2);
            SkinManager.setViewTextColor(this.v, b.a.r0.k2.f.CAM_X0110);
            this.v.setAlpha(0.95f);
            b.a.r0.k2.u.d.a aVar = this.r;
            if (aVar != null) {
                aVar.b();
            }
            SkinManager.setBackgroundColor(this.B, b.a.r0.k2.f.CAM_X0203);
            this.A.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
            this.z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.f.p.l.g(this.f20449a, b.a.r0.k2.g.tbds47), SkinManager.getColor(b.a.r0.k2.f.CAM_X0209)));
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
            sparseArray.put(a0, Integer.valueOf(b0));
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
            this.I = new b.a.q0.s.s.a(this.f20449a);
            if (StringUtils.isNull(str2)) {
                this.I.setMessageId(i4);
            } else {
                this.I.setOnlyMessageShowCenter(false);
                this.I.setMessage(str2);
            }
            this.I.setYesButtonTag(sparseArray);
            this.I.setPositiveButton(b.a.r0.k2.l.dialog_ok, this.f20449a);
            this.I.setNegativeButton(b.a.r0.k2.l.dialog_cancel, new d(this));
            this.I.setCancelable(true);
            this.I.create(this.f20449a.getPageContext());
            if (z2) {
                b0(sparseArray);
            } else if (z) {
                b0(sparseArray);
            } else if (Z()) {
                b.a.r0.j.i iVar = new b.a.r0.j.i(this.f20450b.P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f20450b.P0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f20450b.P0().o().has_forum_rule.intValue());
                iVar.i(this.f20450b.P0().l().getId(), this.f20450b.P0().l().getName());
                iVar.h(this.f20450b.P0().l().getImage_url());
                iVar.j(this.f20450b.P0().l().getUser_level());
                e0(sparseArray, i2, iVar, this.f20450b.P0().U(), false);
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
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f20449a);
            iVar.p(this.f20449a.getString(b.a.r0.k2.l.bar_manager));
            iVar.m(new C1021c(this, z));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(b.a.r0.k2.i.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(b.a.r0.k2.i.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new b.a.q0.s.s.f(10, this.f20449a.getString(b.a.r0.k2.l.delete_post), iVar);
                } else {
                    fVar2 = new b.a.q0.s.s.f(10, this.f20449a.getString(b.a.r0.k2.l.delete), iVar);
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
                fVar2.f14338d.setTag(sparseArray2);
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
                b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(11, this.f20449a.getString(b.a.r0.k2.l.forbidden_person), iVar);
                fVar3.f14338d.setTag(sparseArray3);
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
                    fVar = new b.a.q0.s.s.f(12, this.f20449a.getString(b.a.r0.k2.l.un_mute), iVar);
                } else {
                    fVar = new b.a.q0.s.s.f(12, this.f20449a.getString(b.a.r0.k2.l.mute), iVar);
                }
                fVar.f14338d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            b.a.r0.k2.u.f.g1.a.e(arrayList);
            if (b.a.q0.b.d.I()) {
                iVar.k(arrayList, false);
            } else {
                iVar.k(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f20449a.getPageContext(), iVar);
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (foldCommentActivity = this.f20449a) == null || foldCommentActivity.getPbEditor() == null || this.T == null) {
            return;
        }
        b.a.q0.x.x.a.a().c(0);
        b.a.q0.x.x.e pbEditor = this.f20449a.getPbEditor();
        pbEditor.U();
        pbEditor.S();
        if (pbEditor.z() != null) {
            pbEditor.z().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.m0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        b.a.q0.x.h findLauncherById = this.T.findLauncherById(23);
        b.a.q0.x.h findLauncherById2 = this.T.findLauncherById(2);
        b.a.q0.x.h findLauncherById3 = this.T.findLauncherById(5);
        if (findLauncherById2 != null) {
            findLauncherById2.display();
        }
        if (findLauncherById3 != null) {
            findLauncherById3.display();
        }
        if (findLauncherById != null) {
            findLauncherById.hide();
        }
        this.T.invalidate();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Q();
            D();
            this.U.c();
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
        this.f20453e.setEnableDragExit(true);
        String adVertiComment = TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), z());
        TextView textView = this.R;
        if (textView != null) {
            textView.setText(adVertiComment);
        }
    }

    public void T(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.T = editorTools;
            editorTools.setOnCancelClickListener(new i(this));
            this.T.setId(b.a.r0.k2.i.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.T.getParent() == null) {
                this.n.addView(this.T, layoutParams);
            }
            this.T.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.T.setActionListener(24, new j(this));
            D();
            this.f20449a.getPbEditor().i(new l(this));
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
            this.K = b3Var;
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.Q = z;
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
            this.f20450b = pbModel;
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.f20449a == null || this.f20450b.P0().l().getDeletedReasonInfo() == null || 1 != this.f20450b.P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true : invokeV.booleanValue;
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || this.y == null) {
            return;
        }
        W(this.f20449a.getPbEditor().D());
        if (this.Q) {
            c0(z);
        } else {
            C(z);
        }
    }

    public final void b0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, sparseArray) == null) || this.f20449a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(b.a.r0.k2.l.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(b.a.r0.k2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f20449a);
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
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || this.y == null || (textView = this.R) == null) {
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
            if (this.L == null) {
                this.L = new b.a.q0.s.g0.a(this.f20449a.getPageContext());
            }
            this.L.h(true);
        }
    }

    public final void e0(SparseArray<Object> sparseArray, int i2, b.a.r0.j.i iVar, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z)}) == null) || (foldCommentActivity = this.f20449a) == null) {
            return;
        }
        if (this.N == null) {
            this.N = new b.a.r0.j.j(foldCommentActivity.getPageContext(), null, iVar, userData);
        }
        this.N.C(z);
        AntiData antiData = this.f20449a.getAntiData();
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
        this.N.E(new String[]{this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.N.D(x0Var);
        this.N.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.N.F(new g(this, sparseArray));
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            H(NoDataViewFactory.e.d(null, this.f20449a.getResources().getString(b.a.r0.k2.l.refresh_view_title_text)));
            this.y.setVisibility(8);
        }
    }

    public void g0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, str, z) == null) {
            if (z) {
                H(NoDataViewFactory.e.d("", str));
            } else {
                H(NoDataViewFactory.e.d(str, this.f20449a.getPageContext().getString(b.a.r0.k2.l.refresh_view_title_text)));
            }
            this.y.setVisibility(8);
        }
    }

    public final void h0(b.a.q0.s.s.a aVar, int i2) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048609, this, aVar, i2) == null) || (foldCommentActivity = this.f20449a) == null || aVar == null) {
            return;
        }
        if (this.M == null) {
            this.M = new b.a.r0.j.g(foldCommentActivity.getPageContext(), null);
        }
        AntiData antiData = this.f20449a.getAntiData();
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
        this.M.y(new String[]{this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f20449a.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.M.x(x0Var);
        this.M.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.M.z(new h(this, aVar));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.m = new BlankView(this.f20449a.getPageContext().getPageActivity());
            PbModel pbModel = this.f20450b;
            if (pbModel != null && (pbModel.t1() || this.f20450b.s1())) {
                this.J = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds562) + UtilHelper.getStatusBarHeight();
            } else {
                this.J = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds160);
            }
            this.f20454f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.J));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.f20453e.setBlankView(this.m);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.f20449a.checkUpIsLogin() && this.f20449a.checkPrivacyBeforeInput()) {
            b.a.q0.x.x.e pbEditor = this.f20449a.getPbEditor();
            if (pbEditor != null && (pbEditor.C() || pbEditor.E())) {
                this.f20449a.getPbEditor().A(false, null);
                return;
            }
            if (this.T != null) {
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
            this.f20449a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.f20449a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(b.a.r0.k2.l.success));
            } else if (z2) {
                if (b.a.e.f.p.k.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.neterror);
                }
                this.f20449a.showToast(str);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.X : (PbFakeFloorModel) invokeV.objValue;
    }

    public b.a.r0.k2.u.f.t y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.U : (b.a.r0.k2.u.f.t) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!b.a.e.f.p.k.isEmpty(this.O)) {
                return this.O;
            }
            if (this.f20449a != null) {
                this.O = TbadkCoreApplication.getInst().getResources().getString(r0.b());
            }
            return this.O;
        }
        return (String) invokeV.objValue;
    }
}
