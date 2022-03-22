package c.a.p0.c4.q;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.c4.h f13563b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MainTabActivity mainTabActivity, c.a.p0.c4.h hVar) {
        super(2007002);
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
        this.f13563b = hVar;
        setPriority(100);
    }

    public final void a(Intent intent) {
        c.a.p0.c4.h hVar;
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null || (hVar = this.f13563b) == null || hVar.z() == null) {
            return;
        }
        try {
            if (intent.hasExtra("locate_type")) {
                a = intent.getIntExtra("locate_type", 1);
            } else {
                a = this.a.mAppEntranceModel.a();
            }
            this.f13563b.z().setCurrentTabByType(a);
        } catch (Throwable th) {
            BdLog.e(th);
            this.a.finish();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<c.a.o0.h0.b> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) {
            this.a.mIsAdd = false;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || (b2 = ((c.a.o0.h0.d) customResponsedMessage.getData()).b()) == null || b2.size() == 0) {
                return;
            }
            this.f13563b.B(b2);
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.isUseCurrType) {
                if (mainTabActivity.reloginGotoType != 23) {
                    c.a.p0.c4.h hVar = this.f13563b;
                    if (hVar != null && hVar.z() != null) {
                        this.f13563b.z().setCurrentTabByType(this.a.reloginGotoType);
                    }
                } else {
                    VideoClickTabData videoClickTabData = new VideoClickTabData();
                    Bundle reloginVideoMiddleBundle = TbSingleton.getInstance().getReloginVideoMiddleBundle();
                    TbSingleton.getInstance().setReloginVideoMiddleBundle(null);
                    reloginVideoMiddleBundle.remove(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
                    videoClickTabData.setVideoMiddleBundle(reloginVideoMiddleBundle);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921610, videoClickTabData));
                }
            } else {
                c.a.p0.c4.h hVar2 = this.f13563b;
                if (hVar2 != null && hVar2.z() != null) {
                    if (this.a.getIntent() != null && this.a.getIntent().getDataString() != null && this.a.getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                        this.f13563b.z().setCurrentTabByType(2);
                    } else {
                        a(this.a.getIntent());
                    }
                }
            }
            this.a.isUseCurrType = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921567, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, 0));
        }
    }
}
