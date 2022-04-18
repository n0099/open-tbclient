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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.ad6;
import com.repackage.bd6;
import com.repackage.bj8;
import com.repackage.eu4;
import com.repackage.ex5;
import com.repackage.fr7;
import com.repackage.gj8;
import com.repackage.ld6;
import com.repackage.me6;
import com.repackage.nc5;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.oz5;
import com.repackage.p75;
import com.repackage.ry4;
import com.repackage.u75;
import com.repackage.ux5;
import com.repackage.vn4;
import com.repackage.vr4;
import com.repackage.x45;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes3.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public ThreadData B;
    public Context C;
    public TbPageContext D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public int P;
    public int Q;
    public String R;
    public int S;
    public String T;
    public String U;
    public String V;
    public View.OnClickListener W;
    public int a;
    public TextView b;
    public TextView c;
    public boolean d;
    public AgreeView e;
    public EMTextView f;
    public ImageView g;
    public int g0;
    public EMTextView h;
    public View h0;
    public View i;
    public MaskView i0;
    public EMTextView j;
    public j j0;
    public ImageView k;
    public LinearLayout k0;
    public View l;
    public i l0;
    public FrameLayout m;
    public boolean m0;
    public ImageView n;
    public CustomMessageListener n0;
    public EMTextView o;
    public CustomMessageListener o0;
    public ImageView p;
    public View q;
    public ux5 r;
    public LinearLayout s;
    public ImageView t;
    public EMTextView u;
    public LinearLayout v;
    public ImageView w;
    public EMTextView x;
    public ImageView y;
    public EMTextView z;

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.W != null) {
                    this.a.W.onClick(view2);
                }
                if (UbsABTestHelper.isLikeModifyTestA()) {
                    this.a.c(view2);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
                threadCommentAndPraiseInfoLayout.h(view2, threadCommentAndPraiseInfoLayout.B);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.y.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.y.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (this.a.B == null || threadData == null) {
                return;
            }
            String str = threadData.getBaijiahaoData() != null ? threadData.getBaijiahaoData().oriUgcNid : "";
            String str2 = this.a.B.getBaijiahaoData() != null ? this.a.B.getBaijiahaoData().oriUgcNid : "";
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (str.equals(str2)) {
                    this.a.B.setReply_num(threadData.getReply_num());
                    this.a.K(threadData);
                    return;
                }
                return;
            }
            String id = threadData.getId();
            String id2 = this.a.B.getId();
            if ("0".equals(id2) || TextUtils.isEmpty(id2) || !id2.equals(id)) {
                return;
            }
            this.a.B.setReply_num(threadData.getReply_num());
            this.a.K(threadData);
        }
    }

    /* loaded from: classes3.dex */
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
            if (TextUtils.isEmpty(str) || (threadData = this.a.B) == null || "0".equals(threadData.getId()) || !str.equals(this.a.B.getId())) {
                return;
            }
            if ((this.a.B.isLiveThread() || this.a.B.isSharedLiveThread()) && this.a.B.getThreadAlaInfo() != null) {
                if (this.a.B.getThreadAlaInfo() != null && this.a.B.getThreadAlaInfo().share_info != null) {
                    this.a.B.getThreadAlaInfo().share_info.share_count++;
                }
            } else {
                ThreadData threadData2 = this.a.B;
                threadData2.setShareNum(threadData2.getShareNum() + 1);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
            threadCommentAndPraiseInfoLayout.N(threadCommentAndPraiseInfoLayout.B);
        }
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes3.dex */
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
        oi.f(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.N = true;
        this.O = 2;
        this.P = 1;
        this.g0 = 3;
        this.j0 = null;
        this.m0 = true;
        this.n0 = new g(this, 2921416);
        this.o0 = new h(this, 2921417);
        o(context);
    }

    private BdUniqueId getPageUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            TbPageContext tbPageContext = this.D;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            int i2 = this.P;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i2 = this.O;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ThreadData threadData = this.B;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isShareThread) {
                return 4;
            }
            if (threadData.getThreadType() == 49 || this.B.getThreadType() == 69) {
                return 5;
            }
            if (this.B.getThreadVideoInfo() != null) {
                return 1;
            }
            if (this.B.getType() == ThreadData.TYPE_NORMAL || this.B.getType() == ThreadData.TYPE_GOD_NORMAL) {
                return ListUtils.getCount(this.B.getVoice()) > 0 ? 3 : 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            ThreadData threadData = this.B;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 1;
            }
            if (this.B.isBJHVideoThreadType()) {
                return 2;
            }
            if (this.B.isBJHNormalThreadType()) {
                return 3;
            }
            return this.B.isBJHVideoDynamicThreadType() ? 4 : 0;
        }
        return invokeV.intValue;
    }

    public void A(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
        }
    }

    public void B(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || this.y == null || (threadData = this.B) == null || this.z == null || threadData.isTransportThread()) {
            return;
        }
        boolean z = true;
        if (!this.B.isMarkToDel() && bd6.f().i()) {
            if (bd6.f().a(this.B)) {
                this.B.setMarkToDel(true);
            }
        } else if (!this.B.isMarkToMove() && ad6.h().j()) {
            if (ad6.h().a(this.B)) {
                this.B.setMarkToMove(true);
            }
        } else {
            bd6.f().l(this.B);
            this.B.setMarkToDel(false);
            ad6.h().l(this.B);
            this.B.setMarkToMove(false);
        }
        if (!this.B.isMarkToDel() && !this.B.isMarkToMove()) {
            vr4.d(this.z).x(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f08090f, R.color.CAM_X0107, null);
        } else {
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f08090b, R.color.CAM_X0304, null);
        }
        j jVar = this.j0;
        if (jVar != null) {
            if (!this.B.isMarkToDel() && !this.B.isMarkToMove()) {
                z = false;
            }
            jVar.a(z);
        }
    }

    public void C(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if ((ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.C)) && this.B != null) {
                D();
                h(view2, this.B);
                if (AntiHelper.e(getContext(), this.B)) {
                    return;
                }
                E();
                View.OnClickListener onClickListener = this.W;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.B == null) {
            return;
        }
        StatisticItem f2 = f();
        f2.param("thread_type", this.B.getThreadType());
        TiebaStatic.log(f2);
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
    public final void E() {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (threadData = this.B) == null || this.C == null) {
            return;
        }
        String valueOf = String.valueOf(threadData.getFid());
        String forum_name = this.B.getForum_name();
        OriginalForumInfo originalForumInfo = this.B.mOriginalForumInfo;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            forum_name = originalForumInfo.ori_fname;
        }
        String str3 = forum_name;
        String str4 = valueOf;
        String title = this.B.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.B.getAbstract();
        }
        String str5 = title;
        if (this.B.isUgcThreadType()) {
            tid = this.B.getBaijiahaoData().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + this.B.getBaijiahaoData().oriUgcType + "&dvid=" + this.B.getBaijiahaoData().oriUgcVid + "&nid=" + this.B.getBaijiahaoData().oriUgcNid;
        } else {
            tid = this.B.getTid();
            str = "?share=9105&fr=sharewise";
        }
        String str6 = str;
        String str7 = tid;
        String str8 = str6 + "&share_from=post";
        if (this.B.getVoiceRoomData() != null && this.B.getVoiceRoomData().room_id.longValue() > 0) {
            str2 = String.format("http://tieba.baidu.com/mo/q/wise-main-share/shareVoiceRoom?room_id=%s", String.valueOf(this.B.getVoiceRoomData().room_id));
            z = true;
        } else {
            str2 = "http://tieba.baidu.com/p/" + str7 + str8;
            z = false;
        }
        if (this.B.getThreadAlaInfo() != null && this.B.getThreadAlaInfo().user_info != null) {
            try {
                str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.B.getThreadAlaInfo().user_info.user_name, IMAudioTransRequest.CHARSET);
                z2 = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (this.B.getThreadAlaInfo() != null && this.B.getThreadAlaInfo().isLegalYYLiveData()) {
                str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.B.getThreadAlaInfo().mYyExtData.mSid + "&livessid=" + this.B.getThreadAlaInfo().mYyExtData.mSsid + "&uid=" + this.B.getThreadAlaInfo().mYyExtData.mYyUid;
                z2 = false;
            }
            String k = k(this.B);
            parse = k != null ? null : Uri.parse(k);
            String str9 = this.B.getAbstract();
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f1116);
            String string2 = getResources().getString(R.string.obfuscated_res_0x7f0f0481);
            if (!this.B.isUgcThreadType() && this.B.getAuthor() != null) {
                format = (TextUtils.isEmpty(this.B.getTitle()) || TextUtils.isEmpty(str9)) ? MessageFormat.format(string2, this.B.getAuthor().getName_show(), getResources().getString(R.string.obfuscated_res_0x7f0f0482)) : str9;
            } else if (!z) {
                StringBuilder sb = new StringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f152c));
                if (this.B.getForumData() != null && !StringUtils.isNull(this.B.getForumData().b)) {
                    sb.insert(0, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f152d), this.B.getForumData().b));
                }
                format = sb.toString();
            } else {
                format = MessageFormat.format(string, str5, str9);
            }
            int k2 = ry4.k(this.B);
            String cutString = ni.cutString(str5, 100);
            String cutString2 = ni.cutString(format, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            if (!this.B.isUgcThreadType()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (k2 == 2 && this.B.getThreadVideoInfo() != null) {
                    shareItem.R = this.B.getThreadVideoInfo().play_count.intValue();
                } else if (k2 == 1) {
                    shareItem.R = this.B.getView_num();
                }
                shareItem.D = str9;
            }
            shareItem.t = str2;
            shareItem.q = str7;
            shareItem.J = str4;
            shareItem.p = str3;
            shareItem.K = str7;
            shareItem.f = true;
            shareItem.o = this.P;
            shareItem.E = getShareObjSource();
            shareItem.M = k2;
            shareItem.F = 3;
            shareItem.G = l(this.B);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (this.B.isUgcThreadType()) {
                z2 = false;
            }
            shareItem.m0 = z2;
            if (z2) {
                shareItem.k0 = this.B.getShareImageUrl();
            }
            g();
            generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.B);
            shareItem.T = generateShareInfo;
            if (StringUtils.isNull(generateShareInfo.showText, true)) {
                if (StringUtils.isNull(this.B.getTitle(), true)) {
                    OriginalThreadInfo originalThreadInfo = this.B.originalThreadData;
                    if (originalThreadInfo != null) {
                        shareItem.T.showText = originalThreadInfo.g;
                    }
                } else {
                    shareItem.T.showText = this.B.getTitle();
                }
            }
            if (StringUtils.isNull(shareItem.T.showText, true)) {
                shareItem.T.showText = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cec);
            }
            if (this.O != 13) {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(this.B, 2);
            } else {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(this.B);
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
                shareItem.y0 = ry4.j(this.B, k2);
                shareItem.z0 = ry4.i(this.B, k2, str3, shareItem.R, "", "");
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.C, shareItem, true, true);
            boolean z3 = this.B.getThreadType() != 49 || this.B.getThreadType() == 60 || this.B.getThreadType() == 69;
            shareDialogConfig.mIsVoiceRoom = z;
            shareDialogConfig.setIsAlaLive(z3);
            d(shareDialogConfig);
            oz5.c().l(shareDialogConfig);
        }
        z2 = true;
        if (this.B.getThreadAlaInfo() != null) {
            str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.B.getThreadAlaInfo().mYyExtData.mSid + "&livessid=" + this.B.getThreadAlaInfo().mYyExtData.mSsid + "&uid=" + this.B.getThreadAlaInfo().mYyExtData.mYyUid;
            z2 = false;
        }
        String k3 = k(this.B);
        if (k3 != null) {
        }
        String str92 = this.B.getAbstract();
        String string3 = getResources().getString(R.string.obfuscated_res_0x7f0f1116);
        String string22 = getResources().getString(R.string.obfuscated_res_0x7f0f0481);
        if (!this.B.isUgcThreadType()) {
        }
        if (!z) {
        }
        int k22 = ry4.k(this.B);
        String cutString3 = ni.cutString(str5, 100);
        String cutString22 = ni.cutString(format, 100);
        shareItem = new ShareItem();
        shareItem.r = cutString3;
        shareItem.s = cutString22;
        if (!this.B.isUgcThreadType()) {
        }
        shareItem.t = str2;
        shareItem.q = str7;
        shareItem.J = str4;
        shareItem.p = str3;
        shareItem.K = str7;
        shareItem.f = true;
        shareItem.o = this.P;
        shareItem.E = getShareObjSource();
        shareItem.M = k22;
        shareItem.F = 3;
        shareItem.G = l(this.B);
        if (parse != null) {
        }
        if (this.B.isUgcThreadType()) {
        }
        shareItem.m0 = z2;
        if (z2) {
        }
        g();
        generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.B);
        shareItem.T = generateShareInfo;
        if (StringUtils.isNull(generateShareInfo.showText, true)) {
        }
        if (StringUtils.isNull(shareItem.T.showText, true)) {
        }
        if (this.O != 13) {
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
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.C, shareItem, true, true);
        if (this.B.getThreadType() != 49) {
        }
        shareDialogConfig2.mIsVoiceRoom = z;
        shareDialogConfig2.setIsAlaLive(z3);
        d(shareDialogConfig2);
        oz5.c().l(shareDialogConfig2);
    }

    public void F(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            this.b.setVisibility(8);
        }
    }

    public void G(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            EMTextView eMTextView = this.x;
            if (eMTextView != null) {
                int i2 = threadData.collectNum;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f0a81);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(threadData);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            eu4.b(this.k0);
        }
    }

    public void I(ThreadData threadData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) || this.q == null || threadData == null) {
            return;
        }
        this.K = t(4);
        if (threadData.mOriginalForumInfo != null) {
            this.K = false;
        }
        if (this.K && ((linearLayout = this.A) == null || linearLayout.getVisibility() == 8)) {
            this.q.setVisibility(0);
            String string = this.C.getString(R.string.obfuscated_res_0x7f0f0a77);
            this.o.setText(string);
            this.o.setContentDescription(string);
            this.E = true;
        } else {
            this.q.setVisibility(t(64) ? 4 : 8);
        }
        updateManagerUI();
    }

    public void J(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) && threadData != null && this.O == 13) {
            showOperationMaskView(threadData.isAuthorView == 1);
        }
    }

    public void K(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) || this.f == null || threadData == null) {
            return;
        }
        if (this.I) {
            this.i.setVisibility(0);
            if (threadData.getReply_num() > 0) {
                this.f.setVisibility(0);
                String numFormatOverWan = StringHelper.numFormatOverWan(threadData.getReply_num());
                if (this.H) {
                    updateReplyStateUI();
                    this.f.setText(numFormatOverWan);
                } else {
                    this.f.setText(String.format(this.C.getString(R.string.obfuscated_res_0x7f0f0f97), numFormatOverWan));
                }
                EMTextView eMTextView = this.f;
                eMTextView.setContentDescription(this.C.getString(R.string.obfuscated_res_0x7f0f0f96) + numFormatOverWan);
                this.E = true;
                return;
            } else if (this.H) {
                updateReplyStateUI();
                this.f.setText(this.C.getString(R.string.obfuscated_res_0x7f0f0084));
                this.f.setVisibility(0);
                this.E = true;
                return;
            } else {
                this.f.setVisibility(8);
                return;
            }
        }
        this.i.setVisibility(8);
    }

    public final void L(ThreadData threadData) {
        String replyTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) || this.c == null || threadData == null) {
            return;
        }
        if (threadData.getLast_time_int() > 0 && this.F) {
            this.c.setVisibility(0);
            if (this.O == 3) {
                replyTime = threadData.getReplyTimeForMyThread();
            } else {
                replyTime = threadData.getReplyTime();
            }
            this.c.setText(replyTime);
            this.E = true;
            return;
        }
        this.c.setVisibility(8);
    }

    public void M(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) || this.A == null || this.y == null || this.z == null || threadData == null) {
            return;
        }
        if (!this.m0) {
            View view2 = this.h0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.A.setVisibility(8);
        } else if (this.L && !t(128) && (bd6.f().i() || ad6.h().j())) {
            if (this.h0 == null) {
                View view3 = new View(getContext());
                this.h0 = view3;
                SkinManager.setBackgroundColor(view3, R.color.CAM_X0201);
                addView(this.h0);
                this.h0.setAlpha(0.5f);
                this.h0.setOnTouchListener(new e(this));
                this.h0.setOnClickListener(new f(this));
            }
            int k = oi.k(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h0.getLayoutParams();
            if (layoutParams == null) {
                this.h0.setLayoutParams(new FrameLayout.LayoutParams(k, -1));
            } else {
                layoutParams.width = k;
                requestLayout();
            }
            if (!this.B.isMarkToDel() && !this.B.isMarkToMove()) {
                vr4.d(this.z).x(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f08090f, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f08090b, R.color.CAM_X0304, null);
            }
            this.h0.setVisibility(0);
            this.A.setVisibility(8);
        } else {
            View view4 = this.h0;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            this.A.setVisibility(8);
        }
    }

    public void N(ThreadData threadData) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) || (view2 = this.l) == null || this.j == null || threadData == null) {
            return;
        }
        if (this.J) {
            view2.setVisibility(0);
            long shareNum = threadData.getShareNum();
            if ((threadData.isLiveThread() || threadData.isSharedLiveThread()) && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().share_info != null) {
                shareNum = threadData.getThreadAlaInfo().share_info.share_count;
            }
            String string = this.C.getString(R.string.obfuscated_res_0x7f0f110e);
            if (shareNum > 0) {
                string = StringHelper.numFormatOverWan(shareNum);
            }
            this.j.setText(string);
            this.E = true;
            updateShareStateUI(threadData);
            return;
        }
        view2.setVisibility(8);
    }

    public void addPraiseStats(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (this.B != null || i2 >= 0) {
                StatisticItem e2 = e(i2);
                e2.param("thread_type", this.B.getThreadType());
                TiebaStatic.log(e2);
            }
        }
    }

    public void c(@NonNull View view2) {
        TbPageContext tbPageContext;
        int width;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view2) == null) || this.e.getData() == null || !this.e.getData().hasAgree || (tbPageContext = this.D) == null || tbPageContext.getPageActivity() == null || this.e.getImgAgree() == null) {
            return;
        }
        if (!this.M || (this.e.getAgreeFlag() && !this.e.E())) {
            fr7 fr7Var = new fr7(getContext());
            int[] iArr = new int[2];
            this.e.getImgAgree().getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int f2 = this.M ? oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds774) : oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds600);
            int f3 = this.M ? oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070724) : oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
            int i4 = (int) ((f3 * 1) / 1.45d);
            if (i2 > i4) {
                width = ((i2 - i4) + (this.e.getImgAgree().getWidth() / 2)) - 10;
            } else {
                width = (i2 - i4) + (this.e.getImgAgree().getWidth() / 2);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f2);
            layoutParams.leftMargin = width;
            layoutParams.topMargin = this.M ? oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds36) : oi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
            fr7Var.j(f2);
            fr7Var.i(layoutParams);
            fr7Var.h(false);
            fr7Var.l(this.N, this.D.getPageActivity().findViewById(16908290), 0, i3 - 10, this.B.getTid(), String.valueOf(this.B.getFid()));
        }
    }

    public void changeSelectStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            onClick(this.y);
        }
    }

    public final void d(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, shareDialogConfig) == null) {
            int i2 = this.O;
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

    public final StatisticItem e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (this.B != null || i2 >= 0) {
                StatisticItem statisticItem = new StatisticItem("c12003");
                statisticItem.param("tid", this.B.getTid());
                if (this.B.getThreadType() == 40) {
                    statisticItem.param("obj_param1", "2");
                } else if (this.B.getThreadType() == 0) {
                    statisticItem.param("obj_param1", "1");
                }
                statisticItem.param("obj_source", "1");
                statisticItem.param("fid", this.B.getFid());
                statisticItem.param("obj_locate", this.O);
                statisticItem.param("obj_id", i2);
                if (!ni.isEmpty(this.R)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.R);
                }
                if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
                }
                statisticItem.param("nid", this.B.getNid());
                statisticItem.param("card_type", this.B.getRecomCardType());
                statisticItem.param("recom_source", this.B.mRecomSource);
                statisticItem.param("ab_tag", this.B.mRecomAbTag);
                statisticItem.param("weight", this.B.mRecomWeight);
                statisticItem.param("extra", this.B.mRecomExtra);
                if (this.B.getBaijiahaoData() != null && !ni.isEmpty(this.B.getBaijiahaoData().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.B.getBaijiahaoData().oriUgcVid);
                }
                p75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
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

    public final StatisticItem f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.B == null) {
                return null;
            }
            int i2 = 0;
            int i3 = this.P;
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
            statisticItem.param("fid", this.B.getFid());
            statisticItem.param("tid", this.B.getTid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.S);
            if (!ni.isEmpty(this.R)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.R);
            }
            if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.B.getThreadAlaInfo() != null && this.B.getThreadAlaInfo().user_info != null && this.B.getThreadAlaInfo().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.B.getThreadAlaInfo().user_info.is_official);
            }
            statisticItem.param("card_type", this.B.getRecomCardType()).param("ab_tag", this.B.mRecomAbTag).param("recom_source", this.B.mRecomSource).param("weight", this.B.mRecomWeight).param("extra", this.B.mRecomExtra);
            if (this.B.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 10);
            } else if (this.B.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 9);
            } else if (this.B.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 8);
            } else if (this.B.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 7);
            } else {
                ThreadData threadData = this.B;
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
            int i5 = this.O;
            if (i5 == 1 || i5 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
            }
            if (this.O == 18) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.T);
            }
            if (this.B.getBaijiahaoData() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.B.getBaijiahaoData().oriUgcNid);
                if (this.B.isBJHVideoThreadType() || this.B.isBJHVideoDynamicThreadType()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.B.getBaijiahaoData().oriUgcVid);
                }
            }
            if (this.B.isBjhDynamicThread()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.B.isBJHArticleThreadType() && !this.B.isBJHVideoThreadType()) {
                int i6 = this.B.threadType;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.D;
            if (tbPageContext != null) {
                u75.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.B.getNid());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void g() {
        ThreadData threadData;
        ItemInfo itemInfo;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Context context = this.C;
            if ((context instanceof me6) && ((me6) context).isInScoreTab() && (threadData = this.B) != null && threadData.getItem() == null && (itemInfo = ((me6) this.C).getItemInfo()) != null) {
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
                this.B.setItemData(itemData);
            }
        }
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.b : (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final void h(View view2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, view2, threadData) == null) || threadData == null) {
            return;
        }
        int id = view2.getId();
        int i2 = 3;
        int i3 = id == R.id.obfuscated_res_0x7f091f99 ? 3 : id == R.id.obfuscated_res_0x7f091cba ? 4 : id == R.id.obfuscated_res_0x7f090e97 ? 1 : id == R.id.obfuscated_res_0x7f090ead ? 2 : 0;
        int i4 = this.O;
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
        TiebaStatic.log(bj8.m("c13694", threadData, i2, i3));
    }

    public void hideDisagree() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.e.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.J = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.g.setLayoutParams(layoutParams);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
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

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.m0 : invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public View j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d060e, (ViewGroup) this, true) : (View) invokeL.objValue;
    }

    public final String k(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, threadData)) == null) {
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
                return threadData.getForumData().c;
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

    public final int l(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, threadData)) == null) {
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

    public final void m(Context context, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048611, this, context, threadData) == null) || threadData == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        int i2 = this.O;
        String str = i2 == 2 ? "frs" : (i2 == 4 || i2 == 9 || i2 == 1) ? "index" : "";
        videoItemData.buildWithThreadData(threadData);
        arrayList.add(videoItemData);
        nc5.e(context, arrayList, threadData.getBaijiahaoData() != null ? threadData.getBaijiahaoData().oriUgcNid : null, videoItemData.isVerticalVideo == 1, 0, null, "from_nani_video", "personalize_page", "", str, str, true, threadData.isJumpToFrsVideoTabPlay, true);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.l.setVisibility(t(1) ? 0 : 8);
            this.i.setVisibility(t(2) ? 0 : 8);
            View view2 = this.q;
            int i2 = 4;
            if (t(4)) {
                i2 = 0;
            } else if (!t(64)) {
                i2 = 8;
            }
            view2.setVisibility(i2);
            this.e.setVisibility(t(8) ? 0 : 8);
            this.e.setAgreeAlone(t(32));
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, context) == null) {
            this.C = context;
            if (context instanceof BaseActivity) {
                this.D = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.D = ((BaseFragmentActivity) context).getPageContext();
            }
            oi.f(this.C, R.dimen.tbds84);
            p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.n0);
            MessageManager.getInstance().registerListener(this.o0);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.g0 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.g0 = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.h0, R.color.CAM_X0201);
        MaskView maskView = this.i0;
        if (maskView != null) {
            maskView.f();
        }
        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
        updateReplyStateUI();
        updateCollectStateUI(this.B);
        updateShareStateUI(this.B);
        updateManagerUI();
        ux5 ux5Var = this.r;
        if (ux5Var != null) {
            ux5Var.g0();
        }
        AgreeView agreeView = this.e;
        if (agreeView != null) {
            agreeView.J(this.g0);
            AgreeView agreeView2 = this.e;
            ThreadData threadData = this.B;
            agreeView2.setAlpha((threadData == null || threadData.getType() != ThreadData.TYPE_FAKE_VIDEO) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
            ThreadData threadData = this.B;
            if (threadData == null || threadData.getType() != ThreadData.TYPE_FAKE_VIDEO) {
                if (view2 == this.b) {
                    u(view2);
                } else if (view2 == this.i) {
                    w(view2);
                    int i2 = this.O;
                    if (i2 == 1 || i2 == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                } else if (view2 == this.l) {
                    C(view2);
                    int i3 = this.O;
                    if (i3 == 1 || i3 == 2) {
                        TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                    }
                } else if (view2 == this.n) {
                    z(view2);
                } else if (view2 == this.q) {
                    y(view2);
                } else if (view2 == this.y) {
                    B(view2);
                } else if (view2 == this.s) {
                    A(view2);
                } else if (view2 == this.v) {
                    v(view2);
                }
            }
        }
    }

    public void onDestroy() {
        ux5 ux5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (ux5Var = this.r) == null) {
            return;
        }
        ux5Var.V();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.n0);
            MessageManager.getInstance().unRegisterListener(this.o0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            r(j(this.C));
        }
    }

    public void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f98);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fa2);
            this.k0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f8e);
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091f9c);
            this.f = eMTextView;
            vr4.d(eMTextView).A(R.string.F_X01);
            this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091f9b);
            this.h = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091f9a);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f091f99);
            EMTextView eMTextView2 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091cb9);
            this.j = eMTextView2;
            vr4.d(eMTextView2).A(R.string.F_X01);
            this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cbb);
            this.l = view2.findViewById(R.id.obfuscated_res_0x7f091cba);
            this.m = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090415);
            this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090414);
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091541);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.e = agreeView;
                agreeView.setAfterClickListener(new a(this));
                this.e.setUseLikeDefaultRes(this.d);
            }
            this.q = view2.findViewById(R.id.obfuscated_res_0x7f091382);
            EMTextView eMTextView3 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091f9f);
            this.o = eMTextView3;
            vr4.d(eMTextView3).A(R.string.F_X01);
            this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091f9e);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09137f);
            EMTextView eMTextView4 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091380);
            this.z = eMTextView4;
            vr4.d(eMTextView4).A(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09137e);
            this.A = linearLayout;
            linearLayout.setOnTouchListener(new b(this));
            this.z.setOnClickListener(new c(this));
            this.s = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091983);
            this.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091984);
            EMTextView eMTextView5 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091985);
            this.u = eMTextView5;
            if (eMTextView5 != null) {
                vr4.d(eMTextView5).A(R.string.F_X01);
            }
            this.v = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090682);
            this.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090683);
            EMTextView eMTextView6 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090684);
            this.x = eMTextView6;
            if (eMTextView6 != null) {
                vr4.d(eMTextView6).A(R.string.F_X01);
            }
            this.A.setOnClickListener(new d(this));
            this.i.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.y.setOnClickListener(this);
            LinearLayout linearLayout2 = this.s;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(this);
            }
            LinearLayout linearLayout3 = this.v;
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(this);
            }
        }
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.J = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = this.C.getResources().getDimensionPixelSize(R.dimen.tbds78);
            this.g.setLayoutParams(layoutParams);
        }
    }

    public final boolean s(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, threadData)) == null) ? (threadData == null || !threadData.isVideoThreadType() || threadData.getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public void setAgreeClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
        }
    }

    public void setAgreeStatisticData(vn4 vn4Var) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, vn4Var) == null) || (agreeView = this.e) == null) {
            return;
        }
        agreeView.setStatisticData(vn4Var);
    }

    public void setAgreeViewType(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, threadData) == null) && threadData != null && threadData.isUgcThreadType()) {
            this.e.setAgreeAlone(true);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.G = z;
            TextView textView = this.b;
            if (textView != null) {
                textView.setClickable(z);
            }
        }
    }

    public void setCollectVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z) == null) || (linearLayout = this.v) == null) {
            return;
        }
        if (z) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    public void setCommentClickable(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048628, this, z) == null) || (view2 = this.i) == null) {
            return;
        }
        view2.setClickable(z);
        this.g.setEnabled(z);
        this.f.setEnabled(z);
    }

    public void setCommentNumEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, context) == null) {
            this.C = context;
            if (this.D == null) {
                if (context instanceof BaseActivity) {
                    this.D = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.D = ((BaseFragmentActivity) context).getPageContext();
                }
            }
        }
    }

    public boolean setData(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, threadData)) == null) {
            if (threadData == null) {
                setVisibility(8);
                return false;
            }
            this.B = threadData;
            H();
            F(threadData);
            L(threadData);
            K(threadData);
            G(threadData);
            N(threadData);
            updatePraiseNum(threadData);
            M(threadData);
            I(threadData);
            setVisibility(this.E ? 0 : 8);
            J(threadData);
            x();
            return this.E;
        }
        return invokeL.booleanValue;
    }

    public void setDisPraiseFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onClickListener) == null) {
            this.W = onClickListener;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            this.O = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.S = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.m0 = z;
        }
    }

    public void setIsBarViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
        }
    }

    public void setIsPbFirst(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.M = z;
        }
    }

    public void setLiveShareEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.K = z;
        }
    }

    public void setMultiForumCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
        }
    }

    public void setNeedAddPraiseIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.H = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.N = z;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setNeedMatchStrategy(z);
            }
        }
    }

    public void setOnCommentClickCallback(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, iVar) == null) {
            this.l0 = iVar;
        }
    }

    public void setOnSelectStatusChangeListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, jVar) == null) {
            this.j0 = jVar;
        }
    }

    public void setQQShareVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048648, this, z) == null) || (linearLayout = this.s) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.F = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.L = z;
        }
    }

    public void setShareClickable(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048651, this, z) == null) || (view2 = this.l) == null) {
            return;
        }
        view2.setClickable(z);
        this.k.setEnabled(z);
        this.j.setEnabled(z);
    }

    public void setShareReportFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            this.P = i2;
        }
    }

    public void setShareVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
        }
    }

    public void setShowCommonView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            this.a = i2;
            n();
        }
    }

    public void setShowPraiseNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            this.U = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.T = str;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setUseDynamicLikeRes() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048659, this) == null) || (agreeView = this.e) == null) {
            return;
        }
        agreeView.setUseDynamicLikeRes();
    }

    public void setUseDynamicLikeResImmediately() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || (agreeView = this.e) == null) {
            return;
        }
        agreeView.setUseDynamicLikeResImmediately();
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.V = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            if (z && this.i0 == null) {
                MaskView maskView = new MaskView(getContext());
                this.i0 = maskView;
                addView(maskView);
            }
            MaskView maskView2 = this.i0;
            if (maskView2 != null) {
                maskView2.setVisibility(z ? 0 : 8);
            }
        }
    }

    public final boolean t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048663, this, i2)) == null) ? (i2 & this.a) > 0 : invokeI.booleanValue;
    }

    public final void u(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, view2) == null) || (threadData = this.B) == null || StringUtils.isNull(threadData.getForum_name())) {
            return;
        }
        if (!StringUtils.isNull(this.U) && !StringUtils.isNull(this.V)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.C).createCfgForpersonalized(this.B.getForum_name(), this.U, this.V)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.C).createNormalCfg(this.B.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
        View.OnClickListener onClickListener = this.W;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void updateCollectStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048665, this, threadData) == null) || this.w == null) {
            return;
        }
        if (threadData != null && threadData.getIsMarked() != 0) {
            WebPManager.setPureDrawable(this.w, R.drawable.obfuscated_res_0x7f080933, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.w, R.drawable.obfuscated_res_0x7f080932, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void updateManagerUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.obfuscated_res_0x7f0808ee, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.o;
            ThreadData threadData = this.B;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = gj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.p;
            ThreadData threadData2 = this.B;
            imageView.setEnabled(threadData2 == null || threadData2.getType() != ThreadData.TYPE_FAKE_VIDEO);
        }
    }

    public void updatePraiseNum(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, threadData) == null) {
            setAgreeViewType(threadData);
            if (threadData.getAgreeData() != null) {
                threadData.getAgreeData().isInThread = true;
                this.e.setCardType(threadData.getRecomCardType());
                this.e.setThreadData(threadData);
                this.e.setData(threadData.getAgreeData());
            }
            AgreeView agreeView = this.e;
            ThreadData threadData2 = this.B;
            agreeView.setAlpha((threadData2 == null || threadData2.getType() != ThreadData.TYPE_FAKE_VIDEO) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    public void updateReplyStateUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            if (this.H) {
                WebPManager.setPureDrawable(this.g, R.drawable.obfuscated_res_0x7f0808f2, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.g;
            ThreadData threadData = this.B;
            imageView.setEnabled(threadData == null || threadData.getType() != ThreadData.TYPE_FAKE_VIDEO);
            EMTextView eMTextView = this.f;
            ThreadData threadData2 = this.B;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = gj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            eu4.a(this.g, R.drawable.obfuscated_res_0x7f0808f1);
            eu4.e(this.f);
        }
    }

    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, threadData) == null) {
            WebPManager.setPureDrawable(this.k, R.drawable.obfuscated_res_0x7f0808f6, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(threadData)) {
                setShareClickable(true);
                this.j.setTextColor(gj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                if (threadData != null && threadData.originalThreadData != null) {
                    ThreadData threadData2 = this.B;
                    if (threadData2.originalThreadData.m || threadData2.shouldShowBlockedState()) {
                        setShareClickable(false);
                        this.j.setTextColor(gj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
                setShareClickable(true);
                vr4.d(this.j).x(R.color.CAM_X0107);
            }
            ThreadData threadData3 = this.B;
            if (threadData3 != null && threadData3.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.k.setEnabled(false);
                this.j.setTextColor(gj8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
            eu4.a(this.k, R.drawable.obfuscated_res_0x7f0808f5);
            eu4.e(this.j);
        }
    }

    public void v(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, view2) == null) {
        }
    }

    public void w(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048671, this, view2) == null) || (threadData = this.B) == null || this.C == null) {
            return;
        }
        ex5.a(threadData.getTid());
        StatisticItem statisticItem = new StatisticItem("c12942");
        statisticItem.param("obj_locate", this.O);
        statisticItem.param("obj_type", getThreadType());
        statisticItem.param("tid", this.B.getTid());
        statisticItem.param("nid", this.B.getNid());
        if (this.O == 18) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.B.getFid());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.T);
        }
        p75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
        if (findPageExtraByView != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
        }
        if (TbPageExtraHelper.getPrePageKey() != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
        }
        TiebaStatic.log(statisticItem);
        if (this.B.getVoiceRoomData() != null && this.B.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(this.B.getVoiceRoomData().room_name)) {
            ((x45) ServiceManager.getService(x45.a.a())).a(this.D, this.B.getVoiceRoomData().room_id.longValue());
        } else if (this.B.getThreadVideoInfo() != null && !TextUtils.isEmpty(this.B.getThreadVideoInfo().video_url)) {
            m(this.C, this.B);
        } else {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.C).createFromThreadCfg(this.B, null, this.U, 0, true, false, false).addLocateParam("");
            addLocateParam.setForumId(String.valueOf(this.B.getFid()));
            addLocateParam.setForumName(this.B.getForum_name());
            if (this.B.getIsDailyThread() && this.B.getForumData() != null) {
                addLocateParam.setForumId(this.B.getForumData().b());
                addLocateParam.setForumName(this.B.getForumData().a());
            }
            addLocateParam.setJumpToCommentArea(true);
            i iVar = this.l0;
            if (iVar != null) {
                iVar.a(addLocateParam);
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && s(this.B)) {
                addLocateParam.setNeedPreLoad(true);
                ld6.update(this.B);
            }
            if (this.B.isQualityReplyThread) {
                addLocateParam.setFromHomePageQuality(true);
            }
            if (this.B.isInterviewLiveStyle() && addLocateParam.getIntent() != null) {
                addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
            }
            addLocateParam.setStartFrom(this.Q);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
        }
        StatisticItem statisticItem2 = new StatisticItem("c12291");
        statisticItem2.param("obj_locate", this.O);
        TiebaStatic.log(statisticItem2);
        i();
        h(view2, this.B);
        View.OnClickListener onClickListener = this.W;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
        }
    }

    public void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, view2) == null) {
            if (this.r == null) {
                this.r = new ux5(this.D, t(16));
            }
            this.r.i0(this.B);
            this.r.m();
            if (this.B != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.B.getFid()).param("tid", this.B.getId()));
            }
        }
    }

    public final void z(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.k0 : (LinearLayout) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCommentAndPraiseInfoLayout(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        oi.f(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.N = true;
        this.O = 2;
        this.P = 1;
        this.g0 = 3;
        this.j0 = null;
        this.m0 = true;
        this.n0 = new g(this, 2921416);
        this.o0 = new h(this, 2921417);
        this.d = z;
        o(context);
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
        oi.f(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.N = true;
        this.O = 2;
        this.P = 1;
        this.g0 = 3;
        this.j0 = null;
        this.m0 = true;
        this.n0 = new g(this, 2921416);
        this.o0 = new h(this, 2921417);
        o(context);
    }
}
