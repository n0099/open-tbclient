package c.a.s0.m4.m.e.b;

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
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<QmStickerItem> f19843e;

    /* renamed from: f  reason: collision with root package name */
    public RecordEffectLayout.i f19844f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19845e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19846f;

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
            this.f19846f = bVar;
            this.f19845e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f19846f.f19843e.get(this.f19845e * 2)).isSelect || this.f19846f.f19844f == null) {
                return;
            }
            this.f19846f.f19844f.a((QmStickerItem) this.f19846f.f19843e.get(this.f19845e * 2));
        }
    }

    /* renamed from: c.a.s0.m4.m.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1198b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f19848f;

        public View$OnClickListenerC1198b(b bVar, int i2) {
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
            this.f19848f = bVar;
            this.f19847e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f19848f.f19843e.get((this.f19847e * 2) + 1)).isSelect || this.f19848f.f19844f == null) {
                return;
            }
            this.f19848f.f19844f.a((QmStickerItem) this.f19848f.f19843e.get((this.f19847e * 2) + 1));
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f19849b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f19850c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f19851d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f19852e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f19853f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f19854g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f19855h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f19856i;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (QmStickerItem) ListUtils.getItem(this.f19843e, i2) : (QmStickerItem) invokeI.objValue;
    }

    public void d() {
        List<QmStickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f19843e) == null) {
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
            this.f19843e = list;
        }
    }

    public void f(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f19844f = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f19843e)) {
                return 0;
            }
            return (int) Math.ceil(this.f19843e.size() / 2.0d);
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
                cVar.f19850c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f19851d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f19856i = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f19849b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f19852e = (TbImageView) view.findViewById(R.id.top_need_download);
                cVar.f19853f = (TbImageView) view.findViewById(R.id.bottom_need_download);
                cVar.f19854g = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f19855h = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f19850c.setAutoChangeStyle(false);
            cVar.f19851d.setAutoChangeStyle(false);
            cVar.f19852e.setAutoChangeStyle(false);
            cVar.f19853f.setAutoChangeStyle(false);
            cVar.f19850c.setGifIconSupport(false);
            cVar.f19851d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f19843e, i3) instanceof QmStickerItem) {
                cVar.a.setVisibility(0);
                if (this.f19843e.get(i3).id == -1) {
                    cVar.f19856i.setVisibility(0);
                    cVar.f19850c.setVisibility(8);
                    cVar.f19856i.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f19856i.setVisibility(8);
                    cVar.f19850c.setVisibility(0);
                    cVar.f19850c.startLoad(this.f19843e.get(i3).bgurl, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i2));
                if (this.f19843e.get(i3).isDownLoading) {
                    cVar.f19854g.setVisibility(0);
                    cVar.f19852e.setVisibility(8);
                } else {
                    cVar.f19854g.setVisibility(8);
                    if (this.f19843e.get(i3).isLocalSource) {
                        cVar.f19852e.setVisibility(8);
                    } else {
                        cVar.f19852e.setVisibility(0);
                    }
                }
                if (this.f19843e.get(i3).isSelect) {
                    cVar.a.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f19843e, i4) instanceof QmStickerItem) {
                cVar.f19849b.setVisibility(0);
                cVar.f19851d.startLoad(this.f19843e.get(i4).bgurl, 10, true);
                cVar.f19849b.setOnClickListener(new View$OnClickListenerC1198b(this, i2));
                if (this.f19843e.get(i4).isDownLoading) {
                    cVar.f19855h.setVisibility(0);
                    cVar.f19853f.setVisibility(8);
                } else {
                    cVar.f19855h.setVisibility(8);
                    if (this.f19843e.get(i4).isLocalSource) {
                        cVar.f19853f.setVisibility(8);
                    } else {
                        cVar.f19853f.setVisibility(0);
                    }
                }
                if (this.f19843e.get(i4).isSelect) {
                    cVar.f19849b.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f19849b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f19849b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
