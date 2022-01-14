package c.a.t0.w1;

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
/* loaded from: classes8.dex */
public class a extends BdAsyncTask<String, Integer, ClientUpdateInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClientUpdater a;

    /* renamed from: b  reason: collision with root package name */
    public IClientUpdaterCallback f24711b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ClientUpdateInfo f24712c;

    /* renamed from: d  reason: collision with root package name */
    public String f24713d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24714e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f24715f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f24716g;

    /* renamed from: c.a.t0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1500a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24717e;

        public RunnableC1500a(a aVar) {
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
            this.f24717e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24717e.f24712c != null && "1".equals(this.f24717e.f24712c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(this.f24717e.f24712c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(this.f24717e.f24712c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(this.f24717e.f24712c.mVercode));
                versionData.setNewFile(this.f24717e.f24712c.mPackageName + this.f24717e.f24712c.mVername + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                versionData.setHasNewVer(Integer.parseInt(this.f24717e.f24712c.mStatus));
                versionData.setNewVersionDesc(this.f24717e.f24712c.mChangelog);
                versionData.setUrl(this.f24717e.f24712c.mDownurl);
                versionData.setSize(this.f24717e.f24712c.mSize);
                versionData.setPatch(this.f24717e.f24712c.mPatchDownUrl);
                versionData.setPatchSize(this.f24717e.f24712c.mPatchSize);
                versionData.setTiebaIconUrl(this.f24717e.f24712c.mIconUrl);
                versionData.setApkMD5RSA(this.f24717e.f24712c.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), this.f24717e.f24712c, this.f24717e.f24713d)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || this.f24717e.f24714e) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), this.f24717e.f24712c, this.f24717e.f24713d)));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, clientUpdateInfo, ruleInfo) == null) || clientUpdateInfo == null || TextUtils.isEmpty(this.a.f24713d)) {
                return;
            }
            this.a.f24712c = clientUpdateInfo;
            this.a.f24715f.post(this.a.f24716g);
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
            this.a.f24713d = optJSONObject2.optString("apk_MD5_RSA");
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
        this.f24716g = new RunnableC1500a(this);
        this.f24714e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.a.setUseRSA(false);
        this.a.setFileProvider("com.baidu.tieba.fileprovider");
        this.f24711b = new b(this);
        this.f24715f = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.cancel();
            this.f24715f.removeCallbacks(this.f24716g);
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
            this.a.checkUpdate(this.f24711b);
            return null;
        }
        return (ClientUpdateInfo) invokeL.objValue;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPreExecute();
            this.f24715f.removeCallbacks(this.f24716g);
        }
    }
}
