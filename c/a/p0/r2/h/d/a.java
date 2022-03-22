package c.a.p0.r2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.p0.r2.h.f.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f18065b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f18066c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1361a> f18067d;

    /* renamed from: e  reason: collision with root package name */
    public c f18068e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.r2.h.b.a f18069f;

    /* renamed from: c.a.p0.r2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1361a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f18070b;

        /* renamed from: c  reason: collision with root package name */
        public int f18071c;

        public C1361a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "id: " + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f18070b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f18071c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.p0.r2.h.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdListView, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bdListView;
        c cVar = new c(tbPageContext);
        this.f18068e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.a.addHeaderView(this.f18068e.a());
        this.f18066c = new ArrayList();
        this.f18067d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f18066c, this.f18067d, tbPageContext);
        this.f18065b = myEmotionHorizontalAdater;
        this.f18069f = aVar;
        this.a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i < 0 || i >= this.f18066c.size() || i2 < 0 || i2 >= this.f18066c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f18066c;
        list.add(i2, list.remove(i));
        List<C1361a> list2 = this.f18067d;
        list2.add(i2, list2.remove(i));
        this.f18065b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList(this.f18067d);
            this.f18067d.clear();
            for (EmotionPackageData emotionPackageData : this.f18066c) {
                C1361a c1361a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1361a c1361a2 = (C1361a) it.next();
                    if (c1361a2 != null && c1361a2.a == emotionPackageData.id) {
                        c1361a = c1361a2;
                        break;
                    }
                }
                if (c1361a == null) {
                    c1361a = new C1361a();
                    c1361a.a = emotionPackageData.id;
                }
                this.f18067d.add(c1361a);
            }
        }
    }

    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.a == null || this.f18065b == null) {
            return;
        }
        this.f18066c.clear();
        this.f18066c.addAll(list);
        b();
        this.f18065b.d();
        this.f18068e.update(Integer.valueOf(this.f18065b.b()));
        this.f18069f.b(0, this.f18065b.b());
        this.f18069f.a(c.a.p0.r2.h.a.b().a());
        this.f18065b.notifyDataSetChanged();
    }

    public void update() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f18065b == null || this.a == null || this.f18066c == null || (cVar = this.f18068e) == null || this.f18069f == null) {
            return;
        }
        cVar.c();
        this.f18069f.b(0, this.f18065b.b());
        this.f18069f.a(c.a.p0.r2.h.a.b().a());
        this.f18065b.notifyDataSetChanged();
    }
}
