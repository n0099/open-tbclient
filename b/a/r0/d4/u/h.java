package b.a.r0.d4.u;

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
import b.a.e.e.p.l;
import b.a.q0.x.n;
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
/* loaded from: classes4.dex */
public class h extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<ImageFileInfo> f16110e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16111f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.d0.b f16112g;

    /* renamed from: h  reason: collision with root package name */
    public n f16113h;

    /* renamed from: i  reason: collision with root package name */
    public f f16114i;
    public LayoutInflater j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16115e;

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
            this.f16115e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16115e.f16114i == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 13));
            this.f16115e.f16114i.b();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f16117f;

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
            this.f16117f = hVar;
            this.f16116e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (i2 = this.f16116e) < 0) {
                return;
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.f16117f.getItem(i2);
            if (imageFileInfo.isFromMoreForum) {
                return;
            }
            boolean z = true;
            if (imageFileInfo == null || (imageFileInfo.getImageType() != 1 && !new File(imageFileInfo.getFilePath()).exists())) {
                z = false;
            }
            if (!z) {
                l.I(this.f16117f.f16111f, R.string.editor_mutiiamge_image_error);
                return;
            }
            if (this.f16117f.f16113h != null) {
                this.f16117f.f16113h.sendAction(new b.a.q0.x.a(15, 0, Integer.valueOf(this.f16116e)));
            }
            if (this.f16117f.f16114i != null) {
                this.f16117f.f16114i.c(this.f16116e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f16119f;

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
            this.f16119f = hVar;
            this.f16118e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16119f.f16114i == null) {
                return;
            }
            this.f16119f.f16114i.a(this.f16118e);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16120e;

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
            this.f16120e = viewGroup;
        }

        @Override // b.a.q0.c0.b
        public void imageLoaded(b.a.e.l.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f16120e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends b.a.e.e.l.c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16121a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f16122b;

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
            this.f16121a = viewGroup;
            this.f16122b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || (tbImageView = (TbImageView) this.f16121a.findViewWithTag(this.f16122b)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(int i2);
    }

    public h(Context context, b.a.q0.d0.b bVar, n nVar, f fVar) {
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
        this.f16110e = new ArrayList();
        this.k = false;
        this.l = false;
        this.f16113h = nVar;
        this.f16111f = context;
        this.j = LayoutInflater.from(context);
        this.f16112g = bVar;
        this.f16114i = fVar;
    }

    public final String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f16111f.getResources().getString(i2) : (String) invokeI.objValue;
    }

    public final void e(ImageFileInfo imageFileInfo, View view, ViewGroup viewGroup, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageFileInfo, view, viewGroup, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || imageFileInfo == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        ImageOperation g2 = b.a.q0.d0.i.d.g(i2, i3);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g2);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
        ((FrameLayout) view.findViewById(R.id.item_root)).setForeground(SkinManager.getDrawable(R.drawable.new_frame_add_photo_foreground_selector));
        if (imageFileInfo.getImageType() == 0) {
            b.a.e.l.d.a c2 = this.f16112g.c(imageFileInfo, true);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                tbImageView.invalidate();
            } else {
                this.f16112g.d(imageFileInfo, new d(this, viewGroup), true);
            }
            tbImageView.setTagStr(this.f16111f.getString(R.string.edit));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!b.a.e.e.p.k.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g3 = b.a.e.e.l.d.h().g(filePath, 20);
                tbImageView.setTag(g3);
                b.a.e.e.l.d.h().k(filePath, 20, new e(this, viewGroup, g3), 0, 0, null, null, filePath, Boolean.FALSE, null);
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
        this.f16110e.clear();
        if (count > 0) {
            this.f16110e.addAll(writeImagesInfo.getChosedFiles());
        }
        if (count >= this.m || !this.k || !this.l || count <= 0) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("FLAG_ADD_ICON");
        this.f16110e.add(imageFileInfo);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16110e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f16110e.get(i2) : invokeI.objValue;
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
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.f16110e, i2);
            if (imageFileInfo == null) {
                return null;
            }
            if (view == null) {
                view = this.j.inflate(R.layout.new_frame_editor_muti_image_item, (ViewGroup) null);
            }
            int k = (l.k(this.f16111f) - ((l.g(this.f16111f, R.dimen.tbds44) * 2) + (l.g(this.f16111f, R.dimen.tbds10) * 2))) / 3;
            if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
                layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
                layoutParams.width = k;
                layoutParams.height = k;
            } else {
                layoutParams = new AbsListView.LayoutParams(k, k);
            }
            view.setLayoutParams(layoutParams);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
            tbImageView.setTagTextSize(l.g(this.f16111f, R.dimen.T_X10));
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
                    tbImageView.setTagColor(this.f16111f.getResources().getColor(R.color.CAM_X0101));
                } else {
                    tbImageView.setTagColor(this.f16111f.getResources().getColor(R.color.CAM_X0101));
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
