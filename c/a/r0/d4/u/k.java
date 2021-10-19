package c.a.r0.d4.u;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.model.StickerModel;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements c.a.r0.d4.u.l.a, MultiImagePagerAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f17166a;

    /* renamed from: b  reason: collision with root package name */
    public j f17167b;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f17168c;

    /* renamed from: d  reason: collision with root package name */
    public int f17169d;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f17170e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.s.s.a f17171f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f17172g;

    /* renamed from: h  reason: collision with root package name */
    public int f17173h;

    /* renamed from: i  reason: collision with root package name */
    public WriteImagesInfo f17174i;

    /* renamed from: j  reason: collision with root package name */
    public int f17175j;
    public HashMap<String, String> k;
    public PermissionJudgePolicy l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17176e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17176e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getTag() == null) {
                return;
            }
            this.f17176e.f17168c.i(Integer.parseInt(view.getTag().toString()), this.f17176e.c());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17177e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17177e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17177e.f17166a == null) {
                return;
            }
            Activity pageActivity = this.f17177e.f17166a.getPageActivity();
            if (this.f17177e.l == null) {
                this.f17177e.l = new PermissionJudgePolicy();
            }
            this.f17177e.l.clearRequestPermissionList();
            this.f17177e.l.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.f17177e.l.startRequestPermission(pageActivity)) {
                return;
            }
            this.f17177e.f17168c.g(false);
            if (this.f17177e.f17167b == null) {
                return;
            }
            if (this.f17177e.f17174i == null || this.f17177e.f17174i.getChosedFiles() == null || this.f17177e.f17174i.getChosedFiles().size() <= 0 || !this.f17177e.f17174i.isOriginalImg() || this.f17177e.f17173h <= 0 || !this.f17177e.o()) {
                this.f17177e.f17167b.k(true, this.f17177e.f17174i);
            } else {
                this.f17177e.f17167b.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17178e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f17179f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f17180g;

        public c(k kVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17180g = kVar;
            this.f17178e = i2;
            this.f17179f = z;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f17180g.f17171f != null) {
                    this.f17180g.f17171f.dismiss();
                }
                MultiImagePagerAdapter multiImagePagerAdapter = this.f17180g.f17168c;
                if (multiImagePagerAdapter != null) {
                    multiImagePagerAdapter.i(this.f17178e, this.f17179f);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17181e;

        public d(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17181e = kVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f17181e.f17171f == null) {
                return;
            }
            this.f17181e.f17171f.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f17182e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f17183f;

        public e(k kVar, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17183f = kVar;
            this.f17182e = bitmap;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f17183f.f17171f != null) {
                    this.f17183f.f17171f.dismiss();
                }
                this.f17183f.f17167b.i(this.f17182e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17184e;

        public f(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17184e = kVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f17184e.f17171f == null) {
                return;
            }
            this.f17184e.f17171f.dismiss();
        }
    }

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, jVar, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17168c = null;
        this.f17169d = 0;
        this.f17173h = 0;
        this.f17174i = null;
        this.f17175j = TbadkCoreApplication.getInst().getSkinType();
        this.k = new HashMap<>();
        this.f17166a = tbPageContext;
        this.f17167b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17166a == null) {
            return;
        }
        if (!c.a.e.e.p.j.z()) {
            if (this.f17166a.getContext() != null) {
                l.L(this.f17166a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f17172g == null) {
            this.f17172g = new StickerModel(this.f17166a);
        }
        this.f17172g.loadData();
        this.f17172g.x(this);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s();
            r(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            p(i2, z);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public boolean c() {
        InterceptResult invokeV;
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            j jVar = this.f17167b;
            return (jVar == null || (stickerLayout = jVar.f17156f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.r0.d4.u.l.a
    public void e(List<String> list) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || (jVar = this.f17167b) == null) {
            return;
        }
        jVar.a(list);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f17173h++;
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f17174i;
            if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.f17174i.getChosedFiles() != null && this.f17174i.getChosedFiles().size() != 0) {
                Iterator<ImageFileInfo> it = this.f17174i.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.k.get(next.getFilePath()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(int i2, boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (tbPageContext = this.f17166a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f17171f == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f17166a.getPageActivity());
            this.f17171f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f17171f.setPositiveButton(R.string.alert_yes_button, new c(this, i2, z));
            this.f17171f.setNegativeButton(R.string.cancel, new d(this));
            this.f17171f.create(this.f17166a);
        }
        this.f17171f.show();
    }

    public boolean q(Bitmap bitmap) {
        InterceptResult invokeL;
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmap)) == null) {
            if (!this.f17168c.judgeVaild() || (tbPageContext = this.f17166a) == null || tbPageContext.getPageActivity() == null) {
                return false;
            }
            if (this.f17171f == null) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f17166a.getPageActivity());
                this.f17171f = aVar;
                aVar.setMessageId(R.string.orginal_tip);
                this.f17171f.setPositiveButton(R.string.alert_yes_button, new e(this, bitmap));
                this.f17171f.setNegativeButton(R.string.cancel, new f(this));
                this.f17171f.create(this.f17166a);
            }
            this.f17171f.show();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (c()) {
                this.f17167b.f17155e.setmDisallowSlip(true);
            } else {
                this.f17167b.f17155e.setmDisallowSlip(false);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f17173h--;
        }
    }

    public void t() {
        StickerModel stickerModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (stickerModel = this.f17172g) == null) {
            return;
        }
        stickerModel.destroy();
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f17169d : invokeV.intValue;
    }

    public ForumWriteData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f17170e : (ForumWriteData) invokeV.objValue;
    }

    public WriteImagesInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f17174i : (WriteImagesInfo) invokeV.objValue;
    }

    public final void x(Bundle bundle) {
        String str;
        int i2;
        Intent intent;
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            if (bundle != null) {
                str = bundle.getString(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_IMG_INFO);
                intExtra = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_CURRENT_INDEX);
                this.f17169d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
                this.f17170e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
                this.f17175j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            } else {
                TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f17166a;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f17166a.getPageActivity().getIntent()) == null) {
                    str = null;
                    i2 = -1;
                    if (str != null || i2 == -1) {
                    }
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                    this.f17174i = writeImagesInfo;
                    writeImagesInfo.parseJson(str);
                    z();
                    j jVar = this.f17167b;
                    if (jVar == null || jVar.f17155e == null) {
                        return;
                    }
                    MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.f17166a.getOrignalPage(), this.f17167b.f17155e, this.f17174i.getChosedFiles(), i2, this, this.f17167b, this.f17174i.mIsFromIm);
                    this.f17168c = multiImagePagerAdapter;
                    this.f17167b.f17155e.setAdapter(multiImagePagerAdapter);
                    int fixedCurrentIndex = this.f17168c.getFixedCurrentIndex();
                    this.f17167b.f17155e.setCurrentItem(fixedCurrentIndex, true);
                    if (fixedCurrentIndex == 0) {
                        this.f17168c.onPageSelected(0);
                    }
                    this.f17167b.p(this.f17174i);
                    return;
                }
                str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
                intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
                this.f17169d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
                this.f17170e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
                this.f17175j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            }
            i2 = intExtra;
            if (str != null) {
            }
        }
    }

    public final void y() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (jVar = this.f17167b) == null) {
            return;
        }
        c.a.r0.d4.t.c.b bVar = jVar.f17154d;
        if (bVar != null) {
            bVar.f(new a(this));
        }
        TextView textView = this.f17167b.f17157g;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (writeImagesInfo = this.f17174i) == null || !writeImagesInfo.isOriginalImg() || this.f17174i.getChosedFiles() == null || this.f17174i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.f17174i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
