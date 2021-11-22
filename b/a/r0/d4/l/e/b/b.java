package b.a.r0.d4.l.e.b;

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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<QmStickerItem> f17208e;

    /* renamed from: f  reason: collision with root package name */
    public RecordEffectLayout.i f17209f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17210e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17211f;

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
            this.f17211f = bVar;
            this.f17210e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f17211f.f17208e.get(this.f17210e * 2)).isSelect || this.f17211f.f17209f == null) {
                return;
            }
            this.f17211f.f17209f.a((QmStickerItem) this.f17211f.f17208e.get(this.f17210e * 2));
        }
    }

    /* renamed from: b.a.r0.d4.l.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0864b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17212e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17213f;

        public View$OnClickListenerC0864b(b bVar, int i2) {
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
            this.f17213f = bVar;
            this.f17212e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f17213f.f17208e.get((this.f17212e * 2) + 1)).isSelect || this.f17213f.f17209f == null) {
                return;
            }
            this.f17213f.f17209f.a((QmStickerItem) this.f17213f.f17208e.get((this.f17212e * 2) + 1));
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f17214a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f17215b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f17216c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f17217d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f17218e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f17219f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f17220g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f17221h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f17222i;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (QmStickerItem) ListUtils.getItem(this.f17208e, i2) : (QmStickerItem) invokeI.objValue;
    }

    public void d() {
        List<QmStickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f17208e) == null) {
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
            this.f17208e = list;
        }
    }

    public void f(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f17209f = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f17208e)) {
                return 0;
            }
            return (int) Math.ceil(this.f17208e.size() / 2.0d);
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
                cVar.f17216c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f17217d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f17214a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f17222i = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f17215b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f17218e = (TbImageView) view.findViewById(R.id.top_need_download);
                cVar.f17219f = (TbImageView) view.findViewById(R.id.bottom_need_download);
                cVar.f17220g = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f17221h = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f17216c.setAutoChangeStyle(false);
            cVar.f17217d.setAutoChangeStyle(false);
            cVar.f17218e.setAutoChangeStyle(false);
            cVar.f17219f.setAutoChangeStyle(false);
            cVar.f17216c.setGifIconSupport(false);
            cVar.f17217d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f17208e, i3) instanceof QmStickerItem) {
                cVar.f17214a.setVisibility(0);
                if (this.f17208e.get(i3).id == -1) {
                    cVar.f17222i.setVisibility(0);
                    cVar.f17216c.setVisibility(8);
                    cVar.f17222i.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f17222i.setVisibility(8);
                    cVar.f17216c.setVisibility(0);
                    cVar.f17216c.startLoad(this.f17208e.get(i3).bgurl, 10, true);
                }
                cVar.f17214a.setOnClickListener(new a(this, i2));
                if (this.f17208e.get(i3).isDownLoading) {
                    cVar.f17220g.setVisibility(0);
                    cVar.f17218e.setVisibility(8);
                } else {
                    cVar.f17220g.setVisibility(8);
                    if (this.f17208e.get(i3).isLocalSource) {
                        cVar.f17218e.setVisibility(8);
                    } else {
                        cVar.f17218e.setVisibility(0);
                    }
                }
                if (this.f17208e.get(i3).isSelect) {
                    cVar.f17214a.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f17214a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f17214a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f17208e, i4) instanceof QmStickerItem) {
                cVar.f17215b.setVisibility(0);
                cVar.f17217d.startLoad(this.f17208e.get(i4).bgurl, 10, true);
                cVar.f17215b.setOnClickListener(new View$OnClickListenerC0864b(this, i2));
                if (this.f17208e.get(i4).isDownLoading) {
                    cVar.f17221h.setVisibility(0);
                    cVar.f17219f.setVisibility(8);
                } else {
                    cVar.f17221h.setVisibility(8);
                    if (this.f17208e.get(i4).isLocalSource) {
                        cVar.f17219f.setVisibility(8);
                    } else {
                        cVar.f17219f.setVisibility(0);
                    }
                }
                if (this.f17208e.get(i4).isSelect) {
                    cVar.f17215b.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f17215b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f17215b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
