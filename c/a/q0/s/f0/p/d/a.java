package c.a.q0.s.f0.p.d;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.core.view.itemcard.download.ItemFetchUrlHttpMsg;
import com.baidu.tbadk.core.view.itemcard.download.ItemFetchUrlHttpResponsedMsg;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f13891c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashSet<String> f13892a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, String> f13893b;

    /* renamed from: c.a.q0.s.f0.p.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0683a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13894a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0683a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13894a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            ItemDownloadExtraData itemDownloadExtraData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003508 && (httpResponsedMessage instanceof ItemFetchUrlHttpResponsedMsg) && (httpResponsedMessage.getOrginalMessage() instanceof ItemFetchUrlHttpMsg)) {
                ItemFetchUrlHttpResponsedMsg itemFetchUrlHttpResponsedMsg = (ItemFetchUrlHttpResponsedMsg) httpResponsedMessage;
                DownloadData downloadData = ((ItemFetchUrlHttpMsg) itemFetchUrlHttpResponsedMsg.getOrginalMessage()).getDownloadData();
                String pkgName = ((ItemFetchUrlHttpMsg) itemFetchUrlHttpResponsedMsg.getOrginalMessage()).getPkgName();
                BdUniqueId buttonTag = ((ItemFetchUrlHttpMsg) itemFetchUrlHttpResponsedMsg.getOrginalMessage()).getButtonTag();
                if (downloadData != null) {
                    if (itemFetchUrlHttpResponsedMsg.getError() != 0 || !itemFetchUrlHttpResponsedMsg.isSuccess() || k.isEmpty(itemFetchUrlHttpResponsedMsg.getDownloadUrl())) {
                        this.f13894a.l(pkgName, downloadData.getUrl());
                        if (c.a.q0.e0.a.l(downloadData)) {
                            c.a.q0.s.f0.p.d.b.a(downloadData, 300);
                        }
                    } else {
                        downloadData.setUrl(itemFetchUrlHttpResponsedMsg.getDownloadUrl());
                        this.f13894a.l(pkgName, itemFetchUrlHttpResponsedMsg.getDownloadUrl());
                        if (downloadData.getExtra() instanceof ItemDownloadExtraData) {
                            itemDownloadExtraData = (ItemDownloadExtraData) downloadData.getExtra();
                        } else {
                            itemDownloadExtraData = new ItemDownloadExtraData(1);
                            downloadData.setExtra(itemDownloadExtraData);
                        }
                        itemDownloadExtraData.shouzhuSource = itemFetchUrlHttpResponsedMsg.getSource();
                        if (!k.isEmpty(itemFetchUrlHttpResponsedMsg.getAppname())) {
                            itemDownloadExtraData.appName = itemFetchUrlHttpResponsedMsg.getAppname();
                        }
                        c.a.q0.s.f0.p.d.c.f().m(itemDownloadExtraData.pkgName, itemDownloadExtraData.shouzhuSource);
                        if (c.a.q0.e0.a.l(downloadData)) {
                            c.a.q0.s.f0.p.d.b.a(downloadData, 300);
                            if (itemFetchUrlHttpResponsedMsg.isBussinessApk() && !k.isEmpty(itemFetchUrlHttpResponsedMsg.getRcvUrl())) {
                                new c().execute(itemFetchUrlHttpResponsedMsg.getRcvUrl());
                            }
                        }
                    }
                    if (downloadData.getExtra() instanceof ItemDownloadExtraData) {
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921609, ((ItemDownloadExtraData) downloadData.getExtra()).shouzhuSource);
                        customResponsedMessage.setOrginalMessage(new CustomMessage(2921609, buttonTag));
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
                this.f13894a.f13892a.remove(pkgName);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f13895a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13895a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Intent) {
                    Intent intent = (Intent) data;
                    String g2 = c.a.q0.e0.a.g(intent);
                    if (PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction()) || "android.intent.action.PACKAGE_REPLACED".equals(intent.getAction())) {
                        this.f13895a.k(g2);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... strArr) {
            InterceptResult invokeL;
            HttpURLConnection httpURLConnection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                HttpURLConnection httpURLConnection2 = null;
                if (strArr == null || strArr.length == 0) {
                    return null;
                }
                try {
                    httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    try {
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(c.a.e.c.j.b.d().c().b());
                            httpURLConnection.setReadTimeout(c.a.e.c.j.b.d().b().b());
                            httpURLConnection.addRequestProperty("User-Agent", "bdtb for Android " + TbConfig.getVersion());
                            String str = (CookieHandler.getDefault() == null || CookieHandler.getDefault().get(URI.create(strArr[0]), new HashMap()) == null || ListUtils.isEmpty(CookieHandler.getDefault().get(URI.create(strArr[0]), new HashMap()).get("Cookie"))) ? null : CookieHandler.getDefault().get(URI.create(strArr[0]), new HashMap()).get("Cookie").get(0);
                            StringBuilder sb = new StringBuilder();
                            if (!k.isEmpty(str)) {
                                if (!str.contains("BAIDUCUID")) {
                                    sb.append("BAIDUCUID=");
                                    sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
                                    sb.append(";");
                                }
                                if (!str.contains("BAIDUID")) {
                                    sb.append("BAIDUID=");
                                    sb.append(c.a.q0.m.a.e());
                                    sb.append(";");
                                }
                            }
                            httpURLConnection.addRequestProperty("Cookie", sb.toString());
                            httpURLConnection.getResponseCode();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            c.a.e.e.m.a.e(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                        c.a.e.e.m.a.e(httpURLConnection2);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (Throwable th2) {
                    th = th2;
                    c.a.e.e.m.a.e(httpURLConnection2);
                    throw th;
                }
                c.a.e.e.m.a.e(httpURLConnection);
                return null;
            }
            return (Integer) invokeL.objValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13892a = new HashSet<>();
        this.f13893b = new HashMap<>();
        j();
        h();
        i();
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f13891c == null) {
                f13891c = new a();
            }
            return f13891c;
        }
        return (a) invokeV.objValue;
    }

    public void d(ItemData itemData, DownloadData downloadData, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, itemData, downloadData, str, bdUniqueId) == null) || downloadData == null || itemData == null || !(downloadData.getExtra() instanceof ItemDownloadExtraData)) {
            return;
        }
        String g2 = g(itemData.pkgName);
        if (k.isEmpty(g2)) {
            FileHelper.deleteFile(new File(TbadkCoreApplication.getInst().getApp().getCacheDir() + "/" + downloadData.getId() + "_" + downloadData.getName() + ".tmp"));
            e(itemData, downloadData, str, bdUniqueId);
            return;
        }
        downloadData.setUrl(g2);
        c.a.q0.e0.a.l(downloadData);
    }

    public void e(ItemData itemData, DownloadData downloadData, String str, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itemData, downloadData, str, bdUniqueId) == null) || itemData == null || downloadData == null) {
            return;
        }
        if (this.f13892a.contains(itemData.pkgName)) {
            l.M(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getResources().getString(R.string.item_downloading_tip));
            return;
        }
        this.f13892a.add(itemData.pkgName);
        MessageManager.getInstance().sendMessage(new ItemFetchUrlHttpMsg(downloadData, itemData, str, bdUniqueId));
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = "url_" + str;
            if (this.f13893b.containsKey(str2)) {
                return this.f13893b.get(str2);
            }
            String string = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).getString(str2, "");
            this.f13893b.put(str2, string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(new C0683a(this, CmdConfigHttp.CMD_ITEM_FETCH_URL));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b bVar = new b(this, 2002504);
            bVar.setPriority(-1);
            MessageManager.getInstance().registerListener(bVar);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ITEM_FETCH_URL, TbConfig.SERVER_ADDRESS + "c/s/getCommercialPackage");
            tbHttpMessageTask.setResponsedClass(ItemFetchUrlHttpResponsedMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            String str2 = "url_" + str;
            this.f13893b.remove(str2);
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).edit();
            edit.remove(str2);
            edit.commit();
        }
    }

    public final void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            String str3 = "url_" + str;
            if (StringHelper.equals(this.f13893b.get(str3), str2)) {
                return;
            }
            this.f13893b.put(str3, str2);
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).edit();
            edit.putString(str3, str2);
            edit.commit();
        }
    }
}
