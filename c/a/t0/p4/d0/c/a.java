package c.a.t0.p4.d0.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.p4.f;
import c.a.t0.p4.g;
import c.a.t0.p4.h;
import c.a.t0.p4.j;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f21072e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.d0.b f21073f;

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f21074g;

    /* renamed from: h  reason: collision with root package name */
    public int f21075h;

    /* renamed from: i  reason: collision with root package name */
    public int f21076i;

    /* renamed from: j  reason: collision with root package name */
    public BaseActivity f21077j;
    public LinkedList<ImageFileInfo> k;
    public GridView l;
    public e m;

    /* renamed from: c.a.t0.p4.d0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1321a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1321a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.t0.p4.d0.c.a.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.k == null) {
                return;
            }
            if (this.a.k.size() - 1 >= i2) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) this.a.k.remove(i2);
                if (imageFileInfo.isTempFile()) {
                    c.a.d.f.a.d.f().a(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            int size = this.a.k.size();
            if (this.a.f21074g != null) {
                this.a.f21074g.sendAction(new c.a.s0.x.a(this.a.f21075h, -1, null));
                if (size > 0) {
                    this.a.f21074g.sendAction(new c.a.s0.x.a(2, 10, String.valueOf(size)));
                } else {
                    this.a.f21074g.sendAction(new c.a.s0.x.a(2, 10, null));
                }
                if (this.a.k.size() == 1 && size == 0) {
                    this.a.f21074g.sendAction(new c.a.s0.x.a(1, 2, null));
                }
            }
            this.a.k();
            ((WriteActivity) this.a.f21077j).updateChoseFile(this.a.k);
            this.a.h();
            this.a.notifyDataSetChanged();
            this.a.l.invalidateViews();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.s0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f21078e;

        public b(a aVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21078e = viewGroup;
        }

        @Override // c.a.s0.c0.b
        public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
            ViewGroup viewGroup;
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (viewGroup = this.f21078e) == null || (tbImageView = (TbImageView) viewGroup.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f21079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f21080f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f21081g;

        public c(a aVar, ViewGroup viewGroup, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21081g = aVar;
            this.f21079e = viewGroup;
            this.f21080f = z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
            if (r3.length() != 0) goto L20;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            int indexOfChild;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (indexOfChild = this.f21079e.indexOfChild(view)) < 0) {
                return;
            }
            boolean z = true;
            if (this.f21080f && (this.f21081g.f21077j instanceof WriteActivity)) {
                if (this.f21081g.k != null && this.f21081g.k.size() > 0) {
                    this.f21081g.k.remove(this.f21081g.k.size() - 1);
                }
                ((WriteActivity) this.f21081g.f21077j).updateChoseFile(this.f21081g.k);
                ((WriteActivity) this.f21081g.f21077j).openImageActivity(null);
                return;
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.f21081g.getItem(indexOfChild);
            if (imageFileInfo != null) {
                File file = new File(imageFileInfo.getFilePath());
                if (file.exists()) {
                }
            }
            z = false;
            if (!z) {
                n.J(this.f21081g.f21072e, j.editor_mutiiamge_image_error);
            } else if (this.f21081g.f21074g != null) {
                if (this.f21081g.j()) {
                    this.f21081g.k();
                }
                ((WriteActivity) this.f21081g.f21077j).updateChoseFile(this.f21081g.k);
                this.f21081g.f21074g.sendAction(new c.a.s0.x.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21082e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f21083f;

        public d(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21083f = aVar;
            this.f21082e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21083f.m == null) {
                return;
            }
            this.f21083f.m.a(this.f21082e);
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i2);
    }

    public a(BaseActivity baseActivity, WriteImagesInfo writeImagesInfo, GridView gridView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, writeImagesInfo, gridView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21072e = null;
        this.f21073f = new c.a.s0.d0.b();
        this.f21074g = null;
        this.f21075h = 13;
        this.f21076i = 6;
        this.f21077j = null;
        this.k = null;
        this.l = null;
        this.m = new C1321a(this);
        this.f21077j = baseActivity;
        this.f21072e = baseActivity.getActivity();
        this.l = gridView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.k;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.k;
            if (linkedList == null) {
                return null;
            }
            if (linkedList.size() - 1 >= i2) {
                return this.k.get(i2);
            }
            return 0;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c.a.s0.d0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = false;
            View inflate = LayoutInflater.from(this.f21072e).inflate(h.photo_live_grid_item, viewGroup, false);
            LinkedList<ImageFileInfo> linkedList = this.k;
            c.a.d.n.d.a aVar = null;
            ImageFileInfo imageFileInfo = (linkedList == null || linkedList.size() - 1 < i2) ? null : this.k.get(i2);
            View findViewById = inflate.findViewById(g.item_root_photo_live);
            FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(g.shadow_container_photo_live);
            TbImageView tbImageView = (TbImageView) findViewById.findViewById(g.iv_photo_live);
            ImageView imageView = (ImageView) findViewById.findViewById(g.delete_photo_live);
            String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
            LinkedList<ImageFileInfo> linkedList2 = this.k;
            if (linkedList2 != null && i2 == linkedList2.size() - 1 && filePath.startsWith("android.resource://")) {
                z = true;
            }
            if (z) {
                imageView.setVisibility(8);
                SkinManager.setImageResource(tbImageView, f.btn_addpic_n);
            } else {
                SkinManager.setImageResource(imageView, f.icon_live_close_n);
            }
            frameLayout.setForeground(SkinManager.getDrawable(f.bg_add_photo_foregroundselector));
            int dimensionPixelSize = this.f21072e.getResources().getDimensionPixelSize(c.a.t0.p4.e.ds206);
            ImageOperation g2 = c.a.s0.d0.i.d.g(dimensionPixelSize, dimensionPixelSize);
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(g2);
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
            }
            b bVar2 = new b(this, viewGroup);
            if (imageFileInfo != null && (bVar = this.f21073f) != null) {
                aVar = bVar.d(imageFileInfo, bVar2, true);
            }
            if (aVar != null) {
                tbImageView.invalidate();
            }
            inflate.setOnClickListener(new c(this, viewGroup, z));
            imageView.setOnClickListener(new d(this, i2));
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<ImageFileInfo> linkedList = this.k;
            if (linkedList != null && linkedList.size() != 0) {
                if (this.k.size() >= this.f21076i) {
                    return;
                }
                if (this.k.size() > 0) {
                    LinkedList<ImageFileInfo> linkedList2 = this.k;
                    if (linkedList2.get(linkedList2.size() - 1).getFilePath().startsWith("android.resource://")) {
                        return;
                    }
                }
                i();
                return;
            }
            i();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath("android.resource://" + this.f21072e.getPackageName() + "/" + f.btn_addpic_n);
            imageFileInfo.setTempFile(true);
            if (this.k == null) {
                this.k = new LinkedList<>();
            }
            this.k.add(imageFileInfo);
            notifyDataSetChanged();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.k;
            if (linkedList != null && linkedList.size() != 0) {
                LinkedList<ImageFileInfo> linkedList2 = this.k;
                if (linkedList2.get(linkedList2.size() - 1).getFilePath().startsWith("android.resource://")) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        LinkedList<ImageFileInfo> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (linkedList = this.k) == null || linkedList.size() <= 0) {
            return;
        }
        int size = this.k.size() - 1;
        if (this.k.get(size).getFilePath().startsWith("android.resource://")) {
            this.k.remove(size);
        }
    }

    public void l(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, writeImagesInfo) == null) {
            if (writeImagesInfo == null) {
                writeImagesInfo = new WriteImagesInfo();
            }
            if (this.k == null) {
                this.k = new LinkedList<>();
            }
            this.k.clear();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.size() > 0) {
                this.k.addAll(writeImagesInfo.getChosedFiles());
            }
            h();
            notifyDataSetInvalidated();
        }
    }

    public void m(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editorTools) == null) {
            this.f21074g = editorTools;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f21076i = i2;
        }
    }
}
