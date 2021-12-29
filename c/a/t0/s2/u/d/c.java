package c.a.t0.s2.u.d;

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
import c.a.s0.s.q.t0;
import c.a.s0.s.q.x0;
import c.a.s0.s.s.a;
import c.a.s0.s.s.j;
import c.a.s0.t.c.w;
import c.a.t0.k.g;
import c.a.t0.k.j;
import c.a.t0.s2.r.u;
import c.a.t0.s2.u.f.r0;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public View B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public TbRichTextView.y E;
    public c.a.t0.s2.s.c F;
    public View.OnLongClickListener G;
    public PopupDialog H;
    public c.a.s0.s.s.a I;
    public int J;
    public PbFragment.c3 K;
    public c.a.s0.s.i0.a L;
    public c.a.t0.k.g M;
    public c.a.t0.k.j N;
    public String O;
    public PermissionJudgePolicy P;
    public boolean Q;
    public TextView R;
    public PbEmotionBar S;
    public EditorTools T;
    public c.a.t0.s2.u.f.t U;
    public List<String> V;
    public c.a.t0.s2.u.f.c1.c W;
    public PbFakeFloorModel X;
    public BdListView.p Y;
    public CustomMessageListener Z;
    public FoldCommentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public PbModel f23187b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f23188c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f23189d;

    /* renamed from: e  reason: collision with root package name */
    public SubPbView f23190e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23191f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f23192g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f23193h;

    /* renamed from: i  reason: collision with root package name */
    public View f23194i;

    /* renamed from: j  reason: collision with root package name */
    public View f23195j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f23196k;
    public AlertDialog l;
    public BlankView m;
    public RelativeLayout n;
    public BdTypeListView o;
    public c.a.t0.s2.u.h.d p;
    public ProgressBar q;
    public c.a.t0.s2.u.d.a r;
    public c.a.t0.s2.r.f s;
    public boolean t;
    public MaskView u;
    public TextView v;
    public ImageView w;
    public ImageView x;
    public RelativeLayout y;
    public LinearLayout z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23197e;

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
            this.f23197e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(c.a.t0.s2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(c.a.t0.s2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(c.a.t0.s2.i.tag_from, 1);
                    this.f23197e.a.checkMuteState(sparseArray);
                    return;
                }
                this.f23197e.P(view);
            } else if (booleanValue2) {
                sparseArray.put(c.a.t0.s2.i.tag_from, 0);
                sparseArray.put(c.a.t0.s2.i.tag_check_mute_from, 1);
                this.f23197e.a.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f23197e.L(((Integer) sparseArray.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(c.a.t0.s2.i.tag_del_post_id), ((Integer) sparseArray.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23198e;

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
            this.f23198e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23198e.f23187b == null) {
                return;
            }
            this.f23198e.f23187b.L1();
        }
    }

    /* renamed from: c.a.t0.s2.u.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1377c implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f23199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f23200f;

        public C1377c(c cVar, boolean z) {
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
            this.f23200f = cVar;
            this.f23199e = z;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                this.f23200f.H.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f23200f.L(((Integer) sparseArray.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(c.a.t0.s2.i.tag_del_post_id), ((Integer) sparseArray.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f23200f.K != null) {
                            this.f23200f.K.a(new Object[]{sparseArray.get(c.a.t0.s2.i.tag_manage_user_identity), sparseArray.get(c.a.t0.s2.i.tag_forbid_user_name), sparseArray.get(c.a.t0.s2.i.tag_forbid_user_post_id), sparseArray.get(c.a.t0.s2.i.tag_forbid_user_name_show), sparseArray.get(c.a.t0.s2.i.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f23200f.a.handleMuteClick(this.f23199e, (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f23201e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f23202f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f23203g;

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
            this.f23203g = cVar;
            this.f23201e = alertDialog;
            this.f23202f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f23201e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.L(this.f23203g.a, c.a.t0.s2.l.neterror);
                } else {
                    this.f23203g.a.deleteThread(this.f23202f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f23204e;

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
            this.f23204e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f23204e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class g implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f23205b;

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
            this.f23205b = cVar;
            this.a = sparseArray;
        }

        @Override // c.a.t0.k.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f23205b.a.deleteThread(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements g.InterfaceC1145g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.s.s.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f23206b;

        public h(c cVar, c.a.s0.s.s.a aVar) {
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
            this.f23206b = cVar;
            this.a = aVar;
        }

        @Override // c.a.t0.k.g.InterfaceC1145g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f23206b.a.deleteThread(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23207e;

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
            this.f23207e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23207e.R();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements c.a.s0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23208e;

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
            this.f23208e = cVar;
        }

        @Override // c.a.s0.x.b
        public void onAction(c.a.s0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14519c;
                if (obj instanceof w) {
                    if (((w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((w) aVar.f14519c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f23208e.P == null) {
                            this.f23208e.P = new PermissionJudgePolicy();
                        }
                        this.f23208e.P.clearRequestPermissionList();
                        this.f23208e.P.appendRequestPermission(this.f23208e.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f23208e.P.startRequestPermission(this.f23208e.a)) {
                            return;
                        }
                        this.f23208e.a.getPbEditor().h((w) aVar.f14519c);
                        this.f23208e.a.getPbEditor().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23209e;

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
            this.f23209e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23209e.J();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23210e;

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
            this.f23210e = cVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f23210e.a.mContentProcessController == null || this.f23210e.a.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f23210e.a.mContentProcessController.e().e()) {
                this.f23210e.a.mContentProcessController.a(false);
            }
            this.f23210e.a.mContentProcessController.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f23210e.T == null || this.f23210e.T.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f23210e.W == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f23210e.T.getId());
                c cVar = this.f23210e;
                cVar.W = new c.a.t0.s2.u.f.c1.c(cVar.a.getPageContext(), this.f23210e.f23190e, layoutParams);
                if (!ListUtils.isEmpty(this.f23210e.V)) {
                    this.f23210e.W.m(this.f23210e.V);
                }
                this.f23210e.W.n(this.f23210e.T);
            }
            this.f23210e.W.l(substring);
        }
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                u uVar = (u) customResponsedMessage.getData();
                if (this.a.f23190e != null) {
                    this.a.f23190e.setSubPbViewData(uVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23211e;

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
            this.f23211e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23211e.J();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23212e;

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
            this.f23212e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new t0(this.f23212e.a.getActivity(), "pb_huitie"))) {
                this.f23212e.a.processProfessionPermission();
                if (this.f23212e.a == null || this.f23212e.a.getModel() == null || this.f23212e.a.getModel().R0() == null || this.f23212e.a.getModel().R0().O() == null || this.f23212e.a.getModel().R0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f23212e.a.getModel().i1()).param("fid", this.f23212e.a.getModel().R0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f23212e.a.getModel().h1()).param("fid", this.f23212e.a.getModel().R0().m()).param("obj_locate", 1).param("uid", this.f23212e.a.getModel().R0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23213e;

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
            this.f23213e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23213e.R();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.X.N(postData);
                this.a.r.b();
                this.a.U.c();
                this.a.T.hideTools();
                this.a.a0(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23214e;

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
            this.f23214e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23214e.f23190e == null) {
                return;
            }
            this.f23214e.f23190e.onFinish();
        }
    }

    /* loaded from: classes8.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23215e;

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
            this.f23215e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23215e.a.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23216e;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f23217e;

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
                this.f23217e = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23217e.f23216e.l == null) {
                    return;
                }
                this.f23217e.f23216e.l.dismiss();
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f23218e;

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
                this.f23218e = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    UrlManager.getInstance().dealOneLink(this.f23218e.f23216e.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                    if (this.f23218e.f23216e.s != null) {
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.f23218e.f23216e.s.Q()).param("fname", this.f23218e.f23216e.s.n()).param("fid", this.f23218e.f23216e.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
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
            this.f23216e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.comment_folded_explain));
                if (this.f23216e.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.f23216e.s.Q()).param("fname", this.f23216e.s.n()).param("fid", this.f23216e.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a(c.a.t0.s2.l.know, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.a(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.f23216e.a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(c.a.t0.s2.g.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.f23216e.a);
                textView.setText(c.a.t0.s2.l.view_tieba_policy);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(c.a.t0.s2.g.T_X07));
                textView.setTextColor(SkinManager.getColor(c.a.t0.s2.f.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.f23216e.a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(c.a.t0.s2.h.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(c.a.d.f.p.n.f(this.f23216e.a, c.a.t0.s2.g.tbds36), c.a.d.f.p.n.f(this.f23216e.a, c.a.t0.s2.g.tbds36)));
                c cVar = this.f23216e;
                c.a.s0.s.s.m mVar = new c.a.s0.s.s.m(cVar.a);
                mVar.r(c.a.t0.s2.l.comment_folded);
                mVar.n(spannableString);
                mVar.k(3);
                mVar.h(linearLayout);
                mVar.l(true);
                mVar.m(LinkMovementMethod.getInstance());
                mVar.p(aVar);
                mVar.g(true);
                cVar.l = mVar.u();
            }
        }
    }

    public c(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.y yVar, c.a.t0.s2.s.c cVar, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, onClickListener, yVar, cVar, onLongClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23192g = null;
        this.q = null;
        this.H = null;
        this.I = null;
        this.J = 0;
        this.L = null;
        this.Q = false;
        this.Y = new k(this);
        this.Z = new m(this, 2921597);
        this.a = foldCommentActivity;
        this.f23187b = foldCommentActivity.getModel();
        this.C = onClickListener;
        this.E = yVar;
        this.F = cVar;
        this.G = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(c.a.t0.s2.j.layout_fold_comment_activity, (ViewGroup) null);
        this.f23190e = subPbView;
        this.f23191f = (LinearLayout) subPbView.findViewById(c.a.t0.s2.i.navigation_bar_group);
        RelativeLayout relativeLayout = (RelativeLayout) this.f23190e.findViewById(c.a.t0.s2.i.fold_comment_editor_tool_comment);
        this.y = relativeLayout;
        relativeLayout.setVisibility(8);
        this.v = (TextView) this.f23190e.findViewById(c.a.t0.s2.i.fold_comment_editor_tool_comment_reply_text);
        this.w = (ImageView) this.f23190e.findViewById(c.a.t0.s2.i.fold_comment_editor_tool_more_img);
        this.x = (ImageView) this.f23190e.findViewById(c.a.t0.s2.i.fold_comment_editor_tool_emotion_img);
        this.f23188c = (NoNetworkView) this.f23190e.findViewById(c.a.t0.s2.i.view_no_network);
        G();
        this.n = (RelativeLayout) this.f23190e.findViewById(c.a.t0.s2.i.fold_comment_body_layout);
        this.o = (BdTypeListView) this.f23190e.findViewById(c.a.t0.s2.i.fold_comment_list);
        View view = new View(foldCommentActivity.getActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.addHeaderView(view, 0);
        this.o.setOnSrollToBottomListener(this.Y);
        this.f23190e.setTopView(view);
        this.f23190e.setNavigationView(this.f23191f);
        this.f23190e.setListView(this.o);
        this.f23190e.setContentView(this.n);
        c.a.t0.s2.u.h.d dVar = new c.a.t0.s2.u.h.d(foldCommentActivity.getPageContext());
        this.p = dVar;
        dVar.y();
        this.p.C(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.f23190e.findViewById(c.a.t0.s2.i.progress);
        this.u = (MaskView) this.f23190e.findViewById(c.a.t0.s2.i.mask_view);
        this.B = this.f23190e.findViewById(c.a.t0.s2.i.view_comment_top_line);
        LinearLayout linearLayout = (LinearLayout) this.f23190e.findViewById(c.a.t0.s2.i.fold_comment_editer_tool_comment_layout);
        this.z = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.f23190e.findViewById(c.a.t0.s2.i.fold_comment_editor_tool_comment_user_image);
        this.A = headImageView;
        headImageView.setVisibility(0);
        this.A.setIsRound(true);
        this.A.setBorderWidth(c.a.d.f.p.n.f(this.a, c.a.t0.s2.g.L_X01));
        this.A.setBorderColor(SkinManager.getColor(c.a.t0.s2.f.CAM_X0401));
        this.A.setDefaultBgResource(0);
        this.A.setDefaultResource(c.a.t0.s2.f.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.A.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        K(TbadkCoreApplication.getInst().getSkinType());
        F();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.a.getPageContext());
        this.X = pbFakeFloorModel;
        pbFakeFloorModel.P(this.f23187b.F(), this.f23187b.B(), this.f23187b.C(), this.f23187b.A(), this.f23187b.G());
        c.a.t0.s2.u.f.t tVar = new c.a.t0.s2.u.f.t(this.a.getPageContext(), this.X, this.n);
        this.U = tVar;
        tVar.k(new p(this));
        this.U.n(this.a.mOnFloorPostWriteNewCallback);
        this.X.R(new q(this));
        this.a.registerListener(this.Z);
    }

    public SubPbView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23190e : (SubPbView) invokeV.objValue;
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
        PbModel pbModel = this.f23187b;
        boolean z2 = true;
        this.R.setText(tbSingleton.getAdVertiComment((pbModel == null || pbModel.R0() == null || !this.f23187b.R0().k0()) ? false : true, (this.f23187b.R0() == null || !this.f23187b.R0().l0()) ? false : false, z()));
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
        c.a.t0.s2.u.f.c1.c cVar = this.W;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void E() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (noDataView = this.f23189d) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.o.setVisibility(0);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.t0.s2.u.d.a aVar = new c.a.t0.s2.u.d.a(this.a, this.o);
            this.r = aVar;
            aVar.i(this.a.getEventController());
            this.r.j(this.a.getPbPostShareController());
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
            int f2 = c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), c.a.t0.s2.g.ds88);
            int f3 = c.a.d.f.p.n.f(this.a.getPageContext().getPageActivity(), c.a.t0.s2.g.ds2);
            NavigationBar navigationBar = (NavigationBar) this.f23190e.findViewById(c.a.t0.s2.i.view_navigation_bar);
            this.f23192g = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(c.a.t0.s2.l.folded_comment));
            this.f23194i = this.f23192g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(c.a.t0.s2.j.layout_fold_explain_icon, (ViewGroup) null);
            this.f23195j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(c.a.t0.s2.i.navigation_fold_explain_icon);
            this.f23196k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(c.a.t0.s2.h.icon_pure_explain44, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f23192g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f23195j, new t(this));
            ImageView backImageView = this.f23192g.getBackImageView();
            this.f23193h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f23194i.getLayoutParams();
                layoutParams.height = f2;
                layoutParams.width = f2;
                layoutParams.leftMargin = f3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.f23194i;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f23194i.getLayoutParams();
                layoutParams2.width = f2;
                layoutParams2.height = f2;
                this.f23194i.setLayoutParams(layoutParams2);
            }
            this.f23192g.setIsClose(true);
            this.f23192g.setIsCorner(true);
            this.f23192g.isShowBottomLine(true);
            this.f23192g.setBottomLineHeight(3);
            this.f23192g.setStatusBarVisibility(8);
        }
    }

    public final void H(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getPageContext().getString(c.a.t0.s2.l.refresh_view_button_text), new b(this)));
            if (this.f23189d == null) {
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                this.f23189d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, c.a.d.f.p.n.f(pageActivity, c.a.t0.s2.g.ds250)), eVar, a2);
            }
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            SkinManager.setBackgroundColor(this.f23189d, c.a.t0.s2.f.CAM_X0201);
            this.f23189d.setClickable(true);
            this.f23189d.setTextOption(eVar);
            this.f23189d.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f23189d.setVisibility(0);
        }
    }

    public void I() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null || (editorTools = this.T) == null) {
            return;
        }
        editorTools.display();
        if (this.a.getPbEditor() != null) {
            this.a.getPbEditor().P();
        }
        B();
    }

    public final void J() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (pbModel = this.f23187b) == null || pbModel.R0() == null || this.f23187b.R0().y() == null || !c.a.d.f.p.n.C()) {
            return;
        }
        if (this.f23187b.R0().y().b() == 0) {
            U();
            return;
        }
        c.a.t0.s2.u.h.d dVar = this.p;
        if (dVar != null) {
            dVar.R();
        }
        if (this.f23187b.F1(false)) {
            X();
        } else {
            U();
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f23190e);
            SkinManager.setBackgroundColor(this.f23190e, c.a.t0.s2.f.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, c.a.t0.s2.f.CAM_X0201);
            this.f23192g.onChangeSkinType(this.a.getPageContext(), i2);
            PbModel pbModel = this.f23187b;
            if (pbModel != null && (pbModel.v1() || this.f23187b.u1())) {
                WebPManager.setPureDrawable(this.f23193h, c.a.t0.s2.h.icon_topbar_return, c.a.t0.s2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.f23193h, c.a.t0.s2.h.icon_pure_topbar_close44, c.a.t0.s2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.f23188c.onChangeSkinType(this.a.getPageContext(), i2);
            this.a.getLayoutMode().j(this.p.b());
            this.p.d(i2);
            SkinManager.setViewTextColor(this.v, c.a.t0.s2.f.CAM_X0110);
            this.v.setAlpha(0.95f);
            c.a.t0.s2.u.d.a aVar = this.r;
            if (aVar != null) {
                aVar.b();
            }
            SkinManager.setBackgroundColor(this.B, c.a.t0.s2.f.CAM_X0203);
            this.A.setBorderColor(SkinManager.getColor(c.a.t0.s2.f.CAM_X0401));
            this.z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.n.f(this.a, c.a.t0.s2.g.tbds47), SkinManager.getColor(c.a.t0.s2.f.CAM_X0209)));
            c.a.s0.s.u.c.d(this.y).f(c.a.t0.s2.f.CAM_X0208);
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
            sparseArray.put(c.a.t0.s2.i.tag_del_post_id, str);
            sparseArray.put(c.a.t0.s2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(c.a.t0.s2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(0, 3);
            int i4 = c.a.t0.s2.l.del_all_post_confirm;
            if (i3 == 1002 && !z) {
                i4 = c.a.t0.s2.l.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = c.a.t0.s2.l.report_thread_confirm;
                } else {
                    i4 = c.a.t0.s2.l.del_thread_confirm;
                }
            }
            this.I = new c.a.s0.s.s.a(this.a);
            if (StringUtils.isNull(str2)) {
                this.I.setMessageId(i4);
            } else {
                this.I.setOnlyMessageShowCenter(false);
                this.I.setMessage(str2);
            }
            this.I.setYesButtonTag(sparseArray);
            this.I.setPositiveButton(c.a.t0.s2.l.dialog_ok, this.a);
            this.I.setNegativeButton(c.a.t0.s2.l.dialog_cancel, new d(this));
            this.I.setCancelable(true);
            this.I.create(this.a.getPageContext());
            if (z2) {
                b0(sparseArray);
            } else if (z) {
                b0(sparseArray);
            } else if (Z()) {
                c.a.t0.k.i iVar = new c.a.t0.k.i(this.f23187b.R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f23187b.R0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f23187b.R0().o().has_forum_rule.intValue());
                iVar.i(this.f23187b.R0().l().getId(), this.f23187b.R0().l().getName());
                iVar.h(this.f23187b.R0().l().getImage_url());
                iVar.j(this.f23187b.R0().l().getUser_level());
                e0(sparseArray, i2, iVar, this.f23187b.R0().U(), false);
            } else {
                h0(this.I, i2);
            }
        }
    }

    public void O(SparseArray<Object> sparseArray, boolean z) {
        c.a.s0.s.s.g gVar;
        c.a.s0.s.s.g gVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, sparseArray, z) == null) {
            c.a.s0.s.s.j jVar = new c.a.s0.s.s.j(this.a);
            jVar.p(this.a.getString(c.a.t0.s2.l.bar_manager));
            jVar.m(new C1377c(this, z));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(c.a.t0.s2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(c.a.t0.s2.i.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(c.a.t0.s2.i.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(c.a.t0.s2.i.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(c.a.t0.s2.i.tag_del_post_type)).intValue() : -1) == 0) {
                    gVar2 = new c.a.s0.s.s.g(10, this.a.getString(c.a.t0.s2.l.delete_post), jVar);
                } else {
                    gVar2 = new c.a.s0.s.s.g(10, this.a.getString(c.a.t0.s2.l.delete), jVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = c.a.t0.s2.i.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = c.a.t0.s2.i.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = c.a.t0.s2.i.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = c.a.t0.s2.i.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                gVar2.f13917d.setTag(sparseArray2);
                arrayList.add(gVar2);
            }
            if (!"".equals(sparseArray.get(c.a.t0.s2.i.tag_forbid_user_name)) || !"".equals(sparseArray.get(c.a.t0.s2.i.tag_forbid_user_name_show))) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = c.a.t0.s2.i.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = c.a.t0.s2.i.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = c.a.t0.s2.i.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = c.a.t0.s2.i.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = c.a.t0.s2.i.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                c.a.s0.s.s.g gVar3 = new c.a.s0.s.s.g(11, this.a.getString(c.a.t0.s2.l.forbidden_person), jVar);
                gVar3.f13917d.setTag(sparseArray3);
                arrayList.add(gVar3);
            }
            if ((sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = c.a.t0.s2.i.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = c.a.t0.s2.i.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = c.a.t0.s2.i.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = c.a.t0.s2.i.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = c.a.t0.s2.i.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z) {
                    gVar = new c.a.s0.s.s.g(12, this.a.getString(c.a.t0.s2.l.un_mute), jVar);
                } else {
                    gVar = new c.a.s0.s.s.g(12, this.a.getString(c.a.t0.s2.l.mute), jVar);
                }
                gVar.f13917d.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            c.a.t0.s2.u.f.g1.a.e(arrayList);
            if (c.a.s0.b.d.N()) {
                jVar.k(arrayList, false);
            } else {
                jVar.k(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.a.getPageContext(), jVar);
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (foldCommentActivity = this.a) == null || foldCommentActivity.getPbEditor() == null || this.T == null) {
            return;
        }
        c.a.s0.x.y.a.a().c(0);
        c.a.s0.x.y.e pbEditor = this.a.getPbEditor();
        pbEditor.T();
        pbEditor.R();
        if (pbEditor.y() != null) {
            pbEditor.y().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.l0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        c.a.s0.x.h findLauncherById = this.T.findLauncherById(23);
        c.a.s0.x.h findLauncherById2 = this.T.findLauncherById(2);
        c.a.s0.x.h findLauncherById3 = this.T.findLauncherById(5);
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

    public void S(c.a.t0.s2.r.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048594, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.s = fVar;
        this.t = z;
        if (fVar.a0()) {
            this.p.R();
        } else {
            this.p.f();
        }
        this.r.d(this.t);
        this.r.h(fVar);
        this.f23190e.setEnableDragExit(true);
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
            this.T.setId(c.a.t0.s2.i.pb_editor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.T.getParent() == null) {
                this.n.addView(this.T, layoutParams);
            }
            this.T.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.T.setActionListener(24, new j(this));
            D();
            this.a.getPbEditor().i(new l(this));
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

    public void V(PbFragment.c3 c3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, c3Var) == null) {
            this.K = c3Var;
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
            this.p.S();
        }
    }

    public void Y(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, pbModel) == null) {
            this.f23187b = pbModel;
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.a == null || this.f23187b.R0().l().getDeletedReasonInfo() == null || 1 != this.f23187b.R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true : invokeV.booleanValue;
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || this.y == null) {
            return;
        }
        W(this.a.getPbEditor().C());
        if (this.Q) {
            c0(z);
        } else {
            C(z);
        }
    }

    public final void b0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, sparseArray) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(c.a.t0.s2.l.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(c.a.t0.s2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.s0.s.s.m mVar = new c.a.s0.s.s.m(this.a);
        mVar.r(c.a.t0.s2.l.del_my_thread_confirm);
        mVar.j(c.a.t0.s2.l.del_my_thread_confirm_subtitle);
        mVar.l(true);
        mVar.p(aVar2, aVar);
        mVar.g(false);
        AlertDialog u = mVar.u();
        aVar.a(new e(this, u, sparseArray));
        aVar2.a(new f(this, u));
    }

    public void c0(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || this.y == null || (textView = this.R) == null) {
            return;
        }
        textView.setText(c.a.t0.s2.l.draft_to_send);
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
                this.L = new c.a.s0.s.i0.a(this.a.getPageContext());
            }
            this.L.h(true);
        }
    }

    public final void e0(SparseArray<Object> sparseArray, int i2, c.a.t0.k.i iVar, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z)}) == null) || (foldCommentActivity = this.a) == null) {
            return;
        }
        if (this.N == null) {
            this.N = new c.a.t0.k.j(foldCommentActivity.getPageContext(), null, iVar, userData);
        }
        this.N.C(z);
        AntiData antiData = this.a.getAntiData();
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
        this.N.E(new String[]{this.a.getString(c.a.t0.s2.l.delete_thread_reason_1), this.a.getString(c.a.t0.s2.l.delete_thread_reason_2), this.a.getString(c.a.t0.s2.l.delete_thread_reason_3), this.a.getString(c.a.t0.s2.l.delete_thread_reason_4), this.a.getString(c.a.t0.s2.l.delete_thread_reason_5)});
        this.N.D(x0Var);
        this.N.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.N.F(new g(this, sparseArray));
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            H(NoDataViewFactory.e.d(null, this.a.getResources().getString(c.a.t0.s2.l.refresh_view_title_text)));
            this.y.setVisibility(8);
        }
    }

    public void g0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, str, z) == null) {
            if (z) {
                H(NoDataViewFactory.e.d("", str));
            } else {
                H(NoDataViewFactory.e.d(str, this.a.getPageContext().getString(c.a.t0.s2.l.refresh_view_title_text)));
            }
            this.y.setVisibility(8);
        }
    }

    public final void h0(c.a.s0.s.s.a aVar, int i2) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048609, this, aVar, i2) == null) || (foldCommentActivity = this.a) == null || aVar == null) {
            return;
        }
        if (this.M == null) {
            this.M = new c.a.t0.k.g(foldCommentActivity.getPageContext(), null);
        }
        AntiData antiData = this.a.getAntiData();
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
        this.M.y(new String[]{this.a.getString(c.a.t0.s2.l.delete_thread_reason_1), this.a.getString(c.a.t0.s2.l.delete_thread_reason_2), this.a.getString(c.a.t0.s2.l.delete_thread_reason_3), this.a.getString(c.a.t0.s2.l.delete_thread_reason_4), this.a.getString(c.a.t0.s2.l.delete_thread_reason_5)});
        this.M.x(x0Var);
        this.M.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.M.z(new h(this, aVar));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.m = new BlankView(this.a.getPageContext().getPageActivity());
            PbModel pbModel = this.f23187b;
            if (pbModel != null && (pbModel.v1() || this.f23187b.u1())) {
                this.J = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds562) + UtilHelper.getStatusBarHeight();
            } else {
                this.J = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.ds160);
            }
            this.f23191f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.J));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.f23190e.setBlankView(this.m);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.a.checkUpIsLogin() && this.a.checkPrivacyBeforeInput()) {
            c.a.s0.x.y.e pbEditor = this.a.getPbEditor();
            if (pbEditor != null && (pbEditor.B() || pbEditor.D())) {
                this.a.getPbEditor().z(false, null);
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
            this.a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(c.a.t0.s2.l.success));
            } else if (z2) {
                if (c.a.d.f.p.m.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(c.a.t0.s2.l.neterror);
                }
                this.a.showToast(str);
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

    public c.a.t0.s2.u.f.t y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.U : (c.a.t0.s2.u.f.t) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!c.a.d.f.p.m.isEmpty(this.O)) {
                return this.O;
            }
            if (this.a != null) {
                this.O = TbadkCoreApplication.getInst().getResources().getString(r0.b());
            }
            return this.O;
        }
        return (String) invokeV.objValue;
    }
}
