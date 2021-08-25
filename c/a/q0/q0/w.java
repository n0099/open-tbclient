package c.a.q0.q0;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class w extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.p0.f.a> f23810e;

    /* renamed from: f  reason: collision with root package name */
    public String f23811f;

    /* renamed from: g  reason: collision with root package name */
    public Context f23812g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.c0.b f23813h;

    /* renamed from: i  reason: collision with root package name */
    public int f23814i;

    /* renamed from: j  reason: collision with root package name */
    public int f23815j;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f23816e;

        public a(w wVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23816e = viewGroup;
        }

        @Override // c.a.p0.b0.b
        public void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (headImageView = (HeadImageView) this.f23816e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f23817a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f23818b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f23819c;

        public b(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(w wVar, a aVar) {
            this(wVar);
        }
    }

    public w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23812g = context;
        this.f23813h = new c.a.p0.c0.b();
        this.f23815j = (int) this.f23812g.getResources().getDimension(R.dimen.ds120);
        this.f23814i = c.a.e.e.p.l.k(this.f23812g) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.p0.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<c.a.p0.f.a> list = this.f23810e;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f23810e.get(i2);
        }
        return (c.a.p0.f.a) invokeI.objValue;
    }

    public void b(List<c.a.p0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f23810e = list;
            this.f23811f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<c.a.p0.f.a> list = this.f23810e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view != null) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f23812g).inflate(R.layout.collect_album_list_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.f23817a = (HeadImageView) view.findViewById(R.id.item_head);
                bVar.f23818b = (TextView) view.findViewById(R.id.item_name);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_arrow);
                bVar.f23819c = imageView;
                SkinManager.setImageResource(imageView, R.drawable.icon_site_ok);
                view.setTag(bVar);
            }
            bVar.f23817a.setTag(null);
            bVar.f23817a.setDefaultResource(R.drawable.pic_image_h_not);
            bVar.f23817a.startLoad(null, 12, false);
            bVar.f23817a.invalidate();
            c.a.p0.f.a item = getItem(i2);
            if (item != null) {
                if (!TextUtils.isEmpty(item.g())) {
                    item.g();
                    String s = c.a.e.e.p.l.s(bVar.f23818b.getPaint(), item.g(), this.f23814i);
                    bVar.f23818b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    bVar.f23818b.setText("");
                }
                String b2 = item.b();
                if (!TextUtils.isEmpty(b2) && b2.equals(this.f23811f)) {
                    bVar.f23819c.setVisibility(0);
                } else {
                    bVar.f23819c.setVisibility(8);
                }
                ImageFileInfo e2 = item.e();
                if (e2 != null) {
                    e2.clearPageActions();
                    int i3 = this.f23815j;
                    e2.addPageAction(c.a.p0.c0.i.d.g(i3, i3));
                    c.a.e.l.d.a c2 = this.f23813h.c(e2, false);
                    bVar.f23817a.setTag(e2.toCachedKey(false));
                    if (c2 != null) {
                        bVar.f23817a.invalidate();
                    } else {
                        this.f23813h.e(e2, new a(this, viewGroup), false, false);
                    }
                }
            } else {
                bVar.f23818b.setText("");
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
