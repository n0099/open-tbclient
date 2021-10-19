package c.a.r0.s0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static f f24424f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f24425a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f24426b;

    /* renamed from: c  reason: collision with root package name */
    public int f24427c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f24428d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f24429e;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f24430a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f24430a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001140 && (customResponsedMessage instanceof CancelDownloadMessage)) {
                this.f24430a.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f24431a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f24431a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001119 && (customResponsedMessage instanceof QueryDownloadMessage)) {
                this.f24431a.f24426b = ((QueryDownloadMessage) customResponsedMessage).getData();
                f fVar = this.f24431a;
                fVar.g(fVar.f24426b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<List<String>, List<DownloadData>, List<DownloadData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f24432a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24432a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<DownloadData> doInBackground(List<String>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                LinkedList linkedList = new LinkedList();
                if (listArr[0] == null) {
                    return linkedList;
                }
                for (int i2 = 0; i2 < listArr[0].size(); i2++) {
                    MyEmotionGroupData d2 = c.a.r0.s0.a.c().d(TbadkCoreApplication.getCurrentAccount(), listArr[0].get(i2));
                    if (d2 != null && c.a.r0.s0.b.d(d2.getGroupId())) {
                        DownloadData downloadData = new DownloadData(d2.getGroupId());
                        downloadData.setStatus(3);
                        linkedList.add(downloadData);
                    }
                }
                return linkedList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<DownloadData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (list == null) {
                    list = new LinkedList<>();
                }
                for (DownloadData downloadData : c.a.q0.w.f.k().j()) {
                    for (String str : this.f24432a.f24426b) {
                        if (downloadData.getType() == 11 && downloadData.getId().equals(str)) {
                            list.add(downloadData);
                        }
                    }
                }
                this.f24432a.h(list);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1795812316, "Lc/a/r0/s0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1795812316, "Lc/a/r0/s0/f;");
                return;
            }
        }
        f24424f = new f();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f24427c = 5;
        this.f24428d = new a(this, 2001140);
        this.f24429e = new b(this, 2001119);
        MessageManager.getInstance().registerListener(this.f24429e);
        MessageManager.getInstance().registerListener(this.f24428d);
    }

    public static f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f24424f : (f) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.w.f.k().i(11);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            c.a.q0.w.f.k().f(str, 11);
        }
    }

    public final void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            c cVar = new c(this);
            this.f24425a = cVar;
            cVar.execute(list);
        }
    }

    public void h(List<DownloadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
        }
    }

    public void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) || c.a.e.e.p.k.isEmpty(str) || c.a.e.e.p.k.isEmpty(str3)) {
            return;
        }
        DownloadData downloadData = new DownloadData(str, str2, str3, new e());
        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
        downloadData.setType(11);
        String[] split = str3.split("/");
        if (split.length > 1) {
            String[] split2 = split[split.length - 1].split("_");
            if (split2 != null) {
                if (split2.length == 5) {
                    downloadData.setDescription(split2[1]);
                    downloadData.setCheck(split2[2]);
                    downloadData.setWidth(c.a.e.e.m.b.e(split2[3], 200));
                    downloadData.setHeight(c.a.e.e.m.b.e(split2[4].split(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)[0], 200));
                } else if (split2.length == 3) {
                    downloadData.setDescription(split2[1]);
                    downloadData.setCheck(split2[2].split(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)[0]);
                    downloadData.setWidth(200);
                    downloadData.setHeight(200);
                } else {
                    downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
                    downloadData.setStatus(2);
                }
            } else {
                downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
                downloadData.setStatus(2);
            }
        } else {
            downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.download_fail));
            downloadData.setStatus(2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath());
        sb.append(FileHelper.getPrefixByType(2));
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        downloadData.setPath(sb.toString());
        BdLog.d("download:path:" + downloadData.getPath());
        c.a.q0.w.f.k().m(downloadData, this.f24427c);
    }
}
