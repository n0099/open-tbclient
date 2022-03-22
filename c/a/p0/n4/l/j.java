package c.a.p0.n4.l;

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
/* loaded from: classes2.dex */
public class j extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<StickerItem> a;

    /* renamed from: b  reason: collision with root package name */
    public VideoEffectLayout.h f16780b;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f16781b;

        public a(j jVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16781b = jVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f16781b.a.get(this.a * 2)).isSelect || this.f16781b.f16780b == null) {
                return;
            }
            this.f16781b.f16780b.onStickerChoosed((StickerItem) this.f16781b.a.get(this.a * 2));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f16782b;

        public b(j jVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16782b = jVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ((StickerItem) this.f16782b.a.get((this.a * 2) + 1)).isSelect || this.f16782b.f16780b == null) {
                return;
            }
            this.f16782b.f16780b.onStickerChoosed((StickerItem) this.f16782b.a.get((this.a * 2) + 1));
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f16783b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f16784c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f16785d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f16786e;

        /* renamed from: f  reason: collision with root package name */
        public ProgressBar f16787f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f16788g;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
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

    public j() {
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
    public StickerItem getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (StickerItem) ListUtils.getItem(this.a, i) : (StickerItem) invokeI.objValue;
    }

    public void d(List<StickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    public void e(VideoEffectLayout.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.f16780b = hVar;
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0507, (ViewGroup) null);
                cVar = new c(this);
                cVar.f16784c = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0920cb);
                cVar.f16785d = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0903db);
                cVar.a = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0920ad);
                cVar.f16788g = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0915a3);
                cVar.f16783b = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0903bb);
                cVar.f16786e = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f0920c8);
                cVar.f16787f = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f0903d4);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f16784c.setAutoChangeStyle(false);
            cVar.f16785d.setAutoChangeStyle(false);
            cVar.f16784c.setGifIconSupport(false);
            cVar.f16785d.setGifIconSupport(false);
            int i2 = i * 2;
            if (ListUtils.getItem(this.a, i2) instanceof StickerItem) {
                cVar.a.setVisibility(0);
                if (this.a.get(i2).id == -1) {
                    cVar.f16788g.setVisibility(0);
                    cVar.f16784c.setVisibility(8);
                    cVar.f16788g.setImageResource(R.drawable.obfuscated_res_0x7f080ac7);
                } else {
                    cVar.f16788g.setVisibility(8);
                    cVar.f16784c.setVisibility(0);
                    cVar.f16784c.J(this.a.get(i2).img, 10, true);
                }
                cVar.a.setOnClickListener(new a(this, i));
                if (this.a.get(i2).isDownLoading) {
                    cVar.f16786e.setVisibility(0);
                } else {
                    cVar.f16786e.setVisibility(8);
                }
                if (this.a.get(i2).isSelect) {
                    SkinManager.setBackgroundResource(cVar.a, R.drawable.obfuscated_res_0x7f0802dc);
                } else {
                    cVar.a.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.a.setVisibility(8);
            }
            int i3 = i2 + 1;
            if (ListUtils.getItem(this.a, i3) instanceof StickerItem) {
                cVar.f16783b.setVisibility(0);
                cVar.f16785d.J(this.a.get(i3).img, 10, true);
                cVar.f16783b.setOnClickListener(new b(this, i));
                if (this.a.get(i3).isDownLoading) {
                    cVar.f16787f.setVisibility(0);
                } else {
                    cVar.f16787f.setVisibility(8);
                }
                if (this.a.get(i3).isSelect) {
                    SkinManager.setBackgroundResource(cVar.f16783b, R.drawable.obfuscated_res_0x7f0802dc);
                } else {
                    cVar.f16783b.setBackgroundResource(R.color.transparent);
                }
            } else {
                cVar.f16783b.setVisibility(8);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
