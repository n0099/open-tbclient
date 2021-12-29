package c.a.t0.o4.e0;

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
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.s.s.a f21639b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.o4.d0.d.c f21640c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.o4.d0.d.b f21641d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPager f21642e;

    /* renamed from: f  reason: collision with root package name */
    public StickerLayout f21643f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21644g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabWidget f21645h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f21646i;

    /* renamed from: j  reason: collision with root package name */
    public int f21647j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f21648k;
    public List<String> l;
    public WriteImagesInfo m;
    public c.a.t0.o4.e0.n.b.c n;
    public NavigationBar o;
    public ArrayList<FragmentTabIndicator> p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21649e;

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
            this.f21649e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21649e.f21646i == null || this.f21649e.f21646i.getPageActivity() == null) {
                return;
            }
            this.f21649e.f21646i.getPageActivity().setResult(0);
            this.f21649e.f21646i.getPageActivity().finish();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.t0.o4.e0.e {
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

        @Override // c.a.t0.o4.e0.e
        public void a(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) {
                if (this.a.n == null || !this.a.n.c(bitmap)) {
                    this.a.i(bitmap);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21650e;

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
            this.f21650e = jVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                j jVar = this.f21650e;
                if (i2 == jVar.f21647j) {
                    return;
                }
                if (i2 == 0) {
                    jVar.f21640c.d().setVisibility(0);
                    this.f21650e.f21641d.d().setVisibility(8);
                    if (ListUtils.isEmpty(this.f21650e.l)) {
                        if (this.f21650e.n != null) {
                            this.f21650e.n.b();
                        }
                    } else {
                        j jVar2 = this.f21650e;
                        jVar2.f21640c.f(jVar2.l);
                    }
                } else if (i2 == 1) {
                    StickerLayout stickerLayout = jVar.f21643f;
                    if (stickerLayout != null) {
                        stickerLayout.redraw();
                    }
                    this.f21650e.f21640c.d().setVisibility(8);
                    this.f21650e.f21641d.d().setVisibility(0);
                } else if (i2 == 2) {
                    StickerLayout stickerLayout2 = jVar.f21643f;
                    if (stickerLayout2 != null) {
                        stickerLayout2.redraw();
                    }
                    this.f21650e.f21640c.d().setVisibility(8);
                    this.f21650e.f21641d.d().setVisibility(0);
                }
                j jVar3 = this.f21650e;
                jVar3.f21647j = i2;
                jVar3.f21645h.setCurrentTab(this.f21650e.f21647j, true, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21651e;

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
            this.f21651e = jVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f21651e.f21639b != null) {
                    this.f21651e.f21639b.dismiss();
                }
                this.f21651e.j(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f21652e;

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
            this.f21652e = jVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f21652e.f21639b != null) {
                    this.f21652e.f21639b.dismiss();
                }
                this.f21652e.j(false);
            }
        }
    }

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, c.a.t0.o4.e0.n.b.c cVar) {
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
        this.f21642e = null;
        this.f21644g = null;
        this.f21647j = 0;
        this.p = new ArrayList<>();
        this.f21646i = tbPageContext;
        this.n = cVar;
        this.f21648k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(c.a.t0.o4.h.write_multi_imgs_activity, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.l = list;
            this.f21640c.f(list);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.a == i2) {
            return;
        }
        this.a = i2;
        SkinManager.setBackgroundResource(this.f21648k, c.a.t0.o4.d.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), c.a.t0.o4.f.ic_icon_pure_topbar_return40_svg, c.a.t0.o4.d.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.f21646i, i2);
        SkinManager.setNavbarTitleColor(this.f21644g, c.a.t0.o4.d.CAM_X0302, c.a.t0.o4.d.s_navbar_title_color);
        this.f21643f.setRemoveRes(c.a.t0.o4.f.icon_sticker_delete);
        this.f21640c.g();
        this.f21641d.e();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.onChangeSkin(i2);
            }
        }
        this.f21645h.setDiverColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            this.f21643f.setVisibility(0);
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(0.6f, 0.6f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                th.printStackTrace();
            }
            this.f21643f.addSticker(bitmap, this.n);
        }
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (tbPageContext = this.f21646i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f21646i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, writeImagesInfo) == null) || (tbPageContext = this.f21646i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f21646i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f21645h = (FragmentTabWidget) this.f21648k.findViewById(c.a.t0.o4.g.tab_widget);
            Resources resources = this.f21646i.getResources();
            String[] stringArray = resources.getStringArray(c.a.t0.o4.c.edit_pic_no_fliter_tab);
            this.p.clear();
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.f21646i.getContext());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(c.a.t0.o4.d.edit_pic_tab_title_color);
                fragmentTabIndicator.setTextSize(0, resources.getDimension(c.a.t0.o4.e.fontsize34));
                fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                this.f21645h.addView(fragmentTabIndicator, i2);
                this.p.add(fragmentTabIndicator);
            }
            this.f21645h.setDiverColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0107));
            this.f21645h.setCurrentTab(this.f21647j, true, false);
            this.f21645h.setDviderRectWidth(n.f(this.f21646i.getContext(), c.a.t0.o4.e.ds64));
            this.f21645h.setTabSelectionListener(new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f21642e = (BdBaseViewPager) this.f21648k.findViewById(c.a.t0.o4.g.write_multi_imgs_viewpager);
            this.f21643f = (StickerLayout) this.f21648k.findViewById(c.a.t0.o4.g.stickers_container);
            Resources resources = this.f21646i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.f21646i.getResources();
            NavigationBar navigationBar = (NavigationBar) this.f21648k.findViewById(c.a.t0.o4.g.write_multi_imgs_navibar);
            this.o = navigationBar;
            navigationBar.setCenterTextTitle(resources.getString(c.a.t0.o4.j.pic_navigation_title));
            this.o.showBottomLine();
            this.f21644g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(c.a.t0.o4.j.done));
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            FrameLayout frameLayout = (FrameLayout) this.f21648k.findViewById(c.a.t0.o4.g.edit_container);
            c.a.t0.o4.d0.d.c cVar = new c.a.t0.o4.d0.d.c(this.f21646i);
            this.f21640c = cVar;
            cVar.h(new b(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, n.f(this.f21646i.getContext(), c.a.t0.o4.e.ds36), 0, 0);
            this.f21640c.d().setLayoutParams(layoutParams);
            frameLayout.addView(this.f21640c.d());
            c.a.t0.o4.d0.d.b bVar = new c.a.t0.o4.d0.d.b(this.f21646i);
            this.f21641d = bVar;
            frameLayout.addView(bVar.d());
            this.f21641d.d().setVisibility(8);
            l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21640c.e();
        }
    }

    public void o() {
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (stickerLayout = this.f21643f) == null) {
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
            if (this.f21639b == null) {
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f21646i.getPageActivity());
                this.f21639b = aVar;
                aVar.setMessageId(c.a.t0.o4.j.orginal_conflict_tip);
                this.f21639b.setPositiveButton(c.a.t0.o4.j.alert_yes_button, new d(this));
                this.f21639b.setNegativeButton(c.a.t0.o4.j.cancel, new e(this));
                this.f21639b.create(this.f21646i);
            }
            this.f21639b.show();
        }
    }
}
