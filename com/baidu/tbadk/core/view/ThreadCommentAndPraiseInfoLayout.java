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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.d1.x;
import c.a.q0.s.q.d2;
import c.a.r0.a0.m;
import c.a.r0.w0.l0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
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
    public int f47900e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47901f;

    /* renamed from: g  reason: collision with root package name */
    public int f47902g;

    /* renamed from: h  reason: collision with root package name */
    public int f47903h;

    /* renamed from: i  reason: collision with root package name */
    public int f47904i;
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
    public String f47905j;
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
    public d2 mData;
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

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f47906e;

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
            this.f47906e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47906e.m != null) {
                    this.f47906e.m.onClick(view);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.f47906e;
                threadCommentAndPraiseInfoLayout.g(view, threadCommentAndPraiseInfoLayout.mData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f47907e;

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
            this.f47907e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f47907e.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f47908e;

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
            this.f47908e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47908e.mSelectImg.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f47909e;

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
            this.f47909e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47909e.mSelectImg.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f47910e;

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
            this.f47910e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f47910e.mSelectImg.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f47911e;

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
            this.f47911e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47911e.mSelectImg.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f47912a;

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
            this.f47912a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d2)) {
                return;
            }
            d2 d2Var = (d2) customResponsedMessage.getData();
            if (this.f47912a.mData == null || d2Var == null) {
                return;
            }
            String str = d2Var.L() != null ? d2Var.L().oriUgcNid : "";
            String str2 = this.f47912a.mData.L() != null ? this.f47912a.mData.L().oriUgcNid : "";
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (str.equals(str2)) {
                    this.f47912a.mData.m4(d2Var.U0());
                    this.f47912a.updateReplyNum(d2Var);
                    return;
                }
                return;
            }
            String f0 = d2Var.f0();
            String f02 = this.f47912a.mData.f0();
            if ("0".equals(f02) || TextUtils.isEmpty(f02) || !f02.equals(f0)) {
                return;
            }
            this.f47912a.mData.m4(d2Var.U0());
            this.f47912a.updateReplyNum(d2Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f47913a;

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
            this.f47913a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str) || (d2Var = this.f47913a.mData) == null || "0".equals(d2Var.f0()) || !str.equals(this.f47913a.mData.f0())) {
                return;
            }
            if ((this.f47913a.mData.h2() || this.f47913a.mData.t2()) && this.f47913a.mData.l1() != null) {
                if (this.f47913a.mData.l1() != null && this.f47913a.mData.l1().share_info != null) {
                    this.f47913a.mData.l1().share_info.share_count++;
                }
            } else {
                d2 d2Var2 = this.f47913a.mData;
                d2Var2.r4(d2Var2.b1() + 1);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.f47913a;
            threadCommentAndPraiseInfoLayout.updateShareNum(threadCommentAndPraiseInfoLayout.mData);
        }
    }

    /* loaded from: classes6.dex */
    public interface i {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes6.dex */
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
        this.TBDS84 = l.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.f47900e = 11;
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
        this.f47902g = 2;
        this.f47903h = 1;
        this.n = 3;
        this.q = null;
        this.s = true;
        this.t = new g(this, 2921416);
        this.u = new h(this, 2921417);
        n(context);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            int i2 = this.f47903h;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            int i2 = this.f47902g;
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
            d2 d2Var = this.mData;
            if (d2Var == null) {
                return 0;
            }
            if (d2Var.z1) {
                return 4;
            }
            if (d2Var.o1() == 49 || this.mData.o1() == 69) {
                return 5;
            }
            if (this.mData.q1() != null) {
                return 1;
            }
            if (this.mData.getType() == d2.a3 || this.mData.getType() == d2.w3) {
                return ListUtils.getCount(this.mData.D1()) > 0 ? 3 : 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            d2 d2Var = this.mData;
            if (d2Var == null) {
                return 0;
            }
            if (d2Var.M1()) {
                return 1;
            }
            if (this.mData.P1()) {
                return 2;
            }
            if (this.mData.N1()) {
                return 3;
            }
            return this.mData.O1() ? 4 : 0;
        }
        return invokeV.intValue;
    }

    public void addPraiseStats(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.mData != null || i2 >= 0) {
                StatisticItem d2 = d(i2);
                d2.param("thread_type", this.mData.o1());
                TiebaStatic.log(d2);
            }
        }
    }

    public final void c(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareDialogConfig) == null) {
            int i2 = this.f47902g;
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
                statisticItem.param("tid", this.mData.s1());
                if (this.mData.o1() == 40) {
                    statisticItem.param("obj_param1", "2");
                } else if (this.mData.o1() == 0) {
                    statisticItem.param("obj_param1", "1");
                }
                statisticItem.param("obj_source", "1");
                statisticItem.param("fid", this.mData.T());
                statisticItem.param("obj_locate", this.f47902g);
                statisticItem.param("obj_id", i2);
                if (!k.isEmpty(this.statFloor)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.statFloor);
                }
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
                }
                statisticItem.param("nid", this.mData.F0());
                statisticItem.param("card_type", this.mData.Q0());
                statisticItem.param("recom_source", this.mData.X0);
                statisticItem.param("ab_tag", this.mData.Z0);
                statisticItem.param("weight", this.mData.Y0);
                statisticItem.param("extra", this.mData.a1);
                if (this.mData.L() != null && !k.isEmpty(this.mData.L().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.mData.L().oriUgcVid);
                }
                c.a.q0.m0.c f2 = TbPageExtraHelper.f(this);
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
            int i3 = this.f47903h;
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
            statisticItem.param("fid", this.mData.T());
            statisticItem.param("tid", this.mData.s1());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f47904i);
            if (!k.isEmpty(this.statFloor)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.statFloor);
            }
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.mData.l1() != null && this.mData.l1().user_info != null && this.mData.l1().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.mData.l1().user_info.is_official);
            }
            statisticItem.param("card_type", this.mData.Q0()).param("ab_tag", this.mData.Z0).param("recom_source", this.mData.X0).param("weight", this.mData.Y0).param("extra", this.mData.a1);
            if (this.mData.M1()) {
                statisticItem.param("obj_type", 10);
            } else if (this.mData.P1()) {
                statisticItem.param("obj_type", 9);
            } else if (this.mData.O1()) {
                statisticItem.param("obj_type", 8);
            } else if (this.mData.N1()) {
                statisticItem.param("obj_type", 7);
            } else {
                d2 d2Var = this.mData;
                if (d2Var.z1) {
                    statisticItem.param("obj_type", 6);
                } else {
                    int i4 = d2Var.i0;
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
            int i5 = this.f47902g;
            if (i5 == 1 || i5 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
            }
            if (this.f47902g == 18) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f47905j);
            }
            if (this.mData.L() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.mData.L().oriUgcNid);
                if (this.mData.P1() || this.mData.O1()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.mData.L().oriUgcVid);
                }
            }
            if (this.mData.R1()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.mData.M1() && !this.mData.P1()) {
                int i6 = this.mData.i0;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.mPageContext;
            if (tbPageContext != null) {
                c.a.q0.n0.c.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.mData.F0());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void f() {
        d2 d2Var;
        ItemInfo itemInfo;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Context context = this.mContext;
            if ((context instanceof l0) && ((l0) context).isInScoreTab() && (d2Var = this.mData) != null && d2Var.s0() == null && (itemInfo = ((l0) this.mContext).getItemInfo()) != null) {
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
                this.mData.Z3(itemData);
            }
        }
    }

    public final void g(View view, d2 d2Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, d2Var) == null) || d2Var == null) {
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
        int i4 = this.f47902g;
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
        TiebaStatic.log(c.a.r0.i3.a.o("c13694", d2Var, i3, i2));
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

    public final String i(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, d2Var)) == null) {
            String str = null;
            if (d2Var == null) {
                return null;
            }
            if (d2Var.l1() != null && !TextUtils.isEmpty(d2Var.l1().cover)) {
                return d2Var.l1().cover;
            }
            if (d2Var.E0() == null) {
                return null;
            }
            ArrayList<MediaData> E0 = d2Var.E0();
            int size = E0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = E0.get(i2);
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
            return (str != null || d2Var.q1() == null || TextUtils.isEmpty(d2Var.q1().thumbnail_url)) ? str : d2Var.q1().thumbnail_url;
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
            this.f47901f = (TextView) view.findViewById(R.id.thread_info_reply_time);
            this.mRootView = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
            EMTextView eMTextView = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
            this.mCommentNum = eMTextView;
            c.a.q0.s.u.c.d(eMTextView).B(R.string.F_X01);
            this.mCommentImageView = (ImageView) view.findViewById(R.id.thread_info_commont_img);
            this.mCommentGrabSofa = (EMTextView) view.findViewById(R.id.thread_info_commont_grab_sofa);
            this.mCommentContainer = view.findViewById(R.id.thread_info_commont_container);
            EMTextView eMTextView2 = (EMTextView) view.findViewById(R.id.share_num);
            this.mShareNum = eMTextView2;
            c.a.q0.s.u.c.d(eMTextView2).B(R.string.F_X01);
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
            c.a.q0.s.u.c.d(eMTextView3).B(R.string.F_X01);
            this.mManageImageView = (ImageView) view.findViewById(R.id.thread_info_manage_img);
            this.mSelectImg = (ImageView) view.findViewById(R.id.manage_select_img);
            EMTextView eMTextView4 = (EMTextView) view.findViewById(R.id.manage_select_text);
            this.mSelectText = eMTextView4;
            c.a.q0.s.u.c.d(eMTextView4).B(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manage_select_container);
            this.mSelectContainer = linearLayout;
            linearLayout.setOnTouchListener(new b(this));
            this.mSelectText.setOnClickListener(new c(this));
            this.mQQShareContainer = (LinearLayout) view.findViewById(R.id.qq_share_container);
            this.mQQShareImageView = (ImageView) view.findViewById(R.id.qq_share_image);
            EMTextView eMTextView5 = (EMTextView) view.findViewById(R.id.qq_share_text);
            this.mQQShareText = eMTextView5;
            if (eMTextView5 != null) {
                c.a.q0.s.u.c.d(eMTextView5).B(R.string.F_X01);
            }
            this.mCollectNumContainer = (LinearLayout) view.findViewById(R.id.collect_num_container);
            this.mCollectNumImageView = (ImageView) view.findViewById(R.id.collect_num_image);
            EMTextView eMTextView6 = (EMTextView) view.findViewById(R.id.collect_num_text);
            this.mCollectNumText = eMTextView6;
            if (eMTextView6 != null) {
                c.a.q0.s.u.c.d(eMTextView6).B(R.string.F_X01);
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

    public final int j(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, d2Var)) == null) {
            if (d2Var == null) {
                return 0;
            }
            if (d2Var.F2()) {
                return 11;
            }
            if (d2Var.M1()) {
                return 10;
            }
            if (d2Var.P1()) {
                return 9;
            }
            if (d2Var.O1()) {
                return 8;
            }
            if (d2Var.N1()) {
                return 7;
            }
            if (d2Var.z1) {
                return 6;
            }
            int i2 = d2Var.i0;
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

    public final int k(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, d2Var)) == null) {
            if (d2Var != null) {
                if (d2Var.q2()) {
                    return 4;
                }
                if (d2Var.j0() == 1) {
                    return 3;
                }
                if (d2Var.M1()) {
                    return 5;
                }
                if (d2Var.P1()) {
                    return 6;
                }
                if (d2Var.N1()) {
                    return 7;
                }
                if (d2Var.O1()) {
                    return 8;
                }
                if (!d2Var.z1 || d2Var.y1 == null) {
                    return d2Var.r2() ? 2 : 1;
                }
                return 9;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void l(Context context, d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, context, d2Var) == null) || d2Var == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        int i2 = this.f47902g;
        String str = i2 == 2 ? "frs" : (i2 == 4 || i2 == 9 || i2 == 1) ? "index" : "";
        videoItemData.buildWithThreadData(d2Var);
        arrayList.add(videoItemData);
        x.d(context, arrayList, d2Var.L() != null ? d2Var.L().oriUgcNid : null, videoItemData.isVerticalVideo == 1, 0, null, "from_nani_video", "personalize_page", "", str, str, true, d2Var.n);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mShareContainer.setVisibility(p(1) ? 0 : 8);
            this.mCommentContainer.setVisibility(p(2) ? 0 : 8);
            View view = this.mManageViewContainer;
            int i2 = 4;
            if (p(4)) {
                i2 = 0;
            } else if (!p(64)) {
                i2 = 8;
            }
            view.setVisibility(i2);
            this.mAgreeView.setVisibility(p(8) ? 0 : 8);
            this.mAgreeView.setAgreeAlone(p(32));
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
            this.mContext = context;
            if (context instanceof BaseActivity) {
                this.mPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
            this.TBDS84 = l.g(this.mContext, R.dimen.tbds84);
            initRootView();
        }
    }

    public final boolean o(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, d2Var)) == null) ? (d2Var == null || !d2Var.E2() || d2Var.q1() == null) ? false : true : invokeL.booleanValue;
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
        SkinManager.setViewTextColor(this.f47901f, R.color.CAM_X0107);
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
            d2 d2Var = this.mData;
            agreeView2.setAlpha((d2Var == null || d2Var.getType() != d2.Q3) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view) == null) {
            d2 d2Var = this.mData;
            if (d2Var == null || d2Var.getType() != d2.Q3) {
                if (view == this.mBarName) {
                    q(view);
                } else if (view == this.mCommentContainer) {
                    onCommentNumClick(view);
                    int i2 = this.f47902g;
                    if (i2 == 1 || i2 == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                } else if (view == this.mShareContainer) {
                    onShareNumClick(view);
                    int i3 = this.f47902g;
                    if (i3 == 1 || i3 == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                } else if (view == this.mBtnMore) {
                    r(view);
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
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, view) == null) || (d2Var = this.mData) == null || this.mContext == null) {
            return;
        }
        m.a(d2Var.s1());
        StatisticItem statisticItem = new StatisticItem("c12942");
        statisticItem.param("obj_locate", this.f47902g);
        statisticItem.param("obj_type", getThreadType());
        statisticItem.param("tid", this.mData.s1());
        statisticItem.param("nid", this.mData.F0());
        if (this.f47902g == 18) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.mData.T());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f47905j);
        }
        c.a.q0.m0.c f2 = TbPageExtraHelper.f(this);
        if (f2 != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
        }
        if (TbPageExtraHelper.m() != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(statisticItem);
        if (this.mData.q1() != null && !TextUtils.isEmpty(this.mData.q1().video_url)) {
            l(this.mContext, this.mData);
        } else {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext).createFromThreadCfg(this.mData, null, this.k, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.mData.T()));
            addLocateParam.setForumName(this.mData.Z());
            if (this.mData.i0() && this.mData.Y() != null) {
                addLocateParam.setForumId(this.mData.Y().getForumId());
                addLocateParam.setForumName(this.mData.Y().getForumName());
            }
            addLocateParam.setJumpToCommentArea(true);
            i iVar = this.r;
            if (iVar != null) {
                iVar.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && o(this.mData)) {
                addLocateParam.setNeedPreLoad(true);
                c.a.r0.w0.l.c(this.mData);
            }
            if (this.mData.X1) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.mData.d2() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.sourceFromForPb);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
        }
        StatisticItem statisticItem2 = new StatisticItem("c12291");
        statisticItem2.param("obj_locate", this.f47902g);
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
                this.mManageDialog = new ThreadManageDialog(this.mPageContext, p(16));
            }
            this.mManageDialog.setData(this.mData);
            this.mManageDialog.showDialog();
            if (this.mData != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.mData.T()).param("tid", this.mData.f0()));
            }
        }
    }

    public void onQQShareClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
        }
    }

    public void onSelectClick(View view) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, view) == null) || this.mSelectImg == null || (d2Var = this.mData) == null || this.mSelectText == null || d2Var.C2()) {
            return;
        }
        boolean z = true;
        if (!this.mData.j2() && c.a.r0.w0.b.f().i()) {
            if (c.a.r0.w0.b.f().a(this.mData)) {
                this.mData.f4(true);
            }
        } else if (!this.mData.k2() && c.a.r0.w0.a.h().j()) {
            if (c.a.r0.w0.a.h().a(this.mData)) {
                this.mData.g4(true);
            }
        } else {
            c.a.r0.w0.b.f().l(this.mData);
            this.mData.f4(false);
            c.a.r0.w0.a.h().l(this.mData);
            this.mData.g4(false);
        }
        if (!this.mData.j2() && !this.mData.k2()) {
            c.a.q0.s.u.c.d(this.mSelectText).y(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.mSelectImg, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        } else {
            SkinManager.setViewTextColor(this.mSelectText, R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.mSelectImg, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
        }
        j jVar = this.q;
        if (jVar != null) {
            if (!this.mData.j2() && !this.mData.k2()) {
                z = false;
            }
            jVar.a(z);
        }
    }

    public void onShareNumClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view) == null) {
            if ((ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.mContext)) && this.mData != null) {
                s();
                g(view, this.mData);
                if (AntiHelper.e(getContext(), this.mData)) {
                    return;
                }
                t();
                View.OnClickListener onClickListener = this.m;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public final boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) ? (i2 & this.f47900e) > 0 : invokeI.booleanValue;
    }

    public final void q(View view) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, view) == null) || (d2Var = this.mData) == null || StringUtils.isNull(d2Var.Z())) {
            return;
        }
        if (!StringUtils.isNull(this.k) && !StringUtils.isNull(this.l)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createCfgForpersonalized(this.mData.Z(), this.k, this.l)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.mData.Z(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view) == null) {
        }
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

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || this.mData == null) {
            return;
        }
        StatisticItem e2 = e();
        e2.param("thread_type", this.mData.o1());
        TiebaStatic.log(e2);
    }

    public void setAgreeClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
        }
    }

    public void setAgreeStatisticData(c.a.q0.s.q.f fVar) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, fVar) == null) || (agreeView = this.mAgreeView) == null) {
            return;
        }
        agreeView.setStatisticData(fVar);
    }

    public void setAgreeViewType(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, d2Var) == null) && d2Var != null && d2Var.D2()) {
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

    public boolean setData(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, d2Var)) == null) {
            if (d2Var == null) {
                setVisibility(8);
                return false;
            }
            this.mData = d2Var;
            updateLayout();
            updateBarName(d2Var);
            u(d2Var);
            updateReplyNum(d2Var);
            updateCollectNum(d2Var);
            updateShareNum(d2Var);
            updatePraiseNum(d2Var);
            updateSelectView(d2Var);
            updateManageView(d2Var);
            setVisibility(this.isVisible ? 0 : 8);
            updateOperationMaskView(d2Var);
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
            this.f47902g = i2;
            AgreeView agreeView = this.mAgreeView;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.f47904i = i2;
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
            this.f47903h = i2;
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
            this.f47900e = i2;
            m();
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
            this.f47905j = str;
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

    /* JADX WARN: Removed duplicated region for block: B:35:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t() {
        d2 d2Var;
        String s1;
        String str;
        boolean z;
        Uri parse;
        String o;
        String format;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || (d2Var = this.mData) == null || this.mContext == null) {
            return;
        }
        String valueOf = String.valueOf(d2Var.T());
        String Z = this.mData.Z();
        OriginalForumInfo originalForumInfo = this.mData.J1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            Z = originalForumInfo.ori_fname;
        }
        String str2 = Z;
        String str3 = valueOf;
        String title = this.mData.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.mData.o();
        }
        String str4 = title;
        if (this.mData.D2()) {
            s1 = this.mData.L().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + this.mData.L().oriUgcType + "&dvid=" + this.mData.L().oriUgcVid + "&nid=" + this.mData.L().oriUgcNid;
        } else {
            s1 = this.mData.s1();
            str = "?share=9105&fr=sharewise";
        }
        String str5 = str;
        String str6 = s1;
        String str7 = "http://tieba.baidu.com/p/" + str6 + (str5 + "&share_from=post");
        if (this.mData.l1() != null && this.mData.l1().user_info != null) {
            try {
                str7 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.mData.l1().user_info.user_name, "utf-8");
                z = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (this.mData.l1() != null && this.mData.l1().isLegalYYLiveData()) {
                str7 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.mData.l1().mYyExtData.mSid + "&livessid=" + this.mData.l1().mYyExtData.mSsid + "&uid=" + this.mData.l1().mYyExtData.mYyUid;
                z = false;
            }
            String i2 = i(this.mData);
            parse = i2 != null ? null : Uri.parse(i2);
            o = this.mData.o();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.mData.D2() && this.mData.J() != null) {
                format = (TextUtils.isEmpty(this.mData.getTitle()) || TextUtils.isEmpty(o)) ? MessageFormat.format(string2, this.mData.J().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : o;
            } else {
                format = MessageFormat.format(string, str4, o);
            }
            String cutString = k.cutString(str4, 100);
            String cutString2 = k.cutString(format, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            int k = k(this.mData);
            if (!this.mData.D2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (k == 2 && this.mData.q1() != null) {
                    shareItem.R = this.mData.q1().play_count.intValue();
                } else if (k == 1) {
                    shareItem.R = this.mData.C1();
                }
                shareItem.D = o;
            }
            shareItem.t = str7;
            shareItem.q = str6;
            shareItem.J = str3;
            shareItem.p = str2;
            shareItem.K = str6;
            shareItem.f48218f = true;
            shareItem.o = this.f47903h;
            shareItem.E = getShareObjSource();
            shareItem.M = k;
            shareItem.F = 3;
            shareItem.G = j(this.mData);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (this.mData.D2()) {
                z = false;
            }
            shareItem.j0 = z;
            if (z) {
                shareItem.i0 = this.mData.Z0();
            }
            f();
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.mData);
            if (this.f47902g != 13) {
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.mData, 2);
            } else {
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.mData);
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
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setIsAlaLive(this.mData.o1() != 49 || this.mData.o1() == 60 || this.mData.o1() == 69);
            c(shareDialogConfig);
            c.a.r0.e0.f.b().k(shareDialogConfig);
        }
        z = true;
        if (this.mData.l1() != null) {
            str7 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.mData.l1().mYyExtData.mSid + "&livessid=" + this.mData.l1().mYyExtData.mSsid + "&uid=" + this.mData.l1().mYyExtData.mYyUid;
            z = false;
        }
        String i22 = i(this.mData);
        if (i22 != null) {
        }
        o = this.mData.o();
        String string3 = getResources().getString(R.string.share_content_tpl);
        String string22 = getResources().getString(R.string.default_share_content_tpl);
        if (!this.mData.D2()) {
        }
        format = MessageFormat.format(string3, str4, o);
        String cutString3 = k.cutString(str4, 100);
        String cutString22 = k.cutString(format, 100);
        shareItem = new ShareItem();
        shareItem.r = cutString3;
        shareItem.s = cutString22;
        int k2 = k(this.mData);
        if (!this.mData.D2()) {
        }
        shareItem.t = str7;
        shareItem.q = str6;
        shareItem.J = str3;
        shareItem.p = str2;
        shareItem.K = str6;
        shareItem.f48218f = true;
        shareItem.o = this.f47903h;
        shareItem.E = getShareObjSource();
        shareItem.M = k2;
        shareItem.F = 3;
        shareItem.G = j(this.mData);
        if (parse != null) {
        }
        if (this.mData.D2()) {
        }
        shareItem.j0 = z;
        if (z) {
        }
        f();
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.mData);
        if (this.f47902g != 13) {
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
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.mContext, shareItem, true, true);
        shareDialogConfig2.setIsAlaLive(this.mData.o1() != 49 || this.mData.o1() == 60 || this.mData.o1() == 69);
        c(shareDialogConfig2);
        c.a.r0.e0.f.b().k(shareDialogConfig2);
    }

    public final void u(d2 d2Var) {
        String S0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, d2Var) == null) || this.f47901f == null || d2Var == null) {
            return;
        }
        if (d2Var.v0() > 0 && this.isReplyTimeVisible) {
            this.f47901f.setVisibility(0);
            if (this.f47902g == 3) {
                S0 = d2Var.T0();
            } else {
                S0 = d2Var.S0();
            }
            this.f47901f.setText(S0);
            this.isVisible = true;
            return;
        }
        this.f47901f.setVisibility(8);
    }

    public void updateBarName(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, d2Var) == null) {
            this.mBarName.setVisibility(8);
        }
    }

    public void updateCollectNum(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, d2Var) == null) {
            EMTextView eMTextView = this.mCollectNumText;
            if (eMTextView != null) {
                int i2 = d2Var.N2;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.mark);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(d2Var);
        }
    }

    public void updateCollectStateUI(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048660, this, d2Var) == null) || this.mCollectNumImageView == null) {
            return;
        }
        if (d2Var != null && d2Var.l0() != 0) {
            WebPManager.setPureDrawable(this.mCollectNumImageView, R.drawable.icon_pure_pb_operate_collect26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.mCollectNumImageView, R.drawable.icon_pure_pb_operate_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void updateLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            c.a.q0.s.f0.h.b(this.mRootView);
        }
    }

    public void updateManageView(d2 d2Var) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, d2Var) == null) || this.mManageViewContainer == null || d2Var == null) {
            return;
        }
        this.isManageVisible = p(4);
        if (d2Var.J1 != null) {
            this.isManageVisible = false;
        }
        if (this.isManageVisible && ((linearLayout = this.mSelectContainer) == null || linearLayout.getVisibility() == 8)) {
            this.mManageViewContainer.setVisibility(0);
            String string = this.mContext.getString(R.string.manage);
            this.mManageText.setText(string);
            this.mManageText.setContentDescription(string);
            this.isVisible = true;
        } else {
            this.mManageViewContainer.setVisibility(p(64) ? 4 : 8);
        }
        updateManagerUI();
    }

    public void updateManagerUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            WebPManager.setPureDrawable(this.mManageImageView, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.mManageText;
            d2 d2Var = this.mData;
            if (d2Var != null && d2Var.getType() == d2.Q3) {
                color = c.a.r0.j3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.mManageImageView;
            d2 d2Var2 = this.mData;
            imageView.setEnabled(d2Var2 == null || d2Var2.getType() != d2.Q3);
        }
    }

    public void updateOperationMaskView(d2 d2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048664, this, d2Var) == null) && d2Var != null && this.f47902g == 13) {
            showOperationMaskView(d2Var.L2 == 1);
        }
    }

    public void updatePraiseNum(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, d2Var) == null) {
            setAgreeViewType(d2Var);
            if (d2Var.B() != null) {
                d2Var.B().isInThread = true;
                this.mAgreeView.setCardType(d2Var.Q0());
                this.mAgreeView.setThreadData(d2Var);
                this.mAgreeView.setData(d2Var.B());
            }
            AgreeView agreeView = this.mAgreeView;
            d2 d2Var2 = this.mData;
            agreeView.setAlpha((d2Var2 == null || d2Var2.getType() != d2.Q3) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    public void updateReplyNum(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048666, this, d2Var) == null) || this.mCommentNum == null || d2Var == null) {
            return;
        }
        if (this.isCommentNumEnable) {
            this.mCommentContainer.setVisibility(0);
            if (d2Var.U0() > 0) {
                this.mCommentNum.setVisibility(0);
                String numFormatOverWan = StringHelper.numFormatOverWan(d2Var.U0());
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
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            if (this.needAddReplyIcon) {
                WebPManager.setPureDrawable(this.mCommentImageView, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.mCommentImageView;
            d2 d2Var = this.mData;
            imageView.setEnabled(d2Var == null || d2Var.getType() != d2.Q3);
            EMTextView eMTextView = this.mCommentNum;
            d2 d2Var2 = this.mData;
            if (d2Var2 != null && d2Var2.getType() == d2.Q3) {
                color = c.a.r0.j3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            c.a.q0.s.f0.h.a(this.mCommentImageView, R.drawable.icon_pure_card_comment20);
            c.a.q0.s.f0.h.e(this.mCommentNum);
        }
    }

    public void updateSelectView(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048668, this, d2Var) == null) || this.mSelectContainer == null || this.mSelectImg == null || this.mSelectText == null || d2Var == null) {
            return;
        }
        if (!this.s) {
            View view = this.o;
            if (view != null) {
                view.setVisibility(8);
            }
            this.mSelectContainer.setVisibility(8);
        } else if (this.isSelectVisible && !p(128) && (c.a.r0.w0.b.f().i() || c.a.r0.w0.a.h().j())) {
            if (this.o == null) {
                View view2 = new View(getContext());
                this.o = view2;
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                addView(this.o);
                this.o.setAlpha(0.5f);
                this.o.setOnTouchListener(new e(this));
                this.o.setOnClickListener(new f(this));
            }
            int k = l.k(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
            if (layoutParams == null) {
                this.o.setLayoutParams(new FrameLayout.LayoutParams(k, -1));
            } else {
                layoutParams.width = k;
                requestLayout();
            }
            if (!this.mData.j2() && !this.mData.k2()) {
                c.a.q0.s.u.c.d(this.mSelectText).y(R.color.CAM_X0107);
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

    public void updateShareNum(d2 d2Var) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, d2Var) == null) || (view = this.mShareContainer) == null || this.mShareNum == null || d2Var == null) {
            return;
        }
        if (this.isShareVisible) {
            view.setVisibility(0);
            long b1 = d2Var.b1();
            if ((d2Var.h2() || d2Var.t2()) && d2Var.l1() != null && d2Var.l1().share_info != null) {
                b1 = d2Var.l1().share_info.share_count;
            }
            String string = this.mContext.getString(R.string.share);
            if (b1 > 0) {
                string = StringHelper.numFormatOverWan(b1);
            }
            this.mShareNum.setText(string);
            this.isVisible = true;
            updateShareStateUI(d2Var);
            return;
        }
        view.setVisibility(8);
    }

    public void updateShareStateUI(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, d2Var) == null) {
            WebPManager.setPureDrawable(this.mShareImageView, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(d2Var)) {
                setShareClickable(true);
                this.mShareNum.setTextColor(c.a.r0.j3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else if (d2Var != null && d2Var.y1 != null && this.mData.y1.m) {
                setShareClickable(false);
                this.mShareNum.setTextColor(c.a.r0.j3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                setShareClickable(true);
                c.a.q0.s.u.c.d(this.mShareNum).y(R.color.CAM_X0107);
            }
            d2 d2Var2 = this.mData;
            if (d2Var2 != null && d2Var2.getType() == d2.Q3) {
                this.mShareImageView.setEnabled(false);
                this.mShareNum.setTextColor(c.a.r0.j3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
            c.a.q0.s.f0.h.a(this.mShareImageView, R.drawable.icon_pure_card_share20);
            c.a.q0.s.f0.h.e(this.mShareNum);
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
        this.TBDS84 = l.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.f47900e = 11;
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
        this.f47902g = 2;
        this.f47903h = 1;
        this.n = 3;
        this.q = null;
        this.s = true;
        this.t = new g(this, 2921416);
        this.u = new h(this, 2921417);
        n(context);
    }
}
