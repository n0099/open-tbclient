package c.a.p0.c4.q;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class h0 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.c4.h f13572b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(MainTabActivity mainTabActivity, c.a.p0.c4.h hVar) {
        super(2921610);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.f13572b = hVar;
        setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c.a.p0.c4.h hVar;
        VideoClickTabData videoClickTabData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921610 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof VideoClickTabData) || (hVar = this.f13572b) == null || hVar.z() == null || (videoClickTabData = (VideoClickTabData) customResponsedMessage.getData()) == null) {
            return;
        }
        MainTabActivity mainTabActivity = this.a;
        if (mainTabActivity.isResumed || mainTabActivity.reloginGotoType == 23) {
            TbSingleton.getInstance().setFromFeedVideoClick(true);
            this.f13572b.z().t(true, videoClickTabData.getMiddleFragment());
            TbSingleton.getInstance().setVideoChannelAttentionRedIcon(TbSingleton.getInstance().getVideoChannelAttentionRedIcon());
            this.f13572b.z().setCurrentTabByType(22);
        }
    }
}
