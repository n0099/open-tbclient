package b.a.r0.d4.u;

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
import b.a.e.e.p.l;
import b.a.q0.s.s.a;
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
/* loaded from: classes4.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f16132a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.q0.s.s.a f16133b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.d4.t.c.c f16134c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.d4.t.c.b f16135d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPager f16136e;

    /* renamed from: f  reason: collision with root package name */
    public StickerLayout f16137f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16138g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabWidget f16139h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f16140i;
    public int j;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public b.a.r0.d4.u.n.b.c n;
    public NavigationBar o;
    public ArrayList<FragmentTabIndicator> p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16141e;

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
            this.f16141e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16141e.f16140i == null || this.f16141e.f16140i.getPageActivity() == null) {
                return;
            }
            this.f16141e.f16140i.getPageActivity().setResult(0);
            this.f16141e.f16140i.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.r0.d4.u.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f16142a;

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
            this.f16142a = jVar;
        }

        @Override // b.a.r0.d4.u.e
        public void a(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) {
                if (this.f16142a.n == null || !this.f16142a.n.c(bitmap)) {
                    this.f16142a.i(bitmap);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16143e;

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
            this.f16143e = jVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                j jVar = this.f16143e;
                if (i2 == jVar.j) {
                    return;
                }
                if (i2 == 0) {
                    jVar.f16134c.d().setVisibility(0);
                    this.f16143e.f16135d.d().setVisibility(8);
                    if (ListUtils.isEmpty(this.f16143e.l)) {
                        if (this.f16143e.n != null) {
                            this.f16143e.n.b();
                        }
                    } else {
                        j jVar2 = this.f16143e;
                        jVar2.f16134c.f(jVar2.l);
                    }
                } else if (i2 == 1) {
                    StickerLayout stickerLayout = jVar.f16137f;
                    if (stickerLayout != null) {
                        stickerLayout.redraw();
                    }
                    this.f16143e.f16134c.d().setVisibility(8);
                    this.f16143e.f16135d.d().setVisibility(0);
                } else if (i2 == 2) {
                    StickerLayout stickerLayout2 = jVar.f16137f;
                    if (stickerLayout2 != null) {
                        stickerLayout2.redraw();
                    }
                    this.f16143e.f16134c.d().setVisibility(8);
                    this.f16143e.f16135d.d().setVisibility(0);
                }
                j jVar3 = this.f16143e;
                jVar3.j = i2;
                jVar3.f16139h.setCurrentTab(this.f16143e.j, true, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16144e;

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
            this.f16144e = jVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f16144e.f16133b != null) {
                    this.f16144e.f16133b.dismiss();
                }
                this.f16144e.j(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f16145e;

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
            this.f16145e = jVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f16145e.f16133b != null) {
                    this.f16145e.f16133b.dismiss();
                }
                this.f16145e.j(false);
            }
        }
    }

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, b.a.r0.d4.u.n.b.c cVar) {
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
        this.f16132a = 3;
        this.f16136e = null;
        this.f16138g = null;
        this.j = 0;
        this.p = new ArrayList<>();
        this.f16140i = tbPageContext;
        this.n = cVar;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.l = list;
            this.f16134c.f(list);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f16132a == i2) {
            return;
        }
        this.f16132a = i2;
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.f16140i, i2);
        SkinManager.setNavbarTitleColor(this.f16138g, R.color.CAM_X0302, R.color.s_navbar_title_color);
        this.f16137f.setRemoveRes(R.drawable.icon_sticker_delete);
        this.f16134c.g();
        this.f16135d.e();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.onChangeSkin(i2);
            }
        }
        this.f16139h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            this.f16137f.setVisibility(0);
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(0.6f, 0.6f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                th.printStackTrace();
            }
            this.f16137f.addSticker(bitmap, this.n);
        }
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (tbPageContext = this.f16140i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f16140i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, writeImagesInfo) == null) || (tbPageContext = this.f16140i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f16140i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16139h = (FragmentTabWidget) this.k.findViewById(R.id.tab_widget);
            Resources resources = this.f16140i.getResources();
            String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
            this.p.clear();
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.f16140i.getContext());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
                fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
                fragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
                this.f16139h.addView(fragmentTabIndicator, i2);
                this.p.add(fragmentTabIndicator);
            }
            this.f16139h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
            this.f16139h.setCurrentTab(this.j, true, false);
            this.f16139h.setDviderRectWidth(l.g(this.f16140i.getContext(), R.dimen.ds64));
            this.f16139h.setTabSelectionListener(new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16136e = (BdBaseViewPager) this.k.findViewById(R.id.write_multi_imgs_viewpager);
            this.f16137f = (StickerLayout) this.k.findViewById(R.id.stickers_container);
            Resources resources = this.f16140i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.f16140i.getResources();
            NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.write_multi_imgs_navibar);
            this.o = navigationBar;
            navigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
            this.o.showBottomLine();
            this.f16138g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.edit_container);
            b.a.r0.d4.t.c.c cVar = new b.a.r0.d4.t.c.c(this.f16140i);
            this.f16134c = cVar;
            cVar.h(new b(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, l.g(this.f16140i.getContext(), R.dimen.ds36), 0, 0);
            this.f16134c.d().setLayoutParams(layoutParams);
            frameLayout.addView(this.f16134c.d());
            b.a.r0.d4.t.c.b bVar = new b.a.r0.d4.t.c.b(this.f16140i);
            this.f16135d = bVar;
            frameLayout.addView(bVar.d());
            this.f16135d.d().setVisibility(8);
            l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16134c.e();
        }
    }

    public void o() {
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (stickerLayout = this.f16137f) == null) {
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
            if (this.f16133b == null) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f16140i.getPageActivity());
                this.f16133b = aVar;
                aVar.setMessageId(R.string.orginal_conflict_tip);
                this.f16133b.setPositiveButton(R.string.alert_yes_button, new d(this));
                this.f16133b.setNegativeButton(R.string.cancel, new e(this));
                this.f16133b.create(this.f16140i);
            }
            this.f16133b.show();
        }
    }
}
