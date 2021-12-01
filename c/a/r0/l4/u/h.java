package c.a.r0.l4.u;

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
import c.a.d.f.p.l;
import c.a.q0.x.n;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<ImageFileInfo> f19705e;

    /* renamed from: f  reason: collision with root package name */
    public Context f19706f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.d0.b f19707g;

    /* renamed from: h  reason: collision with root package name */
    public n f19708h;

    /* renamed from: i  reason: collision with root package name */
    public f f19709i;

    /* renamed from: j  reason: collision with root package name */
    public LayoutInflater f19710j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f19711k;
    public boolean l;
    public int m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f19712e;

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
            this.f19712e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19712e.f19709i == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 13));
            this.f19712e.f19709i.b();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f19714f;

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
            this.f19714f = hVar;
            this.f19713e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (i2 = this.f19713e) < 0) {
                return;
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.f19714f.getItem(i2);
            if (imageFileInfo.isFromMoreForum) {
                return;
            }
            boolean z = true;
            if (imageFileInfo == null || (imageFileInfo.getImageType() != 1 && !new File(imageFileInfo.getFilePath()).exists())) {
                z = false;
            }
            if (!z) {
                l.I(this.f19714f.f19706f, R.string.editor_mutiiamge_image_error);
                return;
            }
            if (this.f19714f.f19708h != null) {
                this.f19714f.f19708h.sendAction(new c.a.q0.x.a(15, 0, Integer.valueOf(this.f19713e)));
            }
            if (this.f19714f.f19709i != null) {
                this.f19714f.f19709i.c(this.f19713e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19715e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f19716f;

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
            this.f19716f = hVar;
            this.f19715e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19716f.f19709i == null) {
                return;
            }
            this.f19716f.f19709i.a(this.f19715e);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f19717e;

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
            this.f19717e = viewGroup;
        }

        @Override // c.a.q0.c0.b
        public void imageLoaded(c.a.d.m.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f19717e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends c.a.d.f.l.c<c.a.d.m.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19718b;

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
            this.f19718b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(this.f19718b)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(int i2);
    }

    public h(Context context, c.a.q0.d0.b bVar, n nVar, f fVar) {
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
        this.f19705e = new ArrayList();
        this.f19711k = false;
        this.l = false;
        this.f19708h = nVar;
        this.f19706f = context;
        this.f19710j = LayoutInflater.from(context);
        this.f19707g = bVar;
        this.f19709i = fVar;
    }

    public final String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f19706f.getResources().getString(i2) : (String) invokeI.objValue;
    }

    public final void e(ImageFileInfo imageFileInfo, View view, ViewGroup viewGroup, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageFileInfo, view, viewGroup, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || imageFileInfo == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        ImageOperation g2 = c.a.q0.d0.i.d.g(i2, i3);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
        ((FrameLayout) view.findViewById(R.id.item_root)).setForeground(SkinManager.getDrawable(R.drawable.new_frame_add_photo_foreground_selector));
        if (imageFileInfo.getImageType() == 0) {
            c.a.d.m.d.a c2 = this.f19707g.c(imageFileInfo, true);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                tbImageView.invalidate();
            } else {
                this.f19707g.d(imageFileInfo, new d(this, viewGroup), true);
            }
            tbImageView.setTagStr(this.f19706f.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!c.a.d.f.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
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
        this.f19705e.clear();
        if (count > 0) {
            this.f19705e.addAll(writeImagesInfo.getChosedFiles());
        }
        if (count >= this.m || !this.f19711k || !this.l || count <= 0) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("FLAG_ADD_ICON");
        this.f19705e.add(imageFileInfo);
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f19711k = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19705e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f19705e.get(i2) : invokeI.objValue;
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
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f19705e, i2);
            if (imageFileInfo == null) {
                return null;
            }
            if (view == null) {
                view = this.f19710j.inflate(R.layout.new_frame_editor_muti_image_item, (ViewGroup) null);
            }
            int k2 = (l.k(this.f19706f) - ((l.f(this.f19706f, R.dimen.tbds44) * 2) + (l.f(this.f19706f, R.dimen.tbds10) * 2))) / 3;
            if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
                layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
                layoutParams.width = k2;
                layoutParams.height = k2;
            } else {
                layoutParams = new AbsListView.LayoutParams(k2, k2);
            }
            view.setLayoutParams(layoutParams);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
            tbImageView.setTagTextSize(l.f(this.f19706f, R.dimen.T_X10));
            tbImageView.setDrawBorder(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setAutoChangeStyle(true);
            tbImageView.setConrers(15);
            tbImageView.setRadiusById(R.string.J_X05);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.delete_info);
            ((ImageView) view.findViewById(R.id.delete)).setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.item_root);
            if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
                tbImageView.setVisibility(8);
                linearLayout.setVisibility(8);
                view.setBackgroundDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pure_post_add, WebPManager.ResourceStateType.NORMAL_PRESS));
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
                tbImageView.setTagStr(d(R.string.edit));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    tbImageView.setTagColor(this.f19706f.getResources().getColor(R.color.CAM_X0101));
                } else {
                    tbImageView.setTagColor(this.f19706f.getResources().getColor(R.color.CAM_X0101));
                }
                e(imageFileInfo, view, viewGroup, k2, k2);
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
            this.f19711k = true;
            this.l = z;
        }
    }
}
