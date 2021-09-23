package c.a.r0.x3.l;

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
/* loaded from: classes4.dex */
public class j extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<StickerItem> f29195e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f29196f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f29197e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f29198f;

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
            this.f29198f = jVar;
            this.f29197e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f29198f.f29195e.get(this.f29197e * 2)).isSelect || this.f29198f.f29196f == null) {
                return;
            }
            this.f29198f.f29196f.onStickerChoosed((StickerItem) this.f29198f.f29195e.get(this.f29197e * 2));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f29199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f29200f;

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
            this.f29200f = jVar;
            this.f29199e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f29200f.f29195e.get((this.f29199e * 2) + 1)).isSelect || this.f29200f.f29196f == null) {
                return;
            }
            this.f29200f.f29196f.onStickerChoosed((StickerItem) this.f29200f.f29195e.get((this.f29199e * 2) + 1));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f29201a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f29202b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f29203c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f29204d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f29205e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f29206f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f29207g;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (StickerItem) ListUtils.getItem(this.f29195e, i2) : (StickerItem) invokeI.objValue;
    }

    public void d() {
        List<StickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f29195e) == null) {
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
            this.f29195e = list;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.f29196f = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f29195e)) {
                return 0;
            }
            return (int) Math.ceil(this.f29195e.size() / 2.0d);
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
                cVar.f29203c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f29204d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f29201a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f29207g = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f29202b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f29205e = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f29206f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f29203c.setAutoChangeStyle(false);
            cVar.f29204d.setAutoChangeStyle(false);
            cVar.f29203c.setGifIconSupport(false);
            cVar.f29204d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f29195e, i3) instanceof StickerItem) {
                cVar.f29201a.setVisibility(0);
                if (this.f29195e.get(i3).id == -1) {
                    cVar.f29207g.setVisibility(0);
                    cVar.f29203c.setVisibility(8);
                    cVar.f29207g.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f29207g.setVisibility(8);
                    cVar.f29203c.setVisibility(0);
                    cVar.f29203c.startLoad(this.f29195e.get(i3).img, 10, true);
                }
                cVar.f29201a.setOnClickListener(new a(this, i2));
                if (this.f29195e.get(i3).isDownLoading) {
                    cVar.f29205e.setVisibility(0);
                } else {
                    cVar.f29205e.setVisibility(8);
                }
                if (this.f29195e.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f29201a, R.drawable.bg_select_sticker);
                } else {
                    cVar.f29201a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f29201a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f29195e, i4) instanceof StickerItem) {
                cVar.f29202b.setVisibility(0);
                cVar.f29204d.startLoad(this.f29195e.get(i4).img, 10, true);
                cVar.f29202b.setOnClickListener(new b(this, i2));
                if (this.f29195e.get(i4).isDownLoading) {
                    cVar.f29206f.setVisibility(0);
                } else {
                    cVar.f29206f.setVisibility(8);
                }
                if (this.f29195e.get(i4).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f29202b, R.drawable.bg_select_sticker);
                } else {
                    cVar.f29202b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f29202b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
