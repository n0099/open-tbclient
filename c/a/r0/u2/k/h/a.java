package c.a.r0.u2.k.h;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.o0;
import c.a.q0.r.l0.f;
import c.a.q0.r.r.x0;
import c.a.q0.r.t.a;
import c.a.q0.r.t.c;
import c.a.r0.f0.m;
import c.a.r0.l.g;
import c.a.r0.l.j;
import c.a.r0.u2.h.t;
import c.a.r0.u2.i.c;
import c.a.r0.u2.k.h.b;
import c.a.r0.y3.b0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbMoreDialog;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int s0;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public c.a.q0.r.l0.a B;
    public c.a.r0.u2.k.h.d C;
    public View D;
    public MorePopupWindow E;
    public View F;
    public c.a.q0.r.t.c G;
    public View H;
    public BlankView I;
    public View J;
    public Dialog K;
    public c.a.q0.r.t.a L;
    public View.OnClickListener M;
    public c.a.q0.r.t.c N;
    public boolean O;
    public ProgressBar P;
    public NewSubPbActivity.r0 Q;
    public NewSubPbActivity.r0 R;
    public c.a.q0.w.y.h S;
    public int T;
    public ArrayList<PostData> U;
    public t V;
    public TextView W;
    public RelativeLayout X;
    public ImageView Y;
    public ImageView Z;
    public SubPbView a;
    public LinearLayout a0;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f23814b;
    public HeadImageView b0;

    /* renamed from: c  reason: collision with root package name */
    public View f23815c;
    public View c0;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f23816d;
    public PbMoreDialog d0;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.u2.p.k f23817e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public NewSubPbActivity f23818f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f23819g;
    public SubPbModel g0;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f23820h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f23821i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f23822j;
    public c.a.r0.l.g j0;
    public NavigationBar k;
    public c.a.r0.l.j k0;
    public ImageView l;
    public c.a.r0.u2.k.h.c l0;
    public View m;
    public boolean m0;
    public TextView n;
    public f.g n0;
    public LinearLayout o;
    public MaskView o0;
    public HeadImageView p;
    public c.a.r0.u2.i.c p0;
    public TextView q;
    public AdapterView.OnItemLongClickListener q0;
    public View r;
    public AdapterView.OnItemClickListener r0;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public EllipsizeRichTextView w;
    public TbImageView x;
    public PlayVoiceBntNew y;
    public TextView z;

    /* renamed from: c.a.r0.u2.k.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1465a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f23823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f23824f;

        public RunnableC1465a(a aVar, boolean z) {
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
            this.f23824f = aVar;
            this.f23823e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23824f.f23816d.setEnabled(this.f23823e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b0.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23825e;

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
            this.f23825e = aVar;
        }

        @Override // c.a.r0.y3.b0.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.f23825e.U();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23826e;

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
            this.f23826e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                PostData postData = (PostData) ListUtils.getItem(this.f23826e.U, i2);
                if (view != null && view.getTag() != null) {
                    if (this.f23826e.d0 == null) {
                        this.f23826e.d0 = new PbMoreDialog(this.f23826e.f23818f.getPageContext(), this.f23826e.M);
                    }
                    this.f23826e.d0.showDialog();
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                        sparseArray = null;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                    PostData postData2 = sparseArray.get(R.id.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(R.id.tag_clip_board) : null;
                    boolean z = this.f23826e.a0(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                    this.f23826e.d0.confirmItems(sparseArray, this.f23826e.g0.B0(), z, this.f23826e.m0 && postData2 != null && postData2.k0, this.f23826e.g0.j0());
                    if (z) {
                        this.f23826e.d0.getReportTextView().setVisibility(0);
                        this.f23826e.d0.getReportTextView().setTag(postData.G());
                    } else {
                        this.f23826e.d0.getReportTextView().setVisibility(8);
                    }
                    this.f23826e.d0.getMarkTextView().setVisibility(8);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23827e;

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
            this.f23827e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && this.f23827e.f23818f != null && ViewHelper.checkUpIsLogin(this.f23827e.f23818f.getPageContext().getPageActivity())) {
                if ((this.f23827e.f23818f.mReplyPrivacyController != null && this.f23827e.g0 != null && this.f23827e.g0.h0() != null && !this.f23827e.f23818f.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.f23827e.g0.h0().replyPrivateFlag)) || this.f23827e.g0 == null || this.f23827e.S == null) {
                    return;
                }
                this.f23827e.L0();
                if (view != null && (view.getTag() instanceof b.a)) {
                    this.f23827e.s();
                    this.f23827e.g0.c1();
                    return;
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(R.id.tag_photo_username);
                    String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                    String str3 = (String) sparseArray.get(R.id.tag_photo_portrait);
                    if (str != null) {
                        this.f23827e.S.W(str2);
                        this.f23827e.S.V(str, str3);
                    }
                }
                this.f23827e.u();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23828e;

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
            this.f23828e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23828e.I == null) {
                return;
            }
            this.f23828e.a.onFinish();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f23829e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f23830f;

        public f(a aVar, int i2) {
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
            this.f23830f = aVar;
            this.f23829e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int headerViewsCount = this.f23829e + this.f23830f.f23816d.getHeaderViewsCount();
                if (headerViewsCount >= 1) {
                    headerViewsCount--;
                }
                this.f23830f.f23816d.setSelection(headerViewsCount);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23831e;

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
            this.f23831e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23831e.g0 == null || (!this.f23831e.g0.J0() && !this.f23831e.g0.G0())) {
                    if (this.f23831e.I != null) {
                        this.f23831e.a.onFinish();
                        return;
                    } else {
                        this.f23831e.f23818f.finish();
                        return;
                    }
                }
                this.f23831e.f23818f.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements c.a {
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

        @Override // c.a.r0.u2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.u2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.u2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                this.a.x(false);
                this.a.x(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23832e;

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
            this.f23832e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23832e.K != null && (this.f23832e.K instanceof Dialog)) {
                    c.a.d.f.m.g.b(this.f23832e.K, this.f23832e.f23818f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.f23832e.h0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23833e;

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
            this.f23833e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23833e.K != null && (this.f23833e.K instanceof Dialog)) {
                    c.a.d.f.m.g.b(this.f23833e.K, this.f23833e.f23818f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null || this.f23833e.Q == null) {
                    return;
                }
                this.f23833e.Q.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f23834e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f23835f;

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
            this.f23835f = aVar;
            this.f23834e = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23835f.K != null && (this.f23835f.K instanceof Dialog)) {
                    c.a.d.f.m.g.b(this.f23835f.K, this.f23835f.f23818f.getPageContext());
                }
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.f23835f.f23818f.handleMuteClick(this.f23834e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f23836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f23837f;

        public l(a aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23837f = aVar;
            this.f23836e = sparseArray;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f23837f.R != null) {
                    this.f23837f.R.a(new Object[]{this.f23836e.get(R.id.tag_del_post_id), this.f23836e.get(R.id.tag_manage_user_identity), this.f23836e.get(R.id.tag_del_post_is_self), this.f23836e.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(a aVar) {
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
                }
            }
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements g.InterfaceC1174g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f23838b;

        public n(a aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23838b = aVar;
            this.a = sparseArray;
        }

        @Override // c.a.r0.l.g.InterfaceC1174g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.f23838b.R != null) {
                    this.f23838b.R.a(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f23839b;

        public o(a aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23839b = aVar;
            this.a = sparseArray;
        }

        @Override // c.a.r0.l.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.f23839b.R != null) {
                    this.f23839b.R.a(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1164772948, "Lc/a/r0/u2/k/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1164772948, "Lc/a/r0/u2/k/h/a;");
                return;
            }
        }
        s0 = TbadkCoreApplication.getInst().getListItemRule().c();
    }

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f23815c = null;
        this.f23816d = null;
        this.f23817e = null;
        this.f23818f = null;
        this.f23819g = null;
        this.f23820h = null;
        this.f23821i = null;
        this.f23822j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = null;
        this.E = null;
        this.G = null;
        this.H = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.O = true;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = 0;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.e0 = 2;
        this.f0 = 0;
        this.h0 = 0;
        this.i0 = true;
        this.m0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.p0 = new c.a.r0.u2.i.c(new h(this));
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.f23818f = newSubPbActivity;
        this.M = onClickListener;
        this.a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.f23815c = LayoutInflater.from(this.f23818f.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.f23814b = (LinearLayout) this.a.findViewById(R.id.navigation_bar_group);
        this.X = (RelativeLayout) this.a.findViewById(R.id.subpb_editor_tool_comment);
        TextView textView = (TextView) this.a.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.W = textView;
        textView.setOnClickListener(this.M);
        this.Y = (ImageView) this.a.findViewById(R.id.subpb_editor_tool_more_img);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.Z = imageView;
        imageView.setOnClickListener(this.M);
        this.Y.setOnClickListener(this.M);
        this.f23819g = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        W();
        V();
        this.f23822j = (RelativeLayout) this.a.findViewById(R.id.sub_pb_body_layout);
        this.f23816d = (BdTypeListView) this.a.findViewById(R.id.new_sub_pb_list);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f23818f.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.A = threadSkinView;
        this.f23816d.addHeaderView(threadSkinView);
        this.f23816d.addHeaderView(this.f23815c);
        this.J = new TextView(newSubPbActivity.getActivity());
        this.J.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.f23816d.addHeaderView(this.J, 0);
        this.a.setTopView(this.J);
        this.a.setNavigationView(this.f23814b);
        this.a.setListView(this.f23816d);
        this.a.setContentView(this.f23822j);
        c.a.r0.u2.k.h.d dVar = new c.a.r0.u2.k.h.d(this.f23818f.getPageContext());
        this.C = dVar;
        dVar.y();
        this.H = this.C.b();
        this.f23816d.setNextPage(this.C);
        this.C.C(this.M);
        this.f23816d.setOnItemClickListener(this.r0);
        this.f23816d.setOnItemLongClickListener(this.q0);
        this.f23816d.setOnTouchListener(this.p0);
        c.a.r0.u2.p.k kVar = new c.a.r0.u2.p.k(newSubPbActivity.getPageContext());
        this.f23817e = kVar;
        kVar.i();
        this.f23817e.a(this.n0);
        this.f23817e.C(TbadkCoreApplication.getInst().getSkinType());
        this.P = (ProgressBar) this.a.findViewById(R.id.progress);
        this.o0 = (MaskView) this.a.findViewById(R.id.mask_view);
        this.c0 = this.a.findViewById(R.id.view_comment_top_line);
        this.a0 = (LinearLayout) this.a.findViewById(R.id.pb_editer_tool_comment_layout);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.b0 = headImageView;
        headImageView.setVisibility(0);
        this.b0.setIsRound(true);
        this.b0.setBorderWidth(c.a.d.f.p.n.f(this.f23818f, R.dimen.L_X01));
        this.b0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.b0.setDefaultBgResource(0);
        this.b0.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.b0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        f0(TbadkCoreApplication.getInst().getSkinType());
        View view = this.f23815c;
        if (view != null) {
            view.setVisibility(4);
        }
        View a = c.a.q0.d.c.b().a(this.f23818f.getActivity(), 4);
        this.r = a;
        if (a != null) {
            a.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        c.a.r0.u2.k.h.c cVar = new c.a.r0.u2.k.h.c(this.f23818f, this.f23816d);
        this.l0 = cVar;
        cVar.f(this.O);
        this.l0.d(this.M);
        this.l0.b();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BlankView blankView = this.I;
            if (blankView == null) {
                return 0;
            }
            return blankView.getHeight();
        }
        return invokeV.intValue;
    }

    public void A0(PostData postData) {
        int i2;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) || postData == null) {
            return;
        }
        postData.t0(true);
        PostData postData2 = new PostData();
        postData2.x0(52);
        if (!J0() && (view = this.H) != null && view.isShown()) {
            i2 = (this.f0 - this.e0) - 1;
        } else {
            i2 = this.f0 - this.e0;
        }
        int count = ListUtils.getCount(this.U);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.U, 0, i2));
        ListUtils.add(arrayList, postData2);
        ListUtils.add(arrayList, postData);
        this.f23816d.smoothScrollToPosition(this.f0 + 2);
        this.f23816d.setNextPage(null);
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23822j : (View) invokeV.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.B == null) {
                this.B = new c.a.q0.r.l0.a(this.f23818f.getPageContext());
            }
            this.B.h(true);
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.q0.w.y.h hVar = this.S;
            if (hVar == null || hVar.a() == null) {
                return 0;
            }
            return this.S.a().getHeight();
        }
        return invokeV.intValue;
    }

    public final void C0(SparseArray<Object> sparseArray, c.a.r0.l.i iVar, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData h0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, sparseArray, iVar, userData) == null) || (newSubPbActivity = this.f23818f) == null || sparseArray == null || this.f23815c == null) {
            return;
        }
        if (this.k0 == null) {
            this.k0 = new c.a.r0.l.j(newSubPbActivity.getPageContext(), this.f23815c, iVar, userData);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.g0;
        if (subPbModel != null && (h0 = subPbModel.h0()) != null && h0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = h0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.j(sparseArray2);
        this.k0.E(new String[]{this.f23818f.getString(R.string.delete_thread_reason_1), this.f23818f.getString(R.string.delete_thread_reason_2), this.f23818f.getString(R.string.delete_thread_reason_3), this.f23818f.getString(R.string.delete_thread_reason_4), this.f23818f.getString(R.string.delete_thread_reason_5)});
        this.k0.D(x0Var);
        this.k0.G("4");
        this.k0.F(new o(this, sparseArray));
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.x : (View) invokeV.objValue;
    }

    public void D0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            X(NoDataViewFactory.e.d(null, this.f23818f.getResources().getString(R.string.refresh_view_title_text)));
            this.X.setVisibility(8);
        }
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public void E0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) {
            if (z) {
                X(NoDataViewFactory.e.d("", str));
            } else {
                X(NoDataViewFactory.e.d(str, this.f23818f.getPageContext().getString(R.string.refresh_view_title_text)));
            }
            this.X.setVisibility(8);
        }
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f23815c : (View) invokeV.objValue;
    }

    public void F0(c.InterfaceC0876c interfaceC0876c, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, interfaceC0876c, z) == null) {
            c.a.q0.r.t.c cVar = this.N;
            if (cVar != null) {
                cVar.e();
                this.N = null;
            }
            c.a.q0.r.t.c cVar2 = new c.a.q0.r.t.c(this.f23818f.getPageContext().getPageActivity());
            this.N = cVar2;
            if (z) {
                cVar2.j(new String[]{this.f23818f.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0876c);
            } else {
                cVar2.j(new String[]{this.f23818f.getPageContext().getString(R.string.save_to_emotion), this.f23818f.getPageContext().getString(R.string.save_to_local)}, interfaceC0876c);
            }
            this.N.c(this.f23818f.getPageContext());
            this.N.m();
        }
    }

    public View G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public final void G0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData h0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, sparseArray) == null) || (newSubPbActivity = this.f23818f) == null || sparseArray == null || this.f23815c == null) {
            return;
        }
        if (this.j0 == null) {
            this.j0 = new c.a.r0.l.g(newSubPbActivity.getPageContext(), this.f23815c);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.g0;
        if (subPbModel != null && (h0 = subPbModel.h0()) != null && h0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = h0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.j(sparseArray2);
        this.j0.y(new String[]{this.f23818f.getString(R.string.delete_thread_reason_1), this.f23818f.getString(R.string.delete_thread_reason_2), this.f23818f.getString(R.string.delete_thread_reason_3), this.f23818f.getString(R.string.delete_thread_reason_4), this.f23818f.getString(R.string.delete_thread_reason_5)});
        this.j0.x(x0Var);
        this.j0.A("4");
        this.j0.z(new n(this, sparseArray));
    }

    public ListView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f23816d : (ListView) invokeV.objValue;
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f23816d.setNextPage(this.C);
            this.C.R();
        }
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.H : (View) invokeV.objValue;
    }

    public void I0(t tVar, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{tVar, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || tVar == null) {
            return;
        }
        if (this.i0 && (view = this.f23815c) != null) {
            view.setVisibility(8);
            this.f23816d.removeHeaderView(this.f23815c);
            this.e0 = 1;
        }
        this.V = tVar;
        if (tVar.i() != null) {
            this.V.i().k0 = true;
        }
        View view2 = this.f23815c;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (tVar.l() != null && tVar.l().H2()) {
            this.n.setText(R.string.view_original);
        } else {
            this.n.setText(R.string.view_subject);
        }
        if (tVar.i() != null) {
            int A = tVar.i().A();
            this.T = A;
            if (A > 0) {
                this.k.setCenterTextTitle(String.format(this.f23818f.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.T)));
                NewSubPbActivity newSubPbActivity = this.f23818f;
                if (newSubPbActivity != null) {
                    this.W.setText(newSubPbActivity.getReplyHint());
                }
            } else {
                this.k.setCenterTextTitle(this.f23818f.getResources().getString(R.string.local_floor_reply));
            }
            String str = this.f23818f.isFromPb() ? "PB" : null;
            if (tVar.i().O() != null) {
                this.A.setData(this.f23818f.getPageContext(), tVar.i().O(), c.a.r0.y3.m0.a.a("PB", "c0132", tVar.d().getId(), tVar.d().getName(), tVar.l().h0(), str));
            } else {
                this.A.setData(null, null, null);
            }
        }
        if (tVar.o()) {
            this.C.R();
            this.l0.g(true);
        } else {
            this.C.f();
            this.l0.g(false);
        }
        ArrayList<PostData> k2 = tVar.k();
        this.U = k2;
        if (k2 == null || k2.size() <= s0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int size = this.U.size() - s0;
            k0(size);
            int firstVisiblePosition = this.f23816d.getFirstVisiblePosition() - size;
            View childAt = this.f23816d.getChildAt(0);
            i3 = size;
            i4 = firstVisiblePosition;
            i5 = childAt == null ? 0 : childAt.getTop();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.U);
        if (ListUtils.isEmpty(this.U)) {
            this.f23816d.setNextPage(null);
            if (this.i0) {
                arrayList.add(0, new c.a.r0.u2.k.h.g.a());
            }
        } else {
            this.f23816d.setNextPage(this.C);
        }
        c.a.r0.u2.k.h.g.b bVar = new c.a.r0.u2.k.h.g.b();
        bVar.d(tVar.m());
        arrayList.add(0, bVar);
        if (this.i0) {
            arrayList.add(0, tVar.i());
        }
        NewSubPbActivity newSubPbActivity2 = this.f23818f;
        if (newSubPbActivity2 != null && newSubPbActivity2.getSubPbModel() != null) {
            this.o0.setVisibility(this.f23818f.getSubPbModel().K0() ? 0 : 8);
        }
        this.l0.e(this.V.l(), arrayList);
        y(tVar, tVar.i(), tVar.e(), tVar.f(), i2, z);
        if (i3 > 0) {
            this.f23816d.setSelectionFromTop(i4, i5);
        } else if (z2 && !c.a.d.f.p.m.isEmpty(this.f23818f.getSubPbModel().p0())) {
            String p0 = this.f23818f.getSubPbModel().p0();
            int i6 = 0;
            while (true) {
                if (i6 < arrayList.size()) {
                    if ((arrayList.get(i6) instanceof PostData) && p0.equals(((PostData) arrayList.get(i6)).G())) {
                        this.f23816d.post(new f(this, i6));
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
        }
        if (this.V.j() > 1) {
            this.f23816d.setPullRefresh(this.f23817e);
            this.a.setEnableDragExit(false);
            return;
        }
        this.f23816d.setPullRefresh(null);
        this.a.setEnableDragExit(true);
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l0.a() : invokeV.booleanValue;
    }

    public PbMoreDialog K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.d0 : (PbMoreDialog) invokeV.objValue;
    }

    public final void K0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, metaData) == null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        if (o0.b(name_show) + (!StringUtils.isNull(metaData.getSealPrefix()) ? c.a.d.f.p.m.byteLength(metaData.getSealPrefix()) + 2 : 0) > 14) {
            String k2 = o0.k(name_show, 0, 14);
            if (k2.length() == name_show.length()) {
                name_show = k2;
            } else {
                name_show = k2 + "...";
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(R(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                c.a.q0.d.b bVar = new c.a.q0.d.b();
                bVar.a = metaData.getAlaUserData();
                bVar.f12250b = 4;
                this.r.setTag(bVar);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, (int) R.color.cp_cont_r);
        } else if (UbsABTestHelper.isPBPlanA()) {
            c.a.q0.r.v.c.d(this.q).v(R.color.CAM_X0108);
        } else {
            c.a.q0.r.v.c.d(this.q).v(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.transparent_bg);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.startLoad(metaData.getAvater(), 28, false);
        this.o.setTag(R.id.tag_user_id, metaData.getUserId());
        this.o.setTag(R.id.tag_user_name, metaData.getUserName());
        this.o.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
    }

    public ImageView L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.Z : (ImageView) invokeV.objValue;
    }

    public void L0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bdTypeListView = this.f23816d) == null) {
            return;
        }
        this.f0 = bdTypeListView.getLastVisiblePosition();
    }

    public ImageView M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.Y : (ImageView) invokeV.objValue;
    }

    public void M0(boolean z) {
        PbMoreDialog pbMoreDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (pbMoreDialog = this.d0) == null || pbMoreDialog.getMarkTextView() == null) {
            return;
        }
        if (z) {
            this.d0.getMarkTextView().setText(R.string.remove_mark);
        } else {
            this.d0.getMarkTextView().setText(R.string.mark);
        }
    }

    public MorePopupWindow N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.E : (MorePopupWindow) invokeV.objValue;
    }

    public TextView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.W : (TextView) invokeV.objValue;
    }

    public TextView P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.w : (TextView) invokeV.objValue;
    }

    public View Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder R(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return c.a.r0.f0.m.h(this.f23818f.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void S() {
        c.a.q0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.h(false);
    }

    public void T() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (noDataView = this.f23820h) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f23816d.setVisibility(0);
        this.X.setVisibility(0);
        this.a.setOnTouchListener(null);
    }

    public void U() {
        c.a.q0.w.y.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.W == null || (hVar = this.S) == null) {
            return;
        }
        if (hVar.w()) {
            this.W.setText(R.string.draft_to_send);
        } else {
            this.W.setText(this.f23818f.getReplyHint());
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f23815c.findViewById(R.id.subpb_head_user_info_root);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.M);
            HeadImageView headImageView = (HeadImageView) this.f23815c.findViewById(R.id.photo);
            this.p = headImageView;
            headImageView.setRadius(c.a.d.f.p.n.f(this.f23818f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.f23815c.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.f23815c.findViewById(R.id.user_rank);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.f23815c.findViewById(R.id.floor_owner);
            TextView textView = (TextView) this.f23815c.findViewById(R.id.see_subject);
            this.n = textView;
            textView.setOnClickListener(this.M);
            this.u = (TextView) this.f23815c.findViewById(R.id.floor);
            this.v = (TextView) this.f23815c.findViewById(R.id.time);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.f23815c.findViewById(R.id.content_text);
            this.w = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.M);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.w.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.f23815c.findViewById(R.id.sub_pb_image);
            this.x = tbImageView;
            tbImageView.setOnClickListener(this.M);
            this.z = (TextView) this.f23815c.findViewById(R.id.advert);
            this.y = (PlayVoiceBntNew) this.f23815c.findViewById(R.id.voice_btn);
            this.f23815c.setOnTouchListener(this.p0);
            this.f23815c.setOnClickListener(this.M);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            int f2 = c.a.d.f.p.n.f(this.f23818f.getPageContext().getPageActivity(), R.dimen.ds88);
            int f3 = c.a.d.f.p.n.f(this.f23818f.getPageContext().getPageActivity(), R.dimen.ds2);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            ImageView backImageView = this.k.getBackImageView();
            this.l = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = f2;
                layoutParams.width = f2;
                layoutParams.leftMargin = f3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.m;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.width = f2;
                layoutParams2.height = f2;
                this.m.setLayoutParams(layoutParams2);
            }
            this.k.hideBottomLine();
        }
    }

    public final void X(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            NoDataViewFactory.c a = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f23818f.getPageContext().getString(R.string.refresh_view_button_text), this.f23821i));
            if (this.f23820h == null) {
                Activity pageActivity = this.f23818f.getPageContext().getPageActivity();
                this.f23820h = NoDataViewFactory.a(pageActivity, this.f23822j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, c.a.d.f.p.n.f(pageActivity, R.dimen.ds250)), eVar, a);
            }
            this.f23816d.setVisibility(8);
            this.P.setVisibility(8);
            this.S.y();
            SkinManager.setBackgroundColor(this.f23820h, R.color.CAM_X0201);
            this.f23820h.setClickable(true);
            this.f23820h.setTextOption(eVar);
            this.f23820h.onChangeSkinType(this.f23818f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f23820h.setVisibility(0);
        }
    }

    public void Y(c.a.q0.w.y.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, hVar) == null) || hVar == null || hVar.a() == null) {
            return;
        }
        this.S = hVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f23822j.addView(hVar.a(), layoutParams);
        this.S.R(new b(this));
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.a.isDrag() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
        }
    }

    public final boolean a0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
            SubPbModel subPbModel = this.g0;
            if (subPbModel == null || subPbModel.j0() == null) {
                return false;
            }
            if (this.g0.B0() != 0) {
                return false;
            }
            t tVar = this.V;
            return (tVar == null || tVar.l() == null || this.V.l().J() == null || !TextUtils.equals(this.V.l().J().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
        }
        return invokeZ.booleanValue;
    }

    public void b0() {
        c.a.r0.u2.k.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (cVar = this.l0) == null) {
            return;
        }
        cVar.c();
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            SubPbView subPbView = this.a;
            if (subPbView != null) {
                subPbView.onDestroy();
            }
            c.a.q0.w.y.h hVar = this.S;
            if (hVar != null) {
                hVar.D();
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.f23818f.getLayoutMode().k(i2 == 1);
            this.f23818f.getLayoutMode().j(this.a);
            this.f23818f.getLayoutMode().j(this.f23815c);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f23822j, R.color.CAM_X0201);
            this.k.onChangeSkinType(this.f23818f.getPageContext(), i2);
            SubPbModel subPbModel = this.g0;
            if (subPbModel != null && (subPbModel.J0() || this.g0.G0())) {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.goto_see_subject_color);
            }
            this.f23819g.onChangeSkinType(this.f23818f.getPageContext(), i2);
            this.f23818f.getLayoutMode().j(this.H);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            c.a.q0.w.y.h hVar = this.S;
            if (hVar != null && hVar.a() != null) {
                this.S.a().onChangeSkinType(i2);
            }
            this.C.d(i2);
            this.y.changeSkin();
            SkinManager.setViewTextColor(this.W, (int) R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            if (UbsABTestHelper.isPBPlanA()) {
                c.a.q0.r.v.c.d(this.q).A(R.string.F_X02);
                c.a.q0.r.v.c.d(this.q).v(R.color.CAM_X0108);
            } else {
                c.a.q0.r.v.c.d(this.q).A(R.string.F_X01);
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            }
            this.W.setAlpha(0.95f);
            if (this.D != null) {
                c.a.q0.w0.a.a(this.f23818f.getPageContext(), this.D);
            }
            c.a.r0.u2.k.h.c cVar = this.l0;
            if (cVar != null) {
                cVar.c();
            }
            this.f23818f.getLayoutMode().j(this.F);
            SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0203);
            this.b0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a0.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.d.f.p.n.f(this.f23818f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            c.a.q0.r.v.c.d(this.X).f(R.color.CAM_X0208);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || this.f23818f.isPaused()) {
        }
    }

    public void h0(int i2, String str, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            int i4 = (i3 != 1002 || z) ? R.string.del_all_post_confirm : R.string.report_post_confirm;
            if (i2 == 0) {
                i4 = (i3 != 1002 || z) ? R.string.del_thread_confirm : R.string.report_thread_confirm;
            }
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.f23818f.getPageContext().getPageActivity());
            this.L = aVar;
            aVar.setMessageId(i4);
            this.L.setYesButtonTag(sparseArray);
            this.L.setPositiveButton(R.string.dialog_ok, new l(this, sparseArray));
            this.L.setNegativeButton(R.string.dialog_cancel, new m(this));
            this.L.setCancelable(true);
            this.L.create(this.f23818f.getPageContext());
            if (z2) {
                this.L.show();
            } else if (z) {
                this.L.show();
            } else if (1 == this.g0.l0()) {
                c.a.r0.l.i iVar = new c.a.r0.l.i(this.g0.l0(), this.g0.k0(), this.g0.o0());
                iVar.i(this.V.d().getId(), this.V.d().getName());
                iVar.h(this.g0.m0());
                iVar.j(this.g0.C0());
                UserData userData = new UserData();
                userData.setIsManager(this.g0.q0());
                C0(sparseArray, iVar, userData);
            } else {
                G0(sparseArray);
            }
        }
    }

    public void i0(SparseArray<Object> sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, sparseArray, z) == null) {
            boolean z2 = true;
            if (this.K == null) {
                Dialog dialog = new Dialog(this.f23818f.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.K = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.K.setCancelable(true);
                this.F = LayoutInflater.from(this.f23818f.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
                this.f23818f.getLayoutMode().j(this.F);
                this.K.setContentView(this.F);
                WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
                attributes.width = (int) (c.a.d.f.p.n.k(this.f23818f.getPageContext().getPageActivity()) * 0.9d);
                this.K.getWindow().setAttributes(attributes);
            }
            TextView textView = (TextView) this.K.findViewById(R.id.del_post_btn);
            TextView textView2 = (TextView) this.K.findViewById(R.id.forbid_user_btn);
            TextView textView3 = (TextView) this.K.findViewById(R.id.disable_reply_btn);
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                SparseArray sparseArray2 = (SparseArray) textView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    textView.setTag(sparseArray2);
                }
                textView.setVisibility(0);
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                textView.setOnClickListener(new i(this));
            } else {
                textView.setVisibility(8);
            }
            if ("".equals(sparseArray.get(R.id.tag_forbid_user_name)) && "".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                textView2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) textView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    textView2.setTag(sparseArray3);
                }
                textView2.setVisibility(0);
                sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                textView2.setOnClickListener(new j(this));
            }
            if (!(((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) ? false : false)) {
                textView3.setVisibility(8);
            } else {
                SparseArray sparseArray4 = (SparseArray) textView3.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    textView3.setTag(sparseArray4);
                }
                textView3.setVisibility(0);
                if (z) {
                    textView3.setText(R.string.un_mute);
                } else {
                    textView3.setText(R.string.mute);
                }
                sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                textView3.setOnClickListener(new k(this, z));
            }
            c.a.d.f.m.g.j(this.K, this.f23818f.getPageContext());
        }
    }

    public void j0(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        i0(sparseArray, false);
    }

    public final void k0(int i2) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i2) == null) || (arrayList = this.U) == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            this.U.clear();
        }
        int i3 = 0;
        Iterator<PostData> it = this.U.iterator();
        while (it.hasNext()) {
            it.next();
            i3++;
            it.remove();
            if (i3 >= i2) {
                return;
            }
        }
    }

    public void l0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, r0Var) == null) {
            this.R = r0Var;
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.f23816d.setVisibility(0);
            this.P.setVisibility(8);
            this.C.f();
        }
    }

    public void n0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, r0Var) == null) {
            this.Q = r0Var;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.i0 = z;
        }
    }

    public void p0(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, gVar) == null) {
            this.n0 = gVar;
            c.a.r0.u2.p.k kVar = this.f23817e;
            if (kVar != null) {
                kVar.a(gVar);
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.f23816d.setVisibility(0);
            this.P.setVisibility(8);
            this.C.S();
        }
    }

    public void r(boolean z) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z) == null) || (subPbModel = this.g0) == null || !subPbModel.I0() || z) {
            return;
        }
        this.k.setIsClose(true);
        this.k.setIsCorner(true);
        this.k.isShowBottomLine(true);
        this.k.setBottomLineHeight(3);
        this.k.setStatusBarVisibility(8);
        this.I = new BlankView(this.f23818f.getPageContext().getPageActivity());
        if (this.g0.J0()) {
            this.h0 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
        } else {
            this.h0 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.ds160);
        }
        this.f23814b.addView(this.I, 0, new LinearLayout.LayoutParams(-1, this.h0));
        this.I.setVisibility(0);
        this.I.setOnClickListener(new e(this));
        this.a.setBlankView(this.I);
    }

    public void r0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, subPbModel) == null) {
            this.g0 = subPbModel;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            w0(this.f23818f);
            this.f23816d.setNextPage(this.C);
        }
    }

    public void s0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, yVar) == null) {
            this.l0.i(yVar);
        }
    }

    public void t(boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048637, this, z) == null) || (headImageView = this.b0) == null) {
            return;
        }
        headImageView.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
    }

    public void t0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onLongClickListener) == null) {
            this.l0.h(onLongClickListener);
        }
    }

    public void u() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || this.g0 == null) {
            return;
        }
        if ((!J0() && (view = this.H) != null && view.isShown()) || ListUtils.isEmpty(this.U)) {
            this.g0.Y0(false);
        } else {
            this.g0.Y0(true);
        }
    }

    public void u0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, onClickListener) == null) {
            this.f23821i = onClickListener;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(PostData postData, int i2, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048641, this, postData, i2, sparseArray) == null) || postData == null) {
            return;
        }
        SparseArray<Object> sparseArray2 = sparseArray == null ? new SparseArray<>() : sparseArray;
        if (i2 != 0) {
            if (i2 != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            String userId2 = postData.t().getUserId();
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        t tVar = this.V;
        if (tVar != null && tVar.l() != null && this.V.l().J() != null && postData.t() != null) {
            String userId3 = this.V.l().J().getUserId();
            String userId4 = postData.t().getUserId();
            if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                    userId = postData.t().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = true;
                    }
                    int i3 = postData.A() == 1 ? 0 : 1;
                    if (z) {
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.G());
                        if (postData.t() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.tag_forbid_user_name, "");
                        sparseArray2.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray2.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(R.id.tag_del_post_id, postData.G());
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.FALSE);
                        sparseArray2.put(R.id.tag_del_post_type, 0);
                        sparseArray2.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.G());
                    if (z) {
                        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        if (postData.t() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray2.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.V.l() != null) {
                            sparseArray2.put(R.id.tag_user_mute_thread_id, this.V.l().h0());
                        }
                        sparseArray2.put(R.id.tag_user_mute_post_id, postData.G());
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray2.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(R.id.tag_del_post_id, postData.G());
                        sparseArray2.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.b0()));
                        return;
                    }
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    return;
                }
                z2 = true;
                z3 = false;
                z4 = true;
                userId = postData.t().getUserId();
                if (userId != null) {
                    z2 = true;
                    z4 = true;
                }
                if (postData.A() == 1) {
                }
                if (z) {
                }
                if (z2) {
                }
                sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                sparseArray2.put(R.id.tag_forbid_user_post_id, postData.G());
                if (z) {
                }
                if (z3) {
                }
                if (z2) {
                }
            }
        }
        z3 = false;
        z4 = false;
        userId = postData.t().getUserId();
        if (userId != null) {
        }
        if (postData.A() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.G());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void v0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, onScrollListener) == null) {
            this.f23816d.setOnScrollListener(onScrollListener);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            MorePopupWindow morePopupWindow = this.E;
            if (morePopupWindow != null) {
                c.a.d.f.m.g.d(morePopupWindow, this.f23818f.getPageContext().getPageActivity());
            }
            c.a.q0.r.t.c cVar = this.G;
            if (cVar != null) {
                cVar.e();
            }
            c.a.q0.r.t.a aVar = this.L;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.K;
            if (dialog != null) {
                c.a.d.f.m.g.b(dialog, this.f23818f.getPageContext());
            }
            ProgressBar progressBar = this.P;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            PbMoreDialog pbMoreDialog = this.d0;
            if (pbMoreDialog != null) {
                pbMoreDialog.dismiss();
            }
        }
    }

    public void w0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, pVar) == null) {
            this.f23816d.setOnSrollToBottomListener(pVar);
        }
    }

    public final void x(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048645, this, z) == null) || (bdTypeListView = this.f23816d) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new RunnableC1465a(this, z), 10L);
        }
    }

    public void x0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, view) == null) {
            this.D = view;
        }
    }

    public void y(t tVar, PostData postData, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{tVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) || postData == null || this.i0) {
            return;
        }
        if (!StringUtils.isNull(postData.z())) {
            this.x.setVisibility(0);
            this.x.startLoad(postData.z(), 10, true);
        } else {
            this.x.setVisibility(8);
        }
        c.a.r0.y3.k0.i v = postData.v();
        if (v != null && v.a) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        SparseArray<Object> sparseArray = (SparseArray) this.f23815c.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f23815c.setTag(sparseArray);
        }
        sparseArray.clear();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        v(postData, i2, sparseArray);
        this.u.setText((CharSequence) null);
        this.q.setText((CharSequence) null);
        this.t.setVisibility(8);
        if (!this.i0) {
            K0(postData.t());
            if (z) {
                this.t.setVisibility(0);
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            }
        }
        this.v.setText(StringHelper.getFormatTime(postData.V()));
        String format = String.format(this.f23818f.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.A()));
        if (tVar.l() != null && tVar.l().H2()) {
            this.u.setText((CharSequence) null);
        } else {
            this.u.setText(format);
        }
        postData.t().getUserTbVipInfoData();
        boolean z0 = z0(this.w, postData.N());
        if (StringUtils.isNull(postData.z()) && !z0 && postData.Z() != null) {
            this.y.setVisibility(0);
            this.y.setTag(postData.Z());
            return;
        }
        this.y.setVisibility(8);
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.P.setVisibility(0);
        }
    }

    public void z(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048649, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.P;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f23818f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.delete_success));
            } else if (str == null || !z2) {
            } else {
                this.f23818f.showToast(str);
            }
        }
    }

    public final boolean z0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048650, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.y() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.y().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type == 17) {
                                    String str = next.z().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.x(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                } else if (type != 18 && type != 1282) {
                                }
                            }
                            tbRichTextData.R(true);
                            textView.setMovementMethod(c.a.r0.o4.b.a());
                        } else {
                            tbRichTextData.x(next.G());
                        }
                    }
                }
                if (!tbRichTextData.N()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.G() == null || tbRichTextData.G().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.G());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
