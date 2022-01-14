package c.a.t0.n2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.t0.n2.h.f.c;
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
    public MyEmotionHorizontalAdater f19706b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f19707c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1233a> f19708d;

    /* renamed from: e  reason: collision with root package name */
    public c f19709e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.n2.h.b.a f19710f;

    /* renamed from: c.a.t0.n2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1233a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f19711b;

        /* renamed from: c  reason: collision with root package name */
        public int f19712c;

        public C1233a() {
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
                return "id: " + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f19711b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f19712c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.t0.n2.h.b.a aVar) {
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
        this.f19709e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.a.addHeaderView(this.f19709e.a());
        this.f19707c = new ArrayList();
        this.f19708d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f19707c, this.f19708d, tbPageContext);
        this.f19706b = myEmotionHorizontalAdater;
        this.f19710f = aVar;
        this.a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f19707c.size() || i3 < 0 || i3 >= this.f19707c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f19707c;
        list.add(i3, list.remove(i2));
        List<C1233a> list2 = this.f19708d;
        list2.add(i3, list2.remove(i2));
        this.f19706b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList(this.f19708d);
            this.f19708d.clear();
            for (EmotionPackageData emotionPackageData : this.f19707c) {
                C1233a c1233a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1233a c1233a2 = (C1233a) it.next();
                    if (c1233a2 != null && c1233a2.a == emotionPackageData.id) {
                        c1233a = c1233a2;
                        break;
                    }
                }
                if (c1233a == null) {
                    c1233a = new C1233a();
                    c1233a.a = emotionPackageData.id;
                }
                this.f19708d.add(c1233a);
            }
        }
    }

    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.a == null || this.f19706b == null) {
            return;
        }
        this.f19707c.clear();
        this.f19707c.addAll(list);
        b();
        this.f19706b.d();
        this.f19709e.update(Integer.valueOf(this.f19706b.b()));
        this.f19710f.b(0, this.f19706b.b());
        this.f19710f.a(c.a.t0.n2.h.a.b().a());
        this.f19706b.notifyDataSetChanged();
    }

    public void update() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f19706b == null || this.a == null || this.f19707c == null || (cVar = this.f19709e) == null || this.f19710f == null) {
            return;
        }
        cVar.c();
        this.f19710f.b(0, this.f19706b.b());
        this.f19710f.a(c.a.t0.n2.h.a.b().a());
        this.f19706b.notifyDataSetChanged();
    }
}
