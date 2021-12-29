package c.a.t0.n4.m.e.b;

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
    public List<QmStickerItem> f20581e;

    /* renamed from: f  reason: collision with root package name */
    public RecordEffectLayout.i f20582f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f20584f;

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
            this.f20584f = bVar;
            this.f20583e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f20584f.f20581e.get(this.f20583e * 2)).isSelect || this.f20584f.f20582f == null) {
                return;
            }
            this.f20584f.f20582f.a((QmStickerItem) this.f20584f.f20581e.get(this.f20583e * 2));
        }
    }

    /* renamed from: c.a.t0.n4.m.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1244b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f20586f;

        public View$OnClickListenerC1244b(b bVar, int i2) {
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
            this.f20586f = bVar;
            this.f20585e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f20586f.f20581e.get((this.f20585e * 2) + 1)).isSelect || this.f20586f.f20582f == null) {
                return;
            }
            this.f20586f.f20582f.a((QmStickerItem) this.f20586f.f20581e.get((this.f20585e * 2) + 1));
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f20587b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f20588c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f20589d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f20590e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f20591f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f20592g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f20593h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f20594i;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (QmStickerItem) ListUtils.getItem(this.f20581e, i2) : (QmStickerItem) invokeI.objValue;
    }

    public void d() {
        List<QmStickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f20581e) == null) {
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
            this.f20581e = list;
        }
    }

    public void f(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f20582f = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f20581e)) {
                return 0;
            }
            return (int) Math.ceil(this.f20581e.size() / 2.0d);
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
                cVar.f20588c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f20589d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f20594i = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f20587b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f20590e = (TbImageView) view.findViewById(R.id.top_need_download);
                cVar.f20591f = (TbImageView) view.findViewById(R.id.bottom_need_download);
                cVar.f20592g = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f20593h = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f20588c.setAutoChangeStyle(false);
            cVar.f20589d.setAutoChangeStyle(false);
            cVar.f20590e.setAutoChangeStyle(false);
            cVar.f20591f.setAutoChangeStyle(false);
            cVar.f20588c.setGifIconSupport(false);
            cVar.f20589d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f20581e, i3) instanceof QmStickerItem) {
                cVar.a.setVisibility(0);
                if (this.f20581e.get(i3).id == -1) {
                    cVar.f20594i.setVisibility(0);
                    cVar.f20588c.setVisibility(8);
                    cVar.f20594i.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f20594i.setVisibility(8);
                    cVar.f20588c.setVisibility(0);
                    cVar.f20588c.startLoad(this.f20581e.get(i3).bgurl, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i2));
                if (this.f20581e.get(i3).isDownLoading) {
                    cVar.f20592g.setVisibility(0);
                    cVar.f20590e.setVisibility(8);
                } else {
                    cVar.f20592g.setVisibility(8);
                    if (this.f20581e.get(i3).isLocalSource) {
                        cVar.f20590e.setVisibility(8);
                    } else {
                        cVar.f20590e.setVisibility(0);
                    }
                }
                if (this.f20581e.get(i3).isSelect) {
                    cVar.a.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f20581e, i4) instanceof QmStickerItem) {
                cVar.f20587b.setVisibility(0);
                cVar.f20589d.startLoad(this.f20581e.get(i4).bgurl, 10, true);
                cVar.f20587b.setOnClickListener(new View$OnClickListenerC1244b(this, i2));
                if (this.f20581e.get(i4).isDownLoading) {
                    cVar.f20593h.setVisibility(0);
                    cVar.f20591f.setVisibility(8);
                } else {
                    cVar.f20593h.setVisibility(8);
                    if (this.f20581e.get(i4).isLocalSource) {
                        cVar.f20591f.setVisibility(8);
                    } else {
                        cVar.f20591f.setVisibility(0);
                    }
                }
                if (this.f20581e.get(i4).isSelect) {
                    cVar.f20587b.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f20587b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f20587b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
