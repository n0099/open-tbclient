package c.a.p0.d2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.p0.d2.h.f.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f16545a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f16546b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f16547c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C0803a> f16548d;

    /* renamed from: e  reason: collision with root package name */
    public c f16549e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.d2.h.b.a f16550f;

    /* renamed from: c.a.p0.d2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0803a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16551a;

        /* renamed from: b  reason: collision with root package name */
        public int f16552b;

        /* renamed from: c  reason: collision with root package name */
        public int f16553c;

        public C0803a() {
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
                return "id: " + this.f16551a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f16552b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f16553c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.p0.d2.h.b.a aVar) {
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
        this.f16545a = bdListView;
        c cVar = new c(tbPageContext);
        this.f16549e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f16545a.addHeaderView(this.f16549e.a());
        this.f16547c = new ArrayList();
        this.f16548d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f16547c, this.f16548d, tbPageContext);
        this.f16546b = myEmotionHorizontalAdater;
        this.f16550f = aVar;
        this.f16545a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f16547c.size() || i3 < 0 || i3 >= this.f16547c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f16547c;
        list.add(i3, list.remove(i2));
        List<C0803a> list2 = this.f16548d;
        list2.add(i3, list2.remove(i2));
        this.f16546b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16546b == null || this.f16545a == null || this.f16547c == null || (cVar = this.f16549e) == null || this.f16550f == null) {
            return;
        }
        cVar.c();
        this.f16550f.b(0, this.f16546b.b());
        this.f16550f.a(c.a.p0.d2.h.a.b().a());
        this.f16546b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f16545a == null || this.f16546b == null) {
            return;
        }
        this.f16547c.clear();
        this.f16547c.addAll(list);
        d();
        this.f16546b.d();
        this.f16549e.d(Integer.valueOf(this.f16546b.b()));
        this.f16550f.b(0, this.f16546b.b());
        this.f16550f.a(c.a.p0.d2.h.a.b().a());
        this.f16546b.notifyDataSetChanged();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList(this.f16548d);
            this.f16548d.clear();
            for (EmotionPackageData emotionPackageData : this.f16547c) {
                C0803a c0803a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0803a c0803a2 = (C0803a) it.next();
                    if (c0803a2 != null && c0803a2.f16551a == emotionPackageData.id) {
                        c0803a = c0803a2;
                        break;
                    }
                }
                if (c0803a == null) {
                    c0803a = new C0803a();
                    c0803a.f16551a = emotionPackageData.id;
                }
                this.f16548d.add(c0803a);
            }
        }
    }
}
