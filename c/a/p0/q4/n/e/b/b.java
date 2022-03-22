package c.a.p0.q4.n.e.b;

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
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<QmStickerItem> a;

    /* renamed from: b  reason: collision with root package name */
    public RecordEffectLayout.i f17881b;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17882b;

        public a(b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17882b = bVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f17882b.a.get(this.a * 2)).isSelect || this.f17882b.f17881b == null) {
                return;
            }
            this.f17882b.f17881b.a((QmStickerItem) this.f17882b.a.get(this.a * 2));
        }
    }

    /* renamed from: c.a.p0.q4.n.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1347b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f17883b;

        public View$OnClickListenerC1347b(b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17883b = bVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((QmStickerItem) this.f17883b.a.get((this.a * 2) + 1)).isSelect || this.f17883b.f17881b == null) {
                return;
            }
            this.f17883b.f17881b.a((QmStickerItem) this.f17883b.a.get((this.a * 2) + 1));
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f17884b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f17885c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f17886d;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f17887e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f17888f;

        /* renamed from: g  reason: collision with root package name */
        public ProgressBar f17889g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f17890h;
        public ImageView i;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public QmStickerItem getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (QmStickerItem) ListUtils.getItem(this.a, i) : (QmStickerItem) invokeI.objValue;
    }

    public void d(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    public void e(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.f17881b = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.a)) {
                return 0;
            }
            return (int) Math.ceil(this.a.size() / 2.0d);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0176, (ViewGroup) null);
                cVar = new c(this);
                cVar.f17885c = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0920cb);
                cVar.f17886d = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0903db);
                cVar.a = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0920ad);
                cVar.i = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0915a3);
                cVar.f17884b = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0903bb);
                cVar.f17887e = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0920c5);
                cVar.f17888f = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0903cf);
                cVar.f17889g = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f0920c8);
                cVar.f17890h = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f0903d4);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f17885c.setAutoChangeStyle(false);
            cVar.f17886d.setAutoChangeStyle(false);
            cVar.f17887e.setAutoChangeStyle(false);
            cVar.f17888f.setAutoChangeStyle(false);
            cVar.f17885c.setGifIconSupport(false);
            cVar.f17886d.setGifIconSupport(false);
            int i2 = i * 2;
            if (ListUtils.getItem(this.a, i2) instanceof QmStickerItem) {
                cVar.a.setVisibility(0);
                if (this.a.get(i2).id == -1) {
                    cVar.i.setVisibility(0);
                    cVar.f17885c.setVisibility(8);
                    cVar.i.setImageResource(R.drawable.obfuscated_res_0x7f080ac7);
                } else {
                    cVar.i.setVisibility(8);
                    cVar.f17885c.setVisibility(0);
                    cVar.f17885c.J(this.a.get(i2).bgurl, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i));
                if (this.a.get(i2).isDownLoading) {
                    cVar.f17889g.setVisibility(0);
                    cVar.f17887e.setVisibility(8);
                } else {
                    cVar.f17889g.setVisibility(8);
                    if (this.a.get(i2).isLocalSource) {
                        cVar.f17887e.setVisibility(8);
                    } else {
                        cVar.f17887e.setVisibility(0);
                    }
                }
                if (this.a.get(i2).isSelect) {
                    cVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f081082);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i3 = i2 + 1;
            if (ListUtils.getItem(this.a, i3) instanceof QmStickerItem) {
                cVar.f17884b.setVisibility(0);
                cVar.f17886d.J(this.a.get(i3).bgurl, 10, true);
                cVar.f17884b.setOnClickListener(new View$OnClickListenerC1347b(this, i));
                if (this.a.get(i3).isDownLoading) {
                    cVar.f17890h.setVisibility(0);
                    cVar.f17888f.setVisibility(8);
                } else {
                    cVar.f17890h.setVisibility(8);
                    if (this.a.get(i3).isLocalSource) {
                        cVar.f17888f.setVisibility(8);
                    } else {
                        cVar.f17888f.setVisibility(0);
                    }
                }
                if (this.a.get(i3).isSelect) {
                    cVar.f17884b.setBackgroundResource(R.drawable.obfuscated_res_0x7f081082);
                } else {
                    cVar.f17884b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f17884b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
