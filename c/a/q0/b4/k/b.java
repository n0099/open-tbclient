package c.a.q0.b4.k;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.p0.f.a> f16194e;

    /* renamed from: f  reason: collision with root package name */
    public String f16195f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f16196g;

    /* renamed from: h  reason: collision with root package name */
    public int f16197h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f16198i;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.q0.b4.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0772b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f16199a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16200b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16201c;

        public C0772b(b bVar) {
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

        public /* synthetic */ C0772b(b bVar, a aVar) {
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
        this.f16196g = baseFragmentActivity;
        this.f16198i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f16197h = l.k(this.f16196g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.p0.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (c.a.p0.f.a) ListUtils.getItem(this.f16194e, i2) : (c.a.p0.f.a) invokeI.objValue;
    }

    public void b(List<c.a.p0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f16194e = list;
            this.f16195f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f16194e) : invokeV.intValue;
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
        C0772b c0772b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof C0772b)) {
                c0772b = (C0772b) view.getTag();
            } else {
                view = this.f16198i.inflate(R.layout.album_list_item, viewGroup, false);
                c0772b = new C0772b(this, null);
                c0772b.f16199a = (TbImageView) view.findViewById(R.id.item_head);
                c0772b.f16200b = (TextView) view.findViewById(R.id.item_name);
                c0772b.f16201c = (ImageView) view.findViewById(R.id.item_arrow);
                c0772b.f16199a.setGifIconSupport(false);
                c0772b.f16199a.setLongIconSupport(false);
                view.setTag(c0772b);
            }
            c.a.p0.f.a item = getItem(i2);
            if (item == null) {
                view.setVisibility(4);
                return view;
            }
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.g())) {
                String s = l.s(c0772b.f16200b.getPaint(), item.g(), this.f16197h);
                c0772b.f16200b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                c0772b.f16200b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.f16195f)) {
                c0772b.f16201c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                c0772b.f16201c.setVisibility(0);
            } else {
                c0772b.f16201c.setVisibility(8);
            }
            MediaFileInfo f2 = item.f();
            if (f2 instanceof VideoFileInfo) {
                c0772b.f16199a.startLoad(((VideoFileInfo) f2).videoPath, 37, false);
            } else if (f2 instanceof ImageFileInfo) {
                c0772b.f16199a.startLoad(((ImageFileInfo) f2).getFilePath(), 35, false);
            }
            SkinManager.setViewTextColor(c0772b.f16200b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
