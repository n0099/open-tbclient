package c.a.t0.n2.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import c.a.d.f.p.n;
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
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f20151e;

    /* renamed from: f  reason: collision with root package name */
    public Context f20152f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.d0.b f20153g;

    /* renamed from: h  reason: collision with root package name */
    public int f20154h;

    /* renamed from: i  reason: collision with root package name */
    public int f20155i;

    /* renamed from: j  reason: collision with root package name */
    public c f20156j;

    /* loaded from: classes7.dex */
    public class a extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1214d f20157b;

        public a(d dVar, ViewGroup viewGroup, C1214d c1214d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup, c1214d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.f20157b = c1214d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null || (findViewWithTag = this.a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f20157b.a);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.s0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f20158e;

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
            this.f20158e = viewGroup;
        }

        @Override // c.a.s0.c0.b
        public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f20158e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            aVar.h(tbImageView);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onAdd();

        void onDel(FaceData faceData);
    }

    /* renamed from: c.a.t0.n2.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1214d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f20159b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f20160c;

        /* renamed from: c.a.t0.n2.g.d$d$a */
        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1214d f20161e;

            public a(C1214d c1214d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1214d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20161e = c1214d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f20161e.f20160c.f20156j != null && view.getTag(view.getId()) != null && (view.getTag(view.getId()) instanceof FaceData) && ((FaceData) view.getTag(view.getId())).type == 4) {
                    this.f20161e.f20160c.f20156j.onAdd();
                }
            }
        }

        /* renamed from: c.a.t0.n2.g.d$d$b */
        /* loaded from: classes7.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1214d f20162e;

            public b(C1214d c1214d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1214d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20162e = c1214d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20162e.f20160c.f20156j == null || view.getTag() == null || !(view.getTag() instanceof FaceData)) {
                    return;
                }
                this.f20162e.f20160c.f20156j.onDel((FaceData) view.getTag());
            }
        }

        public C1214d(d dVar) {
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
            this.f20160c = dVar;
        }

        public final void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a = (TbImageView) view.findViewById(R.id.image);
                this.f20159b = (ImageView) view.findViewById(R.id.delete_icon);
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.width = this.f20160c.f20154h;
                layoutParams.height = this.f20160c.f20154h;
                SkinManager.setImageResource(this.f20159b, R.drawable.icon_live_close_n);
                this.a.setOnClickListener(new a(this));
                this.f20159b.setOnClickListener(new b(this));
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
        this.f20152f = BdBaseApplication.getInst().getApp();
        this.f20151e = list;
        this.f20153g = new c.a.s0.d0.b();
        int k2 = n.k(this.f20152f);
        this.f20155i = k2;
        this.f20154h = (k2 - (n.f(this.f20152f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1214d c1214d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, viewGroup, c1214d) == null) || imageFileInfo == null) {
            return;
        }
        imageFileInfo.clearPageActions();
        int i2 = this.f20154h;
        imageFileInfo.addPageAction(c.a.s0.d0.i.d.g(i2, i2));
        c.a.d.n.d.a c2 = this.f20153g.c(imageFileInfo, false);
        c1214d.a.setTag(imageFileInfo.toCachedKey(false));
        if (c2 != null) {
            c2.h(c1214d.a);
            c1214d.a.setTag(null);
        } else {
            this.f20153g.e(imageFileInfo, new b(this, viewGroup), false, false);
        }
        c1214d.f20159b.setVisibility(0);
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1214d c1214d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, viewGroup, c1214d) == null) || emotionImageData == null) {
            return;
        }
        Object k2 = c.a.d.f.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1214d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
        c.a.d.n.d.a aVar = (k2 == null || !(k2 instanceof c.a.d.n.d.a)) ? null : (c.a.d.n.d.a) k2;
        if (aVar != null) {
            aVar.h(c1214d.a);
            c1214d.a.setTag(null);
        }
        c1214d.f20159b.setVisibility(0);
    }

    public final void e(EmotionImageData emotionImageData, C1214d c1214d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionImageData, c1214d) == null) || emotionImageData == null) {
            return;
        }
        c1214d.a.setTag(emotionImageData.getThumbUrl());
        c1214d.a.startLoad(emotionImageData.getThumbUrl(), 10, false);
        c1214d.f20159b.setVisibility(0);
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f20156j = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<FaceData> list = this.f20151e;
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
            List<FaceData> list = this.f20151e;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f20151e.get(i2);
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
        C1214d c1214d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1214d = new C1214d(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
                c1214d.b(view2);
                view2.setTag(c1214d);
            } else {
                view2 = view;
                c1214d = (C1214d) view.getTag();
            }
            FaceData faceData = this.f20151e.get(i2);
            if (faceData != null) {
                int i3 = faceData.type;
                if (i3 == 4) {
                    SkinManager.setImageResource(c1214d.a, R.drawable.emotion_icon_add_pic);
                    c1214d.f20159b.setVisibility(8);
                } else if (i3 == 1) {
                    c1214d.a.setImageDrawable(null);
                    d(faceData.emotionImageData, viewGroup, c1214d);
                } else if (i3 == 2) {
                    c1214d.a.setImageDrawable(null);
                    e(faceData.emotionImageData, c1214d);
                } else {
                    c1214d.a.setImageDrawable(null);
                    c(faceData.imageFileInfo, viewGroup, c1214d);
                }
                TbImageView tbImageView = c1214d.a;
                tbImageView.setTag(tbImageView.getId(), faceData);
            }
            c1214d.f20159b.setTag(faceData);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
