package b.a.r0.f2;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b.a.q0.w.e;
import b.a.q0.w.f;
import b.a.r0.s0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f17897b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f17898c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f17899a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.f2.e.b f17900e;

        public a(c cVar, b.a.r0.f2.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17900e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17900e.onFail("url null");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17901a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.f2.e.b f17902b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f17903c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f17904e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f17905f;

            public a(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17905f = bVar;
                this.f17904e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17905f.f17902b.onSuccess(this.f17904e);
                }
            }
        }

        /* renamed from: b.a.r0.f2.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0904b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f17906e;

            public RunnableC0904b(b bVar) {
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
                this.f17906e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17906e.f17902b.onFail("rename failed");
                }
            }
        }

        /* renamed from: b.a.r0.f2.c$b$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0905c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f17907e;

            public RunnableC0905c(b bVar) {
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
                this.f17907e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17907e.f17902b.onFail("download failed");
                }
            }
        }

        public b(c cVar, String str, b.a.r0.f2.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17903c = cVar;
            this.f17901a = str;
            this.f17902b = bVar;
        }

        @Override // b.a.q0.w.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) || this.f17902b == null) {
                return;
            }
            this.f17903c.f17899a.post(new RunnableC0905c(this));
        }

        @Override // b.a.q0.w.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                String str = downloadData.getPath() + (FileHelper.isGif(null, this.f17901a) ? ".gif" : ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX);
                if (FileHelper.renameTo(downloadData.getPath(), str)) {
                    new MediaScannerClient(TbadkApplication.getInst().getContext()).saveImage(str);
                    if (this.f17902b != null) {
                        this.f17903c.f17899a.post(new a(this, str));
                    }
                } else if (this.f17902b != null) {
                    this.f17903c.f17899a.post(new RunnableC0904b(this));
                }
            }
        }

        @Override // b.a.q0.w.e
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // b.a.q0.w.e
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
            }
        }

        @Override // b.a.q0.w.e
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: b.a.r0.f2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0906c extends BdAsyncTask<Void, Void, List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17908a;

        public C0906c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17908a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<String> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? this.f17908a.h() : (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || list.isEmpty()) {
                return;
            }
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
            for (String str : list) {
                newFaceGroupDownloadModel.w(str, Boolean.FALSE, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1654783313, "Lb/a/r0/f2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1654783313, "Lb/a/r0/f2/c;");
                return;
            }
        }
        f17898c = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/";
    }

    public c() {
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
        this.f17899a = new Handler(Looper.getMainLooper());
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f17897b == null) {
                synchronized (c.class) {
                    if (f17897b == null) {
                        f17897b = new c();
                    }
                }
            }
            return f17897b;
        }
        return (c) invokeV.objValue;
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            List<String> h2 = h();
            if (h2.size() > 0) {
                if (z) {
                    c(h2, false);
                }
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public boolean c(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, z)) == null) {
            if (list != null && !list.isEmpty()) {
                int i2 = 0;
                for (String str : list) {
                    MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
                    myEmotionGroupData.setGroupId(str);
                    myEmotionGroupData.setUid(TbadkCoreApplication.getCurrentAccount());
                    if (b.a.r0.s0.a.c().b(myEmotionGroupData)) {
                        FileHelper.deleteFileOrDir(new File(f17898c + str));
                        g.k().h(str);
                        i2++;
                    }
                }
                if (i2 > 0) {
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                    if (z) {
                        d.m().w();
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void d(String str, b.a.r0.f2.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
            if (TextUtils.isEmpty(str)) {
                if (bVar != null) {
                    this.f17899a.post(new a(this, bVar));
                    return;
                }
                return;
            }
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            DownloadData downloadData = new DownloadData(nameMd5FromUrl, nameMd5FromUrl, str, new b(this, nameMd5FromUrl, bVar));
            downloadData.setPath((FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/") + nameMd5FromUrl);
            f.k().l(downloadData);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new C0906c(this).execute(new Void[0]);
        }
    }

    public List<MyEmotionGroupData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                List<MyEmotionGroupData> h2 = b.a.r0.s0.a.c().h(TbadkCoreApplication.getCurrentAccount());
                Iterator<MyEmotionGroupData> it = h2.iterator();
                while (it.hasNext()) {
                    MyEmotionGroupData next = it.next();
                    if (next.getGroupId() != null && next.getGroupId().contains("collect_")) {
                        it.remove();
                    }
                }
                return h2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    public MyEmotionGroupData g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? b.a.r0.s0.a.c().d(TbadkCoreApplication.getCurrentAccount(), str) : (MyEmotionGroupData) invokeL.objValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (MyEmotionGroupData myEmotionGroupData : f()) {
                File file = new File(f17898c + myEmotionGroupData.getGroupId());
                BdLog.e("getFileUnExistList Called:" + file.getName() + "   Exsists:" + file.exists());
                if (!file.exists()) {
                    arrayList.add(myEmotionGroupData.getGroupId());
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean j(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, list, z)) == null) {
            if (list != null && !list.isEmpty()) {
                try {
                    g.k().o(list, TbadkCoreApplication.getCurrentAccount());
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                    if (z) {
                        d.m().w();
                        return true;
                    }
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }
}
