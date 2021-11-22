package b.a.r0.x1.s;

import b.a.e.f.p.l;
import b.a.r0.m3.b0;
import b.a.r0.t1.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.tb.ShareChannelService;
import com.baidu.searchbox.live.interfaces.sharechennel.IShareCallback;
import com.baidu.searchbox.live.interfaces.sharechennel.IShareChannel;
import com.baidu.searchbox.live.interfaces.sharechennel.ShareEntity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b implements ShareChannelService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements IShareChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28611a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28611a = bVar;
        }

        @Override // com.baidu.searchbox.live.interfaces.sharechennel.IShareChannel
        public void shareToChannel(ShareEntity shareEntity, int i2, IShareCallback iShareCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, shareEntity, i2, iShareCallback) == null) {
                if (i2 == 1) {
                    this.f28611a.c(6, shareEntity, iShareCallback);
                } else if (i2 == 3) {
                    this.f28611a.c(2, shareEntity, iShareCallback);
                } else if (i2 == 2) {
                    this.f28611a.c(3, shareEntity, iShareCallback);
                } else if (i2 == 4) {
                    this.f28611a.c(8, shareEntity, iShareCallback);
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 2 || i2 == 3) {
                boolean b2 = b0.b(TbadkCoreApplication.getInst(), "com.tencent.mm");
                if (b2) {
                    return b2;
                }
                l.M(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(g.share_weixin_not_installed_yet));
                return b2;
            } else if (i2 == 6) {
                boolean b3 = b0.b(TbadkCoreApplication.getInst(), "com.sina.weibo");
                if (b3) {
                    return b3;
                }
                l.M(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(g.share_weibo_not_installed_yet));
                return b3;
            } else if (i2 != 8) {
                return false;
            } else {
                boolean b4 = b0.b(TbadkCoreApplication.getInst(), "com.tencent.mobileqq");
                if (b4) {
                    return b4;
                }
                l.M(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(g.share_qq_not_installed_yet));
                return b4;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.tb.ShareChannelService
    public IShareChannel buildShareChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (IShareChannel) invokeV.objValue;
    }

    public final void c(int i2, ShareEntity shareEntity, IShareCallback iShareCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, shareEntity, iShareCallback) == null) || shareEntity == null) {
            return;
        }
        if (!b(i2)) {
            if (iShareCallback != null) {
                iShareCallback.onShare(0, 0, "");
                return;
            }
            return;
        }
        ShareItem d2 = d(shareEntity);
        if (d2 == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaSDKShareEmptyActivityConfig(TbadkCoreApplication.getInst(), d2, i2, 2)));
    }

    public final ShareItem d(ShareEntity shareEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, shareEntity)) == null) {
            if (shareEntity != null) {
                ShareItem shareItem = new ShareItem();
                shareItem.r = shareEntity.title;
                shareItem.s = shareEntity.content;
                shareItem.w = shareEntity.imageUrl;
                shareItem.t = shareEntity.linkUrl;
                shareItem.q = String.valueOf(shareEntity.liveId);
                shareItem.o0 = String.valueOf(shareEntity.userId);
                return shareItem;
            }
            return null;
        }
        return (ShareItem) invokeL.objValue;
    }
}
