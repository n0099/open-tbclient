package b.a.r0.s0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.UserCollectModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static t f23382b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GetEmotionInfosModel f23383a;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f23384a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f23385b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f23386c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ t f23387d;

        public a(t tVar, l lVar, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, lVar, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23387d = tVar;
            this.f23384a = lVar;
            this.f23385b = list;
            this.f23386c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? Integer.valueOf(b.a.r0.s0.g.k().i(TbadkCoreApplication.getCurrentAccount()) - 1) : (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num) == null) {
                if (num.intValue() >= 300) {
                    l lVar = this.f23384a;
                    if (lVar != null) {
                        lVar.onResult(4, 0, 0);
                        return;
                    } else {
                        b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_limit);
                        return;
                    }
                }
                while (this.f23385b.size() + num.intValue() > 300) {
                    List list = this.f23385b;
                    list.remove(list.size() - 1);
                }
                this.f23387d.i(this.f23385b, this.f23386c, this.f23384a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements GetEmotionInfosModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f23388a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f23389b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f23390c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f23391d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f23392e;

        public b(t tVar, l lVar, Map map, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, lVar, map, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23392e = tVar;
            this.f23388a = lVar;
            this.f23389b = map;
            this.f23390c = list;
            this.f23391d = z;
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                l lVar = this.f23388a;
                if (lVar == null) {
                    b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            }
        }

        @Override // com.baidu.tbadk.img.GetEmotionInfosModel.b
        public void onSuccess(List<b.a.q0.d0.c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list == null || list.isEmpty()) {
                    l lVar = this.f23388a;
                    if (lVar == null) {
                        b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                    } else {
                        lVar.onResult(4, 0, 0);
                    }
                }
                for (b.a.q0.d0.c cVar : list) {
                    if (!u.e().f(cVar.f12025a)) {
                        cVar.f12030f = (String) this.f23389b.get(cVar.f12031g);
                        this.f23390c.add(cVar);
                    }
                }
                this.f23392e.m(this.f23390c, this.f23388a, this.f23391d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f23393a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.d0.c f23394b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f23395c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ l f23396d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f23397e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t f23398f;

        public c(t tVar, List list, b.a.q0.d0.c cVar, AtomicInteger atomicInteger, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, list, cVar, atomicInteger, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23398f = tVar;
            this.f23393a = list;
            this.f23394b = cVar;
            this.f23395c = atomicInteger;
            this.f23396d = lVar;
            this.f23397e = z;
        }

        @Override // b.a.r0.s0.t.j
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23395c.decrementAndGet() == 0) {
                this.f23398f.f(this.f23393a, this.f23396d, this.f23397e);
            }
        }

        @Override // b.a.r0.s0.t.j
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f23393a.add(this.f23398f.w(this.f23394b));
                if (this.f23395c.decrementAndGet() == 0) {
                    this.f23398f.f(this.f23393a, this.f23396d, this.f23397e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f23399a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f23400b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f23401c;

        public d(t tVar, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23399a = list;
            this.f23400b = lVar;
            this.f23401c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? Boolean.valueOf(b.a.r0.s0.g.k().b(this.f23399a)) : (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    l lVar = this.f23400b;
                    if (lVar == null) {
                        b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.add_success);
                    } else {
                        lVar.onResult(4, 1, 0);
                    }
                    u.e().g();
                    if (this.f23401c) {
                        new UserCollectModel().w();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                    TiebaStatic.log("c12222");
                    return;
                }
                l lVar2 = this.f23400b;
                if (lVar2 == null) {
                    b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar2.onResult(4, 0, 0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f23402a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f23403b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f23404c;

        public e(t tVar, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23402a = list;
            this.f23403b = lVar;
            this.f23404c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> n = b.a.r0.s0.g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
                HashMap hashMap = new HashMap();
                for (CollectEmotionData collectEmotionData : n) {
                    hashMap.put(collectEmotionData.getSharpText(), collectEmotionData);
                }
                int size = n.size() - 2;
                for (int i2 = 0; i2 < this.f23402a.size(); i2++) {
                    CollectEmotionData collectEmotionData2 = (CollectEmotionData) this.f23402a.get(i2);
                    collectEmotionData2.orderId = size;
                    String sharpText = collectEmotionData2.getSharpText();
                    if (hashMap.containsKey(sharpText)) {
                        n.remove(hashMap.get(sharpText));
                        hashMap.remove(sharpText);
                    }
                    b.a.r0.s0.g.k().r(collectEmotionData2);
                    size--;
                }
                for (int i3 = 0; i3 < n.size(); i3++) {
                    CollectEmotionData collectEmotionData3 = n.get(i3);
                    if (!b.a.q0.c0.d.f11983d.equals(collectEmotionData3.sharpText)) {
                        collectEmotionData3.orderId = size;
                        b.a.r0.s0.g.k().r(collectEmotionData3);
                        size--;
                    }
                }
                if (this.f23402a.size() > 0) {
                    u.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(this.f23402a.size()));
                arrayList.add(0);
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f23403b == null || list == null || list.size() != 2) {
                return;
            }
            this.f23403b.onResult(2, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                if (this.f23404c) {
                    new UserCollectModel().w();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                StatisticItem statisticItem = new StatisticItem("c12227");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f23405a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f23406b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f23407c;

        public f(t tVar, List list, l lVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, list, lVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23405a = list;
            this.f23406b = lVar;
            this.f23407c = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                int i2 = 0;
                for (CollectEmotionData collectEmotionData : this.f23405a) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !b.a.q0.c0.d.f11983d.equals(collectEmotionData.sharpText)) {
                        b.a.r0.s0.g.k().g(collectEmotionData);
                        ImageFileInfo imageFileInfo = collectEmotionData.imageFileInfo;
                        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                            File file = new File(collectEmotionData.imageFileInfo.getFilePath());
                            if (file.exists()) {
                                file.delete();
                            }
                            String filePath = collectEmotionData.imageFileInfo.getFilePath();
                            File file2 = new File(filePath.replace("_s.jpg", "_b.jpg"));
                            if (file2.exists()) {
                                file2.delete();
                            }
                            File file3 = new File(filePath.replace("_s.jpg", "_b.gif"));
                            if (file3.exists()) {
                                file3.delete();
                            }
                        }
                        i2++;
                    }
                }
                List<CollectEmotionData> n = b.a.r0.s0.g.k().n(TbadkCoreApplication.getCurrentAccount());
                for (int i3 = 0; i3 < n.size(); i3++) {
                    CollectEmotionData collectEmotionData2 = n.get(i3);
                    if (!b.a.q0.c0.d.f11983d.equals(collectEmotionData2.getSharpText())) {
                        collectEmotionData2.orderId = (n.size() - i3) - 1;
                        b.a.r0.s0.g.k().r(collectEmotionData2);
                    }
                }
                if (i2 > 0) {
                    u.e().g();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(this.f23405a.size() - i2));
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f23406b == null || list == null || list.size() != 2) {
                return;
            }
            this.f23406b.onResult(1, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                if (this.f23407c) {
                    new UserCollectModel().w();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921028));
                StatisticItem statisticItem = new StatisticItem("c12226");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BdAsyncTask<Void, Void, List<Integer>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f23408a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f23409b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t f23410c;

        public g(t tVar, List list, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, list, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23410c = tVar;
            this.f23408a = list;
            this.f23409b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<Integer> doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                int i2 = 0;
                for (CollectEmotionData collectEmotionData : this.f23408a) {
                    String filePath = collectEmotionData.imageFileInfo.getFilePath();
                    File file = new File(filePath.replace("_s.jpg", "_b.jpg"));
                    byte[] r = file.exists() ? this.f23410c.r(file) : null;
                    if (r == null) {
                        r = this.f23410c.r(new File(filePath.replace("_s.jpg", "_b.gif")));
                    }
                    if (r != null && FileHelper.saveImageFileByUser(collectEmotionData.picUrl, r, TbadkCoreApplication.getInst().getContext()) == 0) {
                        i2++;
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(this.f23408a.size() - i2));
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.f23409b == null || list == null || list.size() != 2) {
                return;
            }
            this.f23409b.onResult(3, list.get(0).intValue(), list.get(1).intValue());
            if (list.get(0).intValue() > 0) {
                StatisticItem statisticItem = new StatisticItem("c12228");
                statisticItem.param("obj_param1", list.get(0).intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f23411a;

        public h(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23411a = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) ? this.f23411a.p() : (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
                return;
            }
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null) {
                    b.a.q0.d0.c cVar = new b.a.q0.d0.c();
                    cVar.f12025a = collectEmotionData.pid;
                    cVar.f12030f = collectEmotionData.pkgId;
                    cVar.f12028d = collectEmotionData.picUrl;
                    cVar.f12029e = collectEmotionData.thumbnail;
                    cVar.f12026b = collectEmotionData.width;
                    cVar.f12027c = collectEmotionData.height;
                    new k(this.f23411a, null).execute(cVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.r0.s0.t.l
        public void onResult(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface j {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes5.dex */
    public class k extends BdAsyncTask<b.a.q0.d0.c, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.q0.d0.c f23412a;

        /* renamed from: b  reason: collision with root package name */
        public j f23413b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t f23414c;

        public k(t tVar, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23414c = tVar;
            this.f23413b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(b.a.q0.d0.c[] cVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVarArr)) == null) {
                if (cVarArr != null && cVarArr.length > 0) {
                    this.f23412a = cVarArr[0];
                    WebClient webClient = new WebClient();
                    byte[] downloadImageBytes = webClient.downloadImageBytes(this.f23412a.f12028d, false);
                    if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                        String q = this.f23414c.q(this.f23412a, true);
                        if (TextUtils.isEmpty(q)) {
                            return Boolean.FALSE;
                        }
                        if (b.a.e.e.p.l.B(downloadImageBytes)) {
                            q = q.replace("_b.jpg", "_b.gif");
                        }
                        File file = new File(q);
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (!this.f23414c.u(file, downloadImageBytes)) {
                            return Boolean.FALSE;
                        }
                        byte[] downloadImageBytes2 = webClient.downloadImageBytes(this.f23412a.f12029e, false);
                        if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                            String q2 = this.f23414c.q(this.f23412a, false);
                            if (!TextUtils.isEmpty(q2)) {
                                if (!this.f23414c.u(new File(q2), downloadImageBytes2)) {
                                    return Boolean.FALSE;
                                }
                                return Boolean.TRUE;
                            }
                            return Boolean.FALSE;
                        }
                        return Boolean.FALSE;
                    }
                    return Boolean.FALSE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    j jVar = this.f23413b;
                    if (jVar != null) {
                        jVar.onSuccess();
                        return;
                    }
                    return;
                }
                j jVar2 = this.f23413b;
                if (jVar2 != null) {
                    jVar2.onFail();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface l {
        void onResult(int i2, int i3, int i4);
    }

    public t() {
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

    public static String o(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, z)) == null) {
            String str2 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + b.a.q0.c0.d.b() + "/" + str + "_s.jpg";
            if (z) {
                String replace = str2.replace("_s.jpg", "_b.jpg");
                if (new File(replace).exists()) {
                    return replace;
                }
                String replace2 = str2.replace("_s.jpg", "_b.gif");
                return new File(replace2).exists() ? replace2 : "";
            }
            return str2;
        }
        return (String) invokeLZ.objValue;
    }

    public static t s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f23382b == null) {
                f23382b = new t();
            }
            return f23382b;
        }
        return (t) invokeV.objValue;
    }

    public final void f(List<CollectEmotionData> list, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, list, lVar, z) == null) {
            new d(this, list, lVar, z).execute(new Void[0]);
        }
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (b.a.r0.f2.d.m().n()) {
                b.a.e.e.p.l.L(BdBaseApplication.getInst().getApp(), R.string.face_collect_is_syncing);
                return;
            }
            b.a.q0.d0.c cVar = new b.a.q0.d0.c();
            cVar.f12028d = str;
            cVar.f12030f = str2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            h(arrayList, true, null);
        }
    }

    public void h(List<b.a.q0.d0.c> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            new a(this, lVar, list, z).execute(new Void[0]);
        }
    }

    public void i(List<b.a.q0.d0.c> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list == null || list.isEmpty()) {
                if (lVar == null) {
                    b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.save_emotion_failed);
                } else {
                    lVar.onResult(4, 0, 0);
                }
            } else if (TbadkCoreApplication.isLogin()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap = new HashMap();
                for (b.a.q0.d0.c cVar : list) {
                    String str = cVar.f12025a;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        if (!u.e().f(cVar.f12025a)) {
                            arrayList.add(cVar);
                        }
                    } else {
                        arrayList2.add(cVar.f12028d);
                        String str2 = cVar.f12030f;
                        if (str2 != null) {
                            hashMap.put(cVar.f12028d, str2);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    if (this.f23383a == null) {
                        this.f23383a = new GetEmotionInfosModel();
                    }
                    this.f23383a.y(arrayList2, new b(this, lVar, hashMap, arrayList, z));
                    return;
                }
                m(arrayList, lVar, z);
            } else if (lVar == null) {
                ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
            } else {
                lVar.onResult(4, 0, 0);
            }
        }
    }

    public void j(List<String> list, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, lVar) == null) {
            if (ListUtils.isEmpty(list) && lVar != null) {
                lVar.onResult(4, 0, 0);
            }
            if (b.a.r0.f2.d.m().n()) {
                b.a.e.e.p.l.L(BdBaseApplication.getInst().getApp(), R.string.face_collect_is_syncing);
                lVar.onResult(4, 0, 0);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                b.a.q0.d0.c cVar = new b.a.q0.d0.c();
                cVar.f12028d = str;
                arrayList.add(cVar);
            }
            h(arrayList, true, lVar);
        }
    }

    public boolean k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            List<CollectEmotionData> p = p();
            if (p == null || p.isEmpty()) {
                return true;
            }
            if (z) {
                l(p, false, new i(this));
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void l(List<CollectEmotionData> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list != null && list.size() > 0) {
                new f(this, list, lVar, z).execute(new Void[0]);
            } else if (lVar != null) {
                lVar.onResult(1, 1, 0);
            }
        }
    }

    public final void m(List<b.a.q0.d0.c> list, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, list, lVar, z) == null) {
            if (list.size() == 0) {
                if (lVar == null) {
                    b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.add_success);
                    return;
                } else {
                    lVar.onResult(4, 1, 0);
                    return;
                }
            }
            AtomicInteger atomicInteger = new AtomicInteger(list.size());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            for (b.a.q0.d0.c cVar : list) {
                new k(this, new c(this, copyOnWriteArrayList, cVar, atomicInteger, lVar, z)).execute(cVar);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            new h(this).execute(new Void[0]);
        }
    }

    public List<CollectEmotionData> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<CollectEmotionData> n = b.a.r0.s0.g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
            if (n != null) {
                for (CollectEmotionData collectEmotionData : n) {
                    if (collectEmotionData != null && !"setting_icon".equals(collectEmotionData.pid) && !new File(o(collectEmotionData.pid, false)).exists()) {
                        arrayList.add(collectEmotionData);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final String q(b.a.q0.d0.c cVar, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, cVar, z)) == null) {
            if (cVar == null || TextUtils.isEmpty(cVar.f12028d) || TextUtils.isEmpty(cVar.f12025a)) {
                return "";
            }
            if (z) {
                str = "_b" + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            } else {
                str = "_s" + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
            }
            return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + b.a.q0.c0.d.b() + "/" + cVar.f12025a + str;
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    public byte[] r(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, file)) == null) {
            InputStream inputStream = null;
            if (file != null) {
                ?? exists = file.exists();
                try {
                    if (exists != 0) {
                        try {
                            fileInputStream = new FileInputStream(file);
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr, 0, 1024);
                                    if (read != -1) {
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } else {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        b.a.e.e.p.m.e(fileInputStream);
                                        return byteArray;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                                BdLog.e(e.getMessage());
                                b.a.e.e.p.m.e(fileInputStream);
                                return null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            b.a.e.e.p.m.e(inputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = exists;
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public void t(List<CollectEmotionData> list, boolean z, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{list, Boolean.valueOf(z), lVar}) == null) {
            if (list != null && list.size() > 0) {
                new e(this, list, lVar, z).execute(new Void[0]);
            } else if (lVar != null) {
                lVar.onResult(2, 0, 0);
            }
        }
    }

    public final boolean u(File file, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048589, this, file, bArr)) != null) {
            return invokeLL.booleanValue;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    if ((!file.exists() || file.delete()) && file.createNewFile()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr, 0, bArr.length);
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            return true;
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            BdLog.e(e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    BdLog.e(th2.getMessage());
                    return false;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void v(List<CollectEmotionData> list, l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, list, lVar) == null) || list == null || list.size() <= 0) {
            return;
        }
        new g(this, list, lVar).execute(new Void[0]);
    }

    public final CollectEmotionData w(b.a.q0.d0.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cVar)) == null) {
            CollectEmotionData collectEmotionData = new CollectEmotionData();
            StringBuilder sb = new StringBuilder(b.a.q0.c0.d.f11985f);
            if (TextUtils.isEmpty(cVar.f12030f)) {
                sb.append(cVar.f12025a);
                sb.append(",");
            } else {
                sb.append(cVar.f12030f);
                sb.append("_");
                sb.append(cVar.f12025a);
                sb.append(",");
            }
            sb.append(cVar.f12026b);
            sb.append(",");
            sb.append(cVar.f12027c);
            sb.append(",");
            String lowerCase = b.a.e.e.p.q.c(sb.toString().replace("collect_", "") + "7S6wbXjEKL9N").toLowerCase();
            collectEmotionData.pid = cVar.f12025a;
            collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
            collectEmotionData.sharpText = SmallTailInfo.EMOTION_PREFIX + sb.toString() + lowerCase + SmallTailInfo.EMOTION_SUFFIX;
            collectEmotionData.orderId = b.a.r0.s0.g.k().i(collectEmotionData.uid) + 1;
            collectEmotionData.width = cVar.f12026b;
            collectEmotionData.height = cVar.f12027c;
            collectEmotionData.picUrl = cVar.f12028d;
            collectEmotionData.thumbnail = cVar.f12029e;
            collectEmotionData.backup = "";
            return collectEmotionData;
        }
        return (CollectEmotionData) invokeL.objValue;
    }
}
