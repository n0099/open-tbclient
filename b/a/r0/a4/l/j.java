package b.a.r0.a4.l;

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
    public List<StickerItem> f16202e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f16203f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f16205f;

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
            this.f16205f = jVar;
            this.f16204e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f16205f.f16202e.get(this.f16204e * 2)).isSelect || this.f16205f.f16203f == null) {
                return;
            }
            this.f16205f.f16203f.onStickerChoosed((StickerItem) this.f16205f.f16202e.get(this.f16204e * 2));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16206e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ j f16207f;

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
            this.f16207f = jVar;
            this.f16206e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f16207f.f16202e.get((this.f16206e * 2) + 1)).isSelect || this.f16207f.f16203f == null) {
                return;
            }
            this.f16207f.f16203f.onStickerChoosed((StickerItem) this.f16207f.f16202e.get((this.f16206e * 2) + 1));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f16208a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f16209b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f16210c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f16211d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f16212e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f16213f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f16214g;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (StickerItem) ListUtils.getItem(this.f16202e, i2) : (StickerItem) invokeI.objValue;
    }

    public void d() {
        List<StickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f16202e) == null) {
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
            this.f16202e = list;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.f16203f = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f16202e)) {
                return 0;
            }
            return (int) Math.ceil(this.f16202e.size() / 2.0d);
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
                cVar.f16210c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f16211d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f16208a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f16214g = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f16209b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f16212e = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f16213f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f16210c.setAutoChangeStyle(false);
            cVar.f16211d.setAutoChangeStyle(false);
            cVar.f16210c.setGifIconSupport(false);
            cVar.f16211d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f16202e, i3) instanceof StickerItem) {
                cVar.f16208a.setVisibility(0);
                if (this.f16202e.get(i3).id == -1) {
                    cVar.f16214g.setVisibility(0);
                    cVar.f16210c.setVisibility(8);
                    cVar.f16214g.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f16214g.setVisibility(8);
                    cVar.f16210c.setVisibility(0);
                    cVar.f16210c.startLoad(this.f16202e.get(i3).img, 10, true);
                }
                cVar.f16208a.setOnClickListener(new a(this, i2));
                if (this.f16202e.get(i3).isDownLoading) {
                    cVar.f16212e.setVisibility(0);
                } else {
                    cVar.f16212e.setVisibility(8);
                }
                if (this.f16202e.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f16208a, R.drawable.bg_select_sticker);
                } else {
                    cVar.f16208a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f16208a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f16202e, i4) instanceof StickerItem) {
                cVar.f16209b.setVisibility(0);
                cVar.f16211d.startLoad(this.f16202e.get(i4).img, 10, true);
                cVar.f16209b.setOnClickListener(new b(this, i2));
                if (this.f16202e.get(i4).isDownLoading) {
                    cVar.f16213f.setVisibility(0);
                } else {
                    cVar.f16213f.setVisibility(8);
                }
                if (this.f16202e.get(i4).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f16209b, R.drawable.bg_select_sticker);
                } else {
                    cVar.f16209b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f16209b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
