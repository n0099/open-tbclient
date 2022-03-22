package c.a.o0.y;

import c.a.d.c.g.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.game.GameShareJsBridge;
import com.baidu.tbadk.game.RequestGameDetailMessage;
import com.baidu.tbadk.game.ResponseGameDetailMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f11594d;
    public transient /* synthetic */ FieldHolder $fh;
    public GameInfoData a;

    /* renamed from: b  reason: collision with root package name */
    public String f11595b;

    /* renamed from: c  reason: collision with root package name */
    public final c f11596c;

    /* renamed from: c.a.o0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0870a implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0870a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2001261, this.a.e());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseGameDetailMessage) || socketResponsedMessage.hasError()) {
                return;
            }
            ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
            if (responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage) {
                this.a.a = GameInfoData.fromGameInfo(responseGameDetailMessage.getGameInfo());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(997828312, "Lc/a/o0/y/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(997828312, "Lc/a/o0/y/a;");
                return;
            }
        }
        f11594d = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11596c = new b(this, 303009);
        MessageManager.getInstance().registerListener(this.f11596c);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001261, new C0870a(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f11594d : (a) invokeV.objValue;
    }

    public final GameInfoData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GameInfoData gameInfoData = new GameInfoData();
            gameInfoData.setGameName(TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f047d));
            gameInfoData.setGameLink(this.f11595b);
            gameInfoData.setGameId("default");
            gameInfoData.setIconUrl("default");
            gameInfoData.setIntroduce(TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f047c));
            return gameInfoData;
        }
        return (GameInfoData) invokeV.objValue;
    }

    public GameInfoData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            GameInfoData gameInfoData = this.a;
            return gameInfoData == null ? b() : gameInfoData;
        }
        return (GameInfoData) invokeV.objValue;
    }

    public ShareFromGameCenterMsgData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GameInfoData c2 = c();
            ShareFromGameCenterMsgData shareFromGameCenterMsgData = new ShareFromGameCenterMsgData();
            shareFromGameCenterMsgData.setTitle(StringUtils.isNull(GameShareJsBridge.getInstance().getShareTitle(), true) ? c2.getGameName() : GameShareJsBridge.getInstance().getShareTitle());
            shareFromGameCenterMsgData.setContent(StringUtils.isNull(GameShareJsBridge.getInstance().getShareContent(), true) ? c2.getIntroduce() : GameShareJsBridge.getInstance().getShareContent());
            shareFromGameCenterMsgData.setImageUrl(StringUtils.isNull(GameShareJsBridge.getInstance().getShareImage(), true) ? c2.getIconUrl() : GameShareJsBridge.getInstance().getShareImage());
            shareFromGameCenterMsgData.setShareSource(StringUtils.isNull(GameShareJsBridge.getInstance().getShareName(), true) ? c2.getGameName() : GameShareJsBridge.getInstance().getShareName());
            shareFromGameCenterMsgData.setShareSourceIcon(StringUtils.isNull(GameShareJsBridge.getInstance().getIconUrl(), true) ? c2.getIconUrl() : GameShareJsBridge.getInstance().getIconUrl());
            String gameId = StringUtils.isNull(GameShareJsBridge.getInstance().getGameId(), true) ? c2.getGameId() : GameShareJsBridge.getInstance().getGameId();
            if ("default".equals(gameId)) {
                shareFromGameCenterMsgData.setShareSourceUrl(gameId);
            } else {
                shareFromGameCenterMsgData.setShareSourceUrl("game:detail:TBCGameID=" + gameId);
            }
            String shareContentUrl = GameShareJsBridge.getInstance().getShareContentUrl();
            if (StringUtils.isNull(shareContentUrl)) {
                shareContentUrl = c2.getGameLink();
            }
            if (StringUtils.isNull(shareContentUrl, true)) {
                shareContentUrl = "";
            } else if (!shareContentUrl.contains("tbgametype")) {
                shareContentUrl = shareContentUrl + "&tbgametype=1";
            }
            shareFromGameCenterMsgData.setShareUrl(shareContentUrl.toString());
            return shareFromGameCenterMsgData;
        }
        return (ShareFromGameCenterMsgData) invokeV.objValue;
    }
}
