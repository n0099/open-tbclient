package c.a.q0.i2.k.e;

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
public class p extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f19491e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.c0.b f19492f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f19493g;

    /* renamed from: h  reason: collision with root package name */
    public int f19494h;

    /* renamed from: i  reason: collision with root package name */
    public int f19495i;

    /* renamed from: j  reason: collision with root package name */
    public c f19496j;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f19497e;

        public a(p pVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19497e = viewGroup;
        }

        @Override // c.a.p0.b0.b
        public void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f19497e.findViewWithTag(str)) == null || aVar == null) {
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
        public final /* synthetic */ ViewGroup f19498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19499b;

        public b(p pVar, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19498a = viewGroup;
            this.f19499b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || (tbImageView = (TbImageView) this.f19498a.findViewWithTag(this.f19499b)) == null || aVar == null) {
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
        public TbImageView f19500a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f19501b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f19502c;

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

    public p(Context context) {
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
        this.f19491e = null;
        this.f19492f = new c.a.p0.c0.b();
        this.f19493g = null;
        this.f19491e = context;
        int k = c.a.e.e.p.l.k(context);
        this.f19495i = k;
        this.f19494h = ((k - (c.a.e.e.p.l.g(this.f19491e, R.dimen.tbds44) * 2)) - (c.a.e.e.p.l.g(this.f19491e, R.dimen.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, dVar, viewGroup) == null) || imageFileInfo == null) {
            return;
        }
        int i2 = this.f19494h;
        ImageOperation g2 = c.a.p0.c0.i.d.g(i2, i2);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        if (imageFileInfo.getImageType() == 0) {
            c.a.e.l.d.a c2 = this.f19492f.c(imageFileInfo, true);
            dVar.f19500a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.f19500a.invalidate();
            } else {
                this.f19492f.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.f19500a.setTagStr(this.f19491e.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!c.a.e.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = c.a.e.e.l.d.h().g(filePath, 20);
                dVar.f19500a.setTag(g3);
                c.a.e.e.l.d.h().k(filePath, 20, new b(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.f19500a.setTagStr("");
        }
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f19496j = cVar;
        }
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, linkedList) == null) {
            this.f19493g = linkedList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.f19493g;
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
            LinkedList<ImageFileInfo> linkedList = this.f19493g;
            if (linkedList == null) {
                return null;
            }
            if (linkedList.size() - 1 >= i2) {
                return this.f19493g.get(i2);
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
                dVar.f19500a = (TbImageView) view2.findViewById(R.id.iv_photo_live);
                dVar.f19501b = (LinearLayout) view2.findViewById(R.id.layout_del);
                dVar.f19502c = (ImageView) view2.findViewById(R.id.delete_photo_live);
                dVar.f19500a.setOnClickListener(this);
                dVar.f19500a.setTagTextSize(c.a.e.e.p.l.g(this.f19491e, R.dimen.tbds30));
                dVar.f19500a.setDrawBorder(true);
                dVar.f19500a.setDrawCorner(false);
                dVar.f19500a.setRadius(0);
                dVar.f19501b.setOnClickListener(this);
                dVar.f19500a.setGifIconSupport(true);
                dVar.f19500a.setLongIconSupport(true);
                SkinManager.setBackgroundResource(dVar.f19502c, R.drawable.icon_delete_img);
                ViewGroup.LayoutParams layoutParams = dVar.f19500a.getLayoutParams();
                int i3 = this.f19494h;
                layoutParams.width = i3;
                layoutParams.height = i3;
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            LinkedList<ImageFileInfo> linkedList = this.f19493g;
            if (linkedList != null && linkedList.size() - 1 >= i2) {
                a(this.f19493g.get(i2), dVar, viewGroup);
                TbImageView tbImageView = dVar.f19500a;
                tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i2));
                dVar.f19501b.setTag(Integer.valueOf(i2));
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
                c cVar2 = this.f19496j;
                if (cVar2 != null) {
                    cVar2.onDeleteImage(((Integer) view.getTag()).intValue());
                }
            } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && (cVar = this.f19496j) != null) {
                cVar.onClickImage(((Integer) view.getTag(view.getId())).intValue());
            }
        }
    }
}
