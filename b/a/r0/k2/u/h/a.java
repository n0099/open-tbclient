package b.a.r0.k2.u.h;

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
import b.a.q0.d1.m0;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.x0;
import b.a.q0.s.s.a;
import b.a.q0.s.s.b;
import b.a.r0.b0.m;
import b.a.r0.j.g;
import b.a.r0.j.j;
import b.a.r0.k2.r.s;
import b.a.r0.k2.s.c;
import b.a.r0.k2.u.h.b;
import b.a.r0.l3.a0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
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
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class a implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int s0;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public b.a.q0.s.g0.a B;
    public b.a.r0.k2.u.h.d C;
    public View D;
    public MorePopupWindow E;
    public View F;
    public b.a.q0.s.s.b G;
    public View H;
    public BlankView I;
    public View J;
    public Dialog K;
    public b.a.q0.s.s.a L;
    public View.OnClickListener M;
    public b.a.q0.s.s.b N;
    public boolean O;
    public ProgressBar P;
    public NewSubPbActivity.r0 Q;
    public NewSubPbActivity.r0 R;
    public b.a.q0.x.x.h S;
    public int T;
    public ArrayList<PostData> U;
    public s V;
    public TextView W;
    public RelativeLayout X;
    public ImageView Y;
    public ImageView Z;

    /* renamed from: a  reason: collision with root package name */
    public SubPbView f19575a;
    public LinearLayout a0;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f19576b;
    public HeadImageView b0;

    /* renamed from: c  reason: collision with root package name */
    public View f19577c;
    public View c0;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f19578d;
    public PbMoreDialog d0;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.k2.z.j f19579e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public NewSubPbActivity f19580f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f19581g;
    public SubPbModel g0;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f19582h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f19583i;
    public boolean i0;
    public RelativeLayout j;
    public b.a.r0.j.g j0;
    public NavigationBar k;
    public b.a.r0.j.j k0;
    public ImageView l;
    public b.a.r0.k2.u.h.c l0;
    public View m;
    public boolean m0;
    public TextView n;
    public f.g n0;
    public LinearLayout o;
    public MaskView o0;
    public HeadImageView p;
    public b.a.r0.k2.s.c p0;
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

    /* renamed from: b.a.r0.k2.u.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0974a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19584e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19585f;

        public RunnableC0974a(a aVar, boolean z) {
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
            this.f19585f = aVar;
            this.f19584e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19585f.f19578d.setEnabled(this.f19584e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19586e;

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
            this.f19586e = aVar;
        }

        @Override // b.a.r0.l3.a0.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.f19586e.T();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19587e;

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
            this.f19587e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            InterceptResult invokeCommon;
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                PostData postData = (PostData) ListUtils.getItem(this.f19587e.U, i2);
                if (view != null && view.getTag() != null) {
                    if (this.f19587e.d0 == null) {
                        this.f19587e.d0 = new PbMoreDialog(this.f19587e.f19580f.getPageContext(), this.f19587e.M);
                    }
                    this.f19587e.d0.showDialog();
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                        sparseArray = null;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                    PostData postData2 = sparseArray.get(b.a.r0.k2.i.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board) : null;
                    boolean z = this.f19587e.Z(sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                    this.f19587e.d0.confirmItems(sparseArray, this.f19587e.g0.B0(), z, this.f19587e.m0 && postData2 != null && postData2.o0, this.f19587e.g0.j0());
                    if (z) {
                        this.f19587e.d0.getReportTextView().setVisibility(0);
                        this.f19587e.d0.getReportTextView().setTag(postData.G());
                    } else {
                        this.f19587e.d0.getReportTextView().setVisibility(8);
                    }
                    this.f19587e.d0.getMarkTextView().setVisibility(8);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19588e;

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
            this.f19588e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) && this.f19588e.f19580f != null && ViewHelper.checkUpIsLogin(this.f19588e.f19580f.getPageContext().getPageActivity())) {
                if ((this.f19588e.f19580f.mReplyPrivacyController != null && this.f19588e.g0 != null && this.f19588e.g0.h0() != null && !this.f19588e.f19580f.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.f19588e.g0.h0().replyPrivateFlag)) || this.f19588e.g0 == null || this.f19588e.S == null) {
                    return;
                }
                this.f19588e.K0();
                if (view != null && (view.getTag() instanceof b.a)) {
                    this.f19588e.s();
                    this.f19588e.g0.c1();
                    return;
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(b.a.r0.k2.i.tag_photo_username);
                    String str2 = (String) sparseArray.get(b.a.r0.k2.i.tag_photo_userid);
                    String str3 = (String) sparseArray.get(b.a.r0.k2.i.tag_photo_portrait);
                    if (str != null) {
                        this.f19588e.S.W(str2);
                        this.f19588e.S.V(str, str3);
                    }
                }
                this.f19588e.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19589e;

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
            this.f19589e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19589e.I == null) {
                return;
            }
            this.f19589e.f19575a.onFinish();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19591f;

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
            this.f19591f = aVar;
            this.f19590e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int headerViewsCount = this.f19590e + this.f19591f.f19578d.getHeaderViewsCount();
                if (headerViewsCount >= 1) {
                    headerViewsCount--;
                }
                this.f19591f.f19578d.setSelection(headerViewsCount);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19592e;

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
            this.f19592e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19592e.g0 == null || (!this.f19592e.g0.J0() && !this.f19592e.g0.G0())) {
                    if (this.f19592e.I != null) {
                        this.f19592e.f19575a.onFinish();
                        return;
                    } else {
                        this.f19592e.f19580f.finish();
                        return;
                    }
                }
                this.f19592e.f19580f.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19593a;

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
            this.f19593a = aVar;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // b.a.r0.k2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                this.f19593a.x(false);
                this.f19593a.x(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19594e;

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
            this.f19594e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19594e.K != null && (this.f19594e.K instanceof Dialog)) {
                    b.a.e.e.m.g.b(this.f19594e.K, this.f19594e.f19580f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.f19594e.g0(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19595e;

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
            this.f19595e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19595e.K != null && (this.f19595e.K instanceof Dialog)) {
                    b.a.e.e.m.g.b(this.f19595e.K, this.f19595e.f19580f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null || this.f19595e.Q == null) {
                    return;
                }
                this.f19595e.Q.a(new Object[]{sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_portrait)});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19597f;

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
            this.f19597f = aVar;
            this.f19596e = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19597f.K != null && (this.f19597f.K instanceof Dialog)) {
                    b.a.e.e.m.g.b(this.f19597f.K, this.f19597f.f19580f.getPageContext());
                }
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.f19597f.f19580f.handleMuteClick(this.f19596e, (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid), sparseArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f19599f;

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
            this.f19599f = aVar;
            this.f19598e = sparseArray;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f19599f.R != null) {
                    this.f19599f.R.a(new Object[]{this.f19598e.get(b.a.r0.k2.i.tag_del_post_id), this.f19598e.get(b.a.r0.k2.i.tag_manage_user_identity), this.f19598e.get(b.a.r0.k2.i.tag_del_post_is_self), this.f19598e.get(b.a.r0.k2.i.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements g.InterfaceC0930g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19600a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19601b;

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
            this.f19601b = aVar;
            this.f19600a = sparseArray;
        }

        @Override // b.a.r0.j.g.InterfaceC0930g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.f19601b.R != null) {
                    this.f19601b.R.a(new Object[]{this.f19600a.get(b.a.r0.k2.i.tag_del_post_id), this.f19600a.get(b.a.r0.k2.i.tag_manage_user_identity), this.f19600a.get(b.a.r0.k2.i.tag_del_post_is_self), this.f19600a.get(b.a.r0.k2.i.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19602a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19603b;

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
            this.f19603b = aVar;
            this.f19602a = sparseArray;
        }

        @Override // b.a.r0.j.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.f19603b.R != null) {
                    this.f19603b.R.a(new Object[]{this.f19602a.get(b.a.r0.k2.i.tag_del_post_id), this.f19602a.get(b.a.r0.k2.i.tag_manage_user_identity), this.f19602a.get(b.a.r0.k2.i.tag_del_post_is_self), this.f19602a.get(b.a.r0.k2.i.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(526728185, "Lb/a/r0/k2/u/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(526728185, "Lb/a/r0/k2/u/h/a;");
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
        this.f19575a = null;
        this.f19577c = null;
        this.f19578d = null;
        this.f19579e = null;
        this.f19580f = null;
        this.f19581g = null;
        this.f19582h = null;
        this.f19583i = null;
        this.j = null;
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
        this.m0 = b.a.q0.b.d.m0();
        this.p0 = new b.a.r0.k2.s.c(new h(this));
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.f19580f = newSubPbActivity;
        this.M = onClickListener;
        this.f19575a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.new_sub_pb_layout, (ViewGroup) null);
        this.f19577c = LayoutInflater.from(this.f19580f.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.new_sub_pb_head, (ViewGroup) null);
        this.f19576b = (LinearLayout) this.f19575a.findViewById(b.a.r0.k2.i.navigation_bar_group);
        this.X = (RelativeLayout) this.f19575a.findViewById(b.a.r0.k2.i.subpb_editor_tool_comment);
        TextView textView = (TextView) this.f19575a.findViewById(b.a.r0.k2.i.subpb_editor_tool_comment_reply_text);
        this.W = textView;
        textView.setOnClickListener(this.M);
        this.Y = (ImageView) this.f19575a.findViewById(b.a.r0.k2.i.subpb_editor_tool_more_img);
        ImageView imageView = (ImageView) this.f19575a.findViewById(b.a.r0.k2.i.subpb_editor_tool_emotion_img);
        this.Z = imageView;
        imageView.setOnClickListener(this.M);
        this.Y.setOnClickListener(this.M);
        this.f19581g = (NoNetworkView) this.f19575a.findViewById(b.a.r0.k2.i.view_no_network);
        V();
        U();
        this.j = (RelativeLayout) this.f19575a.findViewById(b.a.r0.k2.i.sub_pb_body_layout);
        this.f19578d = (BdTypeListView) this.f19575a.findViewById(b.a.r0.k2.i.new_sub_pb_list);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f19580f.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.thread_skin_layout, (ViewGroup) null);
        this.A = threadSkinView;
        this.f19578d.addHeaderView(threadSkinView);
        this.f19578d.addHeaderView(this.f19577c);
        this.J = new TextView(newSubPbActivity.getActivity());
        this.J.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.f19578d.addHeaderView(this.J, 0);
        this.f19575a.setTopView(this.J);
        this.f19575a.setNavigationView(this.f19576b);
        this.f19575a.setListView(this.f19578d);
        this.f19575a.setContentView(this.j);
        b.a.r0.k2.u.h.d dVar = new b.a.r0.k2.u.h.d(this.f19580f.getPageContext());
        this.C = dVar;
        dVar.x();
        this.H = this.C.b();
        this.f19578d.setNextPage(this.C);
        this.C.B(this.M);
        this.f19578d.setOnItemClickListener(this.r0);
        this.f19578d.setOnItemLongClickListener(this.q0);
        this.f19578d.setOnTouchListener(this.p0);
        b.a.r0.k2.z.j jVar = new b.a.r0.k2.z.j(newSubPbActivity.getPageContext());
        this.f19579e = jVar;
        jVar.i();
        this.f19579e.a(this.n0);
        this.f19579e.C(TbadkCoreApplication.getInst().getSkinType());
        this.P = (ProgressBar) this.f19575a.findViewById(b.a.r0.k2.i.progress);
        this.o0 = (MaskView) this.f19575a.findViewById(b.a.r0.k2.i.mask_view);
        this.c0 = this.f19575a.findViewById(b.a.r0.k2.i.view_comment_top_line);
        this.a0 = (LinearLayout) this.f19575a.findViewById(b.a.r0.k2.i.pb_editer_tool_comment_layout);
        HeadImageView headImageView = (HeadImageView) this.f19575a.findViewById(b.a.r0.k2.i.pb_editor_tool_comment_user_image);
        this.b0 = headImageView;
        headImageView.setVisibility(0);
        this.b0.setIsRound(true);
        this.b0.setBorderWidth(b.a.e.e.p.l.g(this.f19580f, b.a.r0.k2.g.L_X01));
        this.b0.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
        this.b0.setDefaultBgResource(0);
        this.b0.setDefaultResource(b.a.r0.k2.f.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.b0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        e0(TbadkCoreApplication.getInst().getSkinType());
        View view = this.f19577c;
        if (view != null) {
            view.setVisibility(4);
        }
        View a2 = b.a.q0.e.c.b().a(this.f19580f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        b.a.r0.k2.u.h.c cVar = new b.a.r0.k2.u.h.c(this.f19580f, this.f19578d);
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

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.B == null) {
                this.B = new b.a.q0.s.g0.a(this.f19580f.getPageContext());
            }
            this.B.h(true);
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.q0.x.x.h hVar = this.S;
            if (hVar == null || hVar.a() == null) {
                return 0;
            }
            return this.S.a().getHeight();
        }
        return invokeV.intValue;
    }

    public final void B0(SparseArray<Object> sparseArray, b.a.r0.j.i iVar, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData h0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, sparseArray, iVar, userData) == null) || (newSubPbActivity = this.f19580f) == null || sparseArray == null || this.f19577c == null) {
            return;
        }
        if (this.k0 == null) {
            this.k0 = new b.a.r0.j.j(newSubPbActivity.getPageContext(), this.f19577c, iVar, userData);
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
        this.k0.E(new String[]{this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.k0.D(x0Var);
        this.k0.G("4");
        this.k0.F(new o(this, sparseArray));
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x : (View) invokeV.objValue;
    }

    public void C0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            W(NoDataViewFactory.e.d(null, this.f19580f.getResources().getString(b.a.r0.k2.l.refresh_view_title_text)));
            this.X.setVisibility(8);
        }
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public void D0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            if (z) {
                W(NoDataViewFactory.e.d("", str));
            } else {
                W(NoDataViewFactory.e.d(str, this.f19580f.getPageContext().getString(b.a.r0.k2.l.refresh_view_title_text)));
            }
            this.X.setVisibility(8);
        }
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19577c : (View) invokeV.objValue;
    }

    public void E0(b.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) {
            b.a.q0.s.s.b bVar = this.N;
            if (bVar != null) {
                bVar.e();
                this.N = null;
            }
            b.a.q0.s.s.b bVar2 = new b.a.q0.s.s.b(this.f19580f.getPageContext().getPageActivity());
            this.N = bVar2;
            if (z) {
                bVar2.j(new String[]{this.f19580f.getPageContext().getString(b.a.r0.k2.l.save_to_emotion)}, cVar);
            } else {
                bVar2.j(new String[]{this.f19580f.getPageContext().getString(b.a.r0.k2.l.save_to_emotion), this.f19580f.getPageContext().getString(b.a.r0.k2.l.save_to_local)}, cVar);
            }
            this.N.c(this.f19580f.getPageContext());
            this.N.m();
        }
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public final void F0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData h0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || (newSubPbActivity = this.f19580f) == null || sparseArray == null || this.f19577c == null) {
            return;
        }
        if (this.j0 == null) {
            this.j0 = new b.a.r0.j.g(newSubPbActivity.getPageContext(), this.f19577c);
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
        this.j0.y(new String[]{this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f19580f.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.j0.x(x0Var);
        this.j0.A("4");
        this.j0.z(new n(this, sparseArray));
    }

    public ListView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f19578d : (ListView) invokeV.objValue;
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f19578d.setNextPage(this.C);
            this.C.Q();
        }
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.H : (View) invokeV.objValue;
    }

    public void H0(s sVar, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{sVar, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || sVar == null) {
            return;
        }
        if (this.i0 && (view = this.f19577c) != null) {
            view.setVisibility(8);
            this.f19578d.removeHeaderView(this.f19577c);
            this.e0 = 1;
        }
        this.V = sVar;
        if (sVar.i() != null) {
            this.V.i().o0 = true;
        }
        View view2 = this.f19577c;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (sVar.l() != null && sVar.l().D2()) {
            this.n.setText(b.a.r0.k2.l.view_original);
        } else {
            this.n.setText(b.a.r0.k2.l.view_subject);
        }
        if (sVar.i() != null) {
            int A = sVar.i().A();
            this.T = A;
            if (A > 0) {
                this.k.setCenterTextTitle(String.format(this.f19580f.getResources().getString(b.a.r0.k2.l.subpb_floor_reply), Integer.valueOf(this.T)));
                NewSubPbActivity newSubPbActivity = this.f19580f;
                if (newSubPbActivity != null) {
                    this.W.setText(newSubPbActivity.getReplyHint());
                }
            } else {
                this.k.setCenterTextTitle(this.f19580f.getResources().getString(b.a.r0.k2.l.local_floor_reply));
            }
            String str = this.f19580f.isFromPb() ? "PB" : null;
            if (sVar.i().N() != null) {
                this.A.setData(this.f19580f.getPageContext(), sVar.i().N(), b.a.r0.l3.l0.a.a("PB", "c0132", sVar.d().getId(), sVar.d().getName(), sVar.l().f0(), str));
            } else {
                this.A.setData(null, null, null);
            }
        }
        if (sVar.o()) {
            this.C.Q();
            this.l0.g(true);
        } else {
            this.C.f();
            this.l0.g(false);
        }
        ArrayList<PostData> k2 = sVar.k();
        this.U = k2;
        if (k2 == null || k2.size() <= s0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int size = this.U.size() - s0;
            j0(size);
            int firstVisiblePosition = this.f19578d.getFirstVisiblePosition() - size;
            View childAt = this.f19578d.getChildAt(0);
            i3 = size;
            i4 = firstVisiblePosition;
            i5 = childAt == null ? 0 : childAt.getTop();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.U);
        if (ListUtils.isEmpty(this.U)) {
            this.f19578d.setNextPage(null);
            if (this.i0) {
                arrayList.add(0, new b.a.r0.k2.u.h.g.a());
            }
        } else {
            this.f19578d.setNextPage(this.C);
        }
        b.a.r0.k2.u.h.g.b bVar = new b.a.r0.k2.u.h.g.b();
        bVar.d(sVar.m());
        arrayList.add(0, bVar);
        if (this.i0) {
            arrayList.add(0, sVar.i());
        }
        NewSubPbActivity newSubPbActivity2 = this.f19580f;
        if (newSubPbActivity2 != null && newSubPbActivity2.getSubPbModel() != null) {
            this.o0.setVisibility(this.f19580f.getSubPbModel().K0() ? 0 : 8);
        }
        this.l0.e(this.V.l(), arrayList);
        y(sVar, sVar.i(), sVar.e(), sVar.f(), i2, z);
        if (i3 > 0) {
            this.f19578d.setSelectionFromTop(i4, i5);
        } else if (z2 && !b.a.e.e.p.k.isEmpty(this.f19580f.getSubPbModel().p0())) {
            String p0 = this.f19580f.getSubPbModel().p0();
            int i6 = 0;
            while (true) {
                if (i6 < arrayList.size()) {
                    if ((arrayList.get(i6) instanceof PostData) && p0.equals(((PostData) arrayList.get(i6)).G())) {
                        this.f19578d.post(new f(this, i6));
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
        }
        if (this.V.j() > 1) {
            this.f19578d.setPullRefresh(this.f19579e);
            this.f19575a.setEnableDragExit(false);
            return;
        }
        this.f19578d.setPullRefresh(null);
        this.f19575a.setEnableDragExit(true);
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l0.a() : invokeV.booleanValue;
    }

    public PbMoreDialog J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.d0 : (PbMoreDialog) invokeV.objValue;
    }

    public final void J0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, metaData) == null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        if (m0.b(name_show) + (!StringUtils.isNull(metaData.getSealPrefix()) ? b.a.e.e.p.k.byteLength(metaData.getSealPrefix()) + 2 : 0) > 14) {
            String j2 = m0.j(name_show, 0, 14);
            if (j2.length() == name_show.length()) {
                name_show = j2;
            } else {
                name_show = j2 + "...";
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(Q(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                b.a.q0.e.b bVar = new b.a.q0.e.b();
                bVar.f12206a = metaData.getAlaUserData();
                bVar.f12207b = 4;
                this.r.setTag(bVar);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, b.a.r0.k2.f.cp_cont_r);
        } else if (b.a.q0.b.d.F()) {
            b.a.q0.s.u.c.d(this.q).v(b.a.r0.k2.f.CAM_X0108);
        } else {
            b.a.q0.s.u.c.d(this.q).v(b.a.r0.k2.f.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(b.a.r0.k2.h.transparent_bg);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.startLoad(metaData.getAvater(), 28, false);
        this.o.setTag(b.a.r0.k2.i.tag_user_id, metaData.getUserId());
        this.o.setTag(b.a.r0.k2.i.tag_user_name, metaData.getUserName());
        this.o.setTag(b.a.r0.k2.i.tag_virtual_user_url, metaData.getVirtualUserUrl());
    }

    public ImageView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.Z : (ImageView) invokeV.objValue;
    }

    public void K0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bdTypeListView = this.f19578d) == null) {
            return;
        }
        this.f0 = bdTypeListView.getLastVisiblePosition();
    }

    public ImageView L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.Y : (ImageView) invokeV.objValue;
    }

    public void L0(boolean z) {
        PbMoreDialog pbMoreDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (pbMoreDialog = this.d0) == null || pbMoreDialog.getMarkTextView() == null) {
            return;
        }
        if (z) {
            this.d0.getMarkTextView().setText(b.a.r0.k2.l.remove_mark);
        } else {
            this.d0.getMarkTextView().setText(b.a.r0.k2.l.mark);
        }
    }

    public MorePopupWindow M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.E : (MorePopupWindow) invokeV.objValue;
    }

    public TextView N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.W : (TextView) invokeV.objValue;
    }

    public TextView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.w : (TextView) invokeV.objValue;
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f19575a : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder Q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, b.a.r0.k2.h.pic_smalldot_title));
            return b.a.r0.b0.m.h(this.f19580f.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void R() {
        b.a.q0.s.g0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.h(false);
    }

    public void S() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (noDataView = this.f19582h) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f19578d.setVisibility(0);
        this.X.setVisibility(0);
        this.f19575a.setOnTouchListener(null);
    }

    public void T() {
        b.a.q0.x.x.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.W == null || (hVar = this.S) == null) {
            return;
        }
        if (hVar.w()) {
            this.W.setText(b.a.r0.k2.l.draft_to_send);
        } else {
            this.W.setText(this.f19580f.getReplyHint());
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f19577c.findViewById(b.a.r0.k2.i.subpb_head_user_info_root);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.M);
            HeadImageView headImageView = (HeadImageView) this.f19577c.findViewById(b.a.r0.k2.i.photo);
            this.p = headImageView;
            headImageView.setRadius(b.a.e.e.p.l.g(this.f19580f.getActivity(), b.a.r0.k2.g.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.f19577c.findViewById(b.a.r0.k2.i.user_name);
            ImageView imageView = (ImageView) this.f19577c.findViewById(b.a.r0.k2.i.user_rank);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.f19577c.findViewById(b.a.r0.k2.i.floor_owner);
            TextView textView = (TextView) this.f19577c.findViewById(b.a.r0.k2.i.see_subject);
            this.n = textView;
            textView.setOnClickListener(this.M);
            this.u = (TextView) this.f19577c.findViewById(b.a.r0.k2.i.floor);
            this.v = (TextView) this.f19577c.findViewById(b.a.r0.k2.i.time);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.f19577c.findViewById(b.a.r0.k2.i.content_text);
            this.w = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.M);
            SkinManager.setViewTextColor(this.w, b.a.r0.k2.f.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0304));
            this.w.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.f19577c.findViewById(b.a.r0.k2.i.sub_pb_image);
            this.x = tbImageView;
            tbImageView.setOnClickListener(this.M);
            this.z = (TextView) this.f19577c.findViewById(b.a.r0.k2.i.advert);
            this.y = (PlayVoiceBntNew) this.f19577c.findViewById(b.a.r0.k2.i.voice_btn);
            this.f19577c.setOnTouchListener(this.p0);
            this.f19577c.setOnClickListener(this.M);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            int g2 = b.a.e.e.p.l.g(this.f19580f.getPageContext().getPageActivity(), b.a.r0.k2.g.ds88);
            int g3 = b.a.e.e.p.l.g(this.f19580f.getPageContext().getPageActivity(), b.a.r0.k2.g.ds2);
            NavigationBar navigationBar = (NavigationBar) this.f19575a.findViewById(b.a.r0.k2.i.view_navigation_bar);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            ImageView backImageView = this.k.getBackImageView();
            this.l = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = g2;
                layoutParams.width = g2;
                layoutParams.leftMargin = g3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.m;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.width = g2;
                layoutParams2.height = g2;
                this.m.setLayoutParams(layoutParams2);
            }
            this.k.hideBottomLine();
        }
    }

    public final void W(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f19580f.getPageContext().getString(b.a.r0.k2.l.refresh_view_button_text), this.f19583i));
            if (this.f19582h == null) {
                Activity pageActivity = this.f19580f.getPageContext().getPageActivity();
                this.f19582h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, b.a.e.e.p.l.g(pageActivity, b.a.r0.k2.g.ds250)), eVar, a2);
            }
            this.f19578d.setVisibility(8);
            this.P.setVisibility(8);
            this.S.y();
            SkinManager.setBackgroundColor(this.f19582h, b.a.r0.k2.f.CAM_X0201);
            this.f19582h.setClickable(true);
            this.f19582h.setTextOption(eVar);
            this.f19582h.onChangeSkinType(this.f19580f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f19582h.setVisibility(0);
        }
    }

    public void X(b.a.q0.x.x.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, hVar) == null) || hVar == null || hVar.a() == null) {
            return;
        }
        this.S = hVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.j.addView(hVar.a(), layoutParams);
        this.S.R(new b(this));
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f19575a.isDrag() : invokeV.booleanValue;
    }

    public final boolean Z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
            SubPbModel subPbModel = this.g0;
            if (subPbModel == null || subPbModel.j0() == null) {
                return false;
            }
            if (this.g0.B0() != 0) {
                return false;
            }
            s sVar = this.V;
            return (sVar == null || sVar.l() == null || this.V.l().J() == null || !TextUtils.equals(this.V.l().J().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
        }
    }

    public void a0() {
        b.a.r0.k2.u.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (cVar = this.l0) == null) {
            return;
        }
        cVar.c();
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            SubPbView subPbView = this.f19575a;
            if (subPbView != null) {
                subPbView.onDestroy();
            }
            b.a.q0.x.x.h hVar = this.S;
            if (hVar != null) {
                hVar.D();
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.f19580f.getLayoutMode().k(i2 == 1);
            this.f19580f.getLayoutMode().j(this.f19575a);
            this.f19580f.getLayoutMode().j(this.f19577c);
            SkinManager.setBackgroundColor(this.f19575a, b.a.r0.k2.f.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, b.a.r0.k2.f.CAM_X0201);
            this.k.onChangeSkinType(this.f19580f.getPageContext(), i2);
            SubPbModel subPbModel = this.g0;
            if (subPbModel != null && (subPbModel.J0() || this.g0.G0())) {
                WebPManager.setPureDrawable(this.l, b.a.r0.k2.h.icon_pure_topbar_return40, b.a.r0.k2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, b.a.r0.k2.h.icon_pure_topbar_close44, b.a.r0.k2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, b.a.r0.k2.f.goto_see_subject_color);
            }
            this.f19581g.onChangeSkinType(this.f19580f.getPageContext(), i2);
            this.f19580f.getLayoutMode().j(this.H);
            SkinManager.setViewTextColor(this.w, b.a.r0.k2.f.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0304));
            b.a.q0.x.x.h hVar = this.S;
            if (hVar != null && hVar.a() != null) {
                this.S.a().onChangeSkinType(i2);
            }
            this.C.d(i2);
            this.y.changeSkin();
            SkinManager.setViewTextColor(this.W, b.a.r0.k2.f.CAM_X0110);
            SkinManager.setViewTextColor(this.t, b.a.r0.k2.f.CAM_X0302);
            if (b.a.q0.b.d.F()) {
                b.a.q0.s.u.c.d(this.q).A(b.a.r0.k2.l.F_X02);
                b.a.q0.s.u.c.d(this.q).v(b.a.r0.k2.f.CAM_X0108);
            } else {
                b.a.q0.s.u.c.d(this.q).A(b.a.r0.k2.l.F_X01);
                SkinManager.setViewTextColor(this.q, b.a.r0.k2.f.CAM_X0106);
            }
            this.W.setAlpha(0.95f);
            if (this.D != null) {
                b.a.q0.w0.a.a(this.f19580f.getPageContext(), this.D);
            }
            b.a.r0.k2.u.h.c cVar = this.l0;
            if (cVar != null) {
                cVar.c();
            }
            this.f19580f.getLayoutMode().j(this.F);
            SkinManager.setBackgroundColor(this.c0, b.a.r0.k2.f.CAM_X0203);
            this.b0.setBorderColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0401));
            this.a0.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.e.p.l.g(this.f19580f, b.a.r0.k2.g.tbds47), SkinManager.getColor(b.a.r0.k2.f.CAM_X0209)));
            b.a.q0.s.u.c.d(this.X).f(b.a.r0.k2.f.CAM_X0208);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || this.f19580f.isPaused()) {
        }
    }

    public void g0(int i2, String str, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z));
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
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f19580f.getPageContext().getPageActivity());
            this.L = aVar;
            aVar.setMessageId(i4);
            this.L.setYesButtonTag(sparseArray);
            this.L.setPositiveButton(b.a.r0.k2.l.dialog_ok, new l(this, sparseArray));
            this.L.setNegativeButton(b.a.r0.k2.l.dialog_cancel, new m(this));
            this.L.setCancelable(true);
            this.L.create(this.f19580f.getPageContext());
            if (z2) {
                this.L.show();
            } else if (z) {
                this.L.show();
            } else if (1 == this.g0.l0()) {
                b.a.r0.j.i iVar = new b.a.r0.j.i(this.g0.l0(), this.g0.k0(), this.g0.o0());
                iVar.i(this.V.d().getId(), this.V.d().getName());
                iVar.h(this.g0.m0());
                iVar.j(this.g0.C0());
                UserData userData = new UserData();
                userData.setIsManager(this.g0.q0());
                B0(sparseArray, iVar, userData);
            } else {
                F0(sparseArray);
            }
        }
    }

    public void h0(SparseArray<Object> sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048622, this, sparseArray, z) == null) {
            boolean z2 = true;
            if (this.K == null) {
                Dialog dialog = new Dialog(this.f19580f.getPageContext().getPageActivity(), b.a.r0.k2.m.common_alert_dialog);
                this.K = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.K.setCancelable(true);
                this.F = LayoutInflater.from(this.f19580f.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.forum_manage_dialog, (ViewGroup) null);
                this.f19580f.getLayoutMode().j(this.F);
                this.K.setContentView(this.F);
                WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
                attributes.width = (int) (b.a.e.e.p.l.k(this.f19580f.getPageContext().getPageActivity()) * 0.9d);
                this.K.getWindow().setAttributes(attributes);
            }
            TextView textView = (TextView) this.K.findViewById(b.a.r0.k2.i.del_post_btn);
            TextView textView2 = (TextView) this.K.findViewById(b.a.r0.k2.i.forbid_user_btn);
            TextView textView3 = (TextView) this.K.findViewById(b.a.r0.k2.i.disable_reply_btn);
            int intValue = sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(b.a.r0.k2.i.tag_del_post_id)) && intValue != 2) {
                SparseArray sparseArray2 = (SparseArray) textView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    textView.setTag(sparseArray2);
                }
                textView.setVisibility(0);
                int i2 = b.a.r0.k2.i.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = b.a.r0.k2.i.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = b.a.r0.k2.i.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = b.a.r0.k2.i.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                textView.setOnClickListener(new i(this));
            } else {
                textView.setVisibility(8);
            }
            if ("".equals(sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name)) && "".equals(sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show))) {
                textView2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) textView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    textView2.setTag(sparseArray3);
                }
                textView2.setVisibility(0);
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
                textView2.setOnClickListener(new j(this));
            }
            if (!(((sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) ? false : false)) {
                textView3.setVisibility(8);
            } else {
                SparseArray sparseArray4 = (SparseArray) textView3.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    textView3.setTag(sparseArray4);
                }
                textView3.setVisibility(0);
                if (z) {
                    textView3.setText(b.a.r0.k2.l.un_mute);
                } else {
                    textView3.setText(b.a.r0.k2.l.mute);
                }
                int i11 = b.a.r0.k2.i.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = b.a.r0.k2.i.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = b.a.r0.k2.i.tag_user_mute_post_id;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = b.a.r0.k2.i.tag_user_mute_thread_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                sparseArray4.put(i16, sparseArray.get(i16));
                textView3.setOnClickListener(new k(this, z));
            }
            b.a.e.e.m.g.j(this.K, this.f19580f.getPageContext());
        }
    }

    public void i0(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        h0(sparseArray, false);
    }

    public final void j0(int i2) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (arrayList = this.U) == null) {
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

    public void k0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, r0Var) == null) {
            this.R = r0Var;
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f19578d.setVisibility(0);
            this.P.setVisibility(8);
            this.C.f();
        }
    }

    public void m0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, r0Var) == null) {
            this.Q = r0Var;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.i0 = z;
        }
    }

    public void o0(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, gVar) == null) {
            this.n0 = gVar;
            b.a.r0.k2.z.j jVar = this.f19579e;
            if (jVar != null) {
                jVar.a(gVar);
            }
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.f19578d.setVisibility(0);
            this.P.setVisibility(8);
            this.C.R();
        }
    }

    public void q0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, subPbModel) == null) {
            this.g0 = subPbModel;
        }
    }

    public void r(boolean z) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048632, this, z) == null) || (subPbModel = this.g0) == null || !subPbModel.I0() || z) {
            return;
        }
        this.k.setIsClose(true);
        this.k.setIsCorner(true);
        this.k.isShowBottomLine(true);
        this.k.setBottomLineHeight(3);
        this.k.setStatusBarVisibility(8);
        this.I = new BlankView(this.f19580f.getPageContext().getPageActivity());
        if (this.g0.J0()) {
            this.h0 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds562) + UtilHelper.getStatusBarHeight();
        } else {
            this.h0 = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds160);
        }
        this.f19576b.addView(this.I, 0, new LinearLayout.LayoutParams(-1, this.h0));
        this.I.setVisibility(0);
        this.I.setOnClickListener(new e(this));
        this.f19575a.setBlankView(this.I);
    }

    public void r0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, zVar) == null) {
            this.l0.i(zVar);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            v0(this.f19580f);
            this.f19578d.setNextPage(this.C);
        }
    }

    public void s0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onLongClickListener) == null) {
            this.l0.h(onLongClickListener);
        }
    }

    public void t(boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z) == null) || (headImageView = this.b0) == null) {
            return;
        }
        headImageView.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onClickListener) == null) {
            this.f19583i = onClickListener;
        }
    }

    public void u() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || this.g0 == null) {
            return;
        }
        if ((!I0() && (view = this.H) != null && view.isShown()) || ListUtils.isEmpty(this.U)) {
            this.g0.Y0(false);
        } else {
            this.g0.Y0(true);
        }
    }

    public void u0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onScrollListener) == null) {
            this.f19578d.setOnScrollListener(onScrollListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024c  */
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
        if (!(interceptable == null || interceptable.invokeLIL(1048640, this, postData, i2, sparseArray) == null) || postData == null) {
            return;
        }
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        boolean z6 = true;
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
        s sVar = this.V;
        if (sVar != null && sVar.l() != null && this.V.l().J() != null && postData.t() != null) {
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
                        sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(b.a.r0.k2.i.tag_forbid_user_post_id, postData.G());
                        if (postData.t() != null) {
                            sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(b.a.r0.k2.i.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name, "");
                        sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name_show, "");
                        sparseArray.put(b.a.r0.k2.i.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.TRUE);
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_id, postData.G());
                    } else {
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.FALSE);
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_type, 0);
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_id, "");
                        z6 = z5;
                    }
                    sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(b.a.r0.k2.i.tag_forbid_user_post_id, postData.G());
                    if (z) {
                        sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i2));
                        if (postData.t() != null) {
                            sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(b.a.r0.k2.i.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(b.a.r0.k2.i.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                    } else {
                        sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(b.a.r0.k2.i.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(b.a.r0.k2.i.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(b.a.r0.k2.i.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(b.a.r0.k2.i.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.V.l() != null) {
                            sparseArray.put(b.a.r0.k2.i.tag_user_mute_thread_id, this.V.l().f0());
                        }
                        sparseArray.put(b.a.r0.k2.i.tag_user_mute_post_id, postData.G());
                    } else {
                        sparseArray.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(b.a.r0.k2.i.tag_del_post_id, postData.G());
                        sparseArray.put(b.a.r0.k2.i.tag_has_sub_post, Boolean.valueOf(postData.a0()));
                        return;
                    }
                    sparseArray.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.FALSE);
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
                sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.valueOf(z6));
                sparseArray.put(b.a.r0.k2.i.tag_forbid_user_post_id, postData.G());
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
        sparseArray.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.valueOf(z6));
        sparseArray.put(b.a.r0.k2.i.tag_forbid_user_post_id, postData.G());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void v0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, pVar) == null) {
            this.f19578d.setOnSrollToBottomListener(pVar);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            MorePopupWindow morePopupWindow = this.E;
            if (morePopupWindow != null) {
                b.a.e.e.m.g.d(morePopupWindow, this.f19580f.getPageContext().getPageActivity());
            }
            b.a.q0.s.s.b bVar = this.G;
            if (bVar != null) {
                bVar.e();
            }
            b.a.q0.s.s.a aVar = this.L;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.K;
            if (dialog != null) {
                b.a.e.e.m.g.b(dialog, this.f19580f.getPageContext());
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

    public void w0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, view) == null) {
            this.D = view;
        }
    }

    public final void x(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048644, this, z) == null) || (bdTypeListView = this.f19578d) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new RunnableC0974a(this, z), 10L);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.P.setVisibility(0);
        }
    }

    public void y(s sVar, PostData postData, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{sVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) || postData == null || this.i0) {
            return;
        }
        if (!StringUtils.isNull(postData.z())) {
            this.x.setVisibility(0);
            this.x.startLoad(postData.z(), 10, true);
        } else {
            this.x.setVisibility(8);
        }
        b.a.r0.l3.j0.i v = postData.v();
        if (v != null && v.f20611a) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        SparseArray<Object> sparseArray = (SparseArray) this.f19577c.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f19577c.setTag(sparseArray);
        }
        sparseArray.clear();
        sparseArray.put(b.a.r0.k2.i.tag_clip_board, postData);
        sparseArray.put(b.a.r0.k2.i.tag_is_subpb, Boolean.FALSE);
        v(postData, i2, sparseArray);
        this.u.setText((CharSequence) null);
        this.q.setText((CharSequence) null);
        this.t.setVisibility(8);
        if (!this.i0) {
            J0(postData.t());
            if (z) {
                this.t.setVisibility(0);
                SkinManager.setViewTextColor(this.t, b.a.r0.k2.f.CAM_X0302);
            }
        }
        this.v.setText(StringHelper.getFormatTime(postData.U()));
        String format = String.format(this.f19580f.getPageContext().getString(b.a.r0.k2.l.is_floor), Integer.valueOf(postData.A()));
        if (sVar.l() != null && sVar.l().D2()) {
            this.u.setText((CharSequence) null);
        } else {
            this.u.setText(format);
        }
        postData.t().getUserTbVipInfoData();
        boolean y0 = y0(this.w, postData.M());
        if (StringUtils.isNull(postData.z()) && !y0 && postData.Y() != null) {
            this.y.setVisibility(0);
            this.y.setTag(postData.Y());
            return;
        }
        this.y.setVisibility(8);
    }

    public final boolean y0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048647, this, textView, tbRichText)) == null) {
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
                            textView.setMovementMethod(b.a.r0.c4.b.a());
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

    public void z(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.P;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f19580f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(b.a.r0.k2.l.delete_success));
            } else if (str == null || !z2) {
            } else {
                this.f19580f.showToast(str);
            }
        }
    }

    public void z0(PostData postData) {
        int i2;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048649, this, postData) == null) || postData == null) {
            return;
        }
        postData.s0(true);
        PostData postData2 = new PostData();
        postData2.w0(52);
        if (!I0() && (view = this.H) != null && view.isShown()) {
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
        this.f19578d.smoothScrollToPosition(this.f0 + 2);
        this.f19578d.setNextPage(null);
    }
}
