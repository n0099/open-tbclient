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
    public BdListView f18032a;

    /* renamed from: b  reason: collision with root package name */
    public MyEmotionHorizontalAdater f18033b;

    /* renamed from: c  reason: collision with root package name */
    public List<EmotionPackageData> f18034c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C0913a> f18035d;

    /* renamed from: e  reason: collision with root package name */
    public c f18036e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.f2.h.b.a f18037f;

    /* renamed from: b.a.r0.f2.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0913a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f18038a;

        /* renamed from: b  reason: collision with root package name */
        public int f18039b;

        /* renamed from: c  reason: collision with root package name */
        public int f18040c;

        public C0913a() {
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
                return "id: " + this.f18038a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.f18039b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.f18040c;
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
        this.f18032a = bdListView;
        c cVar = new c(tbPageContext);
        this.f18036e = cVar;
        cVar.b(TbadkCoreApplication.getInst().getSkinType());
        this.f18032a.addHeaderView(this.f18036e.a());
        this.f18034c = new ArrayList();
        this.f18035d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.f18034c, this.f18035d, tbPageContext);
        this.f18033b = myEmotionHorizontalAdater;
        this.f18037f = aVar;
        this.f18032a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || i2 < 0 || i2 >= this.f18034c.size() || i3 < 0 || i3 >= this.f18034c.size()) {
            return;
        }
        List<EmotionPackageData> list = this.f18034c;
        list.add(i3, list.remove(i2));
        List<C0913a> list2 = this.f18035d;
        list2.add(i3, list2.remove(i2));
        this.f18033b.notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i2), Integer.valueOf(i3))));
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList(this.f18035d);
            this.f18035d.clear();
            for (EmotionPackageData emotionPackageData : this.f18034c) {
                C0913a c0913a = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0913a c0913a2 = (C0913a) it.next();
                    if (c0913a2 != null && c0913a2.f18038a == emotionPackageData.id) {
                        c0913a = c0913a2;
                        break;
                    }
                }
                if (c0913a == null) {
                    c0913a = new C0913a();
                    c0913a.f18038a = emotionPackageData.id;
                }
                this.f18035d.add(c0913a);
            }
        }
    }

    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || this.f18032a == null || this.f18033b == null) {
            return;
        }
        this.f18034c.clear();
        this.f18034c.addAll(list);
        b();
        this.f18033b.d();
        this.f18036e.update(Integer.valueOf(this.f18033b.b()));
        this.f18037f.b(0, this.f18033b.b());
        this.f18037f.a(b.a.r0.f2.h.a.b().a());
        this.f18033b.notifyDataSetChanged();
    }

    public void update() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f18033b == null || this.f18032a == null || this.f18034c == null || (cVar = this.f18036e) == null || this.f18037f == null) {
            return;
        }
        cVar.c();
        this.f18037f.b(0, this.f18033b.b());
        this.f18037f.a(b.a.r0.f2.h.a.b().a());
        this.f18033b.notifyDataSetChanged();
    }
}
