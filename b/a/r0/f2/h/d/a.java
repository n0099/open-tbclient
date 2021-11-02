package b.a.r0.f2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import b.a.r0.f2.h.f.c;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f16532a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f16533b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f16534c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C0848a> f16535d;

    /* renamed from: e  reason: collision with root package name */
    public c f16536e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.f2.h.b.a f16537f;

    /* renamed from: b.a.r0.f2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0848a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16538a;

        /* renamed from: b  reason: collision with root package name */
        public int f16539b;

        /* renamed from: c  reason: collision with root package name */
        public int f16540c;

        public C0848a() {
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
                return "id: " + this.f16538a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f16539b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f16540c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, b.a.r0.f2.h.b.a aVar) {
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
        this.f16532a = bdListView;
        c cVar = new c(tbPageContext);
        this.f16536e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f16532a.addHeaderView(this.f16536e.a());
        this.f16534c = new ArrayList();
        this.f16535d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f16534c, this.f16535d, tbPageContext);
        this.f16533b = myEmotionHorizontalAdater;
        this.f16537f = aVar;
        this.f16532a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f16534c.size() || i3 < 0 || i3 >= this.f16534c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f16534c;
        list.add(i3, list.remove(i2));
        List<C0848a> list2 = this.f16535d;
        list2.add(i3, list2.remove(i2));
        this.f16533b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList(this.f16535d);
            this.f16535d.clear();
            for (EmotionPackageData emotionPackageData : this.f16534c) {
                C0848a c0848a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0848a c0848a2 = (C0848a) it.next();
                    if (c0848a2 != null && c0848a2.f16538a == emotionPackageData.id) {
                        c0848a = c0848a2;
                        break;
                    }
                }
                if (c0848a == null) {
                    c0848a = new C0848a();
                    c0848a.f16538a = emotionPackageData.id;
                }
                this.f16535d.add(c0848a);
            }
        }
    }

    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.f16532a == null || this.f16533b == null) {
            return;
        }
        this.f16534c.clear();
        this.f16534c.addAll(list);
        b();
        this.f16533b.d();
        this.f16536e.update(Integer.valueOf(this.f16533b.b()));
        this.f16537f.b(0, this.f16533b.b());
        this.f16537f.a(b.a.r0.f2.h.a.b().a());
        this.f16533b.notifyDataSetChanged();
    }

    public void update() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f16533b == null || this.f16532a == null || this.f16534c == null || (cVar = this.f16536e) == null || this.f16537f == null) {
            return;
        }
        cVar.c();
        this.f16537f.b(0, this.f16533b.b());
        this.f16537f.a(b.a.r0.f2.h.a.b().a());
        this.f16533b.notifyDataSetChanged();
    }
}
