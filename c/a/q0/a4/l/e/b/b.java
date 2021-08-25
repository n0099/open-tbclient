package c.a.q0.a4.l.e.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
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
    public List<QmStickerItem> f15861e;

    /* renamed from: f  reason: collision with root package name */
    public RecordEffectLayout.i f15862f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f15864f;

        public a(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15864f = bVar;
            this.f15863e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f15864f.f15861e.get(this.f15863e * 2)).isSelect || this.f15864f.f15862f == null) {
                return;
            }
            this.f15864f.f15862f.a((QmStickerItem) this.f15864f.f15861e.get(this.f15863e * 2));
        }
    }

    /* renamed from: c.a.q0.a4.l.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0750b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f15866f;

        public View$OnClickListenerC0750b(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15866f = bVar;
            this.f15865e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f15866f.f15861e.get((this.f15865e * 2) + 1)).isSelect || this.f15866f.f15862f == null) {
                return;
            }
            this.f15866f.f15862f.a((QmStickerItem) this.f15866f.f15861e.get((this.f15865e * 2) + 1));
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f15867a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f15868b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f15869c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f15870d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f15871e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f15872f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f15873g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f15874h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f15875i;

        public c(b bVar) {
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
    }

    public b() {
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
    public QmStickerItem getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (QmStickerItem) ListUtils.getItem(this.f15861e, i2) : (QmStickerItem) invokeI.objValue;
    }

    public void d() {
        List<QmStickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f15861e) == null) {
            return;
        }
        for (QmStickerItem qmStickerItem : list) {
            if (qmStickerItem.id == -1) {
                qmStickerItem.isSelect = true;
            } else {
                qmStickerItem.isSelect = false;
                qmStickerItem.isDownLoading = false;
            }
        }
    }

    public void e(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f15861e = list;
        }
    }

    public void f(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f15862f = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f15861e)) {
                return 0;
            }
            return (int) Math.ceil(this.f15861e.size() / 2.0d);
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_sticker, (ViewGroup) null);
                cVar = new c(this);
                cVar.f15869c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f15870d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f15867a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f15875i = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f15868b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f15871e = (TbImageView) view.findViewById(R.id.top_need_download);
                cVar.f15872f = (TbImageView) view.findViewById(R.id.bottom_need_download);
                cVar.f15873g = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f15874h = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f15869c.setAutoChangeStyle(false);
            cVar.f15870d.setAutoChangeStyle(false);
            cVar.f15871e.setAutoChangeStyle(false);
            cVar.f15872f.setAutoChangeStyle(false);
            cVar.f15869c.setGifIconSupport(false);
            cVar.f15870d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f15861e, i3) instanceof QmStickerItem) {
                cVar.f15867a.setVisibility(0);
                if (this.f15861e.get(i3).id == -1) {
                    cVar.f15875i.setVisibility(0);
                    cVar.f15869c.setVisibility(8);
                    cVar.f15875i.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f15875i.setVisibility(8);
                    cVar.f15869c.setVisibility(0);
                    cVar.f15869c.startLoad(this.f15861e.get(i3).bgurl, 10, true);
                }
                cVar.f15867a.setOnClickListener(new a(this, i2));
                if (this.f15861e.get(i3).isDownLoading) {
                    cVar.f15873g.setVisibility(0);
                    cVar.f15871e.setVisibility(8);
                } else {
                    cVar.f15873g.setVisibility(8);
                    if (this.f15861e.get(i3).isLocalSource) {
                        cVar.f15871e.setVisibility(8);
                    } else {
                        cVar.f15871e.setVisibility(0);
                    }
                }
                if (this.f15861e.get(i3).isSelect) {
                    cVar.f15867a.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f15867a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f15867a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f15861e, i4) instanceof QmStickerItem) {
                cVar.f15868b.setVisibility(0);
                cVar.f15870d.startLoad(this.f15861e.get(i4).bgurl, 10, true);
                cVar.f15868b.setOnClickListener(new View$OnClickListenerC0750b(this, i2));
                if (this.f15861e.get(i4).isDownLoading) {
                    cVar.f15874h.setVisibility(0);
                    cVar.f15872f.setVisibility(8);
                } else {
                    cVar.f15874h.setVisibility(8);
                    if (this.f15861e.get(i4).isLocalSource) {
                        cVar.f15872f.setVisibility(8);
                    } else {
                        cVar.f15872f.setVisibility(0);
                    }
                }
                if (this.f15861e.get(i4).isSelect) {
                    cVar.f15868b.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f15868b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f15868b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
