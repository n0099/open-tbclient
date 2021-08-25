package c.a.q0.e0;

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
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
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
/* loaded from: classes3.dex */
public class h implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarCoverTip f16946e;

    /* renamed from: f  reason: collision with root package name */
    public ShadowLinearLayout f16947f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16948g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16949h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f16950i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.s.f0.a f16951j;
    public long k;
    public long l;
    public c2 m;
    public Activity n;
    public TbPageContext o;
    public boolean p;
    public boolean q;
    public final c.a.e.c.g.a r;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f16952a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f16952a = hVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f16952a.g();
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    this.f16952a.f(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    this.f16952a.f(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
                }
            }
        }
    }

    public h(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
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
        this.f16946e = navigationBarCoverTip;
        this.r.setTag(tbPageContext.getUniqueId());
        this.r.getHttpMessageListener().setSelfListener(true);
        this.r.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.r);
    }

    public final String c(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c2Var)) == null) {
            if (c2Var == null || c2Var.C0() == null) {
                return null;
            }
            ArrayList<MediaData> C0 = c2Var.C0();
            int size = C0.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaData mediaData = C0.get(i2);
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

    public final int e(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var)) == null) {
            if (c2Var != null) {
                if (c2Var.m2()) {
                    return 4;
                }
                if (c2Var.j0() == 1) {
                    return 3;
                }
                return c2Var.n2() ? 2 : 1;
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
                c2 c2Var = new c2();
                this.m = c2Var;
                c2Var.S2(getMyPostResIdl.data.thread_info);
                k();
                return;
            }
            this.o.showToast(R.string.neterror);
        }
    }

    public final void g() {
        c.a.p0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f16951j) == null) {
            return;
        }
        aVar.h(false);
    }

    public void h() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (navigationBarCoverTip = this.f16946e) == null) {
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
            if (this.f16951j == null) {
                this.f16951j = new c.a.p0.s.f0.a(this.o);
            }
            this.f16951j.h(true);
        }
    }

    public final void k() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (c2Var = this.m) == null || this.n == null) {
            return;
        }
        String valueOf = String.valueOf(c2Var.T());
        String Z = this.m.Z();
        String title = this.m.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.m.o();
        }
        String q1 = this.m.q1();
        String str = "http://tieba.baidu.com/p/" + q1 + "?share=9105&fr=share";
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
        shareItem.q = q1;
        shareItem.F = 3;
        shareItem.J = valueOf;
        shareItem.p = Z;
        shareItem.K = q1;
        shareItem.f47982f = true;
        shareItem.E = d();
        shareItem.M = e(this.m);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.m);
        shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.m);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.f0 = this.m.X0();
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        f.b().k(new ShareDialogConfig((Context) this.n, shareItem, true, true));
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, postWriteCallBackData) == null) || postWriteCallBackData == null || this.f16946e == null) {
            return;
        }
        this.k = c.a.e.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
        long f2 = c.a.e.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
        this.l = f2;
        if (this.k == 0 || f2 == 0) {
            return;
        }
        this.q = false;
        if (this.f16947f == null) {
            ShadowLinearLayout shadowLinearLayout = (ShadowLinearLayout) LayoutInflater.from(this.n).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
            this.f16947f = shadowLinearLayout;
            this.f16948g = (TextView) shadowLinearLayout.findViewById(R.id.tb_top_toast_title);
            this.f16949h = (TextView) this.f16947f.findViewById(R.id.tb_top_toast_content);
            this.f16950i = (TBSpecificationBtn) this.f16947f.findViewById(R.id.tb_top_toast_btn);
            this.f16948g.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
            this.f16949h.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
            this.f16950i.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
            this.f16950i.setConfig(new c.a.p0.s.f0.n.a());
        }
        SkinManager.setViewTextColor(this.f16948g, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f16949h, R.color.CAM_X0302);
        this.f16950i.changeSkinType();
        this.f16947f.onChangeSkinType();
        this.f16950i.setOnClickListener(this);
        this.f16946e.setBackgroundColor(0);
        this.f16946e.showTip(this.n, this.f16947f, 5000);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || this.q) {
            return;
        }
        this.q = true;
        if (!j.z()) {
            this.o.showToast(R.string.neterror);
            this.f16946e.hideTip();
            return;
        }
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = l.i(TbadkCoreApplication.getInst());
        float f2 = this.n.getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.o.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.l, this.k, 0L, k, i2, f2, i3);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        j();
        this.f16946e.hideTip();
        i();
    }
}
