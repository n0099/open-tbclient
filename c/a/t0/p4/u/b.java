package c.a.t0.p4.u;

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
    public List<c.a.s0.f.a> f21333e;

    /* renamed from: f  reason: collision with root package name */
    public String f21334f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f21335g;

    /* renamed from: h  reason: collision with root package name */
    public int f21336h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f21337i;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.t0.p4.u.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1331b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21338b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f21339c;

        public C1331b(b bVar) {
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

        public /* synthetic */ C1331b(b bVar, a aVar) {
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
        this.f21335g = baseFragmentActivity;
        this.f21337i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f21336h = n.k(this.f21335g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.s0.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (c.a.s0.f.a) ListUtils.getItem(this.f21333e, i2) : (c.a.s0.f.a) invokeI.objValue;
    }

    public void b(List<c.a.s0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f21333e = list;
            this.f21334f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f21333e) : invokeV.intValue;
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
        C1331b c1331b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof C1331b)) {
                c1331b = (C1331b) view.getTag();
            } else {
                view = this.f21337i.inflate(c.a.t0.p4.h.album_list_item, viewGroup, false);
                c1331b = new C1331b(this, null);
                c1331b.a = (TbImageView) view.findViewById(c.a.t0.p4.g.item_head);
                c1331b.f21338b = (TextView) view.findViewById(c.a.t0.p4.g.item_name);
                c1331b.f21339c = (ImageView) view.findViewById(c.a.t0.p4.g.item_arrow);
                c1331b.a.setGifIconSupport(false);
                c1331b.a.setLongIconSupport(false);
                view.setTag(c1331b);
            }
            c.a.s0.f.a item = getItem(i2);
            if (item == null) {
                view.setVisibility(4);
                return view;
            }
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.g())) {
                String s = n.s(c1331b.f21338b.getPaint(), item.g(), this.f21336h);
                c1331b.f21338b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                c1331b.f21338b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.f21334f)) {
                c1331b.f21339c.setImageDrawable(WebPManager.getPureDrawable(c.a.t0.p4.f.icon_pure_strok324_select, SkinManager.getColor(c.a.t0.p4.d.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                c1331b.f21339c.setVisibility(0);
            } else {
                c1331b.f21339c.setVisibility(8);
            }
            MediaFileInfo f2 = item.f();
            if (f2 instanceof VideoFileInfo) {
                c1331b.a.startLoad(((VideoFileInfo) f2).videoPath, 37, false);
            } else if (f2 instanceof ImageFileInfo) {
                c1331b.a.startLoad(((ImageFileInfo) f2).getFilePath(), 35, false);
            }
            SkinManager.setViewTextColor(c1331b.f21338b, c.a.t0.p4.d.CAM_X0105);
            SkinManager.setBackgroundResource(view, c.a.t0.p4.f.addresslist_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
