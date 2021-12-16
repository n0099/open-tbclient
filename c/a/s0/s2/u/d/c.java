package c.a.s0.s2.u.d;

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
import c.a.r0.s.r.t0;
import c.a.r0.s.r.x0;
import c.a.r0.s.t.a;
import c.a.r0.s.t.i;
import c.a.r0.t.c.w;
import c.a.s0.k.g;
import c.a.s0.k.j;
import c.a.s0.s2.r.u;
import c.a.s0.s2.u.f.r0;
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
    public c.a.s0.s2.s.c F;
    public View.OnLongClickListener G;
    public PopupDialog H;
    public c.a.r0.s.t.a I;
    public int J;
    public PbFragment.b3 K;
    public c.a.r0.s.i0.a L;
    public c.a.s0.k.g M;
    public c.a.s0.k.j N;
    public String O;
    public PermissionJudgePolicy P;
    public boolean Q;
    public TextView R;
    public PbEmotionBar S;
    public EditorTools T;
    public c.a.s0.s2.u.f.t U;
    public List<String> V;
    public c.a.s0.s2.u.f.c1.c W;
    public PbFakeFloorModel X;
    public BdListView.p Y;
    public CustomMessageListener Z;
    public FoldCommentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public PbModel f22675b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f22676c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f22677d;

    /* renamed from: e  reason: collision with root package name */
    public SubPbView f22678e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f22679f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f22680g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f22681h;

    /* renamed from: i  reason: collision with root package name */
    public View f22682i;

    /* renamed from: j  reason: collision with root package name */
    public View f22683j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f22684k;
    public AlertDialog l;
    public BlankView m;
    public RelativeLayout n;
    public BdTypeListView o;
    public c.a.s0.s2.u.h.d p;
    public ProgressBar q;
    public c.a.s0.s2.u.d.a r;
    public c.a.s0.s2.r.f s;
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
        public final /* synthetic */ c f22685e;

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
            this.f22685e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(c.a.s0.s2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(c.a.s0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(c.a.s0.s2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_should_delete_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(c.a.s0.s2.i.tag_from, 1);
                    this.f22685e.a.checkMuteState(sparseArray);
                    return;
                }
                this.f22685e.P(view);
            } else if (booleanValue2) {
                sparseArray.put(c.a.s0.s2.i.tag_from, 0);
                sparseArray.put(c.a.s0.s2.i.tag_check_mute_from, 1);
                this.f22685e.a.checkMuteState(sparseArray);
            } else if (booleanValue3) {
                this.f22685e.L(((Integer) sparseArray.get(c.a.s0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(c.a.s0.s2.i.tag_del_post_id), ((Integer) sparseArray.get(c.a.s0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22686e;

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
            this.f22686e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22686e.f22675b == null) {
                return;
            }
            this.f22686e.f22675b.L1();
        }
    }

    /* renamed from: c.a.s0.s2.u.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1349c implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f22687e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f22688f;

        public C1349c(c cVar, boolean z) {
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
            this.f22688f = cVar;
            this.f22687e = z;
        }

        @Override // c.a.r0.s.t.i.e
        public void onItemClick(c.a.r0.s.t.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f22688f.H.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f22688f.L(((Integer) sparseArray.get(c.a.s0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(c.a.s0.s2.i.tag_del_post_id), ((Integer) sparseArray.get(c.a.s0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f22688f.K != null) {
                            this.f22688f.K.a(new Object[]{sparseArray.get(c.a.s0.s2.i.tag_manage_user_identity), sparseArray.get(c.a.s0.s2.i.tag_forbid_user_name), sparseArray.get(c.a.s0.s2.i.tag_forbid_user_post_id), sparseArray.get(c.a.s0.s2.i.tag_forbid_user_name_show), sparseArray.get(c.a.s0.s2.i.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f22688f.a.handleMuteClick(this.f22687e, (String) sparseArray.get(c.a.s0.s2.i.tag_user_mute_mute_userid), sparseArray);
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

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
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
        public final /* synthetic */ AlertDialog f22689e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f22690f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f22691g;

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
            this.f22691g = cVar;
            this.f22689e = alertDialog;
            this.f22690f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlertDialog alertDialog = this.f22689e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.k.A()) {
                    c.a.d.f.p.m.L(this.f22691g.a, c.a.s0.s2.l.neterror);
                } else {
                    this.f22691g.a.deleteThread(this.f22690f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f22692e;

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
            this.f22692e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f22692e) == null) {
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
        public final /* synthetic */ c f22693b;

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
            this.f22693b = cVar;
            this.a = sparseArray;
        }

        @Override // c.a.s0.k.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f22693b.a.deleteThread(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements g.InterfaceC1133g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.s.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22694b;

        public h(c cVar, c.a.r0.s.t.a aVar) {
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
            this.f22694b = cVar;
            this.a = aVar;
        }

        @Override // c.a.s0.k.g.InterfaceC1133g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f22694b.a.deleteThread(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22695e;

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
            this.f22695e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22695e.R();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements c.a.r0.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22696e;

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
            this.f22696e = cVar;
        }

        @Override // c.a.r0.x.b
        public void onAction(c.a.r0.x.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                Object obj = aVar.f14019c;
                if (obj instanceof w) {
                    if (((w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((w) aVar.f14019c).getType() == EmotionGroupType.USER_COLLECT) {
                        if (this.f22696e.P == null) {
                            this.f22696e.P = new PermissionJudgePolicy();
                        }
                        this.f22696e.P.clearRequestPermissionList();
                        this.f22696e.P.appendRequestPermission(this.f22696e.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f22696e.P.startRequestPermission(this.f22696e.a)) {
                            return;
                        }
                        this.f22696e.a.getPbEditor().h((w) aVar.f14019c);
                        this.f22696e.a.getPbEditor().z(false, null);
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
        public final /* synthetic */ c f22697e;

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
            this.f22697e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22697e.J();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22698e;

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
            this.f22698e = cVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f22698e.a.mContentProcessController == null || this.f22698e.a.mContentProcessController.e() == null) {
                return;
            }
            if (!this.f22698e.a.mContentProcessController.e().e()) {
                this.f22698e.a.mContentProcessController.a(false);
            }
            this.f22698e.a.mContentProcessController.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f22698e.T == null || this.f22698e.T.getVisibility() != 0 || charSequence == null || charSequence.length() < (i5 = i4 + i2)) {
                return;
            }
            String substring = charSequence.toString().substring(i2, i5);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.f22698e.W == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.f22698e.T.getId());
                c cVar = this.f22698e;
                cVar.W = new c.a.s0.s2.u.f.c1.c(cVar.a.getPageContext(), this.f22698e.f22678e, layoutParams);
                if (!ListUtils.isEmpty(this.f22698e.V)) {
                    this.f22698e.W.m(this.f22698e.V);
                }
                this.f22698e.W.n(this.f22698e.T);
            }
            this.f22698e.W.l(substring);
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
                if (this.a.f22678e != null) {
                    this.a.f22678e.setSubPbViewData(uVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22699e;

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
            this.f22699e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22699e.J();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22700e;

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
            this.f22700e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && DialogLoginHelper.checkUpIsLogin(new t0(this.f22700e.a.getActivity(), "pb_huitie"))) {
                this.f22700e.a.processProfessionPermission();
                if (this.f22700e.a == null || this.f22700e.a.getModel() == null || this.f22700e.a.getModel().R0() == null || this.f22700e.a.getModel().R0().O() == null || this.f22700e.a.getModel().R0().O().J() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f22700e.a.getModel().i1()).param("fid", this.f22700e.a.getModel().R0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f22700e.a.getModel().h1()).param("fid", this.f22700e.a.getModel().R0().m()).param("obj_locate", 1).param("uid", this.f22700e.a.getModel().R0().O().J().getUserId()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22701e;

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
            this.f22701e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22701e.R();
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
        public final /* synthetic */ c f22702e;

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
            this.f22702e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22702e.f22678e == null) {
                return;
            }
            this.f22702e.f22678e.onFinish();
        }
    }

    /* loaded from: classes8.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22703e;

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
            this.f22703e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22703e.a.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22704e;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f22705e;

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
                this.f22705e = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22705e.f22704e.l == null) {
                    return;
                }
                this.f22705e.f22704e.l.dismiss();
            }
        }

        /* loaded from: classes8.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t f22706e;

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
                this.f22706e = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    UrlManager.getInstance().dealOneLink(this.f22706e.f22704e.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                    if (this.f22706e.f22704e.s != null) {
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.f22706e.f22704e.s.Q()).param("fname", this.f22706e.f22704e.s.n()).param("fid", this.f22706e.f22704e.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
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
            this.f22704e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(c.a.s0.s2.l.comment_folded_explain));
                if (this.f22704e.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.f22704e.s.Q()).param("fname", this.f22704e.s.n()).param("fid", this.f22704e.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a(c.a.s0.s2.l.know, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.a(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.f22704e.a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(c.a.s0.s2.g.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.f22704e.a);
                textView.setText(c.a.s0.s2.l.view_tieba_policy);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(c.a.s0.s2.g.T_X07));
                textView.setTextColor(SkinManager.getColor(c.a.s0.s2.f.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.f22704e.a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(c.a.s0.s2.h.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(c.a.d.f.p.m.f(this.f22704e.a, c.a.s0.s2.g.tbds36), c.a.d.f.p.m.f(this.f22704e.a, c.a.s0.s2.g.tbds36)));
                c cVar = this.f22704e;
                c.a.r0.s.t.l lVar = new c.a.r0.s.t.l(cVar.a);
                lVar.q(c.a.s0.s2.l.comment_folded);
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

    public c(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.y yVar, c.a.s0.s2.s.c cVar, View.OnLongClickListener onLongClickListener) {
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
        this.f22680g = null;
        this.q = null;
        this.H = null;
        this.I = null;
        this.J = 0;
        this.L = null;
        this.Q = false;
        this.Y = new k(this);
        this.Z = new m(this, 2921597);
        this.a = foldCommentActivity;
        this.f22675b = foldCommentActivity.getModel();
        this.C = onClickListener;
        this.E = yVar;
        this.F = cVar;
        this.G = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(c.a.s0.s2.j.layout_fold_comment_activity, (ViewGroup) null);
        this.f22678e = subPbView;
        this.f22679f = (LinearLayout) subPbView.findViewById(c.a.s0.s2.i.navigation_bar_group);
        RelativeLayout relativeLayout = (RelativeLayout) this.f22678e.findViewById(c.a.s0.s2.i.fold_comment_editor_tool_comment);
        this.y = relativeLayout;
        relativeLayout.setVisibility(8);
        this.v = (TextView) this.f22678e.findViewById(c.a.s0.s2.i.fold_comment_editor_tool_comment_reply_text);
        this.w = (ImageView) this.f22678e.findViewById(c.a.s0.s2.i.fold_comment_editor_tool_more_img);
        this.x = (ImageView) this.f22678e.findViewById(c.a.s0.s2.i.fold_comment_editor_tool_emotion_img);
        this.f22676c = (NoNetworkView) this.f22678e.findViewById(c.a.s0.s2.i.view_no_network);
        G();
        this.n = (RelativeLayout) this.f22678e.findViewById(c.a.s0.s2.i.fold_comment_body_layout);
        this.o = (BdTypeListView) this.f22678e.findViewById(c.a.s0.s2.i.fold_comment_list);
        View view = new View(foldCommentActivity.getActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.addHeaderView(view, 0);
        this.o.setOnSrollToBottomListener(this.Y);
        this.f22678e.setTopView(view);
        this.f22678e.setNavigationView(this.f22679f);
        this.f22678e.setListView(this.o);
        this.f22678e.setContentView(this.n);
        c.a.s0.s2.u.h.d dVar = new c.a.s0.s2.u.h.d(foldCommentActivity.getPageContext());
        this.p = dVar;
        dVar.y();
        this.p.C(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.f22678e.findViewById(c.a.s0.s2.i.progress);
        this.u = (MaskView) this.f22678e.findViewById(c.a.s0.s2.i.mask_view);
        this.B = this.f22678e.findViewById(c.a.s0.s2.i.view_comment_top_line);
        LinearLayout linearLayout = (LinearLayout) this.f22678e.findViewById(c.a.s0.s2.i.fold_comment_editer_tool_comment_layout);
        this.z = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.f22678e.findViewById(c.a.s0.s2.i.fold_comment_editor_tool_comment_user_image);
        this.A = headImageView;
        headImageView.setVisibility(0);
        this.A.setIsRound(true);
        this.A.setBorderWidth(c.a.d.f.p.m.f(this.a, c.a.s0.s2.g.L_X01));
        this.A.setBorderColor(SkinManager.getColor(c.a.s0.s2.f.CAM_X0401));
        this.A.setDefaultBgResource(0);
        this.A.setDefaultResource(c.a.s0.s2.f.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.A.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        K(TbadkCoreApplication.getInst().getSkinType());
        F();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.a.getPageContext());
        this.X = pbFakeFloorModel;
        pbFakeFloorModel.P(this.f22675b.F(), this.f22675b.B(), this.f22675b.C(), this.f22675b.A(), this.f22675b.G());
        c.a.s0.s2.u.f.t tVar = new c.a.s0.s2.u.f.t(this.a.getPageContext(), this.X, this.n);
        this.U = tVar;
        tVar.k(new p(this));
        this.U.n(this.a.mOnFloorPostWriteNewCallback);
        this.X.R(new q(this));
        this.a.registerListener(this.Z);
    }

    public SubPbView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22678e : (SubPbView) invokeV.objValue;
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
        PbModel pbModel = this.f22675b;
        boolean z2 = true;
        this.R.setText(tbSingleton.getAdVertiComment((pbModel == null || pbModel.R0() == null || !this.f22675b.R0().k0()) ? false : true, (this.f22675b.R0() == null || !this.f22675b.R0().l0()) ? false : false, z()));
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
        c.a.s0.s2.u.f.c1.c cVar = this.W;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void E() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (noDataView = this.f22677d) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.o.setVisibility(0);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.s0.s2.u.d.a aVar = new c.a.s0.s2.u.d.a(this.a, this.o);
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
            int f2 = c.a.d.f.p.m.f(this.a.getPageContext().getPageActivity(), c.a.s0.s2.g.ds88);
            int f3 = c.a.d.f.p.m.f(this.a.getPageContext().getPageActivity(), c.a.s0.s2.g.ds2);
            NavigationBar navigationBar = (NavigationBar) this.f22678e.findViewById(c.a.s0.s2.i.view_navigation_bar);
            this.f22680g = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(c.a.s0.s2.l.folded_comment));
            this.f22682i = this.f22680g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(c.a.s0.s2.j.layout_fold_explain_icon, (ViewGroup) null);
            this.f22683j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(c.a.s0.s2.i.navigation_fold_explain_icon);
            this.f22684k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(c.a.s0.s2.h.icon_pure_explain44, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f22680g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f22683j, new t(this));
            ImageView backImageView = this.f22680g.getBackImageView();
            this.f22681h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22682i.getLayoutParams();
                layoutParams.height = f2;
                layoutParams.width = f2;
                layoutParams.leftMargin = f3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.f22682i;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f22682i.getLayoutParams();
                layoutParams2.width = f2;
                layoutParams2.height = f2;
                this.f22682i.setLayoutParams(layoutParams2);
            }
            this.f22680g.setIsClose(true);
            this.f22680g.setIsCorner(true);
            this.f22680g.isShowBottomLine(true);
            this.f22680g.setBottomLineHeight(3);
            this.f22680g.setStatusBarVisibility(8);
        }
    }

    public final void H(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getPageContext().getString(c.a.s0.s2.l.refresh_view_button_text), new b(this)));
            if (this.f22677d == null) {
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                this.f22677d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, c.a.d.f.p.m.f(pageActivity, c.a.s0.s2.g.ds250)), eVar, a2);
            }
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            SkinManager.setBackgroundColor(this.f22677d, c.a.s0.s2.f.CAM_X0201);
            this.f22677d.setClickable(true);
            this.f22677d.setTextOption(eVar);
            this.f22677d.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f22677d.setVisibility(0);
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (pbModel = this.f22675b) == null || pbModel.R0() == null || this.f22675b.R0().y() == null || !c.a.d.f.p.m.C()) {
            return;
        }
        if (this.f22675b.R0().y().b() == 0) {
            U();
            return;
        }
        c.a.s0.s2.u.h.d dVar = this.p;
        if (dVar != null) {
            dVar.R();
        }
        if (this.f22675b.F1(false)) {
            X();
        } else {
            U();
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f22678e);
            SkinManager.setBackgroundColor(this.f22678e, c.a.s0.s2.f.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, c.a.s0.s2.f.CAM_X0201);
            this.f22680g.onChangeSkinType(this.a.getPageContext(), i2);
            PbModel pbModel = this.f22675b;
            if (pbModel != null && (pbModel.v1() || this.f22675b.u1())) {
                WebPManager.setPureDrawable(this.f22681h, c.a.s0.s2.h.icon_topbar_return, c.a.s0.s2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.f22681h, c.a.s0.s2.h.icon_pure_topbar_close44, c.a.s0.s2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.f22676c.onChangeSkinType(this.a.getPageContext(), i2);
            this.a.getLayoutMode().j(this.p.b());
            this.p.d(i2);
            SkinManager.setViewTextColor(this.v, c.a.s0.s2.f.CAM_X0110);
            this.v.setAlpha(0.95f);
            c.a.s0.s2.u.d.a aVar = this.r;
            if (aVar != null) {
                aVar.b();
            }
            SkinManager.setBackgroundColor(this.B, c.a.s0.s2.f.CAM_X0203);
            this.A.setBorderColor(SkinManager.getColor(c.a.s0.s2.f.CAM_X0401));
            this.z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.m.f(this.a, c.a.s0.s2.g.tbds47), SkinManager.getColor(c.a.s0.s2.f.CAM_X0209)));
            c.a.r0.s.v.c.d(this.y).f(c.a.s0.s2.f.CAM_X0208);
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
            sparseArray.put(c.a.s0.s2.i.tag_del_post_id, str);
            sparseArray.put(c.a.s0.s2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(c.a.s0.s2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(c.a.s0.s2.i.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(0, 3);
            int i4 = c.a.s0.s2.l.del_all_post_confirm;
            if (i3 == 1002 && !z) {
                i4 = c.a.s0.s2.l.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = c.a.s0.s2.l.report_thread_confirm;
                } else {
                    i4 = c.a.s0.s2.l.del_thread_confirm;
                }
            }
            this.I = new c.a.r0.s.t.a(this.a);
            if (StringUtils.isNull(str2)) {
                this.I.setMessageId(i4);
            } else {
                this.I.setOnlyMessageShowCenter(false);
                this.I.setMessage(str2);
            }
            this.I.setYesButtonTag(sparseArray);
            this.I.setPositiveButton(c.a.s0.s2.l.dialog_ok, this.a);
            this.I.setNegativeButton(c.a.s0.s2.l.dialog_cancel, new d(this));
            this.I.setCancelable(true);
            this.I.create(this.a.getPageContext());
            if (z2) {
                b0(sparseArray);
            } else if (z) {
                b0(sparseArray);
            } else if (Z()) {
                c.a.s0.k.i iVar = new c.a.s0.k.i(this.f22675b.R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f22675b.R0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f22675b.R0().o().has_forum_rule.intValue());
                iVar.i(this.f22675b.R0().l().getId(), this.f22675b.R0().l().getName());
                iVar.h(this.f22675b.R0().l().getImage_url());
                iVar.j(this.f22675b.R0().l().getUser_level());
                e0(sparseArray, i2, iVar, this.f22675b.R0().U(), false);
            } else {
                h0(this.I, i2);
            }
        }
    }

    public void O(SparseArray<Object> sparseArray, boolean z) {
        c.a.r0.s.t.f fVar;
        c.a.r0.s.t.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, sparseArray, z) == null) {
            c.a.r0.s.t.i iVar = new c.a.r0.s.t.i(this.a);
            iVar.p(this.a.getString(c.a.s0.s2.l.bar_manager));
            iVar.m(new C1349c(this, z));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(c.a.s0.s2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(c.a.s0.s2.i.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(c.a.s0.s2.i.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(c.a.s0.s2.i.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(c.a.s0.s2.i.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new c.a.r0.s.t.f(10, this.a.getString(c.a.s0.s2.l.delete_post), iVar);
                } else {
                    fVar2 = new c.a.r0.s.t.f(10, this.a.getString(c.a.s0.s2.l.delete), iVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = c.a.s0.s2.i.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = c.a.s0.s2.i.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = c.a.s0.s2.i.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = c.a.s0.s2.i.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                fVar2.f13539d.setTag(sparseArray2);
                arrayList.add(fVar2);
            }
            if (!"".equals(sparseArray.get(c.a.s0.s2.i.tag_forbid_user_name)) || !"".equals(sparseArray.get(c.a.s0.s2.i.tag_forbid_user_name_show))) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = c.a.s0.s2.i.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = c.a.s0.s2.i.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = c.a.s0.s2.i.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = c.a.s0.s2.i.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = c.a.s0.s2.i.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                c.a.r0.s.t.f fVar3 = new c.a.r0.s.t.f(11, this.a.getString(c.a.s0.s2.l.forbidden_person), iVar);
                fVar3.f13539d.setTag(sparseArray3);
                arrayList.add(fVar3);
            }
            if ((sparseArray.get(c.a.s0.s2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(c.a.s0.s2.i.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = c.a.s0.s2.i.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = c.a.s0.s2.i.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = c.a.s0.s2.i.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = c.a.s0.s2.i.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = c.a.s0.s2.i.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = c.a.s0.s2.i.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = c.a.s0.s2.i.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z) {
                    fVar = new c.a.r0.s.t.f(12, this.a.getString(c.a.s0.s2.l.un_mute), iVar);
                } else {
                    fVar = new c.a.r0.s.t.f(12, this.a.getString(c.a.s0.s2.l.mute), iVar);
                }
                fVar.f13539d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            c.a.s0.s2.u.f.g1.a.e(arrayList);
            if (c.a.r0.b.d.L()) {
                iVar.k(arrayList, false);
            } else {
                iVar.k(arrayList, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.a.getPageContext(), iVar);
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
        c.a.r0.x.x.a.a().c(0);
        c.a.r0.x.x.e pbEditor = this.a.getPbEditor();
        pbEditor.T();
        pbEditor.R();
        if (pbEditor.y() != null) {
            pbEditor.y().setMaxImagesAllowed(pbEditor.z ? 1 : 9);
        }
        pbEditor.l0(SendView.ALL);
        pbEditor.j(SendView.ALL);
        c.a.r0.x.h findLauncherById = this.T.findLauncherById(23);
        c.a.r0.x.h findLauncherById2 = this.T.findLauncherById(2);
        c.a.r0.x.h findLauncherById3 = this.T.findLauncherById(5);
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

    public void S(c.a.s0.s2.r.f fVar, boolean z) {
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
        this.f22678e.setEnableDragExit(true);
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
            this.T.setId(c.a.s0.s2.i.pb_editor);
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
            this.p.S();
        }
    }

    public void Y(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, pbModel) == null) {
            this.f22675b = pbModel;
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.a == null || this.f22675b.R0().l().getDeletedReasonInfo() == null || 1 != this.f22675b.R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true : invokeV.booleanValue;
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
        TBAlertConfig.a aVar = new TBAlertConfig.a(c.a.s0.s2.l.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(c.a.s0.s2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.r0.s.t.l lVar = new c.a.r0.s.t.l(this.a);
        lVar.q(c.a.s0.s2.l.del_my_thread_confirm);
        lVar.j(c.a.s0.s2.l.del_my_thread_confirm_subtitle);
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
        textView.setText(c.a.s0.s2.l.draft_to_send);
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
                this.L = new c.a.r0.s.i0.a(this.a.getPageContext());
            }
            this.L.h(true);
        }
    }

    public final void e0(SparseArray<Object> sparseArray, int i2, c.a.s0.k.i iVar, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z)}) == null) || (foldCommentActivity = this.a) == null) {
            return;
        }
        if (this.N == null) {
            this.N = new c.a.s0.k.j(foldCommentActivity.getPageContext(), null, iVar, userData);
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
        this.N.E(new String[]{this.a.getString(c.a.s0.s2.l.delete_thread_reason_1), this.a.getString(c.a.s0.s2.l.delete_thread_reason_2), this.a.getString(c.a.s0.s2.l.delete_thread_reason_3), this.a.getString(c.a.s0.s2.l.delete_thread_reason_4), this.a.getString(c.a.s0.s2.l.delete_thread_reason_5)});
        this.N.D(x0Var);
        this.N.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.N.F(new g(this, sparseArray));
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            H(NoDataViewFactory.e.d(null, this.a.getResources().getString(c.a.s0.s2.l.refresh_view_title_text)));
            this.y.setVisibility(8);
        }
    }

    public void g0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, str, z) == null) {
            if (z) {
                H(NoDataViewFactory.e.d("", str));
            } else {
                H(NoDataViewFactory.e.d(str, this.a.getPageContext().getString(c.a.s0.s2.l.refresh_view_title_text)));
            }
            this.y.setVisibility(8);
        }
    }

    public final void h0(c.a.r0.s.t.a aVar, int i2) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048609, this, aVar, i2) == null) || (foldCommentActivity = this.a) == null || aVar == null) {
            return;
        }
        if (this.M == null) {
            this.M = new c.a.s0.k.g(foldCommentActivity.getPageContext(), null);
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
        this.M.y(new String[]{this.a.getString(c.a.s0.s2.l.delete_thread_reason_1), this.a.getString(c.a.s0.s2.l.delete_thread_reason_2), this.a.getString(c.a.s0.s2.l.delete_thread_reason_3), this.a.getString(c.a.s0.s2.l.delete_thread_reason_4), this.a.getString(c.a.s0.s2.l.delete_thread_reason_5)});
        this.M.x(x0Var);
        this.M.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.M.z(new h(this, aVar));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.m = new BlankView(this.a.getPageContext().getPageActivity());
            PbModel pbModel = this.f22675b;
            if (pbModel != null && (pbModel.v1() || this.f22675b.u1())) {
                this.J = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds562) + UtilHelper.getStatusBarHeight();
            } else {
                this.J = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.ds160);
            }
            this.f22679f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.J));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.f22678e.setBlankView(this.m);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.a.checkUpIsLogin() && this.a.checkPrivacyBeforeInput()) {
            c.a.r0.x.x.e pbEditor = this.a.getPbEditor();
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
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(c.a.s0.s2.l.success));
            } else if (z2) {
                if (c.a.d.f.p.l.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(c.a.s0.s2.l.neterror);
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

    public c.a.s0.s2.u.f.t y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.U : (c.a.s0.s2.u.f.t) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!c.a.d.f.p.l.isEmpty(this.O)) {
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
