package c.a.p0.l0;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ShadowLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes2.dex */
public class j implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBarCoverTip a;

    /* renamed from: b  reason: collision with root package name */
    public ShadowLinearLayout f16061b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16062c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16063d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f16064e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.r.l0.a f16065f;

    /* renamed from: g  reason: collision with root package name */
    public long f16066g;

    /* renamed from: h  reason: collision with root package name */
    public long f16067h;
    public ThreadData i;
    public Activity j;
    public TbPageContext k;
    public boolean l;
    public boolean m;
    public final c.a.d.c.g.a n;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.g();
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    this.a.f(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    this.a.f(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
                }
            }
        }
    }

    public j(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = new a(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = tbPageContext.getPageActivity();
        this.k = tbPageContext;
        this.a = navigationBarCoverTip;
        this.n.setTag(tbPageContext.getUniqueId());
        this.n.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.n);
    }

    public final String c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null || threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            for (int i = 0; i < size; i++) {
                MediaData mediaData = medias.get(i);
                if (mediaData != null && mediaData.getType() == 3) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        return mediaData.getThumbnails_url();
                    }
                    if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        return mediaData.getPicUrl();
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 15;
        }
        return invokeV.intValue;
    }

    public final int e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                return threadData.isRealVideoThread() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void f(int i, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, getMyPostResIdl) == null) {
            if (i == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                ThreadData threadData = new ThreadData();
                this.i = threadData;
                threadData.parserProtobuf(getMyPostResIdl.data.thread_info);
                k();
                return;
            }
            this.k.showToast(R.string.obfuscated_res_0x7f0f0c15);
        }
    }

    public final void g() {
        c.a.o0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f16065f) == null) {
            return;
        }
        aVar.h(false);
    }

    public void h() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (navigationBarCoverTip = this.a) == null) {
            return;
        }
        navigationBarCoverTip.i();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("tid", this.f16067h);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", 7);
            if (!m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f16065f == null) {
                this.f16065f = new c.a.o0.r.l0.a(this.k);
            }
            this.f16065f.h(true);
        }
    }

    public final void k() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (threadData = this.i) == null || this.j == null) {
            return;
        }
        String valueOf = String.valueOf(threadData.getFid());
        String forum_name = this.i.getForum_name();
        String title = this.i.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.i.getAbstract();
        }
        String tid = this.i.getTid();
        String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
        String c2 = c(this.i);
        Uri parse = c2 == null ? null : Uri.parse(c2);
        String str2 = this.i.getAbstract();
        String format = MessageFormat.format(this.j.getResources().getString(R.string.obfuscated_res_0x7f0f110f), title, str2);
        ShareItem shareItem = new ShareItem();
        shareItem.r = title;
        shareItem.s = format;
        shareItem.R = 0L;
        shareItem.D = str2;
        shareItem.t = str;
        shareItem.o = 5;
        shareItem.q = tid;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = forum_name;
        shareItem.K = tid;
        shareItem.f30356f = true;
        shareItem.E = d();
        shareItem.M = e(this.i);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.i);
        shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(this.i);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.k0 = this.i.getShareImageUrl();
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        h.c().l(new ShareDialogConfig((Context) this.j, shareItem, true, true));
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.a == null) {
            return;
        }
        this.f16066g = c.a.d.f.m.b.g(postWriteCallBackData.getPostId(), 0L);
        long g2 = c.a.d.f.m.b.g(postWriteCallBackData.getThreadId(), 0L);
        this.f16067h = g2;
        if (this.f16066g == 0 || g2 == 0) {
            return;
        }
        this.m = false;
        if (this.f16061b == null) {
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(this.j).inflate(R.layout.obfuscated_res_0x7f0d0815, (ViewGroup) null, false).findViewById(R.id.obfuscated_res_0x7f091f05);
            this.f16061b = shadowLinearLayout;
            this.f16062c = (TextView) shadowLinearLayout.findViewById(R.id.obfuscated_res_0x7f091f06);
            this.f16063d = (TextView) this.f16061b.findViewById(R.id.obfuscated_res_0x7f091f04);
            this.f16064e = (TBSpecificationBtn) this.f16061b.findViewById(R.id.obfuscated_res_0x7f091f03);
            this.f16062c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1592));
            this.f16063d.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1590));
            this.f16064e.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f110a));
            this.f16064e.setConfig(new c.a.o0.r.l0.n.a());
        }
        SkinManager.setViewTextColor(this.f16062c, (int) R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f16063d, (int) R.color.CAM_X0302);
        this.f16064e.k();
        this.f16061b.b();
        this.f16064e.setOnClickListener(this);
        this.a.setBackgroundColor(0);
        this.a.m(this.j, this.f16061b, 5000);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || this.m) {
            return;
        }
        this.m = true;
        if (!l.z()) {
            this.k.showToast(R.string.obfuscated_res_0x7f0f0c15);
            this.a.e();
            return;
        }
        int k = n.k(TbadkCoreApplication.getInst());
        int i = n.i(TbadkCoreApplication.getInst());
        float f2 = this.j.getResources().getDisplayMetrics().density;
        int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.k.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.f16067h, this.f16066g, 0L, k, i, f2, i2);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        j();
        this.a.e();
        i();
    }
}
