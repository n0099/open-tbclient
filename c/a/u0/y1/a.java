package c.a.u0.y1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.Info;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.IOException;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends BdAsyncTask<String, Integer, ClientUpdateInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClientUpdater a;

    /* renamed from: b  reason: collision with root package name */
    public IClientUpdaterCallback f25353b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ClientUpdateInfo f25354c;

    /* renamed from: d  reason: collision with root package name */
    public String f25355d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25356e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f25357f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f25358g;

    /* renamed from: c.a.u0.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1537a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25359e;

        public RunnableC1537a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25359e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f25359e.f25354c != null && "1".equals(this.f25359e.f25354c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(this.f25359e.f25354c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(this.f25359e.f25354c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(this.f25359e.f25354c.mVercode));
                versionData.setNewFile(this.f25359e.f25354c.mPackageName + this.f25359e.f25354c.mVername + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                versionData.setHasNewVer(Integer.parseInt(this.f25359e.f25354c.mStatus));
                versionData.setNewVersionDesc(this.f25359e.f25354c.mChangelog);
                versionData.setUrl(this.f25359e.f25354c.mDownurl);
                versionData.setSize(this.f25359e.f25354c.mSize);
                versionData.setPatch(this.f25359e.f25354c.mPatchDownUrl);
                versionData.setPatchSize(this.f25359e.f25354c.mPatchSize);
                versionData.setTiebaIconUrl(this.f25359e.f25354c.mIconUrl);
                versionData.setApkMD5RSA(this.f25359e.f25354c.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), this.f25359e.f25354c, this.f25359e.f25355d)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || this.f25359e.f25356e) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), this.f25359e.f25354c, this.f25359e.f25355d)));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements IClientUpdaterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onCompleted(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, clientUpdateInfo, ruleInfo) == null) || clientUpdateInfo == null || TextUtils.isEmpty(this.a.f25355d)) {
                return;
            }
            this.a.f25354c = clientUpdateInfo;
            this.a.f25357f.post(this.a.f25358g);
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onError(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            }
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onException(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            }
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onFetched(JSONObject jSONObject) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("rule")) == null || (optJSONObject2 = optJSONObject.optJSONObject("custom")) == null) {
                return;
            }
            this.a.f25355d = optJSONObject2.optString("apk_MD5_RSA");
        }
    }

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25358g = new RunnableC1537a(this);
        this.f25356e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.a.setUseRSA(false);
        this.a.setFileProvider("com.baidu.tieba.fileprovider");
        this.f25353b = new b(this);
        this.f25357f = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.cancel();
            this.f25357f.removeCallbacks(this.f25358g);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            this.a.setOsName(Info.PASSWORD);
            this.a.setTypeId("0");
            this.a.setFrom("tieba");
            this.a.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
            this.a.addParamValue("tieba_versionname", TbConfig.getVersion());
            ClientUpdater clientUpdater = this.a;
            boolean a = c.a.d.f.p.b.a();
            String str = WebKitFactory.OS_64;
            clientUpdater.addParamValue("running_abi", a ? WebKitFactory.OS_64 : "32");
            ClientUpdater clientUpdater2 = this.a;
            if (!c.a.d.f.p.b.b()) {
                str = "32";
            }
            clientUpdater2.addParamValue("support_abi", str);
            this.a.checkUpdate(this.f25353b);
            return null;
        }
        return (ClientUpdateInfo) invokeL.objValue;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPreExecute();
            this.f25357f.removeCallbacks(this.f25358g);
        }
    }
}
