package c.a.s0.j4.l;

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
    public List<StickerItem> f18804e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f18805f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18806e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f18807f;

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
            this.f18807f = jVar;
            this.f18806e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f18807f.f18804e.get(this.f18806e * 2)).isSelect || this.f18807f.f18805f == null) {
                return;
            }
            this.f18807f.f18805f.onStickerChoosed((StickerItem) this.f18807f.f18804e.get(this.f18806e * 2));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f18809f;

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
            this.f18809f = jVar;
            this.f18808e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f18809f.f18804e.get((this.f18808e * 2) + 1)).isSelect || this.f18809f.f18805f == null) {
                return;
            }
            this.f18809f.f18805f.onStickerChoosed((StickerItem) this.f18809f.f18804e.get((this.f18808e * 2) + 1));
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f18810b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f18811c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f18812d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f18813e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f18814f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f18815g;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (StickerItem) ListUtils.getItem(this.f18804e, i2) : (StickerItem) invokeI.objValue;
    }

    public void d() {
        List<StickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f18804e) == null) {
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
            this.f18804e = list;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.f18805f = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f18804e)) {
                return 0;
            }
            return (int) Math.ceil(this.f18804e.size() / 2.0d);
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
                cVar.f18811c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f18812d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f18815g = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f18810b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f18813e = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f18814f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f18811c.setAutoChangeStyle(false);
            cVar.f18812d.setAutoChangeStyle(false);
            cVar.f18811c.setGifIconSupport(false);
            cVar.f18812d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f18804e, i3) instanceof StickerItem) {
                cVar.a.setVisibility(0);
                if (this.f18804e.get(i3).id == -1) {
                    cVar.f18815g.setVisibility(0);
                    cVar.f18811c.setVisibility(8);
                    cVar.f18815g.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f18815g.setVisibility(8);
                    cVar.f18811c.setVisibility(0);
                    cVar.f18811c.startLoad(this.f18804e.get(i3).img, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i2));
                if (this.f18804e.get(i3).isDownLoading) {
                    cVar.f18813e.setVisibility(0);
                } else {
                    cVar.f18813e.setVisibility(8);
                }
                if (this.f18804e.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.a, R.drawable.bg_select_sticker);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f18804e, i4) instanceof StickerItem) {
                cVar.f18810b.setVisibility(0);
                cVar.f18812d.startLoad(this.f18804e.get(i4).img, 10, true);
                cVar.f18810b.setOnClickListener(new b(this, i2));
                if (this.f18804e.get(i4).isDownLoading) {
                    cVar.f18814f.setVisibility(0);
                } else {
                    cVar.f18814f.setVisibility(8);
                }
                if (this.f18804e.get(i4).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f18810b, R.drawable.bg_select_sticker);
                } else {
                    cVar.f18810b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f18810b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
