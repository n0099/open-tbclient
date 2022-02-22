package c.a.u0.n4.l;

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
/* loaded from: classes8.dex */
public class j extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<StickerItem> f20020e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f20021f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f20023f;

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
            this.f20023f = jVar;
            this.f20022e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f20023f.f20020e.get(this.f20022e * 2)).isSelect || this.f20023f.f20021f == null) {
                return;
            }
            this.f20023f.f20021f.onStickerChoosed((StickerItem) this.f20023f.f20020e.get(this.f20022e * 2));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f20025f;

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
            this.f20025f = jVar;
            this.f20024e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f20025f.f20020e.get((this.f20024e * 2) + 1)).isSelect || this.f20025f.f20021f == null) {
                return;
            }
            this.f20025f.f20021f.onStickerChoosed((StickerItem) this.f20025f.f20020e.get((this.f20024e * 2) + 1));
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f20026b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f20027c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f20028d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f20029e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f20030f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f20031g;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (StickerItem) ListUtils.getItem(this.f20020e, i2) : (StickerItem) invokeI.objValue;
    }

    public void d() {
        List<StickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f20020e) == null) {
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
            this.f20020e = list;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.f20021f = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f20020e)) {
                return 0;
            }
            return (int) Math.ceil(this.f20020e.size() / 2.0d);
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
                cVar.f20027c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f20028d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f20031g = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f20026b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f20029e = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f20030f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f20027c.setAutoChangeStyle(false);
            cVar.f20028d.setAutoChangeStyle(false);
            cVar.f20027c.setGifIconSupport(false);
            cVar.f20028d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f20020e, i3) instanceof StickerItem) {
                cVar.a.setVisibility(0);
                if (this.f20020e.get(i3).id == -1) {
                    cVar.f20031g.setVisibility(0);
                    cVar.f20027c.setVisibility(8);
                    cVar.f20031g.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f20031g.setVisibility(8);
                    cVar.f20027c.setVisibility(0);
                    cVar.f20027c.startLoad(this.f20020e.get(i3).img, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i2));
                if (this.f20020e.get(i3).isDownLoading) {
                    cVar.f20029e.setVisibility(0);
                } else {
                    cVar.f20029e.setVisibility(8);
                }
                if (this.f20020e.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.a, R.drawable.bg_select_sticker);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f20020e, i4) instanceof StickerItem) {
                cVar.f20026b.setVisibility(0);
                cVar.f20028d.startLoad(this.f20020e.get(i4).img, 10, true);
                cVar.f20026b.setOnClickListener(new b(this, i2));
                if (this.f20020e.get(i4).isDownLoading) {
                    cVar.f20030f.setVisibility(0);
                } else {
                    cVar.f20030f.setVisibility(8);
                }
                if (this.f20020e.get(i4).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f20026b, R.drawable.bg_select_sticker);
                } else {
                    cVar.f20026b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f20026b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
