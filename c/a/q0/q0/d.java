package c.a.q0.q0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<CollectEmotionData> f23646e;

    /* renamed from: f  reason: collision with root package name */
    public List<CollectEmotionData> f23647f;

    /* renamed from: g  reason: collision with root package name */
    public int f23648g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.c0.b f23649h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23650i;

    /* renamed from: j  reason: collision with root package name */
    public int f23651j;
    public e k;
    public InterfaceC1098d l;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f23652e;

        public a(d dVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23652e = viewGroup;
        }

        @Override // c.a.p0.b0.b
        public void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f23652e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f23653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f23654f;

        public b(d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23654f = dVar;
            this.f23653e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollectEmotionData item;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f23654f.f23650i && (item = this.f23654f.getItem(this.f23653e)) != null) {
                if (!this.f23654f.f23647f.contains(item)) {
                    item.selectIndex = this.f23654f.f23647f.size() + 1;
                    item.isSelect = true;
                    this.f23654f.f23647f.add(item);
                } else {
                    item.selectIndex = -1;
                    int i2 = 0;
                    item.isSelect = false;
                    this.f23654f.f23647f.remove(item);
                    while (i2 < this.f23654f.f23647f.size()) {
                        i2++;
                        this.f23654f.getItem(this.f23653e).selectIndex = i2;
                    }
                }
                if (view.getId() == R.id.collect_select_icon) {
                    imageView = (ImageView) view;
                } else {
                    imageView = (ImageView) ((RelativeLayout) view.getParent()).findViewById(R.id.collect_select_icon);
                }
                if (imageView != null) {
                    if (item.isSelect) {
                        SkinManager.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_s);
                    } else {
                        SkinManager.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_n);
                    }
                }
                if (this.f23654f.k != null) {
                    this.f23654f.k.b(this.f23654f.f23647f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23655e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23655e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23655e.l == null) {
                return;
            }
            this.f23655e.l.e();
        }
    }

    /* renamed from: c.a.q0.q0.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1098d {
        void e();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void b(List<CollectEmotionData> list);
    }

    /* loaded from: classes3.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f23656a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f23657b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f23658c;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(InterfaceC1098d interfaceC1098d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC1098d};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23646e = new ArrayList();
        this.f23647f = new ArrayList();
        this.l = interfaceC1098d;
        this.f23648g = c.a.e.e.p.l.k(TbadkCoreApplication.getInst()) / 4;
        this.f23649h = new c.a.p0.c0.b();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23650i) {
            for (CollectEmotionData collectEmotionData : this.f23647f) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.f23647f.clear();
            ArrayList arrayList = new ArrayList(this.f23646e);
            this.f23646e.clear();
            this.f23646e.addAll(arrayList);
            notifyDataSetChanged();
            e eVar = this.k;
            if (eVar != null) {
                eVar.b(this.f23647f);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public CollectEmotionData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            return (CollectEmotionData) ListUtils.getItem(this.f23646e, i2 - 1);
        }
        return (CollectEmotionData) invokeI.objValue;
    }

    public List<CollectEmotionData> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23647f : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23646e.size() + 1 : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 == 0 ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        View view2;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (view == null) {
                    fVar = new f(this, null);
                    view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                    fVar.f23656a = view;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = this.f23648g;
                    fVar.f23656a.setLayoutParams(layoutParams);
                    TbImageView tbImageView = (TbImageView) view.findViewById(R.id.collect_pic);
                    fVar.f23657b = tbImageView;
                    ((RelativeLayout.LayoutParams) tbImageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                    fVar.f23657b.setScaleType(ImageView.ScaleType.CENTER);
                    view.findViewById(R.id.collect_select_icon).setVisibility(8);
                    view.setTag(fVar);
                    SkinManager.setBackgroundColor(view, R.color.white_alpha0, this.f23651j);
                } else {
                    fVar = (f) view.getTag();
                }
                if (this.f23650i) {
                    fVar.f23656a.setEnabled(false);
                    SkinManager.setImageResource(fVar.f23657b, R.drawable.icon_emotion_unplusadd_n);
                } else {
                    fVar.f23656a.setEnabled(true);
                    SkinManager.setImageResource(fVar.f23657b, R.drawable.icon_emotion_plusadd_n);
                }
                fVar.f23656a.setOnClickListener(new c(this));
                return view;
            } else if (itemViewType != 1) {
                return view;
            } else {
                if (view == null) {
                    fVar2 = new f(this, null);
                    view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                    fVar2.f23656a = view2;
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    layoutParams2.height = this.f23648g;
                    fVar2.f23656a.setLayoutParams(layoutParams2);
                    fVar2.f23657b = (TbImageView) view2.findViewById(R.id.collect_pic);
                    fVar2.f23658c = (ImageView) view2.findViewById(R.id.collect_select_icon);
                    view2.setTag(fVar2);
                    SkinManager.setBackgroundColor(view2, R.color.CAM_X0201, this.f23651j);
                } else {
                    view2 = view;
                    fVar2 = (f) view.getTag();
                }
                fVar2.f23657b.setTag(null);
                fVar2.f23657b.setDefaultResource(R.drawable.img_default_100);
                fVar2.f23657b.startLoad(null, 12, false);
                fVar2.f23657b.invalidate();
                SkinManager.setBackgroundResource(fVar2.f23657b, R.drawable.btn_choose_face_selector, this.f23651j);
                ImageFileInfo imageFileInfo = getItem(i2).imageFileInfo;
                if (imageFileInfo != null) {
                    imageFileInfo.clearPageActions();
                    int i3 = this.f23648g;
                    imageFileInfo.addPageAction(c.a.p0.c0.i.d.g(i3, i3));
                    fVar2.f23657b.setTag(imageFileInfo.toCachedKey(false));
                    if (this.f23649h.c(imageFileInfo, false) != null) {
                        fVar2.f23657b.invalidate();
                    } else {
                        this.f23649h.e(imageFileInfo, new a(this, viewGroup), false, false);
                    }
                }
                if (this.f23650i) {
                    fVar2.f23658c.setVisibility(0);
                } else {
                    fVar2.f23658c.setVisibility(8);
                }
                if (this.f23647f.contains(getItem(i2))) {
                    SkinManager.setBackgroundResource(fVar2.f23658c, R.drawable.ic_post_image_selected_s);
                } else {
                    SkinManager.setBackgroundResource(fVar2.f23658c, R.drawable.ic_post_image_selected_n);
                }
                b bVar = new b(this, i2);
                fVar2.f23657b.setOnClickListener(bVar);
                fVar2.f23658c.setOnClickListener(bVar);
                return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void h(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void i(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f23646e.clear();
            if (list == null) {
                return;
            }
            this.f23646e.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.f23650i == z) {
            return;
        }
        for (CollectEmotionData collectEmotionData : this.f23647f) {
            collectEmotionData.isSelect = false;
            collectEmotionData.selectIndex = -1;
        }
        this.f23647f.clear();
        this.f23650i = z;
        ArrayList arrayList = new ArrayList(this.f23646e);
        this.f23646e.clear();
        this.f23646e.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f23651j = i2;
        }
    }
}
