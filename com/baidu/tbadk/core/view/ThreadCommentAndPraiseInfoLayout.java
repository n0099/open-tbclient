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
import c.a.s0.e1.y;
import c.a.s0.s.q.e2;
import c.a.t0.d1.l;
import c.a.t0.d1.m0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
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
import com.baidu.tieba.card.ThreadManageDialog;
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
/* loaded from: classes11.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ENTER_FORUM_SQUARE = 18;
    public static final int FROM_CHANNEL = 12;
    public static final int FROM_FRS = 1;
    public static final int FROM_FRS_VIDEO_TAB = 14;
    public static final int FROM_GAME_VIDEO = 9;
    public static final int FROM_HOME_CONCERN = 4;
    public static final int FROM_HOME_DAILY = 7;
    public static final int FROM_HOME_RECOMMEND = 3;
    public static final int FROM_HOT_TOPIC = 13;
    public static final int FROM_PB = 2;
    public static final int FROM_PB_BOTTOM_REC = 11;
    public static final int FROM_PERSON_CENTER = 6;
    public static final int FROM_VIDEO_TAB = 10;
    public static final int FROM_WRITE = 5;
    public static final int FRS_PAGE = 2;
    public static final int FRS_PAGE_VIDEO_TAB = 19;
    public static final int HOME_PAGE = 1;
    public static final int HOME_PAGE_ALA_LIVE = 7;
    public static final int HOME_PAGE_CONCERN = 9;
    public static final int HOME_PAGE_DAILY = 11;
    public static final int HOME_PAGE_GAME_VIDEO = 12;
    public static final int HOME_PAGE_VIDEO_TAB = 16;
    public static final int MAX_FORUM_LENGTH = 14;
    public static final int MY_THREAD = 3;
    public static final int MY_THREAD_BOTTOM = 13;
    public static final int PARAM5_TYPE_BJH_NORMAL = 3;
    public static final int PARAM5_TYPE_DYNAMIC = 2;
    public static final int PARAM5_TYPE_NORMAL = 1;
    public static final int PB_BOTTOM_BAR = 17;
    public static final int PB_COMMON_FLOOR = 5;
    public static final int PB_FIRST_FLOOR = 4;
    public static final int PERSON_PAGE_CARD = 8;
    public static final int THREAD_TYPE_ALA_LIVE = 5;
    public static final int THREAD_TYPE_OTHER = 0;
    public static final int THREAD_TYPE_PICTURE_TEXT = 2;
    public static final int THREAD_TYPE_SHARE = 4;
    public static final int THREAD_TYPE_VIDEO = 1;
    public static final int THREAD_TYPE_VOICE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public int TBDS84;
    public boolean barNameClickEnable;

    /* renamed from: e  reason: collision with root package name */
    public int f40480e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40481f;

    /* renamed from: g  reason: collision with root package name */
    public int f40482g;

    /* renamed from: h  reason: collision with root package name */
    public int f40483h;

    /* renamed from: i  reason: collision with root package name */
    public int f40484i;
    public boolean isBarNameVisible;
    public boolean isCommentNumEnable;
    public boolean isLiveShareEnable;
    public boolean isManageVisible;
    public boolean isPraiseNumVisible;
    public boolean isReplyTimeVisible;
    public boolean isSelectVisible;
    public boolean isShareVisible;
    public boolean isVisible;

    /* renamed from: j  reason: collision with root package name */
    public String f40485j;
    public String k;
    public String l;
    public View.OnClickListener m;
    public AgreeView mAgreeView;
    public TextView mBarName;
    public ImageView mBtnMore;
    public FrameLayout mButtonMoreContainer;
    public LinearLayout mCollectNumContainer;
    public ImageView mCollectNumImageView;
    public EMTextView mCollectNumText;
    public View mCommentContainer;
    public EMTextView mCommentGrabSofa;
    public ImageView mCommentImageView;
    public EMTextView mCommentNum;
    public Context mContext;
    public e2 mData;
    public ThreadManageDialog mManageDialog;
    public ImageView mManageImageView;
    public EMTextView mManageText;
    public View mManageViewContainer;
    public TbPageContext mPageContext;
    public LinearLayout mQQShareContainer;
    public ImageView mQQShareImageView;
    public EMTextView mQQShareText;
    public LinearLayout mRootView;
    public LinearLayout mSelectContainer;
    public ImageView mSelectImg;
    public EMTextView mSelectText;
    public View mShareContainer;
    public ImageView mShareImageView;
    public EMTextView mShareNum;
    public int n;
    public boolean needAddReplyIcon;
    public View o;
    public MaskView p;
    public j q;
    public i r;
    public boolean s;
    public int sourceFromForPb;
    public String statFloor;
    public CustomMessageListener t;
    public CustomMessageListener u;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f40486e;

        public a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40486e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f40486e.m != null) {
                    this.f40486e.m.onClick(view);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.f40486e;
                threadCommentAndPraiseInfoLayout.g(view, threadCommentAndPraiseInfoLayout.mData);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f40487e;

        public b(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40487e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f40487e.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f40488e;

        public c(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40488e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40488e.mSelectImg.performClick();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f40489e;

        public d(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40489e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40489e.mSelectImg.performClick();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f40490e;

        public e(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40490e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f40490e.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f40491e;

        public f(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40491e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40491e.mSelectImg.performClick();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, Integer.valueOf(i2)};
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
            this.a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof e2)) {
                return;
            }
            e2 e2Var = (e2) customResponsedMessage.getData();
            if (this.a.mData == null || e2Var == null) {
                return;
            }
            String str = e2Var.L() != null ? e2Var.L().oriUgcNid : "";
            String str2 = this.a.mData.L() != null ? this.a.mData.L().oriUgcNid : "";
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (str.equals(str2)) {
                    this.a.mData.r4(e2Var.V0());
                    this.a.updateReplyNum(e2Var);
                    return;
                }
                return;
            }
            String g0 = e2Var.g0();
            String g02 = this.a.mData.g0();
            if ("0".equals(g02) || TextUtils.isEmpty(g02) || !g02.equals(g0)) {
                return;
            }
            this.a.mData.r4(e2Var.V0());
            this.a.updateReplyNum(e2Var);
        }
    }

    /* loaded from: classes11.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, Integer.valueOf(i2)};
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
            this.a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e2 e2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str) || (e2Var = this.a.mData) == null || "0".equals(e2Var.g0()) || !str.equals(this.a.mData.g0())) {
                return;
            }
            if ((this.a.mData.k2() || this.a.mData.w2()) && this.a.mData.o1() != null) {
                if (this.a.mData.o1() != null && this.a.mData.o1().share_info != null) {
                    this.a.mData.o1().share_info.share_count++;
                }
            } else {
                e2 e2Var2 = this.a.mData;
                e2Var2.w4(e2Var2.d1() + 1);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
            threadCommentAndPraiseInfoLayout.updateShareNum(threadCommentAndPraiseInfoLayout.mData);
        }
    }

    /* loaded from: classes11.dex */
    public interface i {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes11.dex */
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
        this.TBDS84 = n.f(TbadkApplication.getInst(), R.dimen.tbds84);
        this.f40480e = 11;
        this.isVisible = false;
        this.isReplyTimeVisible = true;
        this.isPraiseNumVisible = true;
        this.barNameClickEnable = true;
        this.needAddReplyIcon = false;
        this.isBarNameVisible = false;
        this.isCommentNumEnable = true;
        this.isLiveShareEnable = false;
        this.isShareVisible = true;
        this.isManageVisible = false;
        this.isSelectVisible = true;
        this.f40482g = 2;
        this.f40483h = 1;
        this.n = 3;
        this.q = null;
        this.s = true;
        this.t = new g(this, 2921416);
        this.u = new h(this, 2921417);
        m(context);
    }

    private BdUniqueId getPageUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            TbPageContext tbPageContext = this.mPageContext;
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
            int i2 = this.f40483h;
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
            int i2 = this.f40482g;
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
            e2 e2Var = this.mData;
            if (e2Var == null) {
                return 0;
            }
            if (e2Var.A1) {
                return 4;
            }
            if (e2Var.r1() == 49 || this.mData.r1() == 69) {
                return 5;
            }
            if (this.mData.t1() != null) {
                return 1;
            }
            if (this.mData.getType() == e2.i3 || this.mData.getType() == e2.F3) {
                return ListUtils.getCount(this.mData.F1()) > 0 ? 3 : 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            e2 e2Var = this.mData;
            if (e2Var == null) {
                return 0;
            }
            if (e2Var.P1()) {
                return 1;
            }
            if (this.mData.S1()) {
                return 2;
            }
            if (this.mData.Q1()) {
                return 3;
            }
            return this.mData.R1() ? 4 : 0;
        }
        return invokeV.intValue;
    }

    public void addPraiseStats(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.mData != null || i2 >= 0) {
                StatisticItem d2 = d(i2);
                d2.param("thread_type", this.mData.r1());
                TiebaStatic.log(d2);
            }
        }
    }

    public final void c(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareDialogConfig) == null) {
            int i2 = this.f40482g;
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            onClick(this.mSelectImg);
        }
    }

    public final StatisticItem d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.mData != null || i2 >= 0) {
                StatisticItem statisticItem = new StatisticItem("c12003");
                statisticItem.param("tid", this.mData.v1());
                if (this.mData.r1() == 40) {
                    statisticItem.param("obj_param1", "2");
                } else if (this.mData.r1() == 0) {
                    statisticItem.param("obj_param1", "1");
                }
                statisticItem.param("obj_source", "1");
                statisticItem.param("fid", this.mData.U());
                statisticItem.param("obj_locate", this.f40482g);
                statisticItem.param("obj_id", i2);
                if (!m.isEmpty(this.statFloor)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.statFloor);
                }
                if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
                }
                statisticItem.param("nid", this.mData.G0());
                statisticItem.param("card_type", this.mData.R0());
                statisticItem.param("recom_source", this.mData.Z0);
                statisticItem.param("ab_tag", this.mData.b1);
                statisticItem.param("weight", this.mData.a1);
                statisticItem.param("extra", this.mData.c1);
                if (this.mData.L() != null && !m.isEmpty(this.mData.L().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.mData.L().oriUgcVid);
                }
                c.a.s0.o0.c f2 = TbPageExtraHelper.f(this);
                if (f2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mData == null) {
                return null;
            }
            int i2 = 0;
            int i3 = this.f40483h;
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
                i2 = 27;
            } else if (i3 == 14) {
                i2 = 30;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("fid", this.mData.U());
            statisticItem.param("tid", this.mData.v1());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f40484i);
            if (!m.isEmpty(this.statFloor)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.statFloor);
            }
            if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.mData.o1() != null && this.mData.o1().user_info != null && this.mData.o1().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.mData.o1().user_info.is_official);
            }
            statisticItem.param("card_type", this.mData.R0()).param("ab_tag", this.mData.b1).param("recom_source", this.mData.Z0).param("weight", this.mData.a1).param("extra", this.mData.c1);
            if (this.mData.P1()) {
                statisticItem.param("obj_type", 10);
            } else if (this.mData.S1()) {
                statisticItem.param("obj_type", 9);
            } else if (this.mData.R1()) {
                statisticItem.param("obj_type", 8);
            } else if (this.mData.Q1()) {
                statisticItem.param("obj_type", 7);
            } else {
                e2 e2Var = this.mData;
                if (e2Var.A1) {
                    statisticItem.param("obj_type", 6);
                } else {
                    int i4 = e2Var.d0;
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
            int i5 = this.f40482g;
            if (i5 == 1 || i5 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
            }
            if (this.f40482g == 18) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f40485j);
            }
            if (this.mData.L() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.mData.L().oriUgcNid);
                if (this.mData.S1() || this.mData.R1()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.mData.L().oriUgcVid);
                }
            }
            if (this.mData.U1()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.mData.P1() && !this.mData.S1()) {
                int i6 = this.mData.d0;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.mPageContext;
            if (tbPageContext != null) {
                c.a.s0.p0.c.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.mData.G0());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void f() {
        e2 e2Var;
        ItemInfo itemInfo;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Context context = this.mContext;
            if ((context instanceof m0) && ((m0) context).isInScoreTab() && (e2Var = this.mData) != null && e2Var.t0() == null && (itemInfo = ((m0) this.mContext).getItemInfo()) != null) {
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
                this.mData.e4(itemData);
            }
        }
    }

    public final void g(View view, e2 e2Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, e2Var) == null) || e2Var == null) {
            return;
        }
        int id = view.getId();
        int i3 = 3;
        if (id == R.id.thread_info_commont_container) {
            i2 = 3;
        } else if (id == R.id.share_num_container) {
            i2 = 4;
        } else if (id == R.id.img_agree) {
            i2 = 1;
        } else {
            i2 = id == R.id.img_disagree ? 2 : 0;
        }
        int i4 = this.f40482g;
        if (i4 == 1) {
            i3 = 1;
        } else if (i4 == 2) {
            i3 = 2;
        } else if (i4 != 4) {
            if (i4 == 8) {
                i3 = 4;
            } else if (i4 != 9) {
                i3 = 0;
            }
        }
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        TiebaStatic.log(c.a.t0.v3.a.o("c13694", e2Var, i3, i2));
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBarName : (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mCommentContainer : (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mCommentNum : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mAgreeView.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.isShareVisible = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mCommentImageView.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.mCommentImageView.setLayoutParams(layoutParams);
        }
    }

    public final String i(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, e2Var)) == null) {
            String str = null;
            if (e2Var == null) {
                return null;
            }
            if (e2Var.o1() != null && !TextUtils.isEmpty(e2Var.o1().cover)) {
                return e2Var.o1().cover;
            }
            if (e2Var.G1() != null && e2Var.G1().room_id.longValue() > 0) {
                if (e2Var.Z() == null) {
                    return null;
                }
                return e2Var.Z().f13274c;
            } else if (e2Var.F0() == null) {
                return null;
            } else {
                ArrayList<MediaData> F0 = e2Var.F0();
                int size = F0.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    MediaData mediaData = F0.get(i2);
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
                return (str != null || e2Var.t1() == null || TextUtils.isEmpty(e2Var.t1().thumbnail_url)) ? str : e2Var.t1().thumbnail_url;
            }
        }
        return (String) invokeL.objValue;
    }

    public void initRootView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            initView(getRootView(this.mContext));
        }
    }

    public void initView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            this.mBarName = (TextView) view.findViewById(R.id.thread_info_bar_name);
            this.f40481f = (TextView) view.findViewById(R.id.thread_info_reply_time);
            this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
            EMTextView eMTextView = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
            this.mCommentNum = eMTextView;
            c.a.s0.s.u.c.d(eMTextView).A(R.string.F_X01);
            this.mCommentImageView = (ImageView) view.findViewById(R.id.thread_info_commont_img);
            this.mCommentGrabSofa = (EMTextView) view.findViewById(R.id.thread_info_commont_grab_sofa);
            this.mCommentContainer = view.findViewById(R.id.thread_info_commont_container);
            EMTextView eMTextView2 = (EMTextView) view.findViewById(R.id.share_num);
            this.mShareNum = eMTextView2;
            c.a.s0.s.u.c.d(eMTextView2).A(R.string.F_X01);
            this.mShareImageView = (ImageView) view.findViewById(R.id.share_num_img);
            this.mShareContainer = view.findViewById(R.id.share_num_container);
            this.mButtonMoreContainer = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
            this.mBtnMore = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
            View findViewById = view.findViewById(R.id.new_agree_view);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.mAgreeView = agreeView;
                agreeView.setAfterClickListener(new a(this));
            }
            this.mManageViewContainer = view.findViewById(R.id.manage_view_container);
            EMTextView eMTextView3 = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
            this.mManageText = eMTextView3;
            c.a.s0.s.u.c.d(eMTextView3).A(R.string.F_X01);
            this.mManageImageView = (ImageView) view.findViewById(R.id.thread_info_manage_img);
            this.mSelectImg = (ImageView) view.findViewById(R.id.manage_select_img);
            EMTextView eMTextView4 = (EMTextView) view.findViewById(R.id.manage_select_text);
            this.mSelectText = eMTextView4;
            c.a.s0.s.u.c.d(eMTextView4).A(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manage_select_container);
            this.mSelectContainer = linearLayout;
            linearLayout.setOnTouchListener(new b(this));
            this.mSelectText.setOnClickListener(new c(this));
            this.mQQShareContainer = (LinearLayout) view.findViewById(R.id.qq_share_container);
            this.mQQShareImageView = (ImageView) view.findViewById(R.id.qq_share_image);
            EMTextView eMTextView5 = (EMTextView) view.findViewById(R.id.qq_share_text);
            this.mQQShareText = eMTextView5;
            if (eMTextView5 != null) {
                c.a.s0.s.u.c.d(eMTextView5).A(R.string.F_X01);
            }
            this.mCollectNumContainer = (LinearLayout) view.findViewById(R.id.collect_num_container);
            this.mCollectNumImageView = (ImageView) view.findViewById(R.id.collect_num_image);
            EMTextView eMTextView6 = (EMTextView) view.findViewById(R.id.collect_num_text);
            this.mCollectNumText = eMTextView6;
            if (eMTextView6 != null) {
                c.a.s0.s.u.c.d(eMTextView6).A(R.string.F_X01);
            }
            this.mSelectContainer.setOnClickListener(new d(this));
            this.mCommentContainer.setOnClickListener(this);
            this.mShareContainer.setOnClickListener(this);
            this.mManageViewContainer.setOnClickListener(this);
            this.mSelectImg.setOnClickListener(this);
            LinearLayout linearLayout2 = this.mQQShareContainer;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(this);
            }
            LinearLayout linearLayout3 = this.mCollectNumContainer;
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(this);
            }
        }
    }

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.isVisible : invokeV.booleanValue;
    }

    public final int j(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, e2Var)) == null) {
            if (e2Var == null) {
                return 0;
            }
            if (e2Var.I2()) {
                return 11;
            }
            if (e2Var.P1()) {
                return 10;
            }
            if (e2Var.S1()) {
                return 9;
            }
            if (e2Var.R1()) {
                return 8;
            }
            if (e2Var.Q1()) {
                return 7;
            }
            if (e2Var.A1) {
                return 6;
            }
            int i2 = e2Var.d0;
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

    public final void k(Context context, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, context, e2Var) == null) || e2Var == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        int i2 = this.f40482g;
        String str = i2 == 2 ? "frs" : (i2 == 4 || i2 == 9 || i2 == 1) ? "index" : "";
        videoItemData.buildWithThreadData(e2Var);
        arrayList.add(videoItemData);
        y.e(context, arrayList, e2Var.L() != null ? e2Var.L().oriUgcNid : null, videoItemData.isVerticalVideo == 1, 0, null, "from_nani_video", "personalize_page", "", str, str, true, e2Var.n, true);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.mShareContainer.setVisibility(o(1) ? 0 : 8);
            this.mCommentContainer.setVisibility(o(2) ? 0 : 8);
            View view = this.mManageViewContainer;
            int i2 = 4;
            if (o(4)) {
                i2 = 0;
            } else if (!o(64)) {
                i2 = 8;
            }
            view.setVisibility(i2);
            this.mAgreeView.setVisibility(o(8) ? 0 : 8);
            this.mAgreeView.setAgreeAlone(o(32));
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, context) == null) {
            this.mContext = context;
            if (context instanceof BaseActivity) {
                this.mPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
            this.TBDS84 = n.f(this.mContext, R.dimen.tbds84);
            initRootView();
        }
    }

    public final boolean n(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, e2Var)) == null) ? (e2Var == null || !e2Var.H2() || e2Var.t1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? (i2 & this.f40480e) > 0 : invokeI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.t);
            MessageManager.getInstance().registerListener(this.u);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || this.n == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.n = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.o, R.color.CAM_X0201);
        MaskView maskView = this.p;
        if (maskView != null) {
            maskView.onChangeSkin();
        }
        SkinManager.setViewTextColor(this.mBarName, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f40481f, R.color.CAM_X0107);
        updateReplyStateUI();
        updateCollectStateUI(this.mData);
        updateShareStateUI(this.mData);
        updateManagerUI();
        ThreadManageDialog threadManageDialog = this.mManageDialog;
        if (threadManageDialog != null) {
            threadManageDialog.onChangeSkinType();
        }
        AgreeView agreeView = this.mAgreeView;
        if (agreeView != null) {
            agreeView.onChangeSkinType(this.n);
            AgreeView agreeView2 = this.mAgreeView;
            e2 e2Var = this.mData;
            agreeView2.setAlpha((e2Var == null || e2Var.getType() != e2.Y3) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view) == null) {
            e2 e2Var = this.mData;
            if (e2Var == null || e2Var.getType() != e2.Y3) {
                if (view == this.mBarName) {
                    p(view);
                } else if (view == this.mCommentContainer) {
                    onCommentNumClick(view);
                    int i2 = this.f40482g;
                    if (i2 == 1 || i2 == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                } else if (view == this.mShareContainer) {
                    onShareNumClick(view);
                    int i3 = this.f40482g;
                    if (i3 == 1 || i3 == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                } else if (view == this.mBtnMore) {
                    q(view);
                } else if (view == this.mManageViewContainer) {
                    onManageViewClick(view);
                } else if (view == this.mSelectImg) {
                    onSelectClick(view);
                } else if (view == this.mQQShareContainer) {
                    onQQShareClick(view);
                } else if (view == this.mCollectNumContainer) {
                    onCollectNumClick(view);
                }
            }
        }
    }

    public void onCollectNumClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
        }
    }

    public void onCommentNumClick(View view) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, view) == null) || (e2Var = this.mData) == null || this.mContext == null) {
            return;
        }
        c.a.t0.g0.m.a(e2Var.v1());
        StatisticItem statisticItem = new StatisticItem("c12942");
        statisticItem.param("obj_locate", this.f40482g);
        statisticItem.param("obj_type", getThreadType());
        statisticItem.param("tid", this.mData.v1());
        statisticItem.param("nid", this.mData.G0());
        if (this.f40482g == 18) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.mData.U());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f40485j);
        }
        c.a.s0.o0.c f2 = TbPageExtraHelper.f(this);
        if (f2 != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
        }
        if (TbPageExtraHelper.m() != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(statisticItem);
        if (this.mData.G1() != null && this.mData.G1().room_id.longValue() > 0 && !StringUtils.isNull(this.mData.G1().room_name)) {
            ((c.a.s0.j0.c.a) ServiceManager.getService(c.a.s0.j0.c.a.a.a())).a(this.mPageContext, this.mData.G1().room_id.longValue());
        } else if (this.mData.t1() != null && !TextUtils.isEmpty(this.mData.t1().video_url)) {
            k(this.mContext, this.mData);
        } else {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.mData, null, this.k, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.mData.U()));
            addLocateParam.setForumName(this.mData.a0());
            if (this.mData.j0() && this.mData.Z() != null) {
                addLocateParam.setForumId(this.mData.Z().getForumId());
                addLocateParam.setForumName(this.mData.Z().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            i iVar = this.r;
            if (iVar != null) {
                iVar.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && n(this.mData)) {
                addLocateParam.setNeedPreLoad(true);
                l.update(this.mData);
            }
            if (this.mData.X1) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.mData.g2() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.sourceFromForPb);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
        }
        StatisticItem statisticItem2 = new StatisticItem("c12291");
        statisticItem2.param("obj_locate", this.f40482g);
        TiebaStatic.log(statisticItem2);
        h();
        g(view, this.mData);
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void onDataAfterLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    public void onDestroy() {
        ThreadManageDialog threadManageDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (threadManageDialog = this.mManageDialog) == null) {
            return;
        }
        threadManageDialog.destory();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    public void onManageViewClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            if (this.mManageDialog == null) {
                this.mManageDialog = new ThreadManageDialog(this.mPageContext, o(16));
            }
            this.mManageDialog.setData(this.mData);
            this.mManageDialog.showDialog();
            if (this.mData != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.mData.U()).param("tid", this.mData.g0()));
            }
        }
    }

    public void onQQShareClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
        }
    }

    public void onSelectClick(View view) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, view) == null) || this.mSelectImg == null || (e2Var = this.mData) == null || this.mSelectText == null || e2Var.F2()) {
            return;
        }
        boolean z = true;
        if (!this.mData.m2() && c.a.t0.d1.b.f().i()) {
            if (c.a.t0.d1.b.f().a(this.mData)) {
                this.mData.k4(true);
            }
        } else if (!this.mData.n2() && c.a.t0.d1.a.h().j()) {
            if (c.a.t0.d1.a.h().a(this.mData)) {
                this.mData.l4(true);
            }
        } else {
            c.a.t0.d1.b.f().l(this.mData);
            this.mData.k4(false);
            c.a.t0.d1.a.h().l(this.mData);
            this.mData.l4(false);
        }
        if (!this.mData.m2() && !this.mData.n2()) {
            c.a.s0.s.u.c.d(this.mSelectText).x(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.mSelectImg, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        } else {
            SkinManager.setViewTextColor(this.mSelectText, R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.mSelectImg, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
        }
        j jVar = this.q;
        if (jVar != null) {
            if (!this.mData.m2() && !this.mData.n2()) {
                z = false;
            }
            jVar.a(z);
        }
    }

    public void onShareNumClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view) == null) {
            if ((ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.mContext)) && this.mData != null) {
                r();
                g(view, this.mData);
                if (AntiHelper.e(getContext(), this.mData)) {
                    return;
                }
                s();
                View.OnClickListener onClickListener = this.m;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public final void p(View view) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, view) == null) || (e2Var = this.mData) == null || StringUtils.isNull(e2Var.a0())) {
            return;
        }
        if (!StringUtils.isNull(this.k) && !StringUtils.isNull(this.l)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.mData.a0(), this.k, this.l)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.mData.a0(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view) == null) {
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.mData == null) {
            return;
        }
        StatisticItem e2 = e();
        e2.param("thread_type", this.mData.r1());
        TiebaStatic.log(e2);
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.isShareVisible = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCommentImageView.getLayoutParams();
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds78);
            this.mCommentImageView.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x032e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s() {
        e2 e2Var;
        String v1;
        String str;
        String str2;
        boolean z;
        boolean z2;
        Uri parse;
        String format;
        ShareItem shareItem;
        OriginalThreadInfo.ShareInfo generateShareInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (e2Var = this.mData) == null || this.mContext == null) {
            return;
        }
        String valueOf = String.valueOf(e2Var.U());
        String a0 = this.mData.a0();
        OriginalForumInfo originalForumInfo = this.mData.J1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            a0 = originalForumInfo.ori_fname;
        }
        String str3 = a0;
        String str4 = valueOf;
        String title = this.mData.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.mData.o();
        }
        String str5 = title;
        if (this.mData.G2()) {
            v1 = this.mData.L().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + this.mData.L().oriUgcType + "&dvid=" + this.mData.L().oriUgcVid + "&nid=" + this.mData.L().oriUgcNid;
        } else {
            v1 = this.mData.v1();
            str = "?share=9105&fr=sharewise";
        }
        String str6 = str;
        String str7 = v1;
        String str8 = str6 + "&share_from=post";
        if (this.mData.G1() != null && this.mData.G1().room_id.longValue() > 0) {
            str2 = String.format("http://tieba.baidu.com/mo/q/wise-main-share/shareVoiceRoom?room_id=%s", String.valueOf(this.mData.G1().room_id));
            z = true;
        } else {
            str2 = "http://tieba.baidu.com/p/" + str7 + str8;
            z = false;
        }
        if (this.mData.o1() != null && this.mData.o1().user_info != null) {
            try {
                str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.mData.o1().user_info.user_name, "utf-8");
                z2 = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (this.mData.o1() != null && this.mData.o1().isLegalYYLiveData()) {
                str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.mData.o1().mYyExtData.mSid + "&livessid=" + this.mData.o1().mYyExtData.mSsid + "&uid=" + this.mData.o1().mYyExtData.mYyUid;
                z2 = false;
            }
            String i2 = i(this.mData);
            parse = i2 != null ? null : Uri.parse(i2);
            String o = this.mData.o();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.mData.G2() && this.mData.J() != null) {
                format = (TextUtils.isEmpty(this.mData.getTitle()) || TextUtils.isEmpty(o)) ? MessageFormat.format(string2, this.mData.J().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : o;
            } else if (!z) {
                StringBuilder sb = new StringBuilder(TbadkCoreApplication.getInst().getString(R.string.voice_room_all_together));
                if (this.mData.Z() != null && !StringUtils.isNull(this.mData.Z().f13273b)) {
                    sb.insert(0, String.format(TbadkCoreApplication.getInst().getString(R.string.voice_room_forum), this.mData.Z().f13273b));
                }
                format = sb.toString();
            } else {
                format = MessageFormat.format(string, str5, o);
            }
            int k = c.a.s0.t.g.g.k(this.mData);
            String cutString = m.cutString(str5, 100);
            String cutString2 = m.cutString(format, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            if (!this.mData.G2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (k == 2 && this.mData.t1() != null) {
                    shareItem.R = this.mData.t1().play_count.intValue();
                } else if (k == 1) {
                    shareItem.R = this.mData.E1();
                }
                shareItem.D = o;
            }
            shareItem.t = str2;
            shareItem.q = str7;
            shareItem.J = str4;
            shareItem.p = str3;
            shareItem.K = str7;
            shareItem.f40766f = true;
            shareItem.o = this.f40483h;
            shareItem.E = getShareObjSource();
            shareItem.M = k;
            shareItem.F = 3;
            shareItem.G = j(this.mData);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (this.mData.G2()) {
                z2 = false;
            }
            shareItem.m0 = z2;
            if (z2) {
                shareItem.k0 = this.mData.b1();
            }
            f();
            generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.mData);
            shareItem.T = generateShareInfo;
            if (StringUtils.isNull(generateShareInfo.showText, true)) {
                if (StringUtils.isNull(this.mData.getTitle(), true)) {
                    OriginalThreadInfo originalThreadInfo = this.mData.z1;
                    if (originalThreadInfo != null) {
                        shareItem.T.showText = originalThreadInfo.f40133g;
                    }
                } else {
                    shareItem.T.showText = this.mData.getTitle();
                }
            }
            if (StringUtils.isNull(shareItem.T.showText, true)) {
                shareItem.T.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
            }
            if (this.f40482g != 13) {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(this.mData, 2);
            } else {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(this.mData);
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
            if (c.a.s0.b.d.d0()) {
                shareItem.y0 = c.a.s0.t.g.g.j(this.mData, k);
                shareItem.z0 = c.a.s0.t.g.g.i(this.mData, k, str3, shareItem.R, "", "");
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            boolean z3 = this.mData.r1() != 49 || this.mData.r1() == 60 || this.mData.r1() == 69;
            shareDialogConfig.mIsVoiceRoom = z;
            shareDialogConfig.setIsAlaLive(z3);
            c(shareDialogConfig);
            c.a.t0.k0.h.c().l(shareDialogConfig);
        }
        z2 = true;
        if (this.mData.o1() != null) {
            str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.mData.o1().mYyExtData.mSid + "&livessid=" + this.mData.o1().mYyExtData.mSsid + "&uid=" + this.mData.o1().mYyExtData.mYyUid;
            z2 = false;
        }
        String i22 = i(this.mData);
        if (i22 != null) {
        }
        String o2 = this.mData.o();
        String string3 = getResources().getString(R.string.share_content_tpl);
        String string22 = getResources().getString(R.string.default_share_content_tpl);
        if (!this.mData.G2()) {
        }
        if (!z) {
        }
        int k2 = c.a.s0.t.g.g.k(this.mData);
        String cutString3 = m.cutString(str5, 100);
        String cutString22 = m.cutString(format, 100);
        shareItem = new ShareItem();
        shareItem.r = cutString3;
        shareItem.s = cutString22;
        if (!this.mData.G2()) {
        }
        shareItem.t = str2;
        shareItem.q = str7;
        shareItem.J = str4;
        shareItem.p = str3;
        shareItem.K = str7;
        shareItem.f40766f = true;
        shareItem.o = this.f40483h;
        shareItem.E = getShareObjSource();
        shareItem.M = k2;
        shareItem.F = 3;
        shareItem.G = j(this.mData);
        if (parse != null) {
        }
        if (this.mData.G2()) {
        }
        shareItem.m0 = z2;
        if (z2) {
        }
        f();
        generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.mData);
        shareItem.T = generateShareInfo;
        if (StringUtils.isNull(generateShareInfo.showText, true)) {
        }
        if (StringUtils.isNull(shareItem.T.showText, true)) {
        }
        if (this.f40482g != 13) {
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
        if (c.a.s0.b.d.d0()) {
        }
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, shareItem, true, true);
        if (this.mData.r1() != 49) {
        }
        shareDialogConfig2.mIsVoiceRoom = z;
        shareDialogConfig2.setIsAlaLive(z3);
        c(shareDialogConfig2);
        c.a.t0.k0.h.c().l(shareDialogConfig2);
    }

    public void setAgreeClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
        }
    }

    public void setAgreeStatisticData(c.a.s0.s.q.f fVar) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, fVar) == null) || (agreeView = this.mAgreeView) == null) {
            return;
        }
        agreeView.setStatisticData(fVar);
    }

    public void setAgreeViewType(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, e2Var) == null) && e2Var != null && e2Var.G2()) {
            this.mAgreeView.setAgreeAlone(true);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.barNameClickEnable = z;
            TextView textView = this.mBarName;
            if (textView != null) {
                textView.setClickable(z);
            }
        }
    }

    public void setCollectVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048624, this, z) == null) || (linearLayout = this.mCollectNumContainer) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z) == null) || (view = this.mCommentContainer) == null) {
            return;
        }
        view.setClickable(z);
        this.mCommentImageView.setEnabled(z);
        this.mCommentNum.setEnabled(z);
    }

    public void setCommentNumEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, context) == null) {
            this.mContext = context;
            if (this.mPageContext == null) {
                if (context instanceof BaseActivity) {
                    this.mPageContext = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
                }
            }
        }
    }

    public boolean setData(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, e2Var)) == null) {
            if (e2Var == null) {
                setVisibility(8);
                return false;
            }
            this.mData = e2Var;
            updateLayout();
            updateBarName(e2Var);
            t(e2Var);
            updateReplyNum(e2Var);
            updateCollectNum(e2Var);
            updateShareNum(e2Var);
            updatePraiseNum(e2Var);
            updateSelectView(e2Var);
            updateManageView(e2Var);
            setVisibility(this.isVisible ? 0 : 8);
            updateOperationMaskView(e2Var);
            onDataAfterLayout();
            return this.isVisible;
        }
        return invokeL.booleanValue;
    }

    public void setDisPraiseFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.f40482g = i2;
            AgreeView agreeView = this.mAgreeView;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.f40484i = i2;
            AgreeView agreeView = this.mAgreeView;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.s = z;
        }
    }

    public void setIsBarViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.isBarNameVisible = z;
        }
    }

    public void setLiveShareEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.isLiveShareEnable = z;
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.isManageVisible = z;
        }
    }

    public void setMultiForumCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
        }
    }

    public void setNeedAddPraiseIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.needAddReplyIcon = z;
        }
    }

    public void setOnCommentClickCallback(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, iVar) == null) {
            this.r = iVar;
        }
    }

    public void setOnSelectStatusChangeListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, jVar) == null) {
            this.q = jVar;
        }
    }

    public void setQQShareVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048643, this, z) == null) || (linearLayout = this.mQQShareContainer) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.isReplyTimeVisible = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.isSelectVisible = z;
        }
    }

    public void setShareClickable(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048646, this, z) == null) || (view = this.mShareContainer) == null) {
            return;
        }
        view.setClickable(z);
        this.mShareImageView.setEnabled(z);
        this.mShareNum.setEnabled(z);
    }

    public void setShareReportFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.f40483h = i2;
        }
    }

    public void setShareVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
        }
    }

    public void setShowCommonView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            this.f40480e = i2;
            l();
        }
    }

    public void setShowPraiseNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            this.k = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            this.f40485j = str;
            AgreeView agreeView = this.mAgreeView;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.l = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            if (z && this.p == null) {
                MaskView maskView = new MaskView(getContext());
                this.p = maskView;
                addView(maskView);
            }
            MaskView maskView2 = this.p;
            if (maskView2 != null) {
                maskView2.setVisibility(z ? 0 : 8);
            }
        }
    }

    public final void t(e2 e2Var) {
        String T0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048656, this, e2Var) == null) || this.f40481f == null || e2Var == null) {
            return;
        }
        if (e2Var.w0() > 0 && this.isReplyTimeVisible) {
            this.f40481f.setVisibility(0);
            if (this.f40482g == 3) {
                T0 = e2Var.U0();
            } else {
                T0 = e2Var.T0();
            }
            this.f40481f.setText(T0);
            this.isVisible = true;
            return;
        }
        this.f40481f.setVisibility(8);
    }

    public void updateBarName(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, e2Var) == null) {
            this.mBarName.setVisibility(8);
        }
    }

    public void updateCollectNum(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, e2Var) == null) {
            EMTextView eMTextView = this.mCollectNumText;
            if (eMTextView != null) {
                int i2 = e2Var.P2;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.mark);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(e2Var);
        }
    }

    public void updateCollectStateUI(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048659, this, e2Var) == null) || this.mCollectNumImageView == null) {
            return;
        }
        if (e2Var != null && e2Var.m0() != 0) {
            WebPManager.setPureDrawable(this.mCollectNumImageView, R.drawable.icon_pure_pb_operate_collect26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.mCollectNumImageView, R.drawable.icon_pure_pb_operate_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void updateLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            c.a.s0.s.j0.h.b(this.mRootView);
        }
    }

    public void updateManageView(e2 e2Var) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, e2Var) == null) || this.mManageViewContainer == null || e2Var == null) {
            return;
        }
        this.isManageVisible = o(4);
        if (e2Var.J1 != null) {
            this.isManageVisible = false;
        }
        if (this.isManageVisible && ((linearLayout = this.mSelectContainer) == null || linearLayout.getVisibility() == 8)) {
            this.mManageViewContainer.setVisibility(0);
            String string = this.mContext.getString(R.string.manage);
            this.mManageText.setText(string);
            this.mManageText.setContentDescription(string);
            this.isVisible = true;
        } else {
            this.mManageViewContainer.setVisibility(o(64) ? 4 : 8);
        }
        updateManagerUI();
    }

    public void updateManagerUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            WebPManager.setPureDrawable(this.mManageImageView, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.mManageText;
            e2 e2Var = this.mData;
            if (e2Var != null && e2Var.getType() == e2.Y3) {
                color = c.a.t0.w3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.mManageImageView;
            e2 e2Var2 = this.mData;
            imageView.setEnabled(e2Var2 == null || e2Var2.getType() != e2.Y3);
        }
    }

    public void updateOperationMaskView(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048663, this, e2Var) == null) && e2Var != null && this.f40482g == 13) {
            showOperationMaskView(e2Var.N2 == 1);
        }
    }

    public void updatePraiseNum(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, e2Var) == null) {
            setAgreeViewType(e2Var);
            if (e2Var.B() != null) {
                e2Var.B().isInThread = true;
                this.mAgreeView.setCardType(e2Var.R0());
                this.mAgreeView.setThreadData(e2Var);
                this.mAgreeView.setData(e2Var.B());
            }
            AgreeView agreeView = this.mAgreeView;
            e2 e2Var2 = this.mData;
            agreeView.setAlpha((e2Var2 == null || e2Var2.getType() != e2.Y3) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    public void updateReplyNum(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048665, this, e2Var) == null) || this.mCommentNum == null || e2Var == null) {
            return;
        }
        if (this.isCommentNumEnable) {
            this.mCommentContainer.setVisibility(0);
            if (e2Var.V0() > 0) {
                this.mCommentNum.setVisibility(0);
                String numFormatOverWan = StringHelper.numFormatOverWan(e2Var.V0());
                if (this.needAddReplyIcon) {
                    updateReplyStateUI();
                    this.mCommentNum.setText(numFormatOverWan);
                } else {
                    this.mCommentNum.setText(String.format(this.mContext.getString(R.string.reply_num_tip), numFormatOverWan));
                }
                EMTextView eMTextView = this.mCommentNum;
                eMTextView.setContentDescription(this.mContext.getString(R.string.reply_num) + numFormatOverWan);
                this.isVisible = true;
                return;
            } else if (this.needAddReplyIcon) {
                updateReplyStateUI();
                this.mCommentNum.setText(this.mContext.getString(R.string.action_comment_default));
                this.mCommentNum.setVisibility(0);
                this.isVisible = true;
                return;
            } else {
                this.mCommentNum.setVisibility(8);
                return;
            }
        }
        this.mCommentContainer.setVisibility(8);
    }

    public void updateReplyStateUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            if (this.needAddReplyIcon) {
                WebPManager.setPureDrawable(this.mCommentImageView, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.mCommentImageView;
            e2 e2Var = this.mData;
            imageView.setEnabled(e2Var == null || e2Var.getType() != e2.Y3);
            EMTextView eMTextView = this.mCommentNum;
            e2 e2Var2 = this.mData;
            if (e2Var2 != null && e2Var2.getType() == e2.Y3) {
                color = c.a.t0.w3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            c.a.s0.s.j0.h.a(this.mCommentImageView, R.drawable.icon_pure_card_comment20);
            c.a.s0.s.j0.h.e(this.mCommentNum);
        }
    }

    public void updateSelectView(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048667, this, e2Var) == null) || this.mSelectContainer == null || this.mSelectImg == null || this.mSelectText == null || e2Var == null) {
            return;
        }
        if (!this.s) {
            View view = this.o;
            if (view != null) {
                view.setVisibility(8);
            }
            this.mSelectContainer.setVisibility(8);
        } else if (this.isSelectVisible && !o(128) && (c.a.t0.d1.b.f().i() || c.a.t0.d1.a.h().j())) {
            if (this.o == null) {
                View view2 = new View(getContext());
                this.o = view2;
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                addView(this.o);
                this.o.setAlpha(0.5f);
                this.o.setOnTouchListener(new e(this));
                this.o.setOnClickListener(new f(this));
            }
            int k = n.k(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
            if (layoutParams == null) {
                this.o.setLayoutParams(new FrameLayout.LayoutParams(k, -1));
            } else {
                layoutParams.width = k;
                requestLayout();
            }
            if (!this.mData.m2() && !this.mData.n2()) {
                c.a.s0.s.u.c.d(this.mSelectText).x(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.mSelectImg, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.mSelectText, R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.mSelectImg, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            }
            this.o.setVisibility(0);
            this.mSelectContainer.setVisibility(8);
        } else {
            View view3 = this.o;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            this.mSelectContainer.setVisibility(8);
        }
    }

    public void updateShareNum(e2 e2Var) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048668, this, e2Var) == null) || (view = this.mShareContainer) == null || this.mShareNum == null || e2Var == null) {
            return;
        }
        if (this.isShareVisible) {
            view.setVisibility(0);
            long d1 = e2Var.d1();
            if ((e2Var.k2() || e2Var.w2()) && e2Var.o1() != null && e2Var.o1().share_info != null) {
                d1 = e2Var.o1().share_info.share_count;
            }
            String string = this.mContext.getString(R.string.share);
            if (d1 > 0) {
                string = StringHelper.numFormatOverWan(d1);
            }
            this.mShareNum.setText(string);
            this.isVisible = true;
            updateShareStateUI(e2Var);
            return;
        }
        view.setVisibility(8);
    }

    public void updateShareStateUI(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, e2Var) == null) {
            WebPManager.setPureDrawable(this.mShareImageView, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(e2Var)) {
                setShareClickable(true);
                this.mShareNum.setTextColor(c.a.t0.w3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                if (e2Var != null && e2Var.z1 != null) {
                    e2 e2Var2 = this.mData;
                    if (e2Var2.z1.m || e2Var2.P4()) {
                        setShareClickable(false);
                        this.mShareNum.setTextColor(c.a.t0.w3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
                setShareClickable(true);
                c.a.s0.s.u.c.d(this.mShareNum).x(R.color.CAM_X0107);
            }
            e2 e2Var3 = this.mData;
            if (e2Var3 != null && e2Var3.getType() == e2.Y3) {
                this.mShareImageView.setEnabled(false);
                this.mShareNum.setTextColor(c.a.t0.w3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
            c.a.s0.s.j0.h.a(this.mShareImageView, R.drawable.icon_pure_card_share20);
            c.a.s0.s.j0.h.e(this.mShareNum);
        }
    }

    public View getRootView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRootView : (LinearLayout) invokeV.objValue;
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
        this.TBDS84 = n.f(TbadkApplication.getInst(), R.dimen.tbds84);
        this.f40480e = 11;
        this.isVisible = false;
        this.isReplyTimeVisible = true;
        this.isPraiseNumVisible = true;
        this.barNameClickEnable = true;
        this.needAddReplyIcon = false;
        this.isBarNameVisible = false;
        this.isCommentNumEnable = true;
        this.isLiveShareEnable = false;
        this.isShareVisible = true;
        this.isManageVisible = false;
        this.isSelectVisible = true;
        this.f40482g = 2;
        this.f40483h = 1;
        this.n = 3;
        this.q = null;
        this.s = true;
        this.t = new g(this, 2921416);
        this.u = new h(this, 2921417);
        m(context);
    }
}
