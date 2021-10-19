package c.a.r0.d4.t.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f17066e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.d0.b f17067f;

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f17068g;

    /* renamed from: h  reason: collision with root package name */
    public int f17069h;

    /* renamed from: i  reason: collision with root package name */
    public int f17070i;

    /* renamed from: j  reason: collision with root package name */
    public BaseActivity f17071j;
    public LinkedList<ImageFileInfo> k;
    public GridView l;
    public e m;

    /* renamed from: c.a.r0.d4.t.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0823a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17072a;

        public C0823a(a aVar) {
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
            this.f17072a = aVar;
        }

        @Override // c.a.r0.d4.t.b.a.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f17072a.k == null) {
                return;
            }
            if (this.f17072a.k.size() - 1 >= i2) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) this.f17072a.k.remove(i2);
                if (imageFileInfo.isTempFile()) {
                    c.a.e.e.a.d.g().a(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            int size = this.f17072a.k.size();
            if (this.f17072a.f17068g != null) {
                this.f17072a.f17068g.sendAction(new c.a.q0.x.a(this.f17072a.f17069h, -1, null));
                if (size > 0) {
                    this.f17072a.f17068g.sendAction(new c.a.q0.x.a(2, 10, String.valueOf(size)));
                } else {
                    this.f17072a.f17068g.sendAction(new c.a.q0.x.a(2, 10, null));
                }
                if (this.f17072a.k.size() == 1 && size == 0) {
                    this.f17072a.f17068g.sendAction(new c.a.q0.x.a(1, 2, null));
                }
            }
            this.f17072a.k();
            ((WriteActivity) this.f17072a.f17071j).updateChoseFile(this.f17072a.k);
            this.f17072a.h();
            this.f17072a.notifyDataSetChanged();
            this.f17072a.l.invalidateViews();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.q0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f17073e;

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
            this.f17073e = viewGroup;
        }

        @Override // c.a.q0.c0.b
        public void imageLoaded(c.a.e.l.d.a aVar, String str, boolean z) {
            ViewGroup viewGroup;
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (viewGroup = this.f17073e) == null || (tbImageView = (TbImageView) viewGroup.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f17074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f17075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f17076g;

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
            this.f17076g = aVar;
            this.f17074e = viewGroup;
            this.f17075f = z;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (indexOfChild = this.f17074e.indexOfChild(view)) < 0) {
                return;
            }
            boolean z = true;
            if (this.f17075f && (this.f17076g.f17071j instanceof WriteActivity)) {
                if (this.f17076g.k != null && this.f17076g.k.size() > 0) {
                    this.f17076g.k.remove(this.f17076g.k.size() - 1);
                }
                ((WriteActivity) this.f17076g.f17071j).updateChoseFile(this.f17076g.k);
                ((WriteActivity) this.f17076g.f17071j).openImageActivity(null);
                return;
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.f17076g.getItem(indexOfChild);
            if (imageFileInfo != null) {
                File file = new File(imageFileInfo.getFilePath());
                if (file.exists()) {
                }
            }
            z = false;
            if (!z) {
                l.I(this.f17076g.f17066e, R.string.editor_mutiiamge_image_error);
            } else if (this.f17076g.f17068g != null) {
                if (this.f17076g.j()) {
                    this.f17076g.k();
                }
                ((WriteActivity) this.f17076g.f17071j).updateChoseFile(this.f17076g.k);
                this.f17076g.f17068g.sendAction(new c.a.q0.x.a(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f17078f;

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
            this.f17078f = aVar;
            this.f17077e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17078f.m == null) {
                return;
            }
            this.f17078f.m.a(this.f17077e);
        }
    }

    /* loaded from: classes3.dex */
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
        this.f17066e = null;
        this.f17067f = new c.a.q0.d0.b();
        this.f17068g = null;
        this.f17069h = 13;
        this.f17070i = 6;
        this.f17071j = null;
        this.k = null;
        this.l = null;
        this.m = new C0823a(this);
        this.f17071j = baseActivity;
        this.f17066e = baseActivity.getActivity();
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
        c.a.q0.d0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = false;
            View inflate = LayoutInflater.from(this.f17066e).inflate(R.layout.photo_live_grid_item, viewGroup, false);
            LinkedList<ImageFileInfo> linkedList = this.k;
            c.a.e.l.d.a aVar = null;
            ImageFileInfo imageFileInfo = (linkedList == null || linkedList.size() - 1 < i2) ? null : this.k.get(i2);
            View findViewById = inflate.findViewById(R.id.item_root_photo_live);
            FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(R.id.shadow_container_photo_live);
            TbImageView tbImageView = (TbImageView) findViewById.findViewById(R.id.iv_photo_live);
            ImageView imageView = (ImageView) findViewById.findViewById(R.id.delete_photo_live);
            String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
            LinkedList<ImageFileInfo> linkedList2 = this.k;
            if (linkedList2 != null && i2 == linkedList2.size() - 1 && filePath.startsWith("android.resource://")) {
                z = true;
            }
            if (z) {
                imageView.setVisibility(8);
                SkinManager.setImageResource(tbImageView, R.drawable.btn_addpic_n);
            } else {
                SkinManager.setImageResource(imageView, R.drawable.icon_live_close_n);
            }
            frameLayout.setForeground(SkinManager.getDrawable(R.drawable.bg_add_photo_foregroundselector));
            int dimensionPixelSize = this.f17066e.getResources().getDimensionPixelSize(R.dimen.ds206);
            ImageOperation g2 = c.a.q0.d0.i.d.g(dimensionPixelSize, dimensionPixelSize);
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(g2);
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
            }
            b bVar2 = new b(this, viewGroup);
            if (imageFileInfo != null && (bVar = this.f17067f) != null) {
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
                if (this.k.size() >= this.f17070i) {
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
            imageFileInfo.setFilePath("android.resource://" + this.f17066e.getPackageName() + "/" + R.drawable.btn_addpic_n);
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
            this.f17068g = editorTools;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f17070i = i2;
        }
    }
}
