package c.a.r0.k0;

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
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
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
/* loaded from: classes6.dex */
public class j implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarCoverTip f18599e;

    /* renamed from: f  reason: collision with root package name */
    public ShadowLinearLayout f18600f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18601g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18602h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f18603i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.g0.a f18604j;

    /* renamed from: k  reason: collision with root package name */
    public long f18605k;
    public long l;
    public d2 m;
    public Activity n;
    public TbPageContext o;
    public boolean p;
    public boolean q;
    public final c.a.d.c.g.a r;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = false;
        this.r = new a(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.n = tbPageContext.getPageActivity();
        this.o = tbPageContext;
        this.f18599e = navigationBarCoverTip;
        this.r.setTag(tbPageContext.getUniqueId());
        this.r.getHttpMessageListener().setSelfListener(true);
        this.r.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.r);
    }

    public final String c(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null || d2Var.F0() == null) {
                return null;
            }
            ArrayList<MediaData> F0 = d2Var.F0();
            int size = F0.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaData mediaData = F0.get(i2);
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

    public final int e(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) {
            if (d2Var != null) {
                if (d2Var.t2()) {
                    return 4;
                }
                if (d2Var.k0() == 1) {
                    return 3;
                }
                return d2Var.u2() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void f(int i2, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, getMyPostResIdl) == null) {
            if (i2 == 0 && getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                d2 d2Var = new d2();
                this.m = d2Var;
                d2Var.c3(getMyPostResIdl.data.thread_info);
                k();
                return;
            }
            this.o.showToast(R.string.neterror);
        }
    }

    public final void g() {
        c.a.q0.s.g0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f18604j) == null) {
            return;
        }
        aVar.h(false);
    }

    public void h() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (navigationBarCoverTip = this.f18599e) == null) {
            return;
        }
        navigationBarCoverTip.onDestroy();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("tid", this.l);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", 7);
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f18604j == null) {
                this.f18604j = new c.a.q0.s.g0.a(this.o);
            }
            this.f18604j.h(true);
        }
    }

    public final void k() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (d2Var = this.m) == null || this.n == null) {
            return;
        }
        String valueOf = String.valueOf(d2Var.U());
        String a0 = this.m.a0();
        String title = this.m.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.m.o();
        }
        String v1 = this.m.v1();
        String str = "http://tieba.baidu.com/p/" + v1 + "?share=9105&fr=share";
        String c2 = c(this.m);
        Uri parse = c2 == null ? null : Uri.parse(c2);
        String o = this.m.o();
        String format = MessageFormat.format(this.n.getResources().getString(R.string.share_content_tpl), title, o);
        ShareItem shareItem = new ShareItem();
        shareItem.r = title;
        shareItem.s = format;
        shareItem.R = 0L;
        shareItem.D = o;
        shareItem.t = str;
        shareItem.o = 5;
        shareItem.q = v1;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = a0;
        shareItem.K = v1;
        shareItem.f41580f = true;
        shareItem.E = d();
        shareItem.M = e(this.m);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.m);
        shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.m);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.i0 = this.m.b1();
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        h.c().l(new ShareDialogConfig((Context) this.n, shareItem, true, true));
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.f18599e == null) {
            return;
        }
        this.f18605k = c.a.d.f.m.b.g(postWriteCallBackData.getPostId(), 0L);
        long g2 = c.a.d.f.m.b.g(postWriteCallBackData.getThreadId(), 0L);
        this.l = g2;
        if (this.f18605k == 0 || g2 == 0) {
            return;
        }
        this.q = false;
        if (this.f18600f == null) {
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(this.n).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            this.f18600f = shadowLinearLayout;
            this.f18601g = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            this.f18602h = (TextView) this.f18600f.findViewById(R.id.tb_top_toast_content);
            this.f18603i = (TBSpecificationBtn) this.f18600f.findViewById(R.id.tb_top_toast_btn);
            this.f18601g.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
            this.f18602h.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
            this.f18603i.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
            this.f18603i.setConfig(new c.a.q0.s.g0.n.a());
        }
        SkinManager.setViewTextColor(this.f18601g, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f18602h, R.color.CAM_X0302);
        this.f18603i.changeSkinType();
        this.f18600f.onChangeSkinType();
        this.f18603i.setOnClickListener(this);
        this.f18599e.setBackgroundColor(0);
        this.f18599e.showTip(this.n, this.f18600f, 5000);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || this.q) {
            return;
        }
        this.q = true;
        if (!c.a.d.f.p.j.z()) {
            this.o.showToast(R.string.neterror);
            this.f18599e.hideTip();
            return;
        }
        int k2 = l.k(TbadkCoreApplication.getInst());
        int i2 = l.i(TbadkCoreApplication.getInst());
        float f2 = this.n.getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.o.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.l, this.f18605k, 0L, k2, i2, f2, i3);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        j();
        this.f18599e.hideTip();
        i();
    }
}
