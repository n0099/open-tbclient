package c.a.r0.e2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.r0.e2.h.f.c;
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
    public BdListView f17397a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f17398b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f17399c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C0844a> f17400d;

    /* renamed from: e  reason: collision with root package name */
    public c f17401e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.e2.h.b.a f17402f;

    /* renamed from: c.a.r0.e2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0844a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f17403a;

        /* renamed from: b  reason: collision with root package name */
        public int f17404b;

        /* renamed from: c  reason: collision with root package name */
        public int f17405c;

        public C0844a() {
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
                return "id: " + this.f17403a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f17404b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f17405c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.r0.e2.h.b.a aVar) {
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
        this.f17397a = bdListView;
        c cVar = new c(tbPageContext);
        this.f17401e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f17397a.addHeaderView(this.f17401e.a());
        this.f17399c = new ArrayList();
        this.f17400d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f17399c, this.f17400d, tbPageContext);
        this.f17398b = myEmotionHorizontalAdater;
        this.f17402f = aVar;
        this.f17397a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f17399c.size() || i3 < 0 || i3 >= this.f17399c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f17399c;
        list.add(i3, list.remove(i2));
        List<C0844a> list2 = this.f17400d;
        list2.add(i3, list2.remove(i2));
        this.f17398b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17398b == null || this.f17397a == null || this.f17399c == null || (cVar = this.f17401e) == null || this.f17402f == null) {
            return;
        }
        cVar.c();
        this.f17402f.b(0, this.f17398b.b());
        this.f17402f.a(c.a.r0.e2.h.a.b().a());
        this.f17398b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f17397a == null || this.f17398b == null) {
            return;
        }
        this.f17399c.clear();
        this.f17399c.addAll(list);
        d();
        this.f17398b.d();
        this.f17401e.d(Integer.valueOf(this.f17398b.b()));
        this.f17402f.b(0, this.f17398b.b());
        this.f17402f.a(c.a.r0.e2.h.a.b().a());
        this.f17398b.notifyDataSetChanged();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList(this.f17400d);
            this.f17400d.clear();
            for (EmotionPackageData emotionPackageData : this.f17399c) {
                C0844a c0844a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0844a c0844a2 = (C0844a) it.next();
                    if (c0844a2 != null && c0844a2.f17403a == emotionPackageData.id) {
                        c0844a = c0844a2;
                        break;
                    }
                }
                if (c0844a == null) {
                    c0844a = new C0844a();
                    c0844a.f17403a = emotionPackageData.id;
                }
                this.f17400d.add(c0844a);
            }
        }
    }
}
