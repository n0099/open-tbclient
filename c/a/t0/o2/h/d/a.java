package c.a.t0.o2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.t0.o2.h.f.c;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f20277b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f20278c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1266a> f20279d;

    /* renamed from: e  reason: collision with root package name */
    public c f20280e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.o2.h.b.a f20281f;

    /* renamed from: c.a.t0.o2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1266a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f20282b;

        /* renamed from: c  reason: collision with root package name */
        public int f20283c;

        public C1266a() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "id: " + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f20282b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f20283c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.t0.o2.h.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdListView, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bdListView;
        c cVar = new c(tbPageContext);
        this.f20280e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.a.addHeaderView(this.f20280e.a());
        this.f20278c = new ArrayList();
        this.f20279d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f20278c, this.f20279d, tbPageContext);
        this.f20277b = myEmotionHorizontalAdater;
        this.f20281f = aVar;
        this.a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f20278c.size() || i3 < 0 || i3 >= this.f20278c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f20278c;
        list.add(i3, list.remove(i2));
        List<C1266a> list2 = this.f20279d;
        list2.add(i3, list2.remove(i2));
        this.f20277b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList(this.f20279d);
            this.f20279d.clear();
            for (EmotionPackageData emotionPackageData : this.f20278c) {
                C1266a c1266a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1266a c1266a2 = (C1266a) it.next();
                    if (c1266a2 != null && c1266a2.a == emotionPackageData.id) {
                        c1266a = c1266a2;
                        break;
                    }
                }
                if (c1266a == null) {
                    c1266a = new C1266a();
                    c1266a.a = emotionPackageData.id;
                }
                this.f20279d.add(c1266a);
            }
        }
    }

    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.a == null || this.f20277b == null) {
            return;
        }
        this.f20278c.clear();
        this.f20278c.addAll(list);
        b();
        this.f20277b.d();
        this.f20280e.update(Integer.valueOf(this.f20277b.b()));
        this.f20281f.b(0, this.f20277b.b());
        this.f20281f.a(c.a.t0.o2.h.a.b().a());
        this.f20277b.notifyDataSetChanged();
    }

    public void update() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f20277b == null || this.a == null || this.f20278c == null || (cVar = this.f20280e) == null || this.f20281f == null) {
            return;
        }
        cVar.c();
        this.f20281f.b(0, this.f20277b.b());
        this.f20281f.a(c.a.t0.o2.h.a.b().a());
        this.f20277b.notifyDataSetChanged();
    }
}
