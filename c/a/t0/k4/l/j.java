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
    public List<StickerItem> f19268e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f19269f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19270e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f19271f;

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
            this.f19271f = jVar;
            this.f19270e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f19271f.f19268e.get(this.f19270e * 2)).isSelect || this.f19271f.f19269f == null) {
                return;
            }
            this.f19271f.f19269f.onStickerChoosed((StickerItem) this.f19271f.f19268e.get(this.f19270e * 2));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19272e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f19273f;

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
            this.f19273f = jVar;
            this.f19272e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f19273f.f19268e.get((this.f19272e * 2) + 1)).isSelect || this.f19273f.f19269f == null) {
                return;
            }
            this.f19273f.f19269f.onStickerChoosed((StickerItem) this.f19273f.f19268e.get((this.f19272e * 2) + 1));
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f19274b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f19275c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f19276d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f19277e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f19278f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f19279g;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (StickerItem) ListUtils.getItem(this.f19268e, i2) : (StickerItem) invokeI.objValue;
    }

    public void d() {
        List<StickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f19268e) == null) {
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
            this.f19268e = list;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.f19269f = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f19268e)) {
                return 0;
            }
            return (int) Math.ceil(this.f19268e.size() / 2.0d);
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
                cVar.f19275c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f19276d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f19279g = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f19274b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f19277e = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f19278f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f19275c.setAutoChangeStyle(false);
            cVar.f19276d.setAutoChangeStyle(false);
            cVar.f19275c.setGifIconSupport(false);
            cVar.f19276d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f19268e, i3) instanceof StickerItem) {
                cVar.a.setVisibility(0);
                if (this.f19268e.get(i3).id == -1) {
                    cVar.f19279g.setVisibility(0);
                    cVar.f19275c.setVisibility(8);
                    cVar.f19279g.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f19279g.setVisibility(8);
                    cVar.f19275c.setVisibility(0);
                    cVar.f19275c.startLoad(this.f19268e.get(i3).img, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i2));
                if (this.f19268e.get(i3).isDownLoading) {
                    cVar.f19277e.setVisibility(0);
                } else {
                    cVar.f19277e.setVisibility(8);
                }
                if (this.f19268e.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.a, R.drawable.bg_select_sticker);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f19268e, i4) instanceof StickerItem) {
                cVar.f19274b.setVisibility(0);
                cVar.f19276d.startLoad(this.f19268e.get(i4).img, 10, true);
                cVar.f19274b.setOnClickListener(new b(this, i2));
                if (this.f19268e.get(i4).isDownLoading) {
                    cVar.f19278f.setVisibility(0);
                } else {
                    cVar.f19278f.setVisibility(8);
                }
                if (this.f19268e.get(i4).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f19274b, R.drawable.bg_select_sticker);
                } else {
                    cVar.f19274b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f19274b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
