package c.a.t0.k4.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class j extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<StickerItem> f19035e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f19036f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19037e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f19038f;

        public a(j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19038f = jVar;
            this.f19037e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f19038f.f19035e.get(this.f19037e * 2)).isSelect || this.f19038f.f19036f == null) {
                return;
            }
            this.f19038f.f19036f.onStickerChoosed((StickerItem) this.f19038f.f19035e.get(this.f19037e * 2));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19039e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f19040f;

        public b(j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19040f = jVar;
            this.f19039e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f19040f.f19035e.get((this.f19039e * 2) + 1)).isSelect || this.f19040f.f19036f == null) {
                return;
            }
            this.f19040f.f19036f.onStickerChoosed((StickerItem) this.f19040f.f19035e.get((this.f19039e * 2) + 1));
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f19041b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f19042c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f19043d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f19044e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f19045f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f19046g;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public j() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public StickerItem getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (StickerItem) ListUtils.getItem(this.f19035e, i2) : (StickerItem) invokeI.objValue;
    }

    public void d() {
        List<StickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f19035e) == null) {
            return;
        }
        for (StickerItem stickerItem : list) {
            if (stickerItem.id == -1) {
                stickerItem.isSelect = true;
            } else {
                stickerItem.isSelect = false;
                stickerItem.isDownLoading = false;
            }
        }
    }

    public void e(List<StickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f19035e = list;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.f19036f = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f19035e)) {
                return 0;
            }
            return (int) Math.ceil(this.f19035e.size() / 2.0d);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_sticker, (ViewGroup) null);
                cVar = new c(this);
                cVar.f19042c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f19043d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f19046g = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f19041b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f19044e = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f19045f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f19042c.setAutoChangeStyle(false);
            cVar.f19043d.setAutoChangeStyle(false);
            cVar.f19042c.setGifIconSupport(false);
            cVar.f19043d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f19035e, i3) instanceof StickerItem) {
                cVar.a.setVisibility(0);
                if (this.f19035e.get(i3).id == -1) {
                    cVar.f19046g.setVisibility(0);
                    cVar.f19042c.setVisibility(8);
                    cVar.f19046g.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f19046g.setVisibility(8);
                    cVar.f19042c.setVisibility(0);
                    cVar.f19042c.startLoad(this.f19035e.get(i3).img, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i2));
                if (this.f19035e.get(i3).isDownLoading) {
                    cVar.f19044e.setVisibility(0);
                } else {
                    cVar.f19044e.setVisibility(8);
                }
                if (this.f19035e.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.a, R.drawable.bg_select_sticker);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f19035e, i4) instanceof StickerItem) {
                cVar.f19041b.setVisibility(0);
                cVar.f19043d.startLoad(this.f19035e.get(i4).img, 10, true);
                cVar.f19041b.setOnClickListener(new b(this, i2));
                if (this.f19035e.get(i4).isDownLoading) {
                    cVar.f19045f.setVisibility(0);
                } else {
                    cVar.f19045f.setVisibility(8);
                }
                if (this.f19035e.get(i4).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f19041b, R.drawable.bg_select_sticker);
                } else {
                    cVar.f19041b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f19041b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
