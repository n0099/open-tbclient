package c.a.r0.l4.u;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
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
/* loaded from: classes6.dex */
public class k implements c.a.r0.l4.u.l.a, MultiImagePagerAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<WriteMultiImgsActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public j f19740b;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f19741c;

    /* renamed from: d  reason: collision with root package name */
    public int f19742d;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f19743e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.s.s.a f19744f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f19745g;

    /* renamed from: h  reason: collision with root package name */
    public int f19746h;

    /* renamed from: i  reason: collision with root package name */
    public WriteImagesInfo f19747i;

    /* renamed from: j  reason: collision with root package name */
    public int f19748j;

    /* renamed from: k  reason: collision with root package name */
    public HashMap<String, String> f19749k;
    public PermissionJudgePolicy l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19750e;

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
            this.f19750e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getTag() == null) {
                return;
            }
            this.f19750e.f19741c.i(Integer.parseInt(view.getTag().toString()), this.f19750e.c());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19751e;

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
            this.f19751e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19751e.a == null) {
                return;
            }
            Activity pageActivity = this.f19751e.a.getPageActivity();
            if (this.f19751e.l == null) {
                this.f19751e.l = new PermissionJudgePolicy();
            }
            this.f19751e.l.clearRequestPermissionList();
            this.f19751e.l.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.f19751e.l.startRequestPermission(pageActivity)) {
                return;
            }
            this.f19751e.f19741c.g(false);
            if (this.f19751e.f19740b == null) {
                return;
            }
            if (this.f19751e.f19747i == null || this.f19751e.f19747i.getChosedFiles() == null || this.f19751e.f19747i.getChosedFiles().size() <= 0 || !this.f19751e.f19747i.isOriginalImg() || this.f19751e.f19746h <= 0 || !this.f19751e.o()) {
                this.f19751e.f19740b.k(true, this.f19751e.f19747i);
            } else {
                this.f19751e.f19740b.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f19752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19753f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f19754g;

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
            this.f19754g = kVar;
            this.f19752e = i2;
            this.f19753f = z;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f19754g.f19744f != null) {
                    this.f19754g.f19744f.dismiss();
                }
                MultiImagePagerAdapter multiImagePagerAdapter = this.f19754g.f19741c;
                if (multiImagePagerAdapter != null) {
                    multiImagePagerAdapter.i(this.f19752e, this.f19753f);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19755e;

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
            this.f19755e = kVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f19755e.f19744f == null) {
                return;
            }
            this.f19755e.f19744f.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f19756e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f19757f;

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
            this.f19757f = kVar;
            this.f19756e = bitmap;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f19757f.f19744f != null) {
                    this.f19757f.f19744f.dismiss();
                }
                this.f19757f.f19740b.i(this.f19756e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19758e;

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
            this.f19758e = kVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f19758e.f19744f == null) {
                return;
            }
            this.f19758e.f19744f.dismiss();
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
        this.f19741c = null;
        this.f19742d = 0;
        this.f19746h = 0;
        this.f19747i = null;
        this.f19748j = TbadkCoreApplication.getInst().getSkinType();
        this.f19749k = new HashMap<>();
        this.a = tbPageContext;
        this.f19740b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        if (!c.a.d.f.p.j.z()) {
            if (this.a.getContext() != null) {
                l.L(this.a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f19745g == null) {
            this.f19745g = new StickerModel(this.a);
        }
        this.f19745g.loadData();
        this.f19745g.x(this);
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
            j jVar = this.f19740b;
            return (jVar == null || (stickerLayout = jVar.f19730f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.r0.l4.u.l.a
    public void e(List<String> list) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || (jVar = this.f19740b) == null) {
            return;
        }
        jVar.a(list);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f19746h++;
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f19747i;
            if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.f19747i.getChosedFiles() != null && this.f19747i.getChosedFiles().size() != 0) {
                Iterator<ImageFileInfo> it = this.f19747i.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.f19749k.get(next.getFilePath()))) {
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
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f19744f == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getPageActivity());
            this.f19744f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f19744f.setPositiveButton(R.string.alert_yes_button, new c(this, i2, z));
            this.f19744f.setNegativeButton(R.string.cancel, new d(this));
            this.f19744f.create(this.a);
        }
        this.f19744f.show();
    }

    public boolean q(Bitmap bitmap) {
        InterceptResult invokeL;
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmap)) == null) {
            if (!this.f19741c.judgeVaild() || (tbPageContext = this.a) == null || tbPageContext.getPageActivity() == null) {
                return false;
            }
            if (this.f19744f == null) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getPageActivity());
                this.f19744f = aVar;
                aVar.setMessageId(R.string.orginal_tip);
                this.f19744f.setPositiveButton(R.string.alert_yes_button, new e(this, bitmap));
                this.f19744f.setNegativeButton(R.string.cancel, new f(this));
                this.f19744f.create(this.a);
            }
            this.f19744f.show();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (c()) {
                this.f19740b.f19729e.setmDisallowSlip(true);
            } else {
                this.f19740b.f19729e.setmDisallowSlip(false);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f19746h--;
        }
    }

    public void t() {
        StickerModel stickerModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (stickerModel = this.f19745g) == null) {
            return;
        }
        stickerModel.destroy();
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f19742d : invokeV.intValue;
    }

    public ForumWriteData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f19743e : (ForumWriteData) invokeV.objValue;
    }

    public WriteImagesInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f19747i : (WriteImagesInfo) invokeV.objValue;
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
                this.f19742d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
                this.f19743e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
                this.f19748j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            } else {
                TbPageContext<WriteMultiImgsActivity> tbPageContext = this.a;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.a.getPageActivity().getIntent()) == null) {
                    str = null;
                    i2 = -1;
                    if (str != null || i2 == -1) {
                    }
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                    this.f19747i = writeImagesInfo;
                    writeImagesInfo.parseJson(str);
                    z();
                    j jVar = this.f19740b;
                    if (jVar == null || jVar.f19729e == null) {
                        return;
                    }
                    MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.a.getOrignalPage(), this.f19740b.f19729e, this.f19747i.getChosedFiles(), i2, this, this.f19740b, this.f19747i.mIsFromIm);
                    this.f19741c = multiImagePagerAdapter;
                    this.f19740b.f19729e.setAdapter(multiImagePagerAdapter);
                    int fixedCurrentIndex = this.f19741c.getFixedCurrentIndex();
                    this.f19740b.f19729e.setCurrentItem(fixedCurrentIndex, true);
                    if (fixedCurrentIndex == 0) {
                        this.f19741c.onPageSelected(0);
                    }
                    this.f19740b.p(this.f19747i);
                    return;
                }
                str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
                intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
                this.f19742d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
                this.f19743e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
                this.f19748j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            }
            i2 = intExtra;
            if (str != null) {
            }
        }
    }

    public final void y() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (jVar = this.f19740b) == null) {
            return;
        }
        c.a.r0.l4.t.d.b bVar = jVar.f19728d;
        if (bVar != null) {
            bVar.f(new a(this));
        }
        TextView textView = this.f19740b.f19731g;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (writeImagesInfo = this.f19747i) == null || !writeImagesInfo.isOriginalImg() || this.f19747i.getChosedFiles() == null || this.f19747i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.f19747i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.f19749k.put(next.getFilePath(), "1");
            }
        }
    }
}
