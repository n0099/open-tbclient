package c.a.s0.n4.u;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.r0.f.a> f20466e;

    /* renamed from: f  reason: collision with root package name */
    public String f20467f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f20468g;

    /* renamed from: h  reason: collision with root package name */
    public int f20469h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f20470i;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.s0.n4.u.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1237b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20471b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f20472c;

        public C1237b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1237b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20468g = baseFragmentActivity;
        this.f20470i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f20469h = m.k(this.f20468g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.r0.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (c.a.r0.f.a) ListUtils.getItem(this.f20466e, i2) : (c.a.r0.f.a) invokeI.objValue;
    }

    public void b(List<c.a.r0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f20466e = list;
            this.f20467f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f20466e) : invokeV.intValue;
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
        C1237b c1237b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof C1237b)) {
                c1237b = (C1237b) view.getTag();
            } else {
                view = this.f20470i.inflate(c.a.s0.n4.h.album_list_item, viewGroup, false);
                c1237b = new C1237b(this, null);
                c1237b.a = (TbImageView) view.findViewById(c.a.s0.n4.g.item_head);
                c1237b.f20471b = (TextView) view.findViewById(c.a.s0.n4.g.item_name);
                c1237b.f20472c = (ImageView) view.findViewById(c.a.s0.n4.g.item_arrow);
                c1237b.a.setGifIconSupport(false);
                c1237b.a.setLongIconSupport(false);
                view.setTag(c1237b);
            }
            c.a.r0.f.a item = getItem(i2);
            if (item == null) {
                view.setVisibility(4);
                return view;
            }
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.g())) {
                String s = m.s(c1237b.f20471b.getPaint(), item.g(), this.f20469h);
                c1237b.f20471b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                c1237b.f20471b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.f20467f)) {
                c1237b.f20472c.setImageDrawable(WebPManager.getPureDrawable(c.a.s0.n4.f.icon_pure_strok324_select, SkinManager.getColor(c.a.s0.n4.d.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                c1237b.f20472c.setVisibility(0);
            } else {
                c1237b.f20472c.setVisibility(8);
            }
            MediaFileInfo f2 = item.f();
            if (f2 instanceof VideoFileInfo) {
                c1237b.a.startLoad(((VideoFileInfo) f2).videoPath, 37, false);
            } else if (f2 instanceof ImageFileInfo) {
                c1237b.a.startLoad(((ImageFileInfo) f2).getFilePath(), 35, false);
            }
            SkinManager.setViewTextColor(c1237b.f20471b, c.a.s0.n4.d.CAM_X0105);
            SkinManager.setBackgroundResource(view, c.a.s0.n4.f.addresslist_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
