package c.a.r0.k2.k.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class q extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20378e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.d0.b f20379f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f20380g;

    /* renamed from: h  reason: collision with root package name */
    public int f20381h;

    /* renamed from: i  reason: collision with root package name */
    public int f20382i;

    /* renamed from: j  reason: collision with root package name */
    public c f20383j;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f20384e;

        public a(q qVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20384e = viewGroup;
        }

        @Override // c.a.q0.c0.b
        public void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f20384e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f20385a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20386b;

        public b(q qVar, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20385a = viewGroup;
            this.f20386b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || (tbImageView = (TbImageView) this.f20385a.findViewWithTag(this.f20386b)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onClickImage(int i2);

        void onDeleteImage(int i2);
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f20387a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f20388b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f20389c;

        public d() {
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
    }

    public q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20378e = null;
        this.f20379f = new c.a.q0.d0.b();
        this.f20380g = null;
        this.f20378e = context;
        int k = c.a.e.e.p.l.k(context);
        this.f20382i = k;
        this.f20381h = ((k - (c.a.e.e.p.l.g(this.f20378e, R.dimen.tbds44) * 2)) - (c.a.e.e.p.l.g(this.f20378e, R.dimen.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, dVar, viewGroup) == null) || imageFileInfo == null) {
            return;
        }
        int i2 = this.f20381h;
        ImageOperation g2 = c.a.q0.d0.i.d.g(i2, i2);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        if (imageFileInfo.getImageType() == 0) {
            c.a.e.l.d.a c2 = this.f20379f.c(imageFileInfo, true);
            dVar.f20387a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.f20387a.invalidate();
            } else {
                this.f20379f.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.f20387a.setTagStr(this.f20378e.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!c.a.e.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = c.a.e.e.l.d.h().g(filePath, 20);
                dVar.f20387a.setTag(g3);
                c.a.e.e.l.d.h().k(filePath, 20, new b(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.f20387a.setTagStr("");
        }
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f20383j = cVar;
        }
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, linkedList) == null) {
            this.f20380g = linkedList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.f20380g;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.f20380g;
            if (linkedList == null) {
                return null;
            }
            if (linkedList.size() - 1 >= i2) {
                return this.f20380g.get(i2);
            }
            return 0;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d();
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
                dVar.f20387a = (TbImageView) view2.findViewById(R.id.iv_photo_live);
                dVar.f20388b = (LinearLayout) view2.findViewById(R.id.layout_del);
                dVar.f20389c = (ImageView) view2.findViewById(R.id.delete_photo_live);
                dVar.f20387a.setOnClickListener(this);
                dVar.f20387a.setTagTextSize(c.a.e.e.p.l.g(this.f20378e, R.dimen.tbds30));
                dVar.f20387a.setDrawBorder(true);
                dVar.f20387a.setDrawCorner(false);
                dVar.f20387a.setRadius(0);
                dVar.f20388b.setOnClickListener(this);
                dVar.f20387a.setGifIconSupport(true);
                dVar.f20387a.setLongIconSupport(true);
                SkinManager.setBackgroundResource(dVar.f20389c, R.drawable.icon_delete_img);
                ViewGroup.LayoutParams layoutParams = dVar.f20387a.getLayoutParams();
                int i3 = this.f20381h;
                layoutParams.width = i3;
                layoutParams.height = i3;
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            LinkedList<ImageFileInfo> linkedList = this.f20380g;
            if (linkedList != null && linkedList.size() - 1 >= i2) {
                a(this.f20380g.get(i2), dVar, viewGroup);
                TbImageView tbImageView = dVar.f20387a;
                tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i2));
                dVar.f20388b.setTag(Integer.valueOf(i2));
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int id = view.getId();
            if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
                c cVar2 = this.f20383j;
                if (cVar2 != null) {
                    cVar2.onDeleteImage(((Integer) view.getTag()).intValue());
                }
            } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && (cVar = this.f20383j) != null) {
                cVar.onClickImage(((Integer) view.getTag(view.getId())).intValue());
            }
        }
    }
}
