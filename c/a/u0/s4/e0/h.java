package c.a.u0.s4.e0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.t0.x.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class h extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<ImageFileInfo> f22111e;

    /* renamed from: f  reason: collision with root package name */
    public Context f22112f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.d0.b f22113g;

    /* renamed from: h  reason: collision with root package name */
    public n f22114h;

    /* renamed from: i  reason: collision with root package name */
    public f f22115i;

    /* renamed from: j  reason: collision with root package name */
    public LayoutInflater f22116j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f22117e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22117e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22117e.f22115i == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 13));
            this.f22117e.f22115i.b();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f22119f;

        public b(h hVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22119f = hVar;
            this.f22118e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (i2 = this.f22118e) < 0) {
                return;
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.f22119f.getItem(i2);
            if (imageFileInfo.isFromMoreForum) {
                return;
            }
            boolean z = true;
            if (imageFileInfo == null || (imageFileInfo.getImageType() != 1 && !new File(imageFileInfo.getFilePath()).exists())) {
                z = false;
            }
            if (!z) {
                c.a.d.f.p.n.J(this.f22119f.f22112f, c.a.u0.s4.j.editor_mutiiamge_image_error);
                return;
            }
            if (this.f22119f.f22114h != null) {
                this.f22119f.f22114h.sendAction(new c.a.t0.x.a(15, 0, Integer.valueOf(this.f22118e)));
            }
            if (this.f22119f.f22115i != null) {
                this.f22119f.f22115i.c(this.f22118e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f22121f;

        public c(h hVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22121f = hVar;
            this.f22120e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22121f.f22115i == null) {
                return;
            }
            this.f22121f.f22115i.a(this.f22120e);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements c.a.t0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f22122e;

        public d(h hVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22122e = viewGroup;
        }

        @Override // c.a.t0.c0.b
        public void imageLoaded(c.a.d.o.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f22122e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes9.dex */
    public class e extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22123b;

        public e(h hVar, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, viewGroup, str};
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
            this.f22123b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(this.f22123b)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(int i2);
    }

    public h(Context context, c.a.t0.d0.b bVar, n nVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, nVar, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22111e = new ArrayList();
        this.k = false;
        this.l = false;
        this.f22114h = nVar;
        this.f22112f = context;
        this.f22116j = LayoutInflater.from(context);
        this.f22113g = bVar;
        this.f22115i = fVar;
    }

    public final String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f22112f.getResources().getString(i2) : (String) invokeI.objValue;
    }

    public final void e(ImageFileInfo imageFileInfo, View view, ViewGroup viewGroup, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageFileInfo, view, viewGroup, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || imageFileInfo == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        ImageOperation g2 = c.a.t0.d0.i.d.g(i2, i3);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        TbImageView tbImageView = (TbImageView) view.findViewById(c.a.u0.s4.g.iv);
        ((FrameLayout) view.findViewById(c.a.u0.s4.g.item_root)).setForeground(SkinManager.getDrawable(c.a.u0.s4.f.new_frame_add_photo_foreground_selector));
        if (imageFileInfo.getImageType() == 0) {
            c.a.d.o.d.a c2 = this.f22113g.c(imageFileInfo, true);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                tbImageView.invalidate();
            } else {
                this.f22113g.d(imageFileInfo, new d(this, viewGroup), true);
            }
            tbImageView.setTagStr(this.f22112f.getString(c.a.u0.s4.j.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!m.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = c.a.d.f.l.d.h().g(filePath, 20);
                tbImageView.setTag(g3);
                c.a.d.f.l.d.h().k(filePath, 20, new e(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            tbImageView.setTagStr("");
        }
    }

    public void f(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeImagesInfo) == null) || writeImagesInfo == null) {
            return;
        }
        this.m = writeImagesInfo.getMaxImagesAllowed();
        int count = ListUtils.getCount(writeImagesInfo.getChosedFiles());
        this.f22111e.clear();
        if (count > 0) {
            this.f22111e.addAll(writeImagesInfo.getChosedFiles());
        }
        if (count >= this.m || !this.k || !this.l || count <= 0) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("FLAG_ADD_ICON");
        this.f22111e.add(imageFileInfo);
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.k = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22111e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f22111e.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        AbsListView.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f22111e, i2);
            if (imageFileInfo == null) {
                return null;
            }
            if (view == null) {
                view = this.f22116j.inflate(c.a.u0.s4.h.new_frame_editor_muti_image_item, (ViewGroup) null);
            }
            int k = (c.a.d.f.p.n.k(this.f22112f) - ((c.a.d.f.p.n.f(this.f22112f, c.a.u0.s4.e.tbds44) * 2) + (c.a.d.f.p.n.f(this.f22112f, c.a.u0.s4.e.tbds10) * 2))) / 3;
            if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
                layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
                layoutParams.width = k;
                layoutParams.height = k;
            } else {
                layoutParams = new AbsListView.LayoutParams(k, k);
            }
            view.setLayoutParams(layoutParams);
            TbImageView tbImageView = (TbImageView) view.findViewById(c.a.u0.s4.g.iv);
            tbImageView.setTagTextSize(c.a.d.f.p.n.f(this.f22112f, c.a.u0.s4.e.T_X10));
            tbImageView.setDrawBorder(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setAutoChangeStyle(true);
            tbImageView.setConrers(15);
            tbImageView.setRadiusById(c.a.u0.s4.j.J_X05);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(c.a.u0.s4.g.delete_info);
            ((ImageView) view.findViewById(c.a.u0.s4.g.delete)).setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.s4.f.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            FrameLayout frameLayout = (FrameLayout) view.findViewById(c.a.u0.s4.g.item_root);
            if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
                tbImageView.setVisibility(8);
                linearLayout.setVisibility(8);
                view.setBackgroundDrawable(WebPManager.getMaskDrawable(c.a.u0.s4.f.icon_pure_post_add, WebPManager.ResourceStateType.NORMAL_PRESS));
                view.invalidate();
                frameLayout.setForeground(null);
                view.setOnClickListener(new a(this));
            } else {
                tbImageView.setVisibility(0);
                linearLayout.setVisibility(0);
                view.setBackgroundResource(0);
                tbImageView.setGifIconSupport(true);
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(imageFileInfo.isLong());
                tbImageView.setTagStr(d(c.a.u0.s4.j.edit));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    tbImageView.setTagColor(this.f22112f.getResources().getColor(c.a.u0.s4.d.CAM_X0101));
                } else {
                    tbImageView.setTagColor(this.f22112f.getResources().getColor(c.a.u0.s4.d.CAM_X0101));
                }
                e(imageFileInfo, view, viewGroup, k, k);
                if (imageFileInfo.isFromMoreForum) {
                    linearLayout.setVisibility(8);
                    tbImageView.setTagStr("");
                }
                view.setOnClickListener(new b(this, i2));
                linearLayout.setOnClickListener(new c(this, i2));
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = true;
            this.l = z;
        }
    }
}
