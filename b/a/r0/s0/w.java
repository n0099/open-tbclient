package b.a.r0.s0;

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
/* loaded from: classes5.dex */
public class w extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.q0.f.a> f24760e;

    /* renamed from: f  reason: collision with root package name */
    public String f24761f;

    /* renamed from: g  reason: collision with root package name */
    public Context f24762g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.d0.b f24763h;

    /* renamed from: i  reason: collision with root package name */
    public int f24764i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements b.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f24765e;

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
            this.f24765e = viewGroup;
        }

        @Override // b.a.q0.c0.b
        public void imageLoaded(b.a.e.m.d.a aVar, String str, boolean z) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (headImageView = (HeadImageView) this.f24765e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f24766a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24767b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f24768c;

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
        this.f24762g = context;
        this.f24763h = new b.a.q0.d0.b();
        this.j = (int) this.f24762g.getResources().getDimension(R.dimen.ds120);
        this.f24764i = b.a.e.f.p.l.k(this.f24762g) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public b.a.q0.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<b.a.q0.f.a> list = this.f24760e;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f24760e.get(i2);
        }
        return (b.a.q0.f.a) invokeI.objValue;
    }

    public void b(List<b.a.q0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f24760e = list;
            this.f24761f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<b.a.q0.f.a> list = this.f24760e;
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
                view = LayoutInflater.from(this.f24762g).inflate(R.layout.collect_album_list_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.f24766a = (HeadImageView) view.findViewById(R.id.item_head);
                bVar.f24767b = (TextView) view.findViewById(R.id.item_name);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_arrow);
                bVar.f24768c = imageView;
                SkinManager.setImageResource(imageView, R.drawable.icon_site_ok);
                view.setTag(bVar);
            }
            bVar.f24766a.setTag(null);
            bVar.f24766a.setDefaultResource(R.drawable.pic_image_h_not);
            bVar.f24766a.startLoad(null, 12, false);
            bVar.f24766a.invalidate();
            b.a.q0.f.a item = getItem(i2);
            if (item != null) {
                if (!TextUtils.isEmpty(item.g())) {
                    item.g();
                    String s = b.a.e.f.p.l.s(bVar.f24767b.getPaint(), item.g(), this.f24764i);
                    bVar.f24767b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    bVar.f24767b.setText("");
                }
                String b2 = item.b();
                if (!TextUtils.isEmpty(b2) && b2.equals(this.f24761f)) {
                    bVar.f24768c.setVisibility(0);
                } else {
                    bVar.f24768c.setVisibility(8);
                }
                ImageFileInfo e2 = item.e();
                if (e2 != null) {
                    e2.clearPageActions();
                    int i3 = this.j;
                    e2.addPageAction(b.a.q0.d0.i.d.g(i3, i3));
                    b.a.e.m.d.a c2 = this.f24763h.c(e2, false);
                    bVar.f24766a.setTag(e2.toCachedKey(false));
                    if (c2 != null) {
                        bVar.f24766a.invalidate();
                    } else {
                        this.f24763h.e(e2, new a(this, viewGroup), false, false);
                    }
                }
            } else {
                bVar.f24767b.setText("");
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
