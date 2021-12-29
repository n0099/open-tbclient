package c.a.t0.o4.u;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.s0.f.a> f21837e;

    /* renamed from: f  reason: collision with root package name */
    public String f21838f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f21839g;

    /* renamed from: h  reason: collision with root package name */
    public int f21840h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f21841i;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.t0.o4.u.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1314b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21842b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f21843c;

        public C1314b(b bVar) {
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

        public /* synthetic */ C1314b(b bVar, a aVar) {
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
        this.f21839g = baseFragmentActivity;
        this.f21841i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f21840h = n.k(this.f21839g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.s0.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (c.a.s0.f.a) ListUtils.getItem(this.f21837e, i2) : (c.a.s0.f.a) invokeI.objValue;
    }

    public void b(List<c.a.s0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f21837e = list;
            this.f21838f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f21837e) : invokeV.intValue;
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
        C1314b c1314b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof C1314b)) {
                c1314b = (C1314b) view.getTag();
            } else {
                view = this.f21841i.inflate(c.a.t0.o4.h.album_list_item, viewGroup, false);
                c1314b = new C1314b(this, null);
                c1314b.a = (TbImageView) view.findViewById(c.a.t0.o4.g.item_head);
                c1314b.f21842b = (TextView) view.findViewById(c.a.t0.o4.g.item_name);
                c1314b.f21843c = (ImageView) view.findViewById(c.a.t0.o4.g.item_arrow);
                c1314b.a.setGifIconSupport(false);
                c1314b.a.setLongIconSupport(false);
                view.setTag(c1314b);
            }
            c.a.s0.f.a item = getItem(i2);
            if (item == null) {
                view.setVisibility(4);
                return view;
            }
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.g())) {
                String s = n.s(c1314b.f21842b.getPaint(), item.g(), this.f21840h);
                c1314b.f21842b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                c1314b.f21842b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.f21838f)) {
                c1314b.f21843c.setImageDrawable(WebPManager.getPureDrawable(c.a.t0.o4.f.icon_pure_strok324_select, SkinManager.getColor(c.a.t0.o4.d.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                c1314b.f21843c.setVisibility(0);
            } else {
                c1314b.f21843c.setVisibility(8);
            }
            MediaFileInfo f2 = item.f();
            if (f2 instanceof VideoFileInfo) {
                c1314b.a.startLoad(((VideoFileInfo) f2).videoPath, 37, false);
            } else if (f2 instanceof ImageFileInfo) {
                c1314b.a.startLoad(((ImageFileInfo) f2).getFilePath(), 35, false);
            }
            SkinManager.setViewTextColor(c1314b.f21842b, c.a.t0.o4.d.CAM_X0105);
            SkinManager.setBackgroundResource(view, c.a.t0.o4.f.addresslist_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
