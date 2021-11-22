package b.a.r0.e4.u;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.s.s.a;
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
/* loaded from: classes4.dex */
public class k implements b.a.r0.e4.u.l.a, MultiImagePagerAdapter.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f17758a;

    /* renamed from: b  reason: collision with root package name */
    public j f17759b;

    /* renamed from: c  reason: collision with root package name */
    public MultiImagePagerAdapter f17760c;

    /* renamed from: d  reason: collision with root package name */
    public int f17761d;

    /* renamed from: e  reason: collision with root package name */
    public ForumWriteData f17762e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.q0.s.s.a f17763f;

    /* renamed from: g  reason: collision with root package name */
    public StickerModel f17764g;

    /* renamed from: h  reason: collision with root package name */
    public int f17765h;

    /* renamed from: i  reason: collision with root package name */
    public WriteImagesInfo f17766i;
    public int j;
    public HashMap<String, String> k;
    public PermissionJudgePolicy l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17767e;

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
            this.f17767e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getTag() == null) {
                return;
            }
            this.f17767e.f17760c.i(Integer.parseInt(view.getTag().toString()), this.f17767e.c());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17768e;

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
            this.f17768e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17768e.f17758a == null) {
                return;
            }
            Activity pageActivity = this.f17768e.f17758a.getPageActivity();
            if (this.f17768e.l == null) {
                this.f17768e.l = new PermissionJudgePolicy();
            }
            this.f17768e.l.clearRequestPermissionList();
            this.f17768e.l.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.f17768e.l.startRequestPermission(pageActivity)) {
                return;
            }
            this.f17768e.f17760c.g(false);
            if (this.f17768e.f17759b == null) {
                return;
            }
            if (this.f17768e.f17766i == null || this.f17768e.f17766i.getChosedFiles() == null || this.f17768e.f17766i.getChosedFiles().size() <= 0 || !this.f17768e.f17766i.isOriginalImg() || this.f17768e.f17765h <= 0 || !this.f17768e.o()) {
                this.f17768e.f17759b.k(true, this.f17768e.f17766i);
            } else {
                this.f17768e.f17759b.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17769e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f17770f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f17771g;

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
            this.f17771g = kVar;
            this.f17769e = i2;
            this.f17770f = z;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f17771g.f17763f != null) {
                    this.f17771g.f17763f.dismiss();
                }
                MultiImagePagerAdapter multiImagePagerAdapter = this.f17771g.f17760c;
                if (multiImagePagerAdapter != null) {
                    multiImagePagerAdapter.i(this.f17769e, this.f17770f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17772e;

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
            this.f17772e = kVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f17772e.f17763f == null) {
                return;
            }
            this.f17772e.f17763f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bitmap f17773e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ k f17774f;

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
            this.f17774f = kVar;
            this.f17773e = bitmap;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f17774f.f17763f != null) {
                    this.f17774f.f17763f.dismiss();
                }
                this.f17774f.f17759b.i(this.f17773e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f17775e;

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
            this.f17775e = kVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || this.f17775e.f17763f == null) {
                return;
            }
            this.f17775e.f17763f.dismiss();
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
        this.f17760c = null;
        this.f17761d = 0;
        this.f17765h = 0;
        this.f17766i = null;
        this.j = TbadkCoreApplication.getInst().getSkinType();
        this.k = new HashMap<>();
        this.f17758a = tbPageContext;
        this.f17759b = jVar;
        x(bundle);
        y();
        A();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17758a == null) {
            return;
        }
        if (!b.a.e.f.p.j.z()) {
            if (this.f17758a.getContext() != null) {
                l.L(this.f17758a.getContext(), R.string.neterror);
                return;
            }
            return;
        }
        if (this.f17764g == null) {
            this.f17764g = new StickerModel(this.f17758a);
        }
        this.f17764g.loadData();
        this.f17764g.x(this);
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
            j jVar = this.f17759b;
            return (jVar == null || (stickerLayout = jVar.f17749f) == null || ListUtils.isEmpty(stickerLayout.getStickerViews())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // b.a.r0.e4.u.l.a
    public void e(List<String> list) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || (jVar = this.f17759b) == null) {
            return;
        }
        jVar.a(list);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f17765h++;
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.f17766i;
            if (writeImagesInfo != null && writeImagesInfo.isOriginalImg() && this.f17766i.getChosedFiles() != null && this.f17766i.getChosedFiles().size() != 0) {
                Iterator<ImageFileInfo> it = this.f17766i.getChosedFiles().iterator();
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
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (tbPageContext = this.f17758a) == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        if (this.f17763f == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f17758a.getPageActivity());
            this.f17763f = aVar;
            aVar.setMessageId(R.string.orginal_tip);
            this.f17763f.setPositiveButton(R.string.alert_yes_button, new c(this, i2, z));
            this.f17763f.setNegativeButton(R.string.cancel, new d(this));
            this.f17763f.create(this.f17758a);
        }
        this.f17763f.show();
    }

    public boolean q(Bitmap bitmap) {
        InterceptResult invokeL;
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bitmap)) == null) {
            if (!this.f17760c.judgeVaild() || (tbPageContext = this.f17758a) == null || tbPageContext.getPageActivity() == null) {
                return false;
            }
            if (this.f17763f == null) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f17758a.getPageActivity());
                this.f17763f = aVar;
                aVar.setMessageId(R.string.orginal_tip);
                this.f17763f.setPositiveButton(R.string.alert_yes_button, new e(this, bitmap));
                this.f17763f.setNegativeButton(R.string.cancel, new f(this));
                this.f17763f.create(this.f17758a);
            }
            this.f17763f.show();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (c()) {
                this.f17759b.f17748e.setmDisallowSlip(true);
            } else {
                this.f17759b.f17748e.setmDisallowSlip(false);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f17765h--;
        }
    }

    public void t() {
        StickerModel stickerModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (stickerModel = this.f17764g) == null) {
            return;
        }
        stickerModel.destroy();
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f17761d : invokeV.intValue;
    }

    public ForumWriteData v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f17762e : (ForumWriteData) invokeV.objValue;
    }

    public WriteImagesInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f17766i : (WriteImagesInfo) invokeV.objValue;
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
                this.f17761d = bundle.getInt(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_ENTRANCE);
                this.f17762e = (ForumWriteData) bundle.getSerializable(WriteMultiImgsActivity.OUTSTATE_KEY_WRITE_INFO_DATA);
                this.j = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            } else {
                TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f17758a;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null || (intent = this.f17758a.getPageActivity().getIntent()) == null) {
                    str = null;
                    i2 = -1;
                    if (str != null || i2 == -1) {
                    }
                    WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                    this.f17766i = writeImagesInfo;
                    writeImagesInfo.parseJson(str);
                    z();
                    j jVar = this.f17759b;
                    if (jVar == null || jVar.f17748e == null) {
                        return;
                    }
                    MultiImagePagerAdapter multiImagePagerAdapter = new MultiImagePagerAdapter(this.f17758a.getOrignalPage(), this.f17759b.f17748e, this.f17766i.getChosedFiles(), i2, this, this.f17759b, this.f17766i.mIsFromIm);
                    this.f17760c = multiImagePagerAdapter;
                    this.f17759b.f17748e.setAdapter(multiImagePagerAdapter);
                    int fixedCurrentIndex = this.f17760c.getFixedCurrentIndex();
                    this.f17759b.f17748e.setCurrentItem(fixedCurrentIndex, true);
                    if (fixedCurrentIndex == 0) {
                        this.f17760c.onPageSelected(0);
                    }
                    this.f17759b.p(this.f17766i);
                    return;
                }
                str = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
                intExtra = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
                this.f17761d = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
                this.f17762e = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
                this.j = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            }
            i2 = intExtra;
            if (str != null) {
            }
        }
    }

    public final void y() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (jVar = this.f17759b) == null) {
            return;
        }
        b.a.r0.e4.t.c.b bVar = jVar.f17747d;
        if (bVar != null) {
            bVar.f(new a(this));
        }
        TextView textView = this.f17759b.f17750g;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
    }

    public final void z() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (writeImagesInfo = this.f17766i) == null || !writeImagesInfo.isOriginalImg() || this.f17766i.getChosedFiles() == null || this.f17766i.getChosedFiles().size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> it = this.f17766i.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize()) {
                this.k.put(next.getFilePath(), "1");
            }
        }
    }
}
