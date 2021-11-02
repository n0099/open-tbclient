package b.a.r0.k2.u.f;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class q extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f19368e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.d0.b f19369f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f19370g;

    /* renamed from: h  reason: collision with root package name */
    public int f19371h;

    /* renamed from: i  reason: collision with root package name */
    public int f19372i;
    public c j;

    /* loaded from: classes5.dex */
    public class a implements b.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f19373e;

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
            this.f19373e = viewGroup;
        }

        @Override // b.a.q0.c0.b
        public void imageLoaded(b.a.e.l.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f19373e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f19374a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19375b;

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
            this.f19374a = viewGroup;
            this.f19375b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || (tbImageView = (TbImageView) this.f19374a.findViewWithTag(this.f19375b)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onClickImage(int i2);

        void onDeleteImage(int i2);
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f19376a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f19377b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f19378c;

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
        this.f19368e = null;
        this.f19369f = new b.a.q0.d0.b();
        this.f19370g = null;
        this.f19368e = context;
        int k = b.a.e.e.p.l.k(context);
        this.f19372i = k;
        this.f19371h = ((k - (b.a.e.e.p.l.g(this.f19368e, b.a.r0.k2.g.tbds44) * 2)) - (b.a.e.e.p.l.g(this.f19368e, b.a.r0.k2.g.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, dVar, viewGroup) == null) || imageFileInfo == null) {
            return;
        }
        int i2 = this.f19371h;
        ImageOperation g2 = b.a.q0.d0.i.d.g(i2, i2);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        if (imageFileInfo.getImageType() == 0) {
            b.a.e.l.d.a c2 = this.f19369f.c(imageFileInfo, true);
            dVar.f19376a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.f19376a.invalidate();
            } else {
                this.f19369f.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.f19376a.setTagStr(this.f19368e.getString(b.a.r0.k2.l.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!b.a.e.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = b.a.e.e.l.d.h().g(filePath, 20);
                dVar.f19376a.setTag(g3);
                b.a.e.e.l.d.h().k(filePath, 20, new b(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.f19376a.setTagStr("");
        }
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, linkedList) == null) {
            this.f19370g = linkedList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.f19370g;
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
            LinkedList<ImageFileInfo> linkedList = this.f19370g;
            if (linkedList == null) {
                return null;
            }
            if (linkedList.size() - 1 >= i2) {
                return this.f19370g.get(i2);
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
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(b.a.r0.k2.j.pb_editor_imgs_item, (ViewGroup) null);
                dVar.f19376a = (TbImageView) view2.findViewById(b.a.r0.k2.i.iv_photo_live);
                dVar.f19377b = (LinearLayout) view2.findViewById(b.a.r0.k2.i.layout_del);
                dVar.f19378c = (ImageView) view2.findViewById(b.a.r0.k2.i.delete_photo_live);
                dVar.f19376a.setOnClickListener(this);
                dVar.f19376a.setTagTextSize(b.a.e.e.p.l.g(this.f19368e, b.a.r0.k2.g.tbds30));
                dVar.f19376a.setDrawBorder(true);
                dVar.f19376a.setDrawCorner(false);
                dVar.f19376a.setRadius(0);
                dVar.f19377b.setOnClickListener(this);
                dVar.f19376a.setGifIconSupport(true);
                dVar.f19376a.setLongIconSupport(true);
                SkinManager.setBackgroundResource(dVar.f19378c, b.a.r0.k2.h.icon_delete_img);
                ViewGroup.LayoutParams layoutParams = dVar.f19376a.getLayoutParams();
                int i3 = this.f19371h;
                layoutParams.width = i3;
                layoutParams.height = i3;
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            LinkedList<ImageFileInfo> linkedList = this.f19370g;
            if (linkedList != null && linkedList.size() - 1 >= i2) {
                a(this.f19370g.get(i2), dVar, viewGroup);
                TbImageView tbImageView = dVar.f19376a;
                tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i2));
                dVar.f19377b.setTag(Integer.valueOf(i2));
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
            if (id == b.a.r0.k2.i.layout_del && (view.getTag() instanceof Integer)) {
                c cVar2 = this.j;
                if (cVar2 != null) {
                    cVar2.onDeleteImage(((Integer) view.getTag()).intValue());
                }
            } else if (id == b.a.r0.k2.i.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && (cVar = this.j) != null) {
                cVar.onClickImage(((Integer) view.getTag(view.getId())).intValue());
            }
        }
    }
}
