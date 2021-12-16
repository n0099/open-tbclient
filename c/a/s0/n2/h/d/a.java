package c.a.s0.n2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.s0.n2.h.f.c;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f20004b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f20005c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1211a> f20006d;

    /* renamed from: e  reason: collision with root package name */
    public c f20007e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.n2.h.b.a f20008f;

    /* renamed from: c.a.s0.n2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1211a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f20009b;

        /* renamed from: c  reason: collision with root package name */
        public int f20010c;

        public C1211a() {
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
                return "id: " + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f20009b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f20010c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.s0.n2.h.b.a aVar) {
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
        this.f20007e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.a.addHeaderView(this.f20007e.a());
        this.f20005c = new ArrayList();
        this.f20006d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f20005c, this.f20006d, tbPageContext);
        this.f20004b = myEmotionHorizontalAdater;
        this.f20008f = aVar;
        this.a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f20005c.size() || i3 < 0 || i3 >= this.f20005c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f20005c;
        list.add(i3, list.remove(i2));
        List<C1211a> list2 = this.f20006d;
        list2.add(i3, list2.remove(i2));
        this.f20004b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList(this.f20006d);
            this.f20006d.clear();
            for (EmotionPackageData emotionPackageData : this.f20005c) {
                C1211a c1211a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1211a c1211a2 = (C1211a) it.next();
                    if (c1211a2 != null && c1211a2.a == emotionPackageData.id) {
                        c1211a = c1211a2;
                        break;
                    }
                }
                if (c1211a == null) {
                    c1211a = new C1211a();
                    c1211a.a = emotionPackageData.id;
                }
                this.f20006d.add(c1211a);
            }
        }
    }

    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.a == null || this.f20004b == null) {
            return;
        }
        this.f20005c.clear();
        this.f20005c.addAll(list);
        b();
        this.f20004b.d();
        this.f20007e.update(Integer.valueOf(this.f20004b.b()));
        this.f20008f.b(0, this.f20004b.b());
        this.f20008f.a(c.a.s0.n2.h.a.b().a());
        this.f20004b.notifyDataSetChanged();
    }

    public void update() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f20004b == null || this.a == null || this.f20005c == null || (cVar = this.f20007e) == null || this.f20008f == null) {
            return;
        }
        cVar.c();
        this.f20008f.b(0, this.f20004b.b());
        this.f20008f.a(c.a.s0.n2.h.a.b().a());
        this.f20004b.notifyDataSetChanged();
    }
}
