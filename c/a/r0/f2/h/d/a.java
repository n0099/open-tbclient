package c.a.r0.f2.h.d;

import android.util.Pair;
import android.widget.ListAdapter;
import c.a.r0.f2.h.f.c;
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
    public BdListView f17563a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f17564b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f17565c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C0853a> f17566d;

    /* renamed from: e  reason: collision with root package name */
    public c f17567e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.f2.h.b.a f17568f;

    /* renamed from: c.a.r0.f2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0853a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f17569a;

        /* renamed from: b  reason: collision with root package name */
        public int f17570b;

        /* renamed from: c  reason: collision with root package name */
        public int f17571c;

        public C0853a() {
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
                return "id: " + this.f17569a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f17570b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f17571c;
            }
            return (String) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext, BdListView bdListView, c.a.r0.f2.h.b.a aVar) {
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
        this.f17563a = bdListView;
        c cVar = new c(tbPageContext);
        this.f17567e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f17563a.addHeaderView(this.f17567e.a());
        this.f17565c = new ArrayList();
        this.f17566d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f17565c, this.f17566d, tbPageContext);
        this.f17564b = myEmotionHorizontalAdater;
        this.f17568f = aVar;
        this.f17563a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f17565c.size() || i3 < 0 || i3 >= this.f17565c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f17565c;
        list.add(i3, list.remove(i2));
        List<C0853a> list2 = this.f17566d;
        list2.add(i3, list2.remove(i2));
        this.f17564b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public void b() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17564b == null || this.f17563a == null || this.f17565c == null || (cVar = this.f17567e) == null || this.f17568f == null) {
            return;
        }
        cVar.c();
        this.f17568f.b(0, this.f17564b.b());
        this.f17568f.a(c.a.r0.f2.h.a.b().a());
        this.f17564b.notifyDataSetChanged();
    }

    public void c(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f17563a == null || this.f17564b == null) {
            return;
        }
        this.f17565c.clear();
        this.f17565c.addAll(list);
        d();
        this.f17564b.d();
        this.f17567e.d(Integer.valueOf(this.f17564b.b()));
        this.f17568f.b(0, this.f17564b.b());
        this.f17568f.a(c.a.r0.f2.h.a.b().a());
        this.f17564b.notifyDataSetChanged();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList(this.f17566d);
            this.f17566d.clear();
            for (EmotionPackageData emotionPackageData : this.f17565c) {
                C0853a c0853a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0853a c0853a2 = (C0853a) it.next();
                    if (c0853a2 != null && c0853a2.f17569a == emotionPackageData.id) {
                        c0853a = c0853a2;
                        break;
                    }
                }
                if (c0853a == null) {
                    c0853a = new C0853a();
                    c0853a.f17569a = emotionPackageData.id;
                }
                this.f17566d.add(c0853a);
            }
        }
    }
}
