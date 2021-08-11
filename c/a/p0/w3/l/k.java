package c.a.p0.w3.l;

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
public class k extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<StickerItem> f28149e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEffectLayout.h f28150f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f28151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f28152f;

        public a(k kVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28152f = kVar;
            this.f28151e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f28152f.f28149e.get(this.f28151e * 2)).isSelect || this.f28152f.f28150f == null) {
                return;
            }
            this.f28152f.f28150f.onStickerChoosed((StickerItem) this.f28152f.f28149e.get(this.f28151e * 2));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f28153e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f28154f;

        public b(k kVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28154f = kVar;
            this.f28153e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f28154f.f28149e.get((this.f28153e * 2) + 1)).isSelect || this.f28154f.f28150f == null) {
                return;
            }
            this.f28154f.f28150f.onStickerChoosed((StickerItem) this.f28154f.f28149e.get((this.f28153e * 2) + 1));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f28155a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f28156b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f28157c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f28158d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f28159e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f28160f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f28161g;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
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

    public k() {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (StickerItem) ListUtils.getItem(this.f28149e, i2) : (StickerItem) invokeI.objValue;
    }

    public void d() {
        List<StickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f28149e) == null) {
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
            this.f28149e = list;
        }
    }

    public void f(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.f28150f = hVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f28149e)) {
                return 0;
            }
            return (int) Math.ceil(this.f28149e.size() / 2.0d);
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
                cVar.f28157c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f28158d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f28155a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f28161g = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f28156b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f28159e = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f28160f = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f28157c.setAutoChangeStyle(false);
            cVar.f28158d.setAutoChangeStyle(false);
            cVar.f28157c.setGifIconSupport(false);
            cVar.f28158d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f28149e, i3) instanceof StickerItem) {
                cVar.f28155a.setVisibility(0);
                if (this.f28149e.get(i3).id == -1) {
                    cVar.f28161g.setVisibility(0);
                    cVar.f28157c.setVisibility(8);
                    cVar.f28161g.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f28161g.setVisibility(8);
                    cVar.f28157c.setVisibility(0);
                    cVar.f28157c.startLoad(this.f28149e.get(i3).img, 10, true);
                }
                cVar.f28155a.setOnClickListener(new a(this, i2));
                if (this.f28149e.get(i3).isDownLoading) {
                    cVar.f28159e.setVisibility(0);
                } else {
                    cVar.f28159e.setVisibility(8);
                }
                if (this.f28149e.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f28155a, R.drawable.bg_select_sticker);
                } else {
                    cVar.f28155a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f28155a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f28149e, i4) instanceof StickerItem) {
                cVar.f28156b.setVisibility(0);
                cVar.f28158d.startLoad(this.f28149e.get(i4).img, 10, true);
                cVar.f28156b.setOnClickListener(new b(this, i2));
                if (this.f28149e.get(i4).isDownLoading) {
                    cVar.f28160f.setVisibility(0);
                } else {
                    cVar.f28160f.setVisibility(8);
                }
                if (this.f28149e.get(i4).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f28156b, R.drawable.bg_select_sticker);
                } else {
                    cVar.f28156b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f28156b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
