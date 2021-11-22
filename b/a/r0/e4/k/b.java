package b.a.r0.e4.k;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.f.p.l;
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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.q0.f.a> f17501e;

    /* renamed from: f  reason: collision with root package name */
    public String f17502f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f17503g;

    /* renamed from: h  reason: collision with root package name */
    public int f17504h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f17505i;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.r0.e4.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0883b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f17506a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17507b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f17508c;

        public C0883b(b bVar) {
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

        public /* synthetic */ C0883b(b bVar, a aVar) {
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
        this.f17503g = baseFragmentActivity;
        this.f17505i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f17504h = l.k(this.f17503g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public b.a.q0.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (b.a.q0.f.a) ListUtils.getItem(this.f17501e, i2) : (b.a.q0.f.a) invokeI.objValue;
    }

    public void b(List<b.a.q0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.f17501e = list;
            this.f17502f = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f17501e) : invokeV.intValue;
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
        C0883b c0883b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof C0883b)) {
                c0883b = (C0883b) view.getTag();
            } else {
                view = this.f17505i.inflate(R.layout.album_list_item, viewGroup, false);
                c0883b = new C0883b(this, null);
                c0883b.f17506a = (TbImageView) view.findViewById(R.id.item_head);
                c0883b.f17507b = (TextView) view.findViewById(R.id.item_name);
                c0883b.f17508c = (ImageView) view.findViewById(R.id.item_arrow);
                c0883b.f17506a.setGifIconSupport(false);
                c0883b.f17506a.setLongIconSupport(false);
                view.setTag(c0883b);
            }
            b.a.q0.f.a item = getItem(i2);
            if (item == null) {
                view.setVisibility(4);
                return view;
            }
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.g())) {
                String s = l.s(c0883b.f17507b.getPaint(), item.g(), this.f17504h);
                c0883b.f17507b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                c0883b.f17507b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.f17502f)) {
                c0883b.f17508c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                c0883b.f17508c.setVisibility(0);
            } else {
                c0883b.f17508c.setVisibility(8);
            }
            MediaFileInfo f2 = item.f();
            if (f2 instanceof VideoFileInfo) {
                c0883b.f17506a.startLoad(((VideoFileInfo) f2).videoPath, 37, false);
            } else if (f2 instanceof ImageFileInfo) {
                c0883b.f17506a.startLoad(((ImageFileInfo) f2).getFilePath(), 35, false);
            }
            SkinManager.setViewTextColor(c0883b.f17507b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
