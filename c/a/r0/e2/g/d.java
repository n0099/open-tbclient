package c.a.r0.e2.g;

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
    public List<FaceData> f17301e;

    /* renamed from: f  reason: collision with root package name */
    public Context f17302f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.d0.b f17303g;

    /* renamed from: h  reason: collision with root package name */
    public int f17304h;

    /* renamed from: i  reason: collision with root package name */
    public int f17305i;

    /* renamed from: j  reason: collision with root package name */
    public c f17306j;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f17307a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C0839d f17308b;

        public a(d dVar, ViewGroup viewGroup, C0839d c0839d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup, c0839d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17307a = viewGroup;
            this.f17308b = c0839d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            View findViewWithTag;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null || (findViewWithTag = this.f17307a.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                return;
            }
            aVar.h(this.f17308b.f17310a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f17309e;

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
            this.f17309e = viewGroup;
        }

        @Override // c.a.q0.c0.b
        public void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f17309e.findViewWithTag(str)) == null || aVar == null) {
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

    /* renamed from: c.a.r0.e2.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0839d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f17310a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f17311b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f17312c;

        /* renamed from: c.a.r0.e2.g.d$d$a */
        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0839d f17313e;

            public a(C0839d c0839d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0839d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17313e = c0839d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f17313e.f17312c.f17306j != null && view.getTag(view.getId()) != null && (view.getTag(view.getId()) instanceof FaceData) && ((FaceData) view.getTag(view.getId())).type == 4) {
                    this.f17313e.f17312c.f17306j.onAdd();
                }
            }
        }

        /* renamed from: c.a.r0.e2.g.d$d$b */
        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0839d f17314e;

            public b(C0839d c0839d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0839d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17314e = c0839d;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17314e.f17312c.f17306j == null || view.getTag() == null || !(view.getTag() instanceof FaceData)) {
                    return;
                }
                this.f17314e.f17312c.f17306j.onDel((FaceData) view.getTag());
            }
        }

        public C0839d(d dVar) {
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
            this.f17312c = dVar;
        }

        public final void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f17310a = (TbImageView) view.findViewById(R.id.image);
                this.f17311b = (ImageView) view.findViewById(R.id.delete_icon);
                ViewGroup.LayoutParams layoutParams = this.f17310a.getLayoutParams();
                layoutParams.width = this.f17312c.f17304h;
                layoutParams.height = this.f17312c.f17304h;
                SkinManager.setImageResource(this.f17311b, R.drawable.icon_live_close_n);
                this.f17310a.setOnClickListener(new a(this));
                this.f17311b.setOnClickListener(new b(this));
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
        this.f17302f = BdBaseApplication.getInst().getApp();
        this.f17301e = list;
        this.f17303g = new c.a.q0.d0.b();
        int k = l.k(this.f17302f);
        this.f17305i = k;
        this.f17304h = (k - (l.g(this.f17302f, R.dimen.ds30) * 3)) / 4;
    }

    public final void c(ImageFileInfo imageFileInfo, ViewGroup viewGroup, C0839d c0839d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, viewGroup, c0839d) == null) || imageFileInfo == null) {
            return;
        }
        imageFileInfo.clearPageActions();
        int i2 = this.f17304h;
        imageFileInfo.addPageAction(c.a.q0.d0.i.d.g(i2, i2));
        c.a.e.l.d.a c2 = this.f17303g.c(imageFileInfo, false);
        c0839d.f17310a.setTag(imageFileInfo.toCachedKey(false));
        if (c2 != null) {
            c2.h(c0839d.f17310a);
            c0839d.f17310a.setTag(null);
        } else {
            this.f17303g.e(imageFileInfo, new b(this, viewGroup), false, false);
        }
        c0839d.f17311b.setVisibility(0);
    }

    public final void d(EmotionImageData emotionImageData, ViewGroup viewGroup, C0839d c0839d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionImageData, viewGroup, c0839d) == null) || emotionImageData == null) {
            return;
        }
        Object k = c.a.e.e.l.d.h().k(emotionImageData.getThumbUrl(), 20, new a(this, viewGroup, c0839d), 0, 0, null, null, emotionImageData.getThumbUrl(), Boolean.FALSE, null);
        c.a.e.l.d.a aVar = (k == null || !(k instanceof c.a.e.l.d.a)) ? null : (c.a.e.l.d.a) k;
        if (aVar != null) {
            aVar.h(c0839d.f17310a);
            c0839d.f17310a.setTag(null);
        }
        c0839d.f17311b.setVisibility(0);
    }

    public final void e(EmotionImageData emotionImageData, C0839d c0839d) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, emotionImageData, c0839d) == null) || emotionImageData == null) {
            return;
        }
        c0839d.f17310a.setTag(emotionImageData.getThumbUrl());
        c0839d.f17310a.startLoad(emotionImageData.getThumbUrl(), 10, false);
        c0839d.f17311b.setVisibility(0);
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f17306j = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<FaceData> list = this.f17301e;
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
            List<FaceData> list = this.f17301e;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f17301e.get(i2);
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
        C0839d c0839d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c0839d = new C0839d(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
                c0839d.b(view2);
                view2.setTag(c0839d);
            } else {
                view2 = view;
                c0839d = (C0839d) view.getTag();
            }
            FaceData faceData = this.f17301e.get(i2);
            if (faceData != null) {
                int i3 = faceData.type;
                if (i3 == 4) {
                    SkinManager.setImageResource(c0839d.f17310a, R.drawable.emotion_icon_add_pic);
                    c0839d.f17311b.setVisibility(8);
                } else if (i3 == 1) {
                    c0839d.f17310a.setImageDrawable(null);
                    d(faceData.emotionImageData, viewGroup, c0839d);
                } else if (i3 == 2) {
                    c0839d.f17310a.setImageDrawable(null);
                    e(faceData.emotionImageData, c0839d);
                } else {
                    c0839d.f17310a.setImageDrawable(null);
                    c(faceData.imageFileInfo, viewGroup, c0839d);
                }
                TbImageView tbImageView = c0839d.f17310a;
                tbImageView.setTag(tbImageView.getId(), faceData);
            }
            c0839d.f17311b.setTag(faceData);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
