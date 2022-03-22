package c.a.p0.w2.q.h;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.b0.d;
import c.a.o0.r.r.e0;
import c.a.o0.r.r.v0;
import c.a.o0.r.r.x1;
import c.a.o0.r.t.a;
import c.a.o0.r.t.c;
import c.a.o0.r.t.l;
import c.a.p0.f1.w0;
import c.a.p0.l.g;
import c.a.p0.l.j;
import c.a.p0.w2.m.f.e1;
import c.a.p0.w2.m.f.l0;
import c.a.p0.w2.m.f.m0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
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
import tbclient.ForumToolPerm;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.o.d.a A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public c.a.o0.r.g0.a J;
    public c.a.p0.a4.k0.e K;
    public boolean L;
    public final View.OnLongClickListener M;
    public l.e N;
    public boolean O;
    public final c.InterfaceC0843c P;
    public AbsVideoPbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.r.t.j f20485b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.r.t.l f20486c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.r.t.j f20487d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.r.t.a f20488e;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f20489f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f20490g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.r.t.e f20491h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public c.a.o0.r.t.j q;
    public c.a.o0.r.l0.a r;
    public c.a.o0.r.t.c s;
    public AlertDialog t;
    public l0 u;
    public c.a.p0.l.g v;
    public c.a.p0.l.j w;
    public c.a.p0.w2.m.g.a x;
    public PbFragment.c3 y;
    public e1 z;

    /* renamed from: c.a.p0.w2.q.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1529a implements c.InterfaceC0843c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1529a(a aVar) {
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

        @Override // c.a.o0.r.t.c.InterfaceC0843c
        public void a(c.a.o0.r.t.c cVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i, view) == null) {
                if (cVar != null) {
                    cVar.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        d.a aVar = new d.a();
                        aVar.a = this.a.B;
                        String str = "";
                        if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.C.memeInfo.pck_id;
                        }
                        aVar.f9865b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (this.a.F == null) {
                        this.a.F = new PermissionJudgePolicy();
                    }
                    this.a.F.clearRequestPermissionList();
                    this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.z == null) {
                        a aVar2 = this.a;
                        aVar2.z = new e1(aVar2.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f20492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f20493c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f20494d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20495e;

        public a0(a aVar, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20495e = aVar;
            this.a = sparseArray;
            this.f20492b = z;
            this.f20493c = str;
            this.f20494d = str2;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                if (this.f20495e.f20485b != null) {
                    this.f20495e.f20485b.dismiss();
                }
                if (i == 0) {
                    this.f20495e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091ebb);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091ebd);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091ebc);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f20492b, this.f20493c, str, str2, str3, 1, this.f20494d, this.f20495e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.f20495e.D);
                    this.f20495e.L0(this.f20492b, userMuteAddAndDelCustomMessage, this.f20494d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091eb9));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.a.I2(aVar, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b0(a aVar) {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(a aVar) {
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
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20496b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f20497c;

        public d(a aVar, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20497c = aVar;
            this.a = alertDialog;
            this.f20496b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.f20497c.a.x(), R.string.obfuscated_res_0x7f0f0c15);
                } else {
                    this.f20497c.a.H2(this.f20496b, null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(a aVar, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20498b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f20499c;

        public f(a aVar, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20499c = aVar;
            this.a = alertDialog;
            this.f20498b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.l.A()) {
                    c.a.d.f.p.n.M(this.f20499c.a.x(), R.string.obfuscated_res_0x7f0f0c15);
                } else {
                    this.f20499c.a.H2(this.f20498b, null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(a aVar, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements g.InterfaceC1200g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20500b;

        public h(a aVar, c.a.o0.r.t.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20500b = aVar;
            this.a = aVar2;
        }

        @Override // c.a.p0.l.g.InterfaceC1200g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20500b.a.I2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20501b;

        public i(a aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20501b = aVar;
            this.a = sparseArray;
        }

        @Override // c.a.p0.l.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20501b.a.H2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20502b;

        public j(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20502b = aVar;
            this.a = z;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                this.f20502b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.f20502b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                        return;
                    case 11:
                        if (this.f20502b.y != null) {
                            this.f20502b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e88), sparseArray.get(R.id.obfuscated_res_0x7f091e76), sparseArray.get(R.id.obfuscated_res_0x7f091e79), sparseArray.get(R.id.obfuscated_res_0x7f091e77), sparseArray.get(R.id.obfuscated_res_0x7f091e78)});
                            return;
                        }
                        return;
                    case 12:
                        this.f20502b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091eba), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            c.a.d.f.m.g.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class l implements c.InterfaceC0843c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public l(a aVar) {
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

        @Override // c.a.o0.r.t.c.InterfaceC0843c
        public void a(c.a.o0.r.t.c cVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i, view) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    a aVar = this.a;
                    aVar.H = aVar.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new c.a.p0.w2.m.f.g(this.a.a.w().k1(), this.a.H, "1").start();
                    cVar.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    a aVar2 = this.a;
                    aVar2.H = aVar2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new c.a.p0.w2.m.f.g(this.a.a.w().k1(), this.a.H, "2").start();
                    cVar.e();
                } else if (i == 2) {
                    a aVar3 = this.a;
                    aVar3.H = aVar3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    cVar.e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f20504c;

        public m(a aVar, c.a.o0.r.t.j jVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20504c = aVar;
            this.a = jVar;
            this.f20503b = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.f20504c.a.w().h1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // c.a.o0.r.t.l.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            boolean H2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, lVar, i, view) != null) {
                return;
            }
            this.a.dismiss();
            int i2 = 3;
            if (this.f20504c.a.w().h1() != 1 || i != 1) {
                if (this.f20504c.a.w().h1() == 2 && i == 0) {
                    i2 = 1;
                } else if (this.f20504c.a.w().h1() == 3 && i != 2) {
                    i2 = 2;
                } else if (i == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f20503b.getId() != R.id.obfuscated_res_0x7f091723 ? 1 : 0).param("obj_type", i2));
                if (this.f20504c.a.w().S0().f19819f != null && this.f20504c.a.w().S0().f19819f.size() > i) {
                    i = this.f20504c.a.w().S0().f19819f.get(i).sort_type.intValue();
                }
                H2 = this.f20504c.a.w().H2(i);
                this.f20503b.setTag(Integer.valueOf(this.f20504c.a.w().g1()));
                if (H2) {
                    return;
                }
                this.f20504c.a.t4(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f20503b.getId() != R.id.obfuscated_res_0x7f091723 ? 1 : 0).param("obj_type", i2));
            if (this.f20504c.a.w().S0().f19819f != null) {
                i = this.f20504c.a.w().S0().f19819f.get(i).sort_type.intValue();
            }
            H2 = this.f20504c.a.w().H2(i);
            this.f20503b.setTag(Integer.valueOf(this.f20504c.a.w().g1()));
            if (H2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(a aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = metaData;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20505b;

        public o(a aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20505b = aVar;
            this.a = metaData;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                if (this.f20505b.a.P2() != null) {
                    this.f20505b.a.P2().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.f20505b.a.getPageContext().getUniqueId(), this.f20505b.a.w().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(a aVar) {
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
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20506b;

        public q(a aVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20506b = aVar;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20506b.B0();
                MessageManager.getInstance().sendMessage(this.a);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(a aVar) {
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
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.InterfaceC0843c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20507b;

        public s(a aVar, c.InterfaceC0843c interfaceC0843c) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, interfaceC0843c};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20507b = aVar;
            this.a = interfaceC0843c;
        }

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                this.f20507b.f20487d.dismiss();
                this.a.a(null, i, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public t(a aVar) {
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

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.n = (String) compoundButton.getTag();
                if (this.a.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.n != null && !str.equals(this.a.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public u(a aVar) {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.a.E(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public v(a aVar) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.a.f20490g instanceof Dialog)) {
                c.a.d.f.m.g.b(this.a.f20490g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements PbFragment.c3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public w(a aVar) {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.c3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.d.f.p.l.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.w().S0().l().getId(), this.a.a.w().S0().l().getName(), this.a.a.w().S0().O().getId(), String.valueOf(this.a.a.w().S0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public x(a aVar) {
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

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(c.a.o0.r.t.l lVar, int i, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) {
                if (this.a.f20485b != null) {
                    this.a.f20485b.dismiss();
                }
                this.a.M0(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f09169e);
                        this.a.n0(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f09169d);
                        this.a.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f0916a0);
                        AgreeView agreeView = (AgreeView) view4;
                        this.a.n0(view4);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f0916a0);
                        this.a.n0(view5);
                        AgreeView agreeView2 = (AgreeView) view5;
                        if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                            return;
                        }
                        agreeView2.getImgAgree().performClick();
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                            return;
                        }
                        if (this.a.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                        } else {
                            d.a aVar = new d.a();
                            aVar.a = this.a.B;
                            String str = "";
                            if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.C.memeInfo.pck_id;
                            }
                            aVar.f9865b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.a.A = null;
                        this.a.B = null;
                        return;
                    case 2:
                        if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                            return;
                        }
                        if (this.a.F == null) {
                            this.a.F = new PermissionJudgePolicy();
                        }
                        this.a.F.clearRequestPermissionList();
                        this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.z == null) {
                            a aVar2 = this.a;
                            aVar2.z = new e1(aVar2.a.getPageContext());
                        }
                        this.a.z.b(this.a.B, this.a.A.n());
                        this.a.A = null;
                        this.a.B = null;
                        return;
                    case 3:
                        PostData postData = this.a.G;
                        if (postData != null) {
                            postData.m0();
                            this.a.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.a.checkUpIsLogin()) {
                            this.a.d0(view);
                            if (this.a.a.w().S0().O() == null || this.a.a.w().S0().O().getAuthor() == null || this.a.a.w().S0().O().getAuthor().getUserId() == null || this.a.a.c3() == null) {
                                return;
                            }
                            a aVar3 = this.a;
                            int S = aVar3.S(aVar3.a.w().S0());
                            ThreadData O = this.a.a.w().S0().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.w().k1()).param("obj_locate", 2).param("obj_id", this.a.a.w().S0().O().getAuthor().getUserId()).param("obj_type", !this.a.a.c3().e()).param("obj_source", S).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.d.f.p.l.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.U((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e7c, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e65, 2);
                                this.a.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091e6d) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e6b) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e88) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e88)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e7d)).booleanValue();
                            AbsVideoPbFragment absVideoPbFragment = this.a.a;
                            if (absVideoPbFragment == null || absVideoPbFragment.x() == null) {
                                return;
                            }
                            boolean isHost = this.a.a.x().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.a.t0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e6b), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e6b), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.d.f.p.l.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eab)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e7c, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e65, 2);
                            this.a.B(sparseArray4);
                            return;
                        } else {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091e65, 2);
                            }
                            this.a.l0(view);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69);
                            if (postData2.q() == null) {
                                return;
                            }
                            c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view);
                            if (findPageExtraByView != null) {
                                postData2.q().objSource = findPageExtraByView.a();
                            }
                            this.a.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.w() == null || this.a.a.w().S0() == null || !ViewHelper.checkUpIsLogin(this.a.a.getContext()) || this.a.a.x() == null) {
                            return;
                        }
                        this.a.a.x().showBlockDialog(c.a.p0.j4.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20508b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f20509c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f20510d;

        public y(a aVar, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20510d = aVar;
            this.a = sparseArray;
            this.f20508b = i;
            this.f20509c = z;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f20510d.a.J2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e6b), this.f20508b, this.f20509c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(a aVar) {
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
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-571105110, "Lc/a/p0/w2/q/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-571105110, "Lc/a/p0/w2/q/h/a;");
        }
    }

    public a(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoPbFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20487d = null;
        this.f20488e = null;
        this.f20489f = null;
        this.f20490g = null;
        this.f20491h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.G = null;
        this.L = UbsABTestHelper.showTrisectionAndFeedback();
        this.M = new u(this);
        this.N = new x(this);
        this.P = new C1529a(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        c.a.p0.w2.m.g.a aVar = new c.a.p0.w2.m.g.a(this.a.getContext());
        this.x = aVar;
        aVar.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a80));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a81));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a82), new n(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a83), new o(this, metaData));
        aVar.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.d.f.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.d.f.m.b.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091eba), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.r == null) {
                this.r = new c.a.o0.r.l0.a(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new c.a.o0.r.g0.a();
        }
        if (this.K == null) {
            c.a.p0.a4.k0.e eVar = new c.a.p0.a4.k0.e();
            this.K = eVar;
            eVar.a = this.a.getUniqueId();
        }
        c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
        fVar.f10852b = 5;
        fVar.f10858h = 8;
        fVar.f10857g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.w() != null) {
            fVar.f10856f = this.a.w().R0();
        }
        fVar.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.w() == null || this.a.w().S0() == null) {
                    return;
                }
                this.J.b(this.a.x(), fVar, agreeData, this.a.w().S0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, c.a.p0.l.i iVar, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new c.a.p0.l.j(this.a.getPageContext(), this.a.getView(), iVar, userData);
        }
        this.w.C(z2);
        AntiData L = L();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04a2), this.a.getString(R.string.obfuscated_res_0x7f0f04a3), this.a.getString(R.string.obfuscated_res_0x7f0f04a4), this.a.getString(R.string.obfuscated_res_0x7f0f04a5), this.a.getString(R.string.obfuscated_res_0x7f0f04a6)});
        this.w.D(v0Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.d.f.p.n.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageContext().getPageActivity());
            aVar.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b16));
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0cc9, new b0(this));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new c0(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public final boolean E(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<c.a.o0.r.t.h> b2;
        c.a.o0.r.t.h hVar;
        c.a.o0.r.t.h hVar2;
        c.a.o0.r.t.h hVar3;
        c.a.o0.r.t.h hVar4;
        c.a.o0.r.t.h hVar5;
        c.a.d.o.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || !absVideoPbFragment.isAdded()) {
                return true;
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (Y(view)) {
                    if (view instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view;
                        this.A = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.B = url;
                        if (this.A == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view.getTag(R.id.obfuscated_res_0x7f091e9f) != null && (view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                        } else {
                            this.C = null;
                        }
                    } else if (view instanceof GifView) {
                        GifView gifView = (GifView) view;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.A = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.B = gifView.getBdImage().q();
                        }
                        if (view.getTag(R.id.obfuscated_res_0x7f091e9f) != null && (view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                        } else {
                            this.C = null;
                        }
                    } else if (view instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.A = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.B = tbMemeImageView.getBdImage().q();
                            }
                            if (view.getTag(R.id.obfuscated_res_0x7f091e9f) != null && (view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                            } else {
                                this.C = null;
                            }
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                        }
                    } else if (view.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        F0(this.P, this.A.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69);
            this.G = postData;
            if (postData == null || this.a.c3() == null) {
                return true;
            }
            boolean z5 = this.a.c3().e() && this.G.G() != null && this.G.G().equals(this.a.w().N0());
            boolean z6 = this.a.w().S0() != null && this.a.w().S0().g0();
            if (this.f20486c == null) {
                c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(this.a.getContext());
                this.f20486c = lVar;
                lVar.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view) && !z6;
            boolean z8 = (!Y(view) || (aVar = this.A) == null || aVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e82) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e82)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e79) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new c.a.o0.r.t.h(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1067), this.f20486c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new c.a.o0.r.t.h(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1068), this.f20486c));
            }
            if (!z7 && !z8) {
                c.a.o0.r.t.h hVar6 = new c.a.o0.r.t.h(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0435), this.f20486c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e69, this.G);
                hVar6.f11053d.setTag(sparseArray3);
                arrayList.add(hVar6);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    hVar5 = new c.a.o0.r.t.h(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f80), this.f20486c);
                } else {
                    hVar5 = new c.a.o0.r.t.h(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a7f), this.f20486c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e69, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e82, Boolean.FALSE);
                hVar5.f11053d.setTag(sparseArray4);
                arrayList.add(hVar5);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    c.a.o0.r.t.h hVar7 = new c.a.o0.r.t.h(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b17), this.f20486c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                    hVar7.f11053d.setTag(sparseArray5);
                    arrayList.add(hVar7);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        c.a.o0.r.t.h hVar8 = new c.a.o0.r.t.h(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa2), this.f20486c);
                        hVar8.f11053d.setTag(str);
                        arrayList.add(hVar8);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e76, sparseArray.get(R.id.obfuscated_res_0x7f091e76));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e77, sparseArray.get(R.id.obfuscated_res_0x7f091e77));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e78, sparseArray.get(R.id.obfuscated_res_0x7f091e78));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e79, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                        if (z4) {
                            c.a.o0.r.t.h hVar9 = new c.a.o0.r.t.h(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f048e), this.f20486c);
                            hVar9.f11053d.setTag(sparseArray6);
                            hVar4 = hVar9;
                            hVar = new c.a.o0.r.t.h(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d3), this.f20486c);
                            hVar.f11053d.setTag(sparseArray6);
                            hVar2 = hVar4;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                    }
                    hVar4 = null;
                    hVar = new c.a.o0.r.t.h(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d3), this.f20486c);
                    hVar.f11053d.setTag(sparseArray6);
                    hVar2 = hVar4;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                    if (this.a.w().S0().V() == 1002 && !booleanValue2) {
                        hVar3 = new c.a.o0.r.t.h(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa2), this.f20486c);
                    } else {
                        hVar3 = new c.a.o0.r.t.h(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f048e), this.f20486c);
                    }
                    hVar3.f11053d.setTag(sparseArray7);
                    hVar2 = hVar3;
                    hVar = null;
                } else {
                    hVar = null;
                    hVar2 = null;
                }
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
                c.a.p0.w2.m.f.n1.a.a(arrayList, this.f20486c, this.G, this.a.w());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                b2 = c.a.p0.w2.m.f.n1.a.c(arrayList, this.G.q(), sparseArray, this.f20486c);
            } else {
                b2 = c.a.p0.w2.m.f.n1.a.b(arrayList, this.G.q(), sparseArray, this.f20486c);
            }
            c.a.p0.w2.m.f.n1.a.k(b2, this.O);
            c.a.p0.w2.m.f.n1.a.e(b2);
            this.f20486c.o(c.a.p0.w2.m.f.n1.a.f(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.f20486c.k(b2, false);
            } else {
                this.f20486c.k(b2, true);
            }
            c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.a.getPageContext(), this.f20486c);
            this.f20485b = jVar;
            jVar.m();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.w().k1()).param("fid", this.a.w().getForumId()).param("uid", this.a.w().S0().O().getAuthor().getUserId()).param("post_id", this.a.w().A()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091eba) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091e65) instanceof Integer)) {
            c.a.o0.r.t.j jVar = this.f20485b;
            if (jVar != null && jVar.isShowing()) {
                this.f20485b.dismiss();
                this.f20485b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb8);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eba);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(this.a.getBaseFragmentActivity());
                lVar.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e65) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e65)).intValue() : -1) == 1) {
                    arrayList.add(new c.a.o0.r.t.h(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f048e), lVar));
                }
                if (z2) {
                    arrayList.add(new c.a.o0.r.t.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1460), lVar));
                } else {
                    arrayList.add(new c.a.o0.r.t.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b13), lVar));
                }
                lVar.j(arrayList);
                c.a.o0.r.t.j jVar2 = new c.a.o0.r.t.j(this.a.getPageContext(), lVar);
                this.f20485b = jVar2;
                jVar2.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.p3();
            c.a.o0.r.t.j jVar = this.f20485b;
            if (jVar != null) {
                jVar.dismiss();
            }
            this.a.q3();
            K();
        }
    }

    public void F0(c.InterfaceC0843c interfaceC0843c, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, interfaceC0843c, z2) == null) {
            c.a.o0.r.t.j jVar = this.f20487d;
            if (jVar != null) {
                jVar.dismiss();
                this.f20487d = null;
            }
            c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.w().S0() != null && this.a.w().S0().O() != null && !this.a.w().S0().O().isBjh()) {
                arrayList.add(new c.a.o0.r.t.h(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1067), lVar));
            }
            if (!z2) {
                arrayList.add(new c.a.o0.r.t.h(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1068), lVar));
            }
            lVar.j(arrayList);
            lVar.n(new s(this, interfaceC0843c));
            c.a.o0.r.t.j jVar2 = new c.a.o0.r.t.j(this.a.getPageContext(), lVar);
            this.f20487d = jVar2;
            jVar2.m();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.p3();
            c.a.o0.r.t.j jVar = this.f20485b;
            if (jVar != null) {
                jVar.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            c.a.o0.r.t.e eVar = this.f20491h;
            if (eVar != null) {
                eVar.d();
                this.f20491h = null;
            }
            if (this.a.w() == null) {
                return;
            }
            ArrayList<c.a.o0.r.t.n> arrayList = new ArrayList<>();
            arrayList.add(new c.a.o0.r.t.n(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0266), "", this.a.w().b1() == 1, Integer.toString(1)));
            arrayList.add(new c.a.o0.r.t.n(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b24), "", this.a.w().b1() == 2, Integer.toString(5)));
            arrayList.add(new c.a.o0.r.t.n(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b20), "", this.a.w().b1() == 3, Integer.toString(6)));
            arrayList.add(new c.a.o0.r.t.n(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b3b), "", this.a.w().b1() == 4, Integer.toString(7)));
            c.a.o0.r.t.e eVar2 = new c.a.o0.r.t.e(this.a.getPageContext());
            eVar2.l(R.string.obfuscated_res_0x7f0f0db6);
            this.f20491h = eVar2;
            eVar2.k(arrayList, onItemClickListener);
            eVar2.c();
            this.f20491h.n();
        }
    }

    public void H() {
        c.a.o0.r.t.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (jVar = this.f20485b) == null) {
            return;
        }
        jVar.dismiss();
    }

    public void H0(m0 m0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, m0Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new l0(absVideoPbFragment, absVideoPbFragment.D1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100104).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        c.a.d.f.m.g.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ed);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.t());
        this.u.L(m0Var == null ? false : m0Var.a);
        this.u.y(m0Var == null ? false : m0Var.n);
        this.u.A(m0Var == null ? false : m0Var.f20237e);
        this.u.F(m0Var == null ? false : m0Var.i);
        this.u.B(m0Var == null ? false : m0Var.f20238f);
        this.u.N(m0Var != null ? m0Var.f20235c : true);
        this.u.K(m0Var == null ? false : m0Var.k);
        this.u.C(m0Var == null ? false : m0Var.l, m0Var.t);
        if (m0Var == null) {
            this.u.H(false, false);
            this.u.G(false, false);
        } else {
            this.u.H(m0Var.f20239g, m0Var.s);
            this.u.G(m0Var.f20240h, m0Var.r);
        }
        boolean z2 = m0Var == null ? false : m0Var.q;
        boolean z3 = m0Var == null ? false : m0Var.o;
        boolean z4 = m0Var == null ? false : m0Var.f20236d;
        boolean z5 = m0Var == null ? false : m0Var.f20234b;
        boolean z6 = m0Var == null ? false : m0Var.p;
        boolean z7 = m0Var == null ? false : m0Var.j;
        boolean z8 = m0Var == null ? false : m0Var.m;
        this.u.D(z4, z3);
        this.u.M(z5, z2);
        this.u.I(z7, z6);
        this.u.P(z8);
        if (m0Var != null) {
            l0 l0Var = this.u;
            boolean z9 = m0Var.u;
            l0Var.w = z9;
            if (z9) {
                l0Var.h().setText(R.string.obfuscated_res_0x7f0f0fa2);
                this.u.B(false);
            }
        }
        this.u.z(m0Var != null ? m0Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.w() != null && this.a.w().S0() != null && this.a.w().S0().Q() != null && this.a.w().S0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.d().setText(R.string.obfuscated_res_0x7f0f0812);
        }
        N0();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            c.a.d.f.m.e.a().postDelayed(this.I, 100L);
        }
    }

    public final void I0(c.a.o0.r.t.a aVar, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, aVar, i2) == null) || (absVideoPbFragment = this.a) == null || aVar == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new c.a.p0.l.g(this.a.getPageContext(), this.a.getView());
        }
        AntiData L = L();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04a2), this.a.getString(R.string.obfuscated_res_0x7f0f04a3), this.a.getString(R.string.obfuscated_res_0x7f0f04a4), this.a.getString(R.string.obfuscated_res_0x7f0f04a5), this.a.getString(R.string.obfuscated_res_0x7f0f04a6)});
        this.v.x(v0Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, aVar));
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public void J0(View view) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null) {
            return;
        }
        c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.a.getPageContext());
        if (this.a.w().S0().f19819f == null || this.a.w().S0().f19819f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f118a), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f118b)};
        } else {
            strArr = new String[this.a.w().S0().f19819f.size()];
            for (int i2 = 0; i2 < this.a.w().S0().f19819f.size(); i2++) {
                strArr[i2] = this.a.w().S0().f19819f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1188);
            }
        }
        jVar.j(null, strArr, new m(this, jVar, view));
        jVar.m();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.o0.r.t.a aVar = this.f20488e;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.f20489f;
            if (dialog != null) {
                c.a.d.f.m.g.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.f20490g;
            if (dialog2 != null) {
                c.a.d.f.m.g.b(dialog2, this.a.getPageContext());
            }
            c.a.o0.r.t.j jVar = this.q;
            if (jVar != null) {
                jVar.dismiss();
            }
        }
    }

    public void K0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getPageContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new p(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.w() == null || this.a.w().S0() == null) {
                return null;
            }
            return this.a.w().S0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void L0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                B0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getBaseFragmentActivity());
            if (c.a.d.f.p.m.isEmpty(str)) {
                aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f030f, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new q(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new r(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view = this.i;
            if (view != null) {
                return view.findViewById(R.id.obfuscated_res_0x7f090799);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.w().k1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.p0.w2.m.f.n1.a.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        l0 l0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (l0Var = this.u) == null) {
            return;
        }
        l0Var.x();
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.E : invokeV.objValue;
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.M : (View.OnLongClickListener) invokeV.objValue;
    }

    public l0 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (l0) invokeV.objValue;
    }

    public c.a.o0.r.t.c R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (c.a.o0.r.t.c) invokeV.objValue;
    }

    public int S(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().getThreadType() == 0) {
                return 1;
            }
            if (fVar.O().getThreadType() == 54) {
                return 2;
            }
            return fVar.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091ebb) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebb) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091ebd) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebd) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091ebc) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebc) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091eb8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb8) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091eb9) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb9) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            L0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            if (this.a.w() != null && this.a.w().S0() != null && this.a.w().S0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.w().k1(), str);
                ThreadData O = this.a.w().S0().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void V() {
        c.a.o0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (aVar = this.r) == null) {
            return;
        }
        aVar.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new c.a.o0.r.t.c(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0361), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1184), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1099)};
            c.a.o0.r.t.c cVar = this.s;
            cVar.j(strArr, new l(this));
            cVar.g(c.b.obfuscated_res_0x7f1003a3);
            cVar.h(17);
            cVar.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? c.a.p0.w2.m.f.n1.a.h(this.a.w()) : invokeV.booleanValue;
    }

    public boolean Y(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            if (i2 != 1) {
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.a.w().S0().U() != null && (forumToolAuth = this.a.w().S0().U().getForumToolAuth()) != null) {
                    for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                        ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                        if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    public final boolean b0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z2)) == null) {
            if (this.a.w() != null && this.a.w().S0() != null) {
                return ((this.a.w().S0().V() != 0) || this.a.w().S0().O() == null || this.a.w().S0().O().getAuthor() == null || TextUtils.equals(this.a.w().S0().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void d0(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void e0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.G() != null && postData.G().equals(this.a.w().N0())) {
            z2 = true;
        }
        MarkData M0 = this.a.w().M0(postData);
        if (this.a.w().S0() != null && this.a.w().S0().g0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData U2 = absVideoPbFragment.U2(absVideoPbFragment.w().S0());
            if (U2 != null) {
                M0 = this.a.w().M0(U2);
            }
        }
        if (M0 == null) {
            return;
        }
        this.a.z4();
        if (this.a.c3() != null) {
            this.a.c3().i(M0);
            if (!z2) {
                this.a.c3().a();
            } else {
                this.a.c3().d();
            }
        }
    }

    public void f0(ArrayList<c.a.o0.r.r.m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01f1, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.i);
            if (this.f20490g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039e);
                this.f20490g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f20490g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090cd8);
                this.f20490g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.f20490g.getWindow().getAttributes();
                attributes.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d4);
                this.f20490g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090cd7);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090798);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090799);
                this.k = textView2;
                textView2.setOnClickListener(this.a.Z2());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1398));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    c.a.o0.r.r.m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(m0Var.a()), m0Var.b());
                        this.m.add(D2);
                        View view = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.j.addView(view);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.d.f.p.n.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.d.f.p.n.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.d.f.p.n.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            c.a.d.f.m.g.j(this.f20490g, this.a.getPageContext());
        }
    }

    public void g0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            h0(i2, str, i3, z2, null);
        }
    }

    public void h0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            i0(i2, str, i3, z2, str2, false);
        }
    }

    public void i0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f0483 : R.string.obfuscated_res_0x7f0f0f9f;
            int i5 = R.string.obfuscated_res_0x7f0f0422;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f0487;
                    i4 = R.string.obfuscated_res_0x7f0f0488;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0fa3;
                }
            }
            this.f20488e = new c.a.o0.r.t.a(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.f20488e.setMessageId(i4);
            } else {
                this.f20488e.setOnlyMessageShowCenter(false);
                this.f20488e.setMessage(str2);
            }
            this.f20488e.setYesButtonTag(sparseArray);
            this.f20488e.setPositiveButton(R.string.obfuscated_res_0x7f0f04d6, new b(this));
            this.f20488e.setNegativeButton(R.string.obfuscated_res_0x7f0f04d1, new c(this));
            this.f20488e.setCancelable(true);
            this.f20488e.create(this.a.getPageContext());
            if (z3) {
                v0(sparseArray, i5, i4);
            } else if (z2) {
                v0(sparseArray, i5, i4);
            } else if (q0()) {
                c.a.p0.l.i iVar = new c.a.p0.l.i(this.a.w().S0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.w().S0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.w().S0().o().has_forum_rule.intValue());
                iVar.i(this.a.w().S0().l().getId(), this.a.w().S0().l().getName());
                iVar.h(this.a.w().S0().l().getImage_url());
                iVar.j(this.a.w().S0().l().getUser_level());
                C0(sparseArray, i2, iVar, this.a.w().S0().U(), false);
            } else {
                I0(this.f20488e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e88, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                r0(sparseArray);
            } else {
                s0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        c.a.o0.r.t.h hVar;
        c.a.o0.r.t.h hVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(this.a.getContext());
            lVar.q(this.a.getString(R.string.obfuscated_res_0x7f0f02d3));
            lVar.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e65) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e65)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e6b)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e6d) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue() : -1) == 0) {
                    hVar2 = new c.a.o0.r.t.h(10, this.a.getString(R.string.obfuscated_res_0x7f0f0499), lVar);
                } else {
                    hVar2 = new c.a.o0.r.t.h(10, this.a.getString(R.string.obfuscated_res_0x7f0f048e), lVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                hVar2.f11053d.setTag(sparseArray2);
                arrayList.add(hVar2);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e76)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e77))) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e76, sparseArray.get(R.id.obfuscated_res_0x7f091e76));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e77, sparseArray.get(R.id.obfuscated_res_0x7f091e77));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e78, sparseArray.get(R.id.obfuscated_res_0x7f091e78));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e79, sparseArray.get(R.id.obfuscated_res_0x7f091e79));
                c.a.o0.r.t.h hVar3 = new c.a.o0.r.t.h(11, this.a.getString(R.string.obfuscated_res_0x7f0f0636), lVar);
                hVar3.f11053d.setTag(sparseArray3);
                arrayList.add(hVar3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eb8, sparseArray.get(R.id.obfuscated_res_0x7f091eb8));
                if (z2) {
                    hVar = new c.a.o0.r.t.h(12, this.a.getString(R.string.obfuscated_res_0x7f0f1460), lVar);
                } else {
                    hVar = new c.a.o0.r.t.h(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b13), lVar);
                }
                hVar.f11053d.setTag(sparseArray4);
                arrayList.add(hVar);
            }
            lVar.j(arrayList);
            c.a.o0.r.t.j jVar = this.q;
            if (jVar == null) {
                this.q = new c.a.o0.r.t.j(this.a.getPageContext(), lVar);
            } else {
                jVar.i(lVar);
            }
            this.q.m();
        }
    }

    public void l0(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        c.a.p0.w2.i.f S0;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null || this.a.w().S0() == null || (O = (S0 = this.a.w().S0()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.p3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        m0 m0Var = new m0();
        int V = this.a.w().S0().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            m0Var.f20239g = false;
        } else {
            m0Var.f20239g = true;
            m0Var.s = O.getIs_top() == 1;
        }
        if (Z(V)) {
            m0Var.f20240h = true;
            m0Var.r = O.getIs_good() == 1;
        } else {
            m0Var.f20240h = false;
        }
        if (V == 1002 && !equals) {
            m0Var.u = true;
        }
        m0Var.n = y0(O.isBlocked(), S0.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        m0Var.f20237e = u0(equals, S0.i0());
        m0Var.i = z0();
        m0Var.f20238f = x0(equals);
        m0Var.k = equals && S0.U() != null && S0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            m0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        m0Var.t = equals;
        m0Var.q = this.a.w().i1();
        m0Var.f20234b = true;
        m0Var.a = b0(equals);
        m0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        m0Var.j = true;
        m0Var.o = this.a.w().w0();
        m0Var.f20236d = true;
        if (O.getThreadVideoInfo() == null) {
            m0Var.f20235c = true;
        } else {
            m0Var.f20235c = false;
        }
        if (S0.g0()) {
            m0Var.f20234b = false;
            m0Var.f20236d = false;
            m0Var.f20235c = false;
            m0Var.f20239g = false;
            m0Var.f20240h = false;
        }
        m0Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !S0.g0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.U2(absVideoPbFragment2.w().S0()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            m0Var.w = absVideoPbFragment3.U2(absVideoPbFragment3.w().S0()).Q;
        }
        if (O.isBlocked()) {
            m0Var.n = false;
            m0Var.f20239g = false;
            m0Var.f20240h = false;
        }
        H0(m0Var);
    }

    public final void n0(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091731, Integer.valueOf(this.O ? 2 : 3));
        view.setTag(sparseArray);
    }

    public void o0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.O = z2;
        }
    }

    public void p0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            return (absVideoPbFragment == null || absVideoPbFragment.w().S0().l().getDeletedReasonInfo() == null || 1 != this.a.w().S0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void r0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e7f, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1152, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036c, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.o0.r.t.o oVar = new c.a.o0.r.t.o(this.a.x());
        oVar.v(R.string.obfuscated_res_0x7f0f0b0f);
        oVar.l(R.string.obfuscated_res_0x7f0f0b10);
        oVar.n(true);
        oVar.r(aVar2, aVar);
        oVar.i(false);
        androidx.appcompat.app.AlertDialog y2 = oVar.y();
        aVar.a(new f(this, y2, sparseArray));
        aVar2.a(new g(this, y2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e7f, Boolean.TRUE);
        }
        c.a.p0.l.i iVar = new c.a.p0.l.i(this.a.w().S0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.w().S0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.w().S0().o().has_forum_rule.intValue());
        iVar.i(this.a.w().S0().l().getId(), this.a.w().S0().l().getName());
        iVar.h(this.a.w().S0().l().getImage_url());
        iVar.j(this.a.w().S0().l().getUser_level());
        C0(sparseArray, i2, iVar, this.a.w().S0().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            c.a.p0.w2.m.f.n1.a.d(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        e0 e0Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.w() == null || this.a.w().S0() == null) {
                return false;
            }
            c.a.p0.w2.i.f S0 = this.a.w().S0();
            ThreadData O = S0.O();
            if (O != null) {
                if (O.isBJHArticleThreadType() || O.isBJHVideoThreadType()) {
                    return false;
                }
                if (O.isBJHNormalThreadType() || O.isBJHVideoDynamicThreadType()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !w0.isOn()) || this.a.w().G() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (S0.l() == null || !S0.l().isBlockBawuDelete) {
                if (S0.O() == null || !S0.O().isBlocked()) {
                    if (S0.V() != 0) {
                        return S0.V() != 3;
                    }
                    List<x1> p2 = S0.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (x1 x1Var : p2) {
                            if (x1Var != null && (e0Var = x1Var.f10996g) != null && e0Var.a && !e0Var.f10845c && ((i2 = e0Var.f10844b) == 1 || i2 == 2)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void v0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048636, this, sparseArray, i2, i3) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f048e, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036c, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.o0.r.t.o oVar = new c.a.o0.r.t.o(this.a.x());
        oVar.v(i2);
        oVar.l(i3);
        oVar.n(true);
        oVar.r(aVar2, aVar);
        oVar.i(false);
        androidx.appcompat.app.AlertDialog y2 = oVar.y();
        aVar.a(new d(this, y2, sparseArray));
        aVar2.a(new e(this, y2));
    }

    public void w0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        c.a.o0.r.t.h hVar;
        c.a.o0.r.t.h hVar2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69)) == null) {
            return;
        }
        if (this.f20486c == null) {
            c.a.o0.r.t.l lVar = new c.a.o0.r.t.l(this.a.getContext());
            this.f20486c = lVar;
            lVar.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.w().S0() != null && this.a.w().S0().g0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
            c.a.o0.r.t.h hVar3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e79) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e79) : null;
            if (postData.q() != null) {
                boolean z3 = postData.q().hasAgree;
                int r2 = postData.r();
                if (z3 && r2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0083;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0085;
                }
                c.a.o0.r.t.h hVar4 = new c.a.o0.r.t.h(8, absVideoPbFragment2.getString(i2), this.f20486c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e69, postData);
                hVar4.f11053d.setTag(sparseArray2);
                arrayList.add(hVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    c.a.o0.r.t.h hVar5 = new c.a.o0.r.t.h(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b17), this.f20486c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                    hVar5.f11053d.setTag(sparseArray3);
                    arrayList.add(hVar5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        c.a.o0.r.t.h hVar6 = new c.a.o0.r.t.h(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fa2), this.f20486c);
                        hVar6.f11053d.setTag(str);
                        arrayList.add(hVar6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e76, sparseArray.get(R.id.obfuscated_res_0x7f091e76));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e77, sparseArray.get(R.id.obfuscated_res_0x7f091e77));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e78, sparseArray.get(R.id.obfuscated_res_0x7f091e78));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e79, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e80, sparseArray.get(R.id.obfuscated_res_0x7f091e80));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eba, sparseArray.get(R.id.obfuscated_res_0x7f091eba));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eb9, sparseArray.get(R.id.obfuscated_res_0x7f091eb9));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                        c.a.o0.r.t.h hVar7 = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f048e), this.f20486c);
                        hVar7.f11053d.setTag(sparseArray4);
                        hVar3 = hVar7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, Boolean.FALSE);
                    }
                    c.a.o0.r.t.h hVar8 = new c.a.o0.r.t.h(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d3), this.f20486c);
                    hVar8.f11053d.setTag(sparseArray4);
                    hVar2 = hVar8;
                    hVar = hVar3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea9, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e88, sparseArray.get(R.id.obfuscated_res_0x7f091e88));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6c, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6b, sparseArray.get(R.id.obfuscated_res_0x7f091e6b));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e7d, sparseArray.get(R.id.obfuscated_res_0x7f091e7d));
                    if (this.a.w().S0().V() == 1002 && !booleanValue) {
                        hVar = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fa2), this.f20486c);
                    } else {
                        hVar = new c.a.o0.r.t.h(6, this.a.getString(R.string.obfuscated_res_0x7f0f048e), this.f20486c);
                    }
                    hVar.f11053d.setTag(sparseArray5);
                    hVar2 = null;
                } else {
                    hVar = null;
                    hVar2 = null;
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                }
                if (!booleanValue) {
                    arrayList.add(new c.a.o0.r.t.h(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0310), this.f20486c));
                }
            }
            this.f20486c.j(arrayList);
            c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(this.a.getPageContext(), this.f20486c);
            this.f20485b = jVar;
            jVar.m();
        }
    }

    public final boolean x0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null || this.a.w().S0() == null || (this.a.w().S0().l() != null && this.a.w().S0().l().isBlockBawuDelete)) {
                return false;
            }
            c.a.p0.w2.i.f S0 = this.a.w().S0();
            if ((S0.O() == null || S0.O().getAuthor() == null || !S0.O().getAuthor().isForumBusinessAccount() || w0.isOn()) && !this.a.w().G()) {
                return ((S0.O() != null && S0.O().isBlocked()) || this.a.w().S0().V() == 0 || this.a.w().S0().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final boolean y0(boolean z2, boolean z3, boolean z4, int i2, boolean z5, boolean z6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048639, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Boolean.valueOf(z6)})) == null) {
            if (z2) {
                return false;
            }
            if (z5 || z6) {
                return true;
            }
            return z3 && (z4 || a0(i2));
        }
        return invokeCommon.booleanValue;
    }

    public final boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.w() == null || !this.a.w().i1()) {
                return false;
            }
            return this.a.w().Q0() == null || this.a.w().Q0().c() != 0;
        }
        return invokeV.booleanValue;
    }
}
