package c.a.r0.b4.l.e.b;

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
    public List<QmStickerItem> f16404e;

    /* renamed from: f  reason: collision with root package name */
    public RecordEffectLayout.i f16405f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16406e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16407f;

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
            this.f16407f = bVar;
            this.f16406e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f16407f.f16404e.get(this.f16406e * 2)).isSelect || this.f16407f.f16405f == null) {
                return;
            }
            this.f16407f.f16405f.a((QmStickerItem) this.f16407f.f16404e.get(this.f16406e * 2));
        }
    }

    /* renamed from: c.a.r0.b4.l.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0784b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16408e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16409f;

        public View$OnClickListenerC0784b(b bVar, int i2) {
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
            this.f16409f = bVar;
            this.f16408e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f16409f.f16404e.get((this.f16408e * 2) + 1)).isSelect || this.f16409f.f16405f == null) {
                return;
            }
            this.f16409f.f16405f.a((QmStickerItem) this.f16409f.f16404e.get((this.f16408e * 2) + 1));
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f16410a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f16411b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f16412c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f16413d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16414e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f16415f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f16416g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f16417h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f16418i;

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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (QmStickerItem) ListUtils.getItem(this.f16404e, i2) : (QmStickerItem) invokeI.objValue;
    }

    public void d() {
        List<QmStickerItem> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.f16404e) == null) {
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
            this.f16404e = list;
        }
    }

    public void f(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f16405f = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f16404e)) {
                return 0;
            }
            return (int) Math.ceil(this.f16404e.size() / 2.0d);
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
                cVar.f16412c = (TbImageView) view.findViewById(R.id.top_sticker);
                cVar.f16413d = (TbImageView) view.findViewById(R.id.bottom_sticker);
                cVar.f16410a = (RelativeLayout) view.findViewById(R.id.top_container);
                cVar.f16418i = (ImageView) view.findViewById(R.id.no_sticker);
                cVar.f16411b = (RelativeLayout) view.findViewById(R.id.bottom_container);
                cVar.f16414e = (TbImageView) view.findViewById(R.id.top_need_download);
                cVar.f16415f = (TbImageView) view.findViewById(R.id.bottom_need_download);
                cVar.f16416g = (ProgressBar) view.findViewById(R.id.top_progressbar);
                cVar.f16417h = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f16412c.setAutoChangeStyle(false);
            cVar.f16413d.setAutoChangeStyle(false);
            cVar.f16414e.setAutoChangeStyle(false);
            cVar.f16415f.setAutoChangeStyle(false);
            cVar.f16412c.setGifIconSupport(false);
            cVar.f16413d.setGifIconSupport(false);
            int i3 = i2 * 2;
            if (ListUtils.getItem(this.f16404e, i3) instanceof QmStickerItem) {
                cVar.f16410a.setVisibility(0);
                if (this.f16404e.get(i3).id == -1) {
                    cVar.f16418i.setVisibility(0);
                    cVar.f16412c.setVisibility(8);
                    cVar.f16418i.setImageResource(R.drawable.icon_video_sticker_no);
                } else {
                    cVar.f16418i.setVisibility(8);
                    cVar.f16412c.setVisibility(0);
                    cVar.f16412c.startLoad(this.f16404e.get(i3).bgurl, 10, true);
                }
                cVar.f16410a.setOnClickListener(new a(this, i2));
                if (this.f16404e.get(i3).isDownLoading) {
                    cVar.f16416g.setVisibility(0);
                    cVar.f16414e.setVisibility(8);
                } else {
                    cVar.f16416g.setVisibility(8);
                    if (this.f16404e.get(i3).isLocalSource) {
                        cVar.f16414e.setVisibility(8);
                    } else {
                        cVar.f16414e.setVisibility(0);
                    }
                }
                if (this.f16404e.get(i3).isSelect) {
                    cVar.f16410a.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f16410a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f16410a.setVisibility(8);
            }
            int i4 = i3 + 1;
            if (ListUtils.getItem(this.f16404e, i4) instanceof QmStickerItem) {
                cVar.f16411b.setVisibility(0);
                cVar.f16413d.startLoad(this.f16404e.get(i4).bgurl, 10, true);
                cVar.f16411b.setOnClickListener(new View$OnClickListenerC0784b(this, i2));
                if (this.f16404e.get(i4).isDownLoading) {
                    cVar.f16417h.setVisibility(0);
                    cVar.f16415f.setVisibility(8);
                } else {
                    cVar.f16417h.setVisibility(8);
                    if (this.f16404e.get(i4).isLocalSource) {
                        cVar.f16415f.setVisibility(8);
                    } else {
                        cVar.f16415f.setVisibility(0);
                    }
                }
                if (this.f16404e.get(i4).isSelect) {
                    cVar.f16411b.setBackgroundResource(R.drawable.select_sticker_bg);
                } else {
                    cVar.f16411b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f16411b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
