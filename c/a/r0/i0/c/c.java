package c.a.r0.i0.c;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerHttpResponseMessage;
import com.baidu.tieba.downloadmanager.net.DownloadManagerNetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes3.dex */
public class c extends c.a.r0.i0.c.a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f19134f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19135g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<c.a.r0.i0.a.b> f19136h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<c.a.r0.i0.a.b> f19137i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<String> f19138j;
    public d k;
    public DownloadManagerNetModel l;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19139a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f19139a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Item)) {
                this.f19139a.f19136h.add(0, c.a.r0.i0.a.b.b((Item) customResponsedMessage.getData()));
                c.g(this.f19139a);
                if (this.f19139a.k != null) {
                    this.f19139a.k.b(this.f19139a.f19136h, this.f19139a.f19137i, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BaseFragment baseFragment, int i2) {
        super(baseFragment, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragment) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19134f = 0;
        this.f19136h = new ArrayList<>();
        this.f19137i = new ArrayList<>();
        this.f19138j = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new c.a.r0.i0.d.a(1, i2));
        this.l = downloadManagerNetModel;
        downloadManagerNetModel.Z(this);
        this.l.setUniqueId(baseFragment.getUniqueId());
        o(baseFragment);
    }

    public static /* synthetic */ int g(c cVar) {
        int i2 = cVar.f19134f;
        cVar.f19134f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int h(c cVar) {
        int i2 = cVar.f19134f;
        cVar.f19134f = i2 - 1;
        return i2;
    }

    @Override // c.a.r0.i0.c.a
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19135g) {
            return;
        }
        n();
    }

    @Override // c.a.r0.i0.c.a
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19135g) {
            return;
        }
        this.f19134f = 0;
        this.f19136h.clear();
        this.f19137i.clear();
        n();
    }

    @Override // c.a.r0.i0.c.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.k = dVar;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.f19135g = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            c.a.r0.i0.d.b bVar = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                bVar = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (bVar == null || !s(bVar)) {
                r();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f19135g = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final void o(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baseFragment) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(baseFragment.getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.f19135g = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            c.a.r0.i0.d.b bVar = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                bVar = (c.a.r0.i0.d.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (bVar == null || !s(bVar)) {
                r();
            }
        }
    }

    public final void q(List<c.a.r0.i0.b.b> list, boolean z) {
        Item item;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.r0.i0.b.b bVar : list) {
                if (bVar != null && (item = bVar.f19131b) != null) {
                    arrayList.add(c.a.r0.i0.a.b.b(item));
                }
            }
            this.f19136h.addAll(arrayList);
            if (ListUtils.getCount(this.f19136h) <= 4) {
                this.l.R();
                return;
            }
            this.f19135g = false;
            d dVar = this.k;
            if (dVar != null) {
                dVar.b(this.f19136h, null, z ? 1 : 0);
            }
        }
    }

    public final void r() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.b(this.f19136h, null, 0);
    }

    public final boolean s(c.a.r0.i0.d.b bVar) {
        InterceptResult invokeL;
        Item item;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (!ListUtils.isEmpty(bVar.f19149f)) {
                for (c.a.r0.i0.a.b bVar2 : bVar.f19149f) {
                    if (bVar2 != null && (item = bVar2.f19127e) != null && !this.f19138j.contains(item.apk_name) && c.a.q0.e0.a.d(bVar2.f19127e.apk_name) == null) {
                        this.f19137i.add(bVar2);
                    }
                }
            }
            d dVar = this.k;
            if (dVar != null) {
                dVar.b(this.f19136h, this.f19137i, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<c.a.r0.i0.b.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f19140a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f19141b;

        public b(c cVar) {
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
            this.f19141b = cVar;
            this.f19140a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<c.a.r0.i0.b.b> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<c.a.r0.i0.b.b> d2 = c.a.r0.i0.b.a.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.f19141b.f19134f >= d2.size()) {
                    return arrayList;
                }
                int i2 = this.f19141b.f19134f;
                while (i2 < d2.size()) {
                    c.g(this.f19141b);
                    c.a.r0.i0.b.b bVar = d2.get(i2);
                    if (bVar != null && !k.isEmpty(bVar.f19130a) && !k.isEmpty(bVar.f19132c)) {
                        Item d3 = d(bVar.f19132c);
                        bVar.f19131b = d3;
                        if (d3 != null && d3.apk_detail != null) {
                            PackageInfo d4 = c.a.q0.e0.a.d(bVar.f19130a);
                            if (d4 == null || d4.versionCode < bVar.f19131b.apk_detail.version_code.intValue()) {
                                DownloadData i3 = c.a.q0.e0.a.i(bVar.f19131b);
                                if (c.a.q0.e0.a.c(i3) == 6 && !c.a.q0.e0.a.b(i3.getId())) {
                                    c.a.r0.i0.b.a.e().c(bVar.f19130a);
                                    c.h(this.f19141b);
                                } else {
                                    arrayList.add(bVar);
                                    this.f19141b.f19138j.add(bVar.f19130a);
                                    if (arrayList.size() >= 15) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            c.a.r0.i0.b.a.e().c(bVar.f19130a);
                            c.h(this.f19141b);
                        }
                    }
                    i2++;
                }
                if (arrayList.size() >= 15 && i2 < d2.size()) {
                    this.f19140a = true;
                } else {
                    this.f19140a = false;
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<c.a.r0.i0.b.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f19141b.q(list, this.f19140a);
            }
        }

        public final Item d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (0 != jSONObject.optLong("item_id")) {
                        Item.Builder builder = new Item.Builder();
                        builder.item_id = Long.valueOf(jSONObject.optLong("item_id"));
                        builder.item_name = jSONObject.optString("item_name");
                        builder.icon_size = Double.valueOf(jSONObject.optDouble("icon_size"));
                        builder.icon_url = jSONObject.optString("icon_url");
                        builder.score = Double.valueOf(jSONObject.optDouble("score"));
                        builder.star = Integer.valueOf(jSONObject.optInt(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR));
                        builder.button_name = jSONObject.optString("button_name");
                        builder.button_link = jSONObject.optString("button_link");
                        builder.button_link_type = Integer.valueOf(jSONObject.optInt("button_link_type"));
                        builder.forum_name = jSONObject.optString("forum_name");
                        builder.apk_name = jSONObject.optString("apk_name");
                        JSONObject optJSONObject = jSONObject.optJSONObject("apk_detail");
                        if (optJSONObject != null) {
                            ApkDetail.Builder builder2 = new ApkDetail.Builder();
                            builder2.developer = optJSONObject.optString("developer");
                            builder2.publisher = optJSONObject.optString("publisher");
                            builder2.version = optJSONObject.optString("version");
                            builder2.version_code = Integer.valueOf(optJSONObject.optInt("version_code"));
                            builder2.update_time = optJSONObject.optString("update_time");
                            builder2.size = optJSONObject.optString("size");
                            builder2.need_network = Integer.valueOf(optJSONObject.optInt("need_network"));
                            builder2.need_inner_buy = Integer.valueOf(optJSONObject.optInt("need_inner_buy"));
                            builder2.authority_url = optJSONObject.optString("authority_url");
                            builder2.privacy_url = optJSONObject.optString("privacy_url");
                            builder2.pkg_source = Integer.valueOf(optJSONObject.optInt("pkg_source"));
                            builder.apk_detail = builder2.build(true);
                        }
                        JSONArray optJSONArray = jSONObject.optJSONArray(CommandMessage.TYPE_TAGS);
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                arrayList.add(optJSONArray.optString(i2));
                            }
                            builder.tags = arrayList;
                        }
                        return builder.build(true);
                    }
                    return null;
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (Item) invokeL.objValue;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }
}
