package c.a.r0.l2.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import c.a.d.f.p.l;
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
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<FaceData> f19185e;

    /* renamed from: f  reason: collision with root package name */
    public Context f19186f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.d0.b f19187g;

    /* renamed from: h  reason: collision with root package name */
    public int f19188h;

    /* renamed from: i  reason: collision with root package name */
    public int f19189i;

    /* renamed from: j  reason: collision with root package name */
    public c f19190j;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.f.l.c<c.a.d.m.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1143d f19191b;

        public a(d dVar, ViewGroup viewGroup, C1143d c1143d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup, c1143d};
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
            this.f19191b = c1143d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null || (findViewWithTag = this.a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f19191b.a);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f19192e;

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
            this.f19192e = viewGroup;
        }

        @Override // c.a.q0.c0.b
        public void imageLoaded(c.a.d.m.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f19192e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            aVar.h(tbImageView);
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onAdd();

        void onDel(FaceData faceData);
    }

    /* renamed from: c.a.r0.l2.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1143d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f19193b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f19194c;

        /* renamed from: c.a.r0.l2.g.d$d$a */
        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1143d f19195e;

            public a(C1143d c1143d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1143d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19195e = c1143d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f19195e.f19194c.f19190j != null && view.getTag(view.getId()) != null && (view.getTag(view.getId()) instanceof FaceData) && ((FaceData) view.getTag(view.getId())).type == 4) {
                    this.f19195e.f19194c.f19190j.onAdd();
                }
            }
        }

        /* renamed from: c.a.r0.l2.g.d$d$b */
        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1143d f19196e;

            public b(C1143d c1143d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1143d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19196e = c1143d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19196e.f19194c.f19190j == null || view.getTag() == null || !(view.getTag() instanceof FaceData)) {
                    return;
                }
                this.f19196e.f19194c.f19190j.onDel((FaceData) view.getTag());
            }
        }

        public C1143d(d dVar) {
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
            this.f19194c = dVar;
        }

        public final void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a = (TbImageView) view.findViewById(R.id.image);
                this.f19193b = (ImageView) view.findViewById(R.id.delete_icon);
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.width = this.f19194c.f19188h;
                layoutParams.height = this.f19194c.f19188h;
                SkinManager.setImageResource(this.f19193b, R.drawable.icon_live_close_n);
                this.a.setOnClickListener(new a(this));
                this.f19193b.setOnClickListener(new b(this));
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
        this.f19186f = BdBaseApplication.getInst().getApp();
        this.f19185e = list;
        this.f19187g = new c.a.q0.d0.b();
        int k2 = l.k(this.f19186f);
        this.f19189i = k2;
        this.f19188h = (k2 - (l.f(this.f19186f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C1143d c1143d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, viewGroup, c1143d) == null) || imageFileInfo == null) {
            return;
        }
        imageFileInfo.clearPageActions();
        int i2 = this.f19188h;
        imageFileInfo.addPageAction(c.a.q0.d0.i.d.g(i2, i2));
        c.a.d.m.d.a c2 = this.f19187g.c(imageFileInfo, false);
        c1143d.a.setTag(imageFileInfo.toCachedKey(false));
        if (c2 != null) {
            c2.h(c1143d.a);
            c1143d.a.setTag(null);
        } else {
            this.f19187g.e(imageFileInfo, new b(this, viewGroup), false, false);
        }
        c1143d.f19193b.setVisibility(0);
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C1143d c1143d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, viewGroup, c1143d) == null) || emotionImageData == null) {
            return;
        }
        Object k2 = c.a.d.f.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c1143d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
        c.a.d.m.d.a aVar = (k2 == null || !(k2 instanceof c.a.d.m.d.a)) ? null : (c.a.d.m.d.a) k2;
        if (aVar != null) {
            aVar.h(c1143d.a);
            c1143d.a.setTag(null);
        }
        c1143d.f19193b.setVisibility(0);
    }

    public final void e(EmotionImageData emotionImageData, C1143d c1143d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionImageData, c1143d) == null) || emotionImageData == null) {
            return;
        }
        c1143d.a.setTag(emotionImageData.getThumbUrl());
        c1143d.a.startLoad(emotionImageData.getThumbUrl(), 10, false);
        c1143d.f19193b.setVisibility(0);
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f19190j = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<FaceData> list = this.f19185e;
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
            List<FaceData> list = this.f19185e;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f19185e.get(i2);
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
        C1143d c1143d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1143d = new C1143d(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
                c1143d.b(view2);
                view2.setTag(c1143d);
            } else {
                view2 = view;
                c1143d = (C1143d) view.getTag();
            }
            FaceData faceData = this.f19185e.get(i2);
            if (faceData != null) {
                int i3 = faceData.type;
                if (i3 == 4) {
                    SkinManager.setImageResource(c1143d.a, R.drawable.emotion_icon_add_pic);
                    c1143d.f19193b.setVisibility(8);
                } else if (i3 == 1) {
                    c1143d.a.setImageDrawable(null);
                    d(faceData.emotionImageData, viewGroup, c1143d);
                } else if (i3 == 2) {
                    c1143d.a.setImageDrawable(null);
                    e(faceData.emotionImageData, c1143d);
                } else {
                    c1143d.a.setImageDrawable(null);
                    c(faceData.imageFileInfo, viewGroup, c1143d);
                }
                TbImageView tbImageView = c1143d.a;
                tbImageView.setTag(tbImageView.getId(), faceData);
            }
            c1143d.f19193b.setTag(faceData);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
