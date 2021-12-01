package c.a.r0.l3;

import android.content.Context;
import android.os.Bundle;
import c.a.q0.t.g.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public b(Context context, c.a.q0.t.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = context;
    }

    @Override // c.a.q0.t.g.d
    public void a(ShareItem shareItem, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shareItem, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            b(shareItem, i2);
        }
    }

    public final void b(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem, i2) == null) || this.a == null || shareItem == null) {
            return;
        }
        IntentConfig intentConfig = new IntentConfig(this.a);
        ShareEntity shareEntity = new ShareEntity();
        shareEntity.setTitle(shareItem.r);
        shareEntity.setContent(shareItem.s);
        shareEntity.setReadCount(shareItem.R);
        int i3 = shareItem.M;
        shareEntity.setIsVideoThread(i3 == 2 || i3 == 6 || i3 == 8);
        shareEntity.setImageUri(shareItem.v);
        shareEntity.canShareBySmartApp = shareItem.j0;
        String str = shareItem.t;
        if (i2 == 6 && !StringUtils.isNull(shareItem.u)) {
            str = shareItem.u;
        }
        shareEntity.setLinkUrl(str);
        shareEntity.setLocalFile(shareItem.x);
        shareEntity.setLocation(shareItem.B);
        shareEntity.setShareTo(i2);
        shareEntity.setStats(shareItem.e());
        shareEntity.setPreferImageToLink(shareItem.Z);
        shareEntity.setTid(shareItem.K);
        shareEntity.setfName(shareItem.p);
        shareEntity.setTypeShareToSmallApp(shareItem.y);
        shareEntity.topic = shareItem.O;
        if (i2 == 6 && !StringUtils.isNull(shareItem.Q)) {
            shareEntity.topic = shareItem.P + shareItem.Q;
            shareEntity.setContent("");
        }
        shareEntity.taskCompleteId = shareItem.S;
        shareEntity.diskPicOperate = shareItem.A;
        shareEntity.setExtLiveInfo(shareItem.o0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_share_data", shareEntity);
        bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
        intentConfig.getIntent().putExtras(bundle);
        shareItem.j(true);
        intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
    }
}
