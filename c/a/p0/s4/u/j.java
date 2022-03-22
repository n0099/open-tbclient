package c.a.p0.s4.u;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.r.t.a f18513b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.s4.t.d.c f18514c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.s4.t.d.b f18515d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPager f18516e;

    /* renamed from: f  reason: collision with root package name */
    public StickerLayout f18517f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18518g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabWidget f18519h;
    public TbPageContext<WriteMultiImgsActivity> i;
    public int j;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public c.a.p0.s4.u.n.b.c n;
    public NavigationBar o;
    public ArrayList<FragmentTabIndicator> p;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.i == null || this.a.i.getPageActivity() == null) {
                return;
            }
            this.a.i.getPageActivity().setResult(0);
            this.a.i.getPageActivity().finish();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.p0.s4.u.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // c.a.p0.s4.u.e
        public void a(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) {
                if (this.a.n == null || !this.a.n.c(bitmap)) {
                    this.a.i(bitmap);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                j jVar = this.a;
                if (i == jVar.j) {
                    return;
                }
                if (i == 0) {
                    jVar.f18514c.d().setVisibility(0);
                    this.a.f18515d.d().setVisibility(8);
                    if (ListUtils.isEmpty(this.a.l)) {
                        if (this.a.n != null) {
                            this.a.n.b();
                        }
                    } else {
                        j jVar2 = this.a;
                        jVar2.f18514c.h(jVar2.l);
                    }
                } else if (i == 1) {
                    StickerLayout stickerLayout = jVar.f18517f;
                    if (stickerLayout != null) {
                        stickerLayout.e();
                    }
                    this.a.f18514c.d().setVisibility(8);
                    this.a.f18515d.d().setVisibility(0);
                } else if (i == 2) {
                    StickerLayout stickerLayout2 = jVar.f18517f;
                    if (stickerLayout2 != null) {
                        stickerLayout2.e();
                    }
                    this.a.f18514c.d().setVisibility(8);
                    this.a.f18515d.d().setVisibility(0);
                }
                j jVar3 = this.a;
                jVar3.j = i;
                jVar3.f18519h.setCurrentTab(this.a.j, true, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.a.f18513b != null) {
                    this.a.f18513b.dismiss();
                }
                this.a.j(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public e(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.a.f18513b != null) {
                    this.a.f18513b.dismiss();
                }
                this.a.j(false);
            }
        }
    }

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, c.a.p0.s4.u.n.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f18516e = null;
        this.f18518g = null;
        this.j = 0;
        this.p = new ArrayList<>();
        this.i = tbPageContext;
        this.n = cVar;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08e6, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.l = list;
            this.f18514c.h(list);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), R.drawable.obfuscated_res_0x7f080624, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.i, i);
        SkinManager.setNavbarTitleColor(this.f18518g, R.color.CAM_X0302, R.color.s_navbar_title_color);
        this.f18517f.setRemoveRes(R.drawable.obfuscated_res_0x7f080a3b);
        this.f18514c.i();
        this.f18515d.g();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.e(i);
            }
        }
        this.f18519h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            this.f18517f.setVisibility(0);
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(0.6f, 0.6f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                th.printStackTrace();
            }
            this.f18517f.b(bitmap, this.n);
        }
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (tbPageContext = this.i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, writeImagesInfo) == null) || (tbPageContext = this.i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f18519h = (FragmentTabWidget) this.k.findViewById(R.id.obfuscated_res_0x7f091e51);
            Resources resources = this.i.getResources();
            String[] stringArray = resources.getStringArray(R.array.obfuscated_res_0x7f03000f);
            this.p.clear();
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.i.getContext());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
                fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.obfuscated_res_0x7f070328));
                fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
                this.f18519h.addView(fragmentTabIndicator, i);
                this.p.add(fragmentTabIndicator);
            }
            this.f18519h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
            this.f18519h.setCurrentTab(this.j, true, false);
            this.f18519h.setDviderRectWidth(n.f(this.i.getContext(), R.dimen.obfuscated_res_0x7f070258));
            this.f18519h.setTabSelectionListener(new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18516e = (BdBaseViewPager) this.k.findViewById(R.id.obfuscated_res_0x7f0924a4);
            this.f18517f = (StickerLayout) this.k.findViewById(R.id.obfuscated_res_0x7f091db1);
            Resources resources = this.i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.i.getResources();
            NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.obfuscated_res_0x7f0924a3);
            this.o = navigationBar;
            navigationBar.setCenterTextTitle(resources.getString(R.string.obfuscated_res_0x7f0f0e3b));
            this.o.showBottomLine();
            this.f18518g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.obfuscated_res_0x7f0f04e0));
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.obfuscated_res_0x7f09084b);
            c.a.p0.s4.t.d.c cVar = new c.a.p0.s4.t.d.c(this.i);
            this.f18514c = cVar;
            cVar.j(new b(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, n.f(this.i.getContext(), R.dimen.obfuscated_res_0x7f070215), 0, 0);
            this.f18514c.d().setLayoutParams(layoutParams);
            frameLayout.addView(this.f18514c.d());
            c.a.p0.s4.t.d.b bVar = new c.a.p0.s4.t.d.b(this.i);
            this.f18515d = bVar;
            frameLayout.addView(bVar.d());
            this.f18515d.d().setVisibility(8);
            l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f18514c.g();
        }
    }

    public void o() {
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (stickerLayout = this.f18517f) == null) {
            return;
        }
        stickerLayout.f(null);
    }

    public void p(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, writeImagesInfo) == null) {
            this.m = writeImagesInfo;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f18513b == null) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.i.getPageActivity());
                this.f18513b = aVar;
                aVar.setMessageId(R.string.obfuscated_res_0x7f0f0cdf);
                this.f18513b.setPositiveButton(R.string.obfuscated_res_0x7f0f025c, new d(this));
                this.f18513b.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new e(this));
                this.f18513b.create(this.i);
            }
            this.f18513b.show();
        }
    }
}
