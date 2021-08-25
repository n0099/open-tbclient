package c.a.q0.d2.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import c.a.e.e.p.l;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f16736e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16737f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.c0.b f16738g;

    /* renamed from: h  reason: collision with root package name */
    public int f16739h;

    /* renamed from: i  reason: collision with root package name */
    public int f16740i;

    /* renamed from: j  reason: collision with root package name */
    public c f16741j;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16742a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C0808d f16743b;

        public a(d dVar, ViewGroup viewGroup, C0808d c0808d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup, c0808d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16742a = viewGroup;
            this.f16743b = c0808d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null || (findViewWithTag = this.f16742a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f16743b.f16745a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16744e;

        public b(d dVar, ViewGroup viewGroup) {
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
            this.f16744e = viewGroup;
        }

        @Override // c.a.p0.b0.b
        public void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f16744e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            aVar.h(tbImageView);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onAdd();

        void onDel(FaceData faceData);
    }

    /* renamed from: c.a.q0.d2.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0808d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f16745a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f16746b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f16747c;

        /* renamed from: c.a.q0.d2.g.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0808d f16748e;

            public a(C0808d c0808d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0808d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16748e = c0808d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f16748e.f16747c.f16741j != null && view.getTag(view.getId()) != null && (view.getTag(view.getId()) instanceof FaceData) && ((FaceData) view.getTag(view.getId())).type == 4) {
                    this.f16748e.f16747c.f16741j.onAdd();
                }
            }
        }

        /* renamed from: c.a.q0.d2.g.d$d$b */
        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0808d f16749e;

            public b(C0808d c0808d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0808d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16749e = c0808d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16749e.f16747c.f16741j == null || view.getTag() == null || !(view.getTag() instanceof FaceData)) {
                    return;
                }
                this.f16749e.f16747c.f16741j.onDel((FaceData) view.getTag());
            }
        }

        public C0808d(d dVar) {
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
            this.f16747c = dVar;
        }

        public final void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16745a = (TbImageView) view.findViewById(R.id.image);
                this.f16746b = (ImageView) view.findViewById(R.id.delete_icon);
                ViewGroup.LayoutParams layoutParams = this.f16745a.getLayoutParams();
                layoutParams.width = this.f16747c.f16739h;
                layoutParams.height = this.f16747c.f16739h;
                SkinManager.setImageResource(this.f16746b, R.drawable.icon_live_close_n);
                this.f16745a.setOnClickListener(new a(this));
                this.f16746b.setOnClickListener(new b(this));
            }
        }
    }

    public d(List<FaceData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16737f = BdBaseApplication.getInst().getApp();
        this.f16736e = list;
        this.f16738g = new c.a.p0.c0.b();
        int k = l.k(this.f16737f);
        this.f16740i = k;
        this.f16739h = (k - (l.g(this.f16737f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C0808d c0808d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, viewGroup, c0808d) == null) || imageFileInfo == null) {
            return;
        }
        imageFileInfo.clearPageActions();
        int i2 = this.f16739h;
        imageFileInfo.addPageAction(c.a.p0.c0.i.d.g(i2, i2));
        c.a.e.l.d.a c2 = this.f16738g.c(imageFileInfo, false);
        c0808d.f16745a.setTag(imageFileInfo.toCachedKey(false));
        if (c2 != null) {
            c2.h(c0808d.f16745a);
            c0808d.f16745a.setTag(null);
        } else {
            this.f16738g.e(imageFileInfo, new b(this, viewGroup), false, false);
        }
        c0808d.f16746b.setVisibility(0);
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C0808d c0808d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, viewGroup, c0808d) == null) || emotionImageData == null) {
            return;
        }
        Object k = c.a.e.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c0808d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
        c.a.e.l.d.a aVar = (k == null || !(k instanceof c.a.e.l.d.a)) ? null : (c.a.e.l.d.a) k;
        if (aVar != null) {
            aVar.h(c0808d.f16745a);
            c0808d.f16745a.setTag(null);
        }
        c0808d.f16746b.setVisibility(0);
    }

    public final void e(EmotionImageData emotionImageData, C0808d c0808d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionImageData, c0808d) == null) || emotionImageData == null) {
            return;
        }
        c0808d.f16745a.setTag(emotionImageData.getThumbUrl());
        c0808d.f16745a.startLoad(emotionImageData.getThumbUrl(), 10, false);
        c0808d.f16746b.setVisibility(0);
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f16741j = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<FaceData> list = this.f16736e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            List<FaceData> list = this.f16736e;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f16736e.get(i2);
        }
        return invokeI.objValue;
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
        View view2;
        C0808d c0808d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0808d = new C0808d(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
                c0808d.b(view2);
                view2.setTag(c0808d);
            } else {
                view2 = view;
                c0808d = (C0808d) view.getTag();
            }
            FaceData faceData = this.f16736e.get(i2);
            if (faceData != null) {
                int i3 = faceData.type;
                if (i3 == 4) {
                    SkinManager.setImageResource(c0808d.f16745a, R.drawable.emotion_icon_add_pic);
                    c0808d.f16746b.setVisibility(8);
                } else if (i3 == 1) {
                    c0808d.f16745a.setImageDrawable(null);
                    d(faceData.emotionImageData, viewGroup, c0808d);
                } else if (i3 == 2) {
                    c0808d.f16745a.setImageDrawable(null);
                    e(faceData.emotionImageData, c0808d);
                } else {
                    c0808d.f16745a.setImageDrawable(null);
                    c(faceData.imageFileInfo, viewGroup, c0808d);
                }
                TbImageView tbImageView = c0808d.f16745a;
                tbImageView.setTag(tbImageView.getId(), faceData);
            }
            c0808d.f16746b.setTag(faceData);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
