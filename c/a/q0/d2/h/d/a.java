package c.a.q0.d2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.q0.d2.h.f.c;
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
    public BdListView f16832a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f16833b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f16834c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C0813a> f16835d;

    /* renamed from: e  reason: collision with root package name */
    public c f16836e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.d2.h.b.a f16837f;

    /* renamed from: c.a.q0.d2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0813a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16838a;

        /* renamed from: b  reason: collision with root package name */
        public int f16839b;

        /* renamed from: c  reason: collision with root package name */
        public int f16840c;

        public C0813a() {
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
                return "id: " + this.f16838a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f16839b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f16840c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.q0.d2.h.b.a aVar) {
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
        this.f16832a = bdListView;
        c cVar = new c(tbPageContext);
        this.f16836e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f16832a.addHeaderView(this.f16836e.a());
        this.f16834c = new ArrayList();
        this.f16835d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f16834c, this.f16835d, tbPageContext);
        this.f16833b = myEmotionHorizontalAdater;
        this.f16837f = aVar;
        this.f16832a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f16834c.size() || i3 < 0 || i3 >= this.f16834c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f16834c;
        list.add(i3, list.remove(i2));
        List<C0813a> list2 = this.f16835d;
        list2.add(i3, list2.remove(i2));
        this.f16833b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16833b == null || this.f16832a == null || this.f16834c == null || (cVar = this.f16836e) == null || this.f16837f == null) {
            return;
        }
        cVar.c();
        this.f16837f.b(0, this.f16833b.b());
        this.f16837f.a(c.a.q0.d2.h.a.b().a());
        this.f16833b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f16832a == null || this.f16833b == null) {
            return;
        }
        this.f16834c.clear();
        this.f16834c.addAll(list);
        d();
        this.f16833b.d();
        this.f16836e.d(Integer.valueOf(this.f16833b.b()));
        this.f16837f.b(0, this.f16833b.b());
        this.f16837f.a(c.a.q0.d2.h.a.b().a());
        this.f16833b.notifyDataSetChanged();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList(this.f16835d);
            this.f16835d.clear();
            for (EmotionPackageData emotionPackageData : this.f16834c) {
                C0813a c0813a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0813a c0813a2 = (C0813a) it.next();
                    if (c0813a2 != null && c0813a2.f16838a == emotionPackageData.id) {
                        c0813a = c0813a2;
                        break;
                    }
                }
                if (c0813a == null) {
                    c0813a = new C0813a();
                    c0813a.f16838a = emotionPackageData.id;
                }
                this.f16835d.add(c0813a);
            }
        }
    }
}
