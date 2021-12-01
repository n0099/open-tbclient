package c.a.r0.l2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.r0.l2.h.f.c;
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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f19273b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f19274c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1148a> f19275d;

    /* renamed from: e  reason: collision with root package name */
    public c f19276e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.l2.h.b.a f19277f;

    /* renamed from: c.a.r0.l2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1148a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f19278b;

        /* renamed from: c  reason: collision with root package name */
        public int f19279c;

        public C1148a() {
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
                return "id: " + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f19278b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f19279c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.r0.l2.h.b.a aVar) {
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
        this.f19276e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.a.addHeaderView(this.f19276e.a());
        this.f19274c = new ArrayList();
        this.f19275d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f19274c, this.f19275d, tbPageContext);
        this.f19273b = myEmotionHorizontalAdater;
        this.f19277f = aVar;
        this.a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f19274c.size() || i3 < 0 || i3 >= this.f19274c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f19274c;
        list.add(i3, list.remove(i2));
        List<C1148a> list2 = this.f19275d;
        list2.add(i3, list2.remove(i2));
        this.f19273b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList(this.f19275d);
            this.f19275d.clear();
            for (EmotionPackageData emotionPackageData : this.f19274c) {
                C1148a c1148a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1148a c1148a2 = (C1148a) it.next();
                    if (c1148a2 != null && c1148a2.a == emotionPackageData.id) {
                        c1148a = c1148a2;
                        break;
                    }
                }
                if (c1148a == null) {
                    c1148a = new C1148a();
                    c1148a.a = emotionPackageData.id;
                }
                this.f19275d.add(c1148a);
            }
        }
    }

    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.a == null || this.f19273b == null) {
            return;
        }
        this.f19274c.clear();
        this.f19274c.addAll(list);
        b();
        this.f19273b.d();
        this.f19276e.update(Integer.valueOf(this.f19273b.b()));
        this.f19277f.b(0, this.f19273b.b());
        this.f19277f.a(c.a.r0.l2.h.a.b().a());
        this.f19273b.notifyDataSetChanged();
    }

    public void update() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f19273b == null || this.a == null || this.f19274c == null || (cVar = this.f19276e) == null || this.f19277f == null) {
            return;
        }
        cVar.c();
        this.f19277f.b(0, this.f19273b.b());
        this.f19277f.a(c.a.r0.l2.h.a.b().a());
        this.f19273b.notifyDataSetChanged();
    }
}
