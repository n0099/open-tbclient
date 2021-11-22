package b.a.r0.f2.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import b.a.e.f.p.l;
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
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f17940e;

    /* renamed from: f  reason: collision with root package name */
    public Context f17941f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.d0.b f17942g;

    /* renamed from: h  reason: collision with root package name */
    public int f17943h;

    /* renamed from: i  reason: collision with root package name */
    public int f17944i;
    public c j;

    /* loaded from: classes4.dex */
    public class a extends b.a.e.f.l.c<b.a.e.m.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f17945a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C0908d f17946b;

        public a(d dVar, ViewGroup viewGroup, C0908d c0908d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup, c0908d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17945a = viewGroup;
            this.f17946b = c0908d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.f.l.c
        public void onLoaded(b.a.e.m.d.a aVar, String str, int i2) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null || (findViewWithTag = this.f17945a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f17946b.f17948a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f17947e;

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
            this.f17947e = viewGroup;
        }

        @Override // b.a.q0.c0.b
        public void imageLoaded(b.a.e.m.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f17947e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            aVar.h(tbImageView);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onAdd();

        void onDel(FaceData faceData);
    }

    /* renamed from: b.a.r0.f2.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0908d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f17948a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f17949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f17950c;

        /* renamed from: b.a.r0.f2.g.d$d$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0908d f17951e;

            public a(C0908d c0908d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0908d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17951e = c0908d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f17951e.f17950c.j != null && view.getTag(view.getId()) != null && (view.getTag(view.getId()) instanceof FaceData) && ((FaceData) view.getTag(view.getId())).type == 4) {
                    this.f17951e.f17950c.j.onAdd();
                }
            }
        }

        /* renamed from: b.a.r0.f2.g.d$d$b */
        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0908d f17952e;

            public b(C0908d c0908d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0908d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17952e = c0908d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17952e.f17950c.j == null || view.getTag() == null || !(view.getTag() instanceof FaceData)) {
                    return;
                }
                this.f17952e.f17950c.j.onDel((FaceData) view.getTag());
            }
        }

        public C0908d(d dVar) {
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
            this.f17950c = dVar;
        }

        public final void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17948a = (TbImageView) view.findViewById(R.id.image);
                this.f17949b = (ImageView) view.findViewById(R.id.delete_icon);
                ViewGroup.LayoutParams layoutParams = this.f17948a.getLayoutParams();
                layoutParams.width = this.f17950c.f17943h;
                layoutParams.height = this.f17950c.f17943h;
                SkinManager.setImageResource(this.f17949b, R.drawable.icon_live_close_n);
                this.f17948a.setOnClickListener(new a(this));
                this.f17949b.setOnClickListener(new b(this));
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
        this.f17941f = BdBaseApplication.getInst().getApp();
        this.f17940e = list;
        this.f17942g = new b.a.q0.d0.b();
        int k = l.k(this.f17941f);
        this.f17944i = k;
        this.f17943h = (k - (l.g(this.f17941f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C0908d c0908d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, viewGroup, c0908d) == null) || imageFileInfo == null) {
            return;
        }
        imageFileInfo.clearPageActions();
        int i2 = this.f17943h;
        imageFileInfo.addPageAction(b.a.q0.d0.i.d.g(i2, i2));
        b.a.e.m.d.a c2 = this.f17942g.c(imageFileInfo, false);
        c0908d.f17948a.setTag(imageFileInfo.toCachedKey(false));
        if (c2 != null) {
            c2.h(c0908d.f17948a);
            c0908d.f17948a.setTag(null);
        } else {
            this.f17942g.e(imageFileInfo, new b(this, viewGroup), false, false);
        }
        c0908d.f17949b.setVisibility(0);
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C0908d c0908d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, viewGroup, c0908d) == null) || emotionImageData == null) {
            return;
        }
        Object k = b.a.e.f.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c0908d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
        b.a.e.m.d.a aVar = (k == null || !(k instanceof b.a.e.m.d.a)) ? null : (b.a.e.m.d.a) k;
        if (aVar != null) {
            aVar.h(c0908d.f17948a);
            c0908d.f17948a.setTag(null);
        }
        c0908d.f17949b.setVisibility(0);
    }

    public final void e(EmotionImageData emotionImageData, C0908d c0908d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionImageData, c0908d) == null) || emotionImageData == null) {
            return;
        }
        c0908d.f17948a.setTag(emotionImageData.getThumbUrl());
        c0908d.f17948a.startLoad(emotionImageData.getThumbUrl(), 10, false);
        c0908d.f17949b.setVisibility(0);
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.j = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<FaceData> list = this.f17940e;
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
            List<FaceData> list = this.f17940e;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f17940e.get(i2);
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
        C0908d c0908d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0908d = new C0908d(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
                c0908d.b(view2);
                view2.setTag(c0908d);
            } else {
                view2 = view;
                c0908d = (C0908d) view.getTag();
            }
            FaceData faceData = this.f17940e.get(i2);
            if (faceData != null) {
                int i3 = faceData.type;
                if (i3 == 4) {
                    SkinManager.setImageResource(c0908d.f17948a, R.drawable.emotion_icon_add_pic);
                    c0908d.f17949b.setVisibility(8);
                } else if (i3 == 1) {
                    c0908d.f17948a.setImageDrawable(null);
                    d(faceData.emotionImageData, viewGroup, c0908d);
                } else if (i3 == 2) {
                    c0908d.f17948a.setImageDrawable(null);
                    e(faceData.emotionImageData, c0908d);
                } else {
                    c0908d.f17948a.setImageDrawable(null);
                    c(faceData.imageFileInfo, viewGroup, c0908d);
                }
                TbImageView tbImageView = c0908d.f17948a;
                tbImageView.setTag(tbImageView.getId(), faceData);
            }
            c0908d.f17949b.setTag(faceData);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
