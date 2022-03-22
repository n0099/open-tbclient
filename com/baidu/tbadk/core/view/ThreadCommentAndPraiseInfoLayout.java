package com.baidu.tbadk.core.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.x;
import c.a.p0.f1.l;
import c.a.p0.f1.m0;
import c.a.p0.h0.c0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes5.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData A;
    public Context B;
    public TbPageContext C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public int N;
    public String O;
    public int P;
    public String Q;
    public String R;
    public String S;
    public View.OnClickListener T;
    public int U;
    public View V;
    public MaskView W;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30122b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30123c;

    /* renamed from: d  reason: collision with root package name */
    public AgreeView f30124d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f30125e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f30126f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f30127g;
    public j g0;

    /* renamed from: h  reason: collision with root package name */
    public View f30128h;
    public LinearLayout h0;
    public EMTextView i;
    public i i0;
    public ImageView j;
    public boolean j0;
    public View k;
    public CustomMessageListener k0;
    public FrameLayout l;
    public CustomMessageListener l0;
    public ImageView m;
    public EMTextView n;
    public ImageView o;
    public View p;
    public c0 q;
    public LinearLayout r;
    public ImageView s;
    public EMTextView t;
    public LinearLayout u;
    public ImageView v;
    public EMTextView w;
    public ImageView x;
    public EMTextView y;
    public LinearLayout z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.T != null) {
                    this.a.T.onClick(view);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
                threadCommentAndPraiseInfoLayout.g(view, threadCommentAndPraiseInfoLayout.A);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public b(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.a.x.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public c(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.x.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public d(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.x.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public e(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.a.x.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public f(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.x.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ThreadData)) {
                return;
            }
            ThreadData threadData = (ThreadData) customResponsedMessage.getData();
            if (this.a.A == null || threadData == null) {
                return;
            }
            String str = threadData.getBaijiahaoData() != null ? threadData.getBaijiahaoData().oriUgcNid : "";
            String str2 = this.a.A.getBaijiahaoData() != null ? this.a.A.getBaijiahaoData().oriUgcNid : "";
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (str.equals(str2)) {
                    this.a.A.setReply_num(threadData.getReply_num());
                    this.a.I(threadData);
                    return;
                }
                return;
            }
            String id = threadData.getId();
            String id2 = this.a.A.getId();
            if ("0".equals(id2) || TextUtils.isEmpty(id2) || !id2.equals(id)) {
                return;
            }
            this.a.A.setReply_num(threadData.getReply_num());
            this.a.I(threadData);
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str) || (threadData = this.a.A) == null || "0".equals(threadData.getId()) || !str.equals(this.a.A.getId())) {
                return;
            }
            if ((this.a.A.isLiveThread() || this.a.A.isSharedLiveThread()) && this.a.A.getThreadAlaInfo() != null) {
                if (this.a.A.getThreadAlaInfo() != null && this.a.A.getThreadAlaInfo().share_info != null) {
                    this.a.A.getThreadAlaInfo().share_info.share_count++;
                }
            } else {
                ThreadData threadData2 = this.a.A;
                threadData2.setShareNum(threadData2.getShareNum() + 1);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
            threadCommentAndPraiseInfoLayout.L(threadCommentAndPraiseInfoLayout.A);
        }
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes5.dex */
    public interface j {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.f(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = 2;
        this.M = 1;
        this.U = 3;
        this.g0 = null;
        this.j0 = true;
        this.k0 = new g(this, 2921416);
        this.l0 = new h(this, 2921417);
        n(context);
    }

    private BdUniqueId getPageUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            TbPageContext tbPageContext = this.C;
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    private int getShareObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i2 = this.M;
            if (i2 == 1) {
                return 5;
            }
            if (i2 == 3) {
                return 3;
            }
            if (i2 == 4) {
                return 4;
            }
            if (i2 == 6) {
                return 8;
            }
            if (i2 == 10) {
                return 16;
            }
            if (i2 == 11) {
                return 24;
            }
            if (i2 == 12) {
                return 20;
            }
            return i2 == 13 ? 30 : 0;
        }
        return invokeV.intValue;
    }

    private int getThreadSourceForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            int i2 = this.L;
            if (i2 == 4 || i2 == 9) {
                return 1;
            }
            if (i2 == 1) {
                return 2;
            }
            return (i2 == 8 || i2 == 13) ? 3 : 0;
        }
        return invokeV.intValue;
    }

    private int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            ThreadData threadData = this.A;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isShareThread) {
                return 4;
            }
            if (threadData.getThreadType() == 49 || this.A.getThreadType() == 69) {
                return 5;
            }
            if (this.A.getThreadVideoInfo() != null) {
                return 1;
            }
            if (this.A.getType() == ThreadData.TYPE_NORMAL || this.A.getType() == ThreadData.TYPE_GOD_NORMAL) {
                return ListUtils.getCount(this.A.getVoice()) > 0 ? 3 : 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ThreadData threadData = this.A;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 1;
            }
            if (this.A.isBJHVideoThreadType()) {
                return 2;
            }
            if (this.A.isBJHNormalThreadType()) {
                return 3;
            }
            return this.A.isBJHVideoDynamicThreadType() ? 4 : 0;
        }
        return invokeV.intValue;
    }

    public void A(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if ((ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.B)) && this.A != null) {
                B();
                g(view, this.A);
                if (AntiHelper.e(getContext(), this.A)) {
                    return;
                }
                C();
                View.OnClickListener onClickListener = this.T;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.A == null) {
            return;
        }
        StatisticItem e2 = e();
        e2.param("thread_type", this.A.getThreadType());
        TiebaStatic.log(e2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0334  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C() {
        ThreadData threadData;
        String tid;
        String str;
        String str2;
        boolean z;
        boolean z2;
        Uri parse;
        String format;
        ShareItem shareItem;
        OriginalThreadInfo.ShareInfo generateShareInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (threadData = this.A) == null || this.B == null) {
            return;
        }
        String valueOf = String.valueOf(threadData.getFid());
        String forum_name = this.A.getForum_name();
        OriginalForumInfo originalForumInfo = this.A.mOriginalForumInfo;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            forum_name = originalForumInfo.ori_fname;
        }
        String str3 = forum_name;
        String str4 = valueOf;
        String title = this.A.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.A.getAbstract();
        }
        String str5 = title;
        if (this.A.isUgcThreadType()) {
            tid = this.A.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + this.A.getBaijiahaoData().oriUgcType + "&dvid=" + this.A.getBaijiahaoData().oriUgcVid + "&nid=" + this.A.getBaijiahaoData().oriUgcNid;
        } else {
            tid = this.A.getTid();
            str = "?share=9105&fr=sharewise";
        }
        String str6 = str;
        String str7 = tid;
        String str8 = str6 + "&share_from=post";
        if (this.A.getVoiceRoomData() != null && this.A.getVoiceRoomData().room_id.longValue() > 0) {
            str2 = String.format("http://tieba.baidu.com/mo/q/wise-main-share/shareVoiceRoom?room_id=%s", String.valueOf(this.A.getVoiceRoomData().room_id));
            z = true;
        } else {
            str2 = "http://tieba.baidu.com/p/" + str7 + str8;
            z = false;
        }
        if (this.A.getThreadAlaInfo() != null && this.A.getThreadAlaInfo().user_info != null) {
            try {
                str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.A.getThreadAlaInfo().user_info.user_name, IMAudioTransRequest.CHARSET);
                z2 = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (this.A.getThreadAlaInfo() != null && this.A.getThreadAlaInfo().isLegalYYLiveData()) {
                str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.A.getThreadAlaInfo().mYyExtData.mSid + "&livessid=" + this.A.getThreadAlaInfo().mYyExtData.mSsid + "&uid=" + this.A.getThreadAlaInfo().mYyExtData.mYyUid;
                z2 = false;
            }
            String j2 = j(this.A);
            parse = j2 != null ? null : Uri.parse(j2);
            String str9 = this.A.getAbstract();
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f110f);
            String string2 = getResources().getString(R.string.obfuscated_res_0x7f0f047a);
            if (!this.A.isUgcThreadType() && this.A.getAuthor() != null) {
                format = (TextUtils.isEmpty(this.A.getTitle()) || TextUtils.isEmpty(str9)) ? MessageFormat.format(string2, this.A.getAuthor().getName_show(), getResources().getString(R.string.obfuscated_res_0x7f0f047b)) : str9;
            } else if (!z) {
                StringBuilder sb = new StringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1526));
                if (this.A.getForumData() != null && !StringUtils.isNull(this.A.getForumData().f10991b)) {
                    sb.insert(0, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1527), this.A.getForumData().f10991b));
                }
                format = sb.toString();
            } else {
                format = MessageFormat.format(string, str5, str9);
            }
            int k = c.a.o0.s.g.g.k(this.A);
            String cutString = m.cutString(str5, 100);
            String cutString2 = m.cutString(format, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            if (!this.A.isUgcThreadType()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (k == 2 && this.A.getThreadVideoInfo() != null) {
                    shareItem.R = this.A.getThreadVideoInfo().play_count.intValue();
                } else if (k == 1) {
                    shareItem.R = this.A.getView_num();
                }
                shareItem.D = str9;
            }
            shareItem.t = str2;
            shareItem.q = str7;
            shareItem.J = str4;
            shareItem.p = str3;
            shareItem.K = str7;
            shareItem.f30356f = true;
            shareItem.o = this.M;
            shareItem.E = getShareObjSource();
            shareItem.M = k;
            shareItem.F = 3;
            shareItem.G = k(this.A);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (this.A.isUgcThreadType()) {
                z2 = false;
            }
            shareItem.m0 = z2;
            if (z2) {
                shareItem.k0 = this.A.getShareImageUrl();
            }
            f();
            generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.A);
            shareItem.T = generateShareInfo;
            if (StringUtils.isNull(generateShareInfo.showText, true)) {
                if (StringUtils.isNull(this.A.getTitle(), true)) {
                    OriginalThreadInfo originalThreadInfo = this.A.originalThreadData;
                    if (originalThreadInfo != null) {
                        shareItem.T.showText = originalThreadInfo.f29827g;
                    }
                } else {
                    shareItem.T.showText = this.A.getTitle();
                }
            }
            if (StringUtils.isNull(shareItem.T.showText, true)) {
                shareItem.T.showText = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cea);
            }
            if (this.L != 13) {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(this.A, 2);
            } else {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(this.A);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            if (shareItem.o == 11) {
                bundle.putInt("source", 14);
            }
            if (shareItem.o == 12) {
                bundle.putInt("source", 15);
            }
            shareItem.k(bundle);
            if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
                shareItem.y0 = c.a.o0.s.g.g.j(this.A, k);
                shareItem.z0 = c.a.o0.s.g.g.i(this.A, k, str3, shareItem.R, "", "");
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.B, shareItem, true, true);
            boolean z3 = this.A.getThreadType() != 49 || this.A.getThreadType() == 60 || this.A.getThreadType() == 69;
            shareDialogConfig.mIsVoiceRoom = z;
            shareDialogConfig.setIsAlaLive(z3);
            c(shareDialogConfig);
            c.a.p0.l0.h.c().l(shareDialogConfig);
        }
        z2 = true;
        if (this.A.getThreadAlaInfo() != null) {
            str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.A.getThreadAlaInfo().mYyExtData.mSid + "&livessid=" + this.A.getThreadAlaInfo().mYyExtData.mSsid + "&uid=" + this.A.getThreadAlaInfo().mYyExtData.mYyUid;
            z2 = false;
        }
        String j22 = j(this.A);
        if (j22 != null) {
        }
        String str92 = this.A.getAbstract();
        String string3 = getResources().getString(R.string.obfuscated_res_0x7f0f110f);
        String string22 = getResources().getString(R.string.obfuscated_res_0x7f0f047a);
        if (!this.A.isUgcThreadType()) {
        }
        if (!z) {
        }
        int k2 = c.a.o0.s.g.g.k(this.A);
        String cutString3 = m.cutString(str5, 100);
        String cutString22 = m.cutString(format, 100);
        shareItem = new ShareItem();
        shareItem.r = cutString3;
        shareItem.s = cutString22;
        if (!this.A.isUgcThreadType()) {
        }
        shareItem.t = str2;
        shareItem.q = str7;
        shareItem.J = str4;
        shareItem.p = str3;
        shareItem.K = str7;
        shareItem.f30356f = true;
        shareItem.o = this.M;
        shareItem.E = getShareObjSource();
        shareItem.M = k2;
        shareItem.F = 3;
        shareItem.G = k(this.A);
        if (parse != null) {
        }
        if (this.A.isUgcThreadType()) {
        }
        shareItem.m0 = z2;
        if (z2) {
        }
        f();
        generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.A);
        shareItem.T = generateShareInfo;
        if (StringUtils.isNull(generateShareInfo.showText, true)) {
        }
        if (StringUtils.isNull(shareItem.T.showText, true)) {
        }
        if (this.L != 13) {
        }
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("obj_param1", shareItem.F);
        bundle2.putInt("obj_type", shareItem.M);
        bundle2.putString("fid", shareItem.J);
        bundle2.putString("tid", shareItem.K);
        bundle2.putInt("obj_source", shareItem.o);
        if (shareItem.o == 11) {
        }
        if (shareItem.o == 12) {
        }
        shareItem.k(bundle2);
        if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
        }
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.B, shareItem, true, true);
        if (this.A.getThreadType() != 49) {
        }
        shareDialogConfig2.mIsVoiceRoom = z;
        shareDialogConfig2.setIsAlaLive(z3);
        c(shareDialogConfig2);
        c.a.p0.l0.h.c().l(shareDialogConfig2);
    }

    public void D(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            this.f30122b.setVisibility(8);
        }
    }

    public void E(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            EMTextView eMTextView = this.w;
            if (eMTextView != null) {
                int i2 = threadData.collectNum;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f0a7f);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(threadData);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.o0.r.l0.h.b(this.h0);
        }
    }

    public void G(ThreadData threadData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) || this.p == null || threadData == null) {
            return;
        }
        this.J = r(4);
        if (threadData.mOriginalForumInfo != null) {
            this.J = false;
        }
        if (this.J && ((linearLayout = this.z) == null || linearLayout.getVisibility() == 8)) {
            this.p.setVisibility(0);
            String string = this.B.getString(R.string.obfuscated_res_0x7f0f0a75);
            this.n.setText(string);
            this.n.setContentDescription(string);
            this.D = true;
        } else {
            this.p.setVisibility(r(64) ? 4 : 8);
        }
        updateManagerUI();
    }

    public void H(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) && threadData != null && this.L == 13) {
            showOperationMaskView(threadData.isAuthorView == 1);
        }
    }

    public void I(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) || this.f30125e == null || threadData == null) {
            return;
        }
        if (this.H) {
            this.f30128h.setVisibility(0);
            if (threadData.getReply_num() > 0) {
                this.f30125e.setVisibility(0);
                String numFormatOverWan = StringHelper.numFormatOverWan(threadData.getReply_num());
                if (this.G) {
                    updateReplyStateUI();
                    this.f30125e.setText(numFormatOverWan);
                } else {
                    this.f30125e.setText(String.format(this.B.getString(R.string.obfuscated_res_0x7f0f0f91), numFormatOverWan));
                }
                EMTextView eMTextView = this.f30125e;
                eMTextView.setContentDescription(this.B.getString(R.string.obfuscated_res_0x7f0f0f90) + numFormatOverWan);
                this.D = true;
                return;
            } else if (this.G) {
                updateReplyStateUI();
                this.f30125e.setText(this.B.getString(R.string.obfuscated_res_0x7f0f0084));
                this.f30125e.setVisibility(0);
                this.D = true;
                return;
            } else {
                this.f30125e.setVisibility(8);
                return;
            }
        }
        this.f30128h.setVisibility(8);
    }

    public final void J(ThreadData threadData) {
        String replyTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) || this.f30123c == null || threadData == null) {
            return;
        }
        if (threadData.getLast_time_int() > 0 && this.E) {
            this.f30123c.setVisibility(0);
            if (this.L == 3) {
                replyTime = threadData.getReplyTimeForMyThread();
            } else {
                replyTime = threadData.getReplyTime();
            }
            this.f30123c.setText(replyTime);
            this.D = true;
            return;
        }
        this.f30123c.setVisibility(8);
    }

    public void K(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) || this.z == null || this.x == null || this.y == null || threadData == null) {
            return;
        }
        if (!this.j0) {
            View view = this.V;
            if (view != null) {
                view.setVisibility(8);
            }
            this.z.setVisibility(8);
        } else if (this.K && !r(128) && (c.a.p0.f1.b.f().i() || c.a.p0.f1.a.h().j())) {
            if (this.V == null) {
                View view2 = new View(getContext());
                this.V = view2;
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                addView(this.V);
                this.V.setAlpha(0.5f);
                this.V.setOnTouchListener(new e(this));
                this.V.setOnClickListener(new f(this));
            }
            int k = n.k(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.V.getLayoutParams();
            if (layoutParams == null) {
                this.V.setLayoutParams(new FrameLayout.LayoutParams(k, -1));
            } else {
                layoutParams.width = k;
                requestLayout();
            }
            if (!this.A.isMarkToDel() && !this.A.isMarkToMove()) {
                c.a.o0.r.v.c.d(this.y).x(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.x, R.drawable.obfuscated_res_0x7f080905, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.x, R.drawable.obfuscated_res_0x7f080901, R.color.CAM_X0304, null);
            }
            this.V.setVisibility(0);
            this.z.setVisibility(8);
        } else {
            View view3 = this.V;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            this.z.setVisibility(8);
        }
    }

    public void L(ThreadData threadData) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) || (view = this.k) == null || this.i == null || threadData == null) {
            return;
        }
        if (this.I) {
            view.setVisibility(0);
            long shareNum = threadData.getShareNum();
            if ((threadData.isLiveThread() || threadData.isSharedLiveThread()) && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().share_info != null) {
                shareNum = threadData.getThreadAlaInfo().share_info.share_count;
            }
            String string = this.B.getString(R.string.obfuscated_res_0x7f0f1107);
            if (shareNum > 0) {
                string = StringHelper.numFormatOverWan(shareNum);
            }
            this.i.setText(string);
            this.D = true;
            updateShareStateUI(threadData);
            return;
        }
        view.setVisibility(8);
    }

    public void addPraiseStats(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.A != null || i2 >= 0) {
                StatisticItem d2 = d(i2);
                d2.param("thread_type", this.A.getThreadType());
                TiebaStatic.log(d2);
            }
        }
    }

    public final void c(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, shareDialogConfig) == null) {
            int i2 = this.L;
            if (i2 == 1) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
            } else if (i2 == 2) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.FRS);
            } else if (i2 == 4) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            } else if (i2 == 16) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.HomeVideoTab);
            } else if (i2 == 7) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
            } else if (i2 == 8) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            } else if (i2 == 9) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.Concern);
            } else if (i2 == 12) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.HomeGameTab);
            } else if (i2 != 13) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.Default);
            } else {
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            }
        }
    }

    public void changeSelectStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            onClick(this.x);
        }
    }

    public final StatisticItem d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (this.A != null || i2 >= 0) {
                StatisticItem statisticItem = new StatisticItem("c12003");
                statisticItem.param("tid", this.A.getTid());
                if (this.A.getThreadType() == 40) {
                    statisticItem.param("obj_param1", "2");
                } else if (this.A.getThreadType() == 0) {
                    statisticItem.param("obj_param1", "1");
                }
                statisticItem.param("obj_source", "1");
                statisticItem.param("fid", this.A.getFid());
                statisticItem.param("obj_locate", this.L);
                statisticItem.param("obj_id", i2);
                if (!m.isEmpty(this.O)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.O);
                }
                if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
                }
                statisticItem.param("nid", this.A.getNid());
                statisticItem.param("card_type", this.A.getRecomCardType());
                statisticItem.param("recom_source", this.A.mRecomSource);
                statisticItem.param("ab_tag", this.A.mRecomAbTag);
                statisticItem.param("weight", this.A.mRecomWeight);
                statisticItem.param("extra", this.A.mRecomExtra);
                if (this.A.getBaijiahaoData() != null && !m.isEmpty(this.A.getBaijiahaoData().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.A.getBaijiahaoData().oriUgcVid);
                }
                c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
                if (findPageExtraByView != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                return statisticItem;
            }
            return null;
        }
        return (StatisticItem) invokeI.objValue;
    }

    public final StatisticItem e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.A == null) {
                return null;
            }
            int i2 = 0;
            int i3 = this.M;
            if (i3 == 1) {
                i2 = 4;
            } else if (i3 == 2) {
                i2 = 5;
            } else if (i3 == 3) {
                i2 = 3;
            } else if (i3 == 4) {
                i2 = 2;
            } else if (i3 == 6) {
                i2 = 8;
            } else if (i3 == 7) {
                i2 = 9;
            } else if (i3 == 9) {
                i2 = 10;
            } else if (i3 == 10) {
                i2 = 17;
            } else if (i3 == 18) {
                i2 = 20;
            } else if (i3 == 11) {
                i2 = 26;
            } else if (i3 == 12) {
                i2 = 25;
            } else if (i3 == 13) {
                i2 = 13;
            } else if (i3 == 14) {
                i2 = 30;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("fid", this.A.getFid());
            statisticItem.param("tid", this.A.getTid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.P);
            if (!m.isEmpty(this.O)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.O);
            }
            if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.A.getThreadAlaInfo() != null && this.A.getThreadAlaInfo().user_info != null && this.A.getThreadAlaInfo().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.A.getThreadAlaInfo().user_info.is_official);
            }
            statisticItem.param("card_type", this.A.getRecomCardType()).param("ab_tag", this.A.mRecomAbTag).param("recom_source", this.A.mRecomSource).param("weight", this.A.mRecomWeight).param("extra", this.A.mRecomExtra);
            if (this.A.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 10);
            } else if (this.A.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 9);
            } else if (this.A.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 8);
            } else if (this.A.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 7);
            } else {
                ThreadData threadData = this.A;
                if (threadData.isShareThread) {
                    statisticItem.param("obj_type", 6);
                } else {
                    int i4 = threadData.threadType;
                    if (i4 == 0) {
                        statisticItem.param("obj_type", 1);
                    } else if (i4 == 40) {
                        statisticItem.param("obj_type", 2);
                    } else if (i4 == 49 || i4 == 69) {
                        statisticItem.param("obj_type", 3);
                    } else if (i4 == 54) {
                        statisticItem.param("obj_type", 4);
                    } else {
                        statisticItem.param("obj_type", 5);
                    }
                }
            }
            int i5 = this.L;
            if (i5 == 1 || i5 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
            }
            if (this.L == 18) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.Q);
            }
            if (this.A.getBaijiahaoData() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.A.getBaijiahaoData().oriUgcNid);
                if (this.A.isBJHVideoThreadType() || this.A.isBJHVideoDynamicThreadType()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.A.getBaijiahaoData().oriUgcVid);
                }
            }
            if (this.A.isBjhDynamicThread()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.A.isBJHArticleThreadType() && !this.A.isBJHVideoThreadType()) {
                int i6 = this.A.threadType;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.C;
            if (tbPageContext != null) {
                c.a.o0.o0.c.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.A.getNid());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void f() {
        ThreadData threadData;
        ItemInfo itemInfo;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Context context = this.B;
            if ((context instanceof m0) && ((m0) context).isInScoreTab() && (threadData = this.A) != null && threadData.getItem() == null && (itemInfo = ((m0) this.B).getItemInfo()) != null) {
                Item.Builder builder = new Item.Builder();
                builder.item_id = Long.valueOf(itemInfo.id.longValue());
                builder.item_name = itemInfo.name;
                builder.icon_size = itemInfo.icon_size;
                builder.icon_url = itemInfo.icon_url;
                builder.tags = itemInfo.tags;
                ItemTable itemTable = itemInfo.score;
                if (itemTable != null && (list = itemTable.item_point) != null) {
                    Iterator<ItemPoint> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ItemPoint next = it.next();
                        if (next.time_intval.equals("all")) {
                            Double d2 = next.point;
                            builder.score = d2;
                            builder.star = Integer.valueOf((int) (d2.doubleValue() / 2.0d));
                            break;
                        }
                    }
                }
                Item build = builder.build(false);
                ItemData itemData = new ItemData();
                itemData.parseProto(build);
                this.A.setItemData(itemData);
            }
        }
    }

    public final void g(View view, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, view, threadData) == null) || threadData == null) {
            return;
        }
        int id = view.getId();
        int i2 = 3;
        int i3 = id == R.id.obfuscated_res_0x7f091fac ? 3 : id == R.id.obfuscated_res_0x7f091ccb ? 4 : id == R.id.obfuscated_res_0x7f090e9b ? 1 : id == R.id.obfuscated_res_0x7f090eb1 ? 2 : 0;
        int i4 = this.L;
        if (i4 == 1) {
            i2 = 1;
        } else if (i4 == 2) {
            i2 = 2;
        } else if (i4 != 4) {
            if (i4 == 8) {
                i2 = 4;
            } else if (i4 != 9) {
                i2 = 0;
            }
        }
        if (i3 <= 0 || i2 <= 0) {
            return;
        }
        TiebaStatic.log(c.a.p0.z3.a.o("c13694", threadData, i2, i3));
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f30122b : (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f30128h : (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f30125e : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
            int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
            if (threadSourceForDynamicAndBjh <= 0 || threadTypeForDynamicAndBjh <= 0) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
            statisticItem.param("obj_source", threadSourceForDynamicAndBjh);
            statisticItem.param("obj_type", threadTypeForDynamicAndBjh);
            TiebaStatic.log(statisticItem);
        }
    }

    public void hideDisagree() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f30124d.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.I = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30126f.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.f30126f.setLayoutParams(layoutParams);
        }
    }

    public View i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d060c, (ViewGroup) this, true) : (View) invokeL.objValue;
    }

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.j0 : invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public final String j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, threadData)) == null) {
            String str = null;
            if (threadData == null) {
                return null;
            }
            if (threadData.getThreadAlaInfo() != null && !TextUtils.isEmpty(threadData.getThreadAlaInfo().cover)) {
                return threadData.getThreadAlaInfo().cover;
            }
            if (threadData.getVoiceRoomData() != null && threadData.getVoiceRoomData().room_id.longValue() > 0) {
                if (threadData.getForumData() == null) {
                    return null;
                }
                return threadData.getForumData().f10992c;
            } else if (threadData.getMedias() == null) {
                return null;
            } else {
                ArrayList<MediaData> medias = threadData.getMedias();
                int size = medias.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    MediaData mediaData = medias.get(i2);
                    if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                        if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                            str = mediaData.getThumbnails_url();
                            break;
                        } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                            str = mediaData.getPicUrl();
                            break;
                        }
                    }
                    i2++;
                }
                return (str != null || threadData.getThreadVideoInfo() == null || TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) ? str : threadData.getThreadVideoInfo().thumbnail_url;
            }
        }
        return (String) invokeL.objValue;
    }

    public final int k(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isVideoWorksInfo()) {
                return 11;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 10;
            }
            if (threadData.isBJHVideoThreadType()) {
                return 9;
            }
            if (threadData.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 7;
            }
            if (threadData.isShareThread) {
                return 6;
            }
            int i2 = threadData.threadType;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 40) {
                return 2;
            }
            if (i2 == 49 || i2 == 69) {
                return 3;
            }
            return i2 == 54 ? 4 : 5;
        }
        return invokeL.intValue;
    }

    public final void l(Context context, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, context, threadData) == null) || threadData == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        int i2 = this.L;
        String str = i2 == 2 ? "frs" : (i2 == 4 || i2 == 9 || i2 == 1) ? "index" : "";
        videoItemData.buildWithThreadData(threadData);
        arrayList.add(videoItemData);
        x.e(context, arrayList, threadData.getBaijiahaoData() != null ? threadData.getBaijiahaoData().oriUgcNid : null, videoItemData.isVerticalVideo == 1, 0, null, "from_nani_video", "personalize_page", "", str, str, true, threadData.isJumpToFrsVideoTabPlay, true);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.k.setVisibility(r(1) ? 0 : 8);
            this.f30128h.setVisibility(r(2) ? 0 : 8);
            View view = this.p;
            int i2 = 4;
            if (r(4)) {
                i2 = 0;
            } else if (!r(64)) {
                i2 = 8;
            }
            view.setVisibility(i2);
            this.f30124d.setVisibility(r(8) ? 0 : 8);
            this.f30124d.setAgreeAlone(r(32));
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, context) == null) {
            this.B = context;
            if (context instanceof BaseActivity) {
                this.C = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.C = ((BaseFragmentActivity) context).getPageContext();
            }
            n.f(this.B, R.dimen.tbds84);
            o();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            p(i(this.B));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.k0);
            MessageManager.getInstance().registerListener(this.l0);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.U == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.U = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.V, R.color.CAM_X0201);
        MaskView maskView = this.W;
        if (maskView != null) {
            maskView.f();
        }
        SkinManager.setViewTextColor(this.f30122b, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f30123c, (int) R.color.CAM_X0107);
        updateReplyStateUI();
        updateCollectStateUI(this.A);
        updateShareStateUI(this.A);
        updateManagerUI();
        c0 c0Var = this.q;
        if (c0Var != null) {
            c0Var.g0();
        }
        AgreeView agreeView = this.f30124d;
        if (agreeView != null) {
            agreeView.v(this.U);
            AgreeView agreeView2 = this.f30124d;
            ThreadData threadData = this.A;
            agreeView2.setAlpha((threadData == null || threadData.getType() != ThreadData.TYPE_FAKE_VIDEO) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view) == null) {
            ThreadData threadData = this.A;
            if (threadData == null || threadData.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                if (view == this.f30122b) {
                    s(view);
                } else if (view == this.f30128h) {
                    u(view);
                    int i2 = this.L;
                    if (i2 == 1 || i2 == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                } else if (view == this.k) {
                    A(view);
                    int i3 = this.L;
                    if (i3 == 1 || i3 == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                } else if (view == this.m) {
                    x(view);
                } else if (view == this.p) {
                    w(view);
                } else if (view == this.x) {
                    z(view);
                } else if (view == this.r) {
                    y(view);
                } else if (view == this.u) {
                    t(view);
                }
            }
        }
    }

    public void onDestroy() {
        c0 c0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (c0Var = this.q) == null) {
            return;
        }
        c0Var.V();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.k0);
            MessageManager.getInstance().unRegisterListener(this.l0);
        }
    }

    public void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view) == null) {
            this.f30122b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091fab);
            this.f30123c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091fb6);
            this.h0 = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091fa1);
            EMTextView eMTextView = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f091fb0);
            this.f30125e = eMTextView;
            c.a.o0.r.v.c.d(eMTextView).A(R.string.F_X01);
            this.f30126f = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091faf);
            this.f30127g = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f091fae);
            this.f30128h = view.findViewById(R.id.obfuscated_res_0x7f091fac);
            EMTextView eMTextView2 = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f091cca);
            this.i = eMTextView2;
            c.a.o0.r.v.c.d(eMTextView2).A(R.string.F_X01);
            this.j = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091ccc);
            this.k = view.findViewById(R.id.obfuscated_res_0x7f091ccb);
            this.l = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f09040c);
            this.m = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09040b);
            View findViewById = view.findViewById(R.id.obfuscated_res_0x7f091545);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.f30124d = agreeView;
                agreeView.setAfterClickListener(new a(this));
            }
            this.p = view.findViewById(R.id.obfuscated_res_0x7f09138c);
            EMTextView eMTextView3 = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f091fb3);
            this.n = eMTextView3;
            c.a.o0.r.v.c.d(eMTextView3).A(R.string.F_X01);
            this.o = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091fb2);
            this.x = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091389);
            EMTextView eMTextView4 = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f09138a);
            this.y = eMTextView4;
            c.a.o0.r.v.c.d(eMTextView4).A(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091388);
            this.z = linearLayout;
            linearLayout.setOnTouchListener(new b(this));
            this.y.setOnClickListener(new c(this));
            this.r = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091991);
            this.s = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091992);
            EMTextView eMTextView5 = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f091993);
            this.t = eMTextView5;
            if (eMTextView5 != null) {
                c.a.o0.r.v.c.d(eMTextView5).A(R.string.F_X01);
            }
            this.u = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090678);
            this.v = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090679);
            EMTextView eMTextView6 = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f09067a);
            this.w = eMTextView6;
            if (eMTextView6 != null) {
                c.a.o0.r.v.c.d(eMTextView6).A(R.string.F_X01);
            }
            this.z.setOnClickListener(new d(this));
            this.f30128h.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.x.setOnClickListener(this);
            LinearLayout linearLayout2 = this.r;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(this);
            }
            LinearLayout linearLayout3 = this.u;
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(this);
            }
        }
    }

    public final boolean q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, threadData)) == null) ? (threadData == null || !threadData.isVideoThreadType() || threadData.getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) ? (i2 & this.a) > 0 : invokeI.booleanValue;
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.I = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f30126f.getLayoutParams();
            layoutParams.leftMargin = this.B.getResources().getDimensionPixelSize(R.dimen.tbds78);
            this.f30126f.setLayoutParams(layoutParams);
        }
    }

    public final void s(View view) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, view) == null) || (threadData = this.A) == null || StringUtils.isNull(threadData.getForum_name())) {
            return;
        }
        if (!StringUtils.isNull(this.R) && !StringUtils.isNull(this.S)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.B).createCfgForpersonalized(this.A.getForum_name(), this.R, this.S)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.B).createNormalCfg(this.A.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
        View.OnClickListener onClickListener = this.T;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAgreeClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
        }
    }

    public void setAgreeStatisticData(c.a.o0.r.r.f fVar) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, fVar) == null) || (agreeView = this.f30124d) == null) {
            return;
        }
        agreeView.setStatisticData(fVar);
    }

    public void setAgreeViewType(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, threadData) == null) && threadData != null && threadData.isUgcThreadType()) {
            this.f30124d.setAgreeAlone(true);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.F = z;
            TextView textView = this.f30122b;
            if (textView != null) {
                textView.setClickable(z);
            }
        }
    }

    public void setCollectVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (linearLayout = this.u) == null) {
            return;
        }
        if (z) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    public void setCommentClickable(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z) == null) || (view = this.f30128h) == null) {
            return;
        }
        view.setClickable(z);
        this.f30126f.setEnabled(z);
        this.f30125e.setEnabled(z);
    }

    public void setCommentNumEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, context) == null) {
            this.B = context;
            if (this.C == null) {
                if (context instanceof BaseActivity) {
                    this.C = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.C = ((BaseFragmentActivity) context).getPageContext();
                }
            }
        }
    }

    public boolean setData(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, threadData)) == null) {
            if (threadData == null) {
                setVisibility(8);
                return false;
            }
            this.A = threadData;
            F();
            D(threadData);
            J(threadData);
            I(threadData);
            E(threadData);
            L(threadData);
            updatePraiseNum(threadData);
            K(threadData);
            G(threadData);
            setVisibility(this.D ? 0 : 8);
            H(threadData);
            v();
            return this.D;
        }
        return invokeL.booleanValue;
    }

    public void setDisPraiseFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.L = i2;
            AgreeView agreeView = this.f30124d;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.P = i2;
            AgreeView agreeView = this.f30124d;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.j0 = z;
        }
    }

    public void setIsBarViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
        }
    }

    public void setLiveShareEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.J = z;
        }
    }

    public void setMultiForumCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
        }
    }

    public void setNeedAddPraiseIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.G = z;
        }
    }

    public void setOnCommentClickCallback(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, iVar) == null) {
            this.i0 = iVar;
        }
    }

    public void setOnSelectStatusChangeListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, jVar) == null) {
            this.g0 = jVar;
        }
    }

    public void setQQShareVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048645, this, z) == null) || (linearLayout = this.r) == null) {
            return;
        }
        if (z) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    public void setReplyTimeVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.E = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.K = z;
        }
    }

    public void setShareClickable(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048648, this, z) == null) || (view = this.k) == null) {
            return;
        }
        view.setClickable(z);
        this.j.setEnabled(z);
        this.i.setEnabled(z);
    }

    public void setShareReportFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            this.M = i2;
        }
    }

    public void setShareVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
        }
    }

    public void setShowCommonView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setNeedAddReplyIcon(true);
            setShareVisible(true);
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            this.a = i2;
            m();
        }
    }

    public void setShowPraiseNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.R = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.Q = str;
            AgreeView agreeView = this.f30124d;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, str) == null) {
            this.S = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            if (z && this.W == null) {
                MaskView maskView = new MaskView(getContext());
                this.W = maskView;
                addView(maskView);
            }
            MaskView maskView2 = this.W;
            if (maskView2 != null) {
                maskView2.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void t(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, view) == null) {
        }
    }

    public void u(View view) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048659, this, view) == null) || (threadData = this.A) == null || this.B == null) {
            return;
        }
        c.a.p0.h0.m.a(threadData.getTid());
        StatisticItem statisticItem = new StatisticItem("c12942");
        statisticItem.param("obj_locate", this.L);
        statisticItem.param("obj_type", getThreadType());
        statisticItem.param("tid", this.A.getTid());
        statisticItem.param("nid", this.A.getNid());
        if (this.L == 18) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.A.getFid());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.Q);
        }
        c.a.o0.n0.c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
        if (findPageExtraByView != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
        }
        if (TbPageExtraHelper.getPrePageKey() != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
        }
        TiebaStatic.log(statisticItem);
        if (this.A.getVoiceRoomData() != null && this.A.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(this.A.getVoiceRoomData().room_name)) {
            ((c.a.o0.i0.c.a) ServiceManager.getService(c.a.o0.i0.c.a.a.a())).a(this.C, this.A.getVoiceRoomData().room_id.longValue());
        } else if (this.A.getThreadVideoInfo() != null && !TextUtils.isEmpty(this.A.getThreadVideoInfo().video_url)) {
            l(this.B, this.A);
        } else {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.B).createFromThreadCfg(this.A, null, this.R, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.A.getFid()));
            addLocateParam.setForumName(this.A.getForum_name());
            if (this.A.getIsDailyThread() && this.A.getForumData() != null) {
                addLocateParam.setForumId(this.A.getForumData().c());
                addLocateParam.setForumName(this.A.getForumData().a());
            }
            addLocateParam.setJumpToCommentArea(true);
            i iVar = this.i0;
            if (iVar != null) {
                iVar.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && q(this.A)) {
                addLocateParam.setNeedPreLoad(true);
                l.update(this.A);
            }
            if (this.A.isQualityReplyThread) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.A.isInterviewLiveStyle() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.N);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
        }
        StatisticItem statisticItem2 = new StatisticItem("c12291");
        statisticItem2.param("obj_locate", this.L);
        TiebaStatic.log(statisticItem2);
        h();
        g(view, this.A);
        View.OnClickListener onClickListener = this.T;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void updateCollectStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048660, this, threadData) == null) || this.v == null) {
            return;
        }
        if (threadData != null && threadData.getIsMarked() != 0) {
            WebPManager.setPureDrawable(this.v, R.drawable.obfuscated_res_0x7f080929, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.v, R.drawable.obfuscated_res_0x7f080928, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void updateManagerUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f0808e5, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.n;
            ThreadData threadData = this.A;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.o;
            ThreadData threadData2 = this.A;
            imageView.setEnabled(threadData2 == null || threadData2.getType() != ThreadData.TYPE_FAKE_VIDEO);
        }
    }

    public void updatePraiseNum(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, threadData) == null) {
            setAgreeViewType(threadData);
            if (threadData.getAgreeData() != null) {
                threadData.getAgreeData().isInThread = true;
                this.f30124d.setCardType(threadData.getRecomCardType());
                this.f30124d.setThreadData(threadData);
                this.f30124d.setData(threadData.getAgreeData());
            }
            AgreeView agreeView = this.f30124d;
            ThreadData threadData2 = this.A;
            agreeView.setAlpha((threadData2 == null || threadData2.getType() != ThreadData.TYPE_FAKE_VIDEO) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    public void updateReplyStateUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            if (this.G) {
                WebPManager.setPureDrawable(this.f30126f, R.drawable.obfuscated_res_0x7f0808e9, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.f30126f;
            ThreadData threadData = this.A;
            imageView.setEnabled(threadData == null || threadData.getType() != ThreadData.TYPE_FAKE_VIDEO);
            EMTextView eMTextView = this.f30125e;
            ThreadData threadData2 = this.A;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            c.a.o0.r.l0.h.a(this.f30126f, R.drawable.obfuscated_res_0x7f0808e8);
            c.a.o0.r.l0.h.e(this.f30125e);
        }
    }

    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, threadData) == null) {
            WebPManager.setPureDrawable(this.j, R.drawable.obfuscated_res_0x7f0808ed, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(threadData)) {
                setShareClickable(true);
                this.i.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                if (threadData != null && threadData.originalThreadData != null) {
                    ThreadData threadData2 = this.A;
                    if (threadData2.originalThreadData.m || threadData2.shouldShowBlockedState()) {
                        setShareClickable(false);
                        this.i.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
                setShareClickable(true);
                c.a.o0.r.v.c.d(this.i).x(R.color.CAM_X0107);
            }
            ThreadData threadData3 = this.A;
            if (threadData3 != null && threadData3.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.j.setEnabled(false);
                this.i.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
            c.a.o0.r.l0.h.a(this.j, R.drawable.obfuscated_res_0x7f0808ec);
            c.a.o0.r.l0.h.e(this.i);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
        }
    }

    public void w(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, view) == null) {
            if (this.q == null) {
                this.q = new c0(this.C, r(16));
            }
            this.q.i0(this.A);
            this.q.m();
            if (this.A != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.A.getFid()).param("tid", this.A.getId()));
            }
        }
    }

    public final void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, view) == null) {
        }
    }

    public void y(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, view) == null) {
        }
    }

    public void z(View view) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, view) == null) || this.x == null || (threadData = this.A) == null || this.y == null || threadData.isTransportThread()) {
            return;
        }
        boolean z = true;
        if (!this.A.isMarkToDel() && c.a.p0.f1.b.f().i()) {
            if (c.a.p0.f1.b.f().a(this.A)) {
                this.A.setMarkToDel(true);
            }
        } else if (!this.A.isMarkToMove() && c.a.p0.f1.a.h().j()) {
            if (c.a.p0.f1.a.h().a(this.A)) {
                this.A.setMarkToMove(true);
            }
        } else {
            c.a.p0.f1.b.f().l(this.A);
            this.A.setMarkToDel(false);
            c.a.p0.f1.a.h().l(this.A);
            this.A.setMarkToMove(false);
        }
        if (!this.A.isMarkToDel() && !this.A.isMarkToMove()) {
            c.a.o0.r.v.c.d(this.y).x(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.x, R.drawable.obfuscated_res_0x7f080905, R.color.CAM_X0107, null);
        } else {
            SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.x, R.drawable.obfuscated_res_0x7f080901, R.color.CAM_X0304, null);
        }
        j jVar = this.g0;
        if (jVar != null) {
            if (!this.A.isMarkToDel() && !this.A.isMarkToMove()) {
                z = false;
            }
            jVar.a(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.h0 : (LinearLayout) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n.f(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = 2;
        this.M = 1;
        this.U = 3;
        this.g0 = null;
        this.j0 = true;
        this.k0 = new g(this, 2921416);
        this.l0 = new h(this, 2921417);
        n(context);
    }
}
