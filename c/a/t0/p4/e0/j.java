package c.a.t0.p4.e0;

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
import c.a.s0.s.s.a;
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
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.s.s.a f21386b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.p4.d0.d.c f21387c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.p4.d0.d.b f21388d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPager f21389e;

    /* renamed from: f  reason: collision with root package name */
    public StickerLayout f21390f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21391g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabWidget f21392h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f21393i;

    /* renamed from: j  reason: collision with root package name */
    public int f21394j;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public c.a.t0.p4.e0.n.b.c n;
    public NavigationBar o;
    public ArrayList<FragmentTabIndicator> p;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21395e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21395e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21395e.f21393i == null || this.f21395e.f21393i.getPageActivity() == null) {
                return;
            }
            this.f21395e.f21393i.getPageActivity().setResult(0);
            this.f21395e.f21393i.getPageActivity().finish();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.t0.p4.e0.e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // c.a.t0.p4.e0.e
        public void a(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) {
                if (this.a.n == null || !this.a.n.c(bitmap)) {
                    this.a.i(bitmap);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21396e;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21396e = jVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                j jVar = this.f21396e;
                if (i2 == jVar.f21394j) {
                    return;
                }
                if (i2 == 0) {
                    jVar.f21387c.d().setVisibility(0);
                    this.f21396e.f21388d.d().setVisibility(8);
                    if (ListUtils.isEmpty(this.f21396e.l)) {
                        if (this.f21396e.n != null) {
                            this.f21396e.n.b();
                        }
                    } else {
                        j jVar2 = this.f21396e;
                        jVar2.f21387c.f(jVar2.l);
                    }
                } else if (i2 == 1) {
                    StickerLayout stickerLayout = jVar.f21390f;
                    if (stickerLayout != null) {
                        stickerLayout.redraw();
                    }
                    this.f21396e.f21387c.d().setVisibility(8);
                    this.f21396e.f21388d.d().setVisibility(0);
                } else if (i2 == 2) {
                    StickerLayout stickerLayout2 = jVar.f21390f;
                    if (stickerLayout2 != null) {
                        stickerLayout2.redraw();
                    }
                    this.f21396e.f21387c.d().setVisibility(8);
                    this.f21396e.f21388d.d().setVisibility(0);
                }
                j jVar3 = this.f21396e;
                jVar3.f21394j = i2;
                jVar3.f21392h.setCurrentTab(this.f21396e.f21394j, true, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21397e;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21397e = jVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f21397e.f21386b != null) {
                    this.f21397e.f21386b.dismiss();
                }
                this.f21397e.j(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21398e;

        public e(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21398e = jVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f21398e.f21386b != null) {
                    this.f21398e.f21386b.dismiss();
                }
                this.f21398e.j(false);
            }
        }
    }

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, c.a.t0.p4.e0.n.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f21389e = null;
        this.f21391g = null;
        this.f21394j = 0;
        this.p = new ArrayList<>();
        this.f21393i = tbPageContext;
        this.n = cVar;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(c.a.t0.p4.h.write_multi_imgs_activity, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.l = list;
            this.f21387c.f(list);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.a == i2) {
            return;
        }
        this.a = i2;
        SkinManager.setBackgroundResource(this.k, c.a.t0.p4.d.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), c.a.t0.p4.f.ic_icon_pure_topbar_return40_svg, c.a.t0.p4.d.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.f21393i, i2);
        SkinManager.setNavbarTitleColor(this.f21391g, c.a.t0.p4.d.CAM_X0302, c.a.t0.p4.d.s_navbar_title_color);
        this.f21390f.setRemoveRes(c.a.t0.p4.f.icon_sticker_delete);
        this.f21387c.g();
        this.f21388d.e();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.onChangeSkin(i2);
            }
        }
        this.f21392h.setDiverColor(SkinManager.getColor(c.a.t0.p4.d.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            this.f21390f.setVisibility(0);
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(0.6f, 0.6f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                th.printStackTrace();
            }
            this.f21390f.addSticker(bitmap, this.n);
        }
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (tbPageContext = this.f21393i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f21393i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, writeImagesInfo) == null) || (tbPageContext = this.f21393i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f21393i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21392h = (FragmentTabWidget) this.k.findViewById(c.a.t0.p4.g.tab_widget);
            Resources resources = this.f21393i.getResources();
            String[] stringArray = resources.getStringArray(c.a.t0.p4.c.edit_pic_no_fliter_tab);
            this.p.clear();
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.f21393i.getContext());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(c.a.t0.p4.d.edit_pic_tab_title_color);
                fragmentTabIndicator.setTextSize(0, resources.getDimension(c.a.t0.p4.e.fontsize34));
                fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                this.f21392h.addView(fragmentTabIndicator, i2);
                this.p.add(fragmentTabIndicator);
            }
            this.f21392h.setDiverColor(SkinManager.getColor(c.a.t0.p4.d.CAM_X0107));
            this.f21392h.setCurrentTab(this.f21394j, true, false);
            this.f21392h.setDviderRectWidth(n.f(this.f21393i.getContext(), c.a.t0.p4.e.ds64));
            this.f21392h.setTabSelectionListener(new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f21389e = (BdBaseViewPager) this.k.findViewById(c.a.t0.p4.g.write_multi_imgs_viewpager);
            this.f21390f = (StickerLayout) this.k.findViewById(c.a.t0.p4.g.stickers_container);
            Resources resources = this.f21393i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.f21393i.getResources();
            NavigationBar navigationBar = (NavigationBar) this.k.findViewById(c.a.t0.p4.g.write_multi_imgs_navibar);
            this.o = navigationBar;
            navigationBar.setCenterTextTitle(resources.getString(c.a.t0.p4.j.pic_navigation_title));
            this.o.showBottomLine();
            this.f21391g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(c.a.t0.p4.j.done));
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            FrameLayout frameLayout = (FrameLayout) this.k.findViewById(c.a.t0.p4.g.edit_container);
            c.a.t0.p4.d0.d.c cVar = new c.a.t0.p4.d0.d.c(this.f21393i);
            this.f21387c = cVar;
            cVar.h(new b(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, n.f(this.f21393i.getContext(), c.a.t0.p4.e.ds36), 0, 0);
            this.f21387c.d().setLayoutParams(layoutParams);
            frameLayout.addView(this.f21387c.d());
            c.a.t0.p4.d0.d.b bVar = new c.a.t0.p4.d0.d.b(this.f21393i);
            this.f21388d = bVar;
            frameLayout.addView(bVar.d());
            this.f21388d.d().setVisibility(8);
            l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21387c.e();
        }
    }

    public void o() {
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (stickerLayout = this.f21390f) == null) {
            return;
        }
        stickerLayout.removeAllSticker(null);
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
            if (this.f21386b == null) {
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f21393i.getPageActivity());
                this.f21386b = aVar;
                aVar.setMessageId(c.a.t0.p4.j.orginal_conflict_tip);
                this.f21386b.setPositiveButton(c.a.t0.p4.j.alert_yes_button, new d(this));
                this.f21386b.setNegativeButton(c.a.t0.p4.j.cancel, new e(this));
                this.f21386b.create(this.f21393i);
            }
            this.f21386b.show();
        }
    }
}
